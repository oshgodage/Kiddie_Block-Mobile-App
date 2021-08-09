package lk.sliit.kiddieblocksapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import lk.sliit.kiddieblocksapp.Utill.Config;
import lk.sliit.kiddieblocksapp.Utill.SharedPreferenceHelper;

public class BeginnerLevel3Activity extends Activity
{
    public Button btnCaptureLevel3, btnSubmitLevel3;
    public double resultValue = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beginner_level3);

        Config.setStatusBarColor(getApplicationContext(), BeginnerLevel3Activity.this);

        initialize();
        eventHandler();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode ==  Config.BEGINNER_LEVEL_3)
        {
            if(data != null)
            {
                resultValue = data.getDoubleExtra("result", 0.0);
                //Config.showToast(BeginnerLevel3Activity.this, resultValue + "");

                if(resultValue > 1.0)
                {
                    btnCaptureLevel3.setVisibility(View.VISIBLE);
                    btnSubmitLevel3.setVisibility(View.GONE);
                }
                else
                {
                    btnCaptureLevel3.setVisibility(View.GONE);
                    btnSubmitLevel3.setVisibility(View.VISIBLE);
                }
            }
        }
    }


    public void initialize()
    {
        btnCaptureLevel3 = (Button) findViewById(R.id.btn_captureLevel3);
        btnSubmitLevel3 = (Button) findViewById(R.id.btn_submitLevel3);
    }


    public void eventHandler()
    {
        btnCaptureLevel3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent in = new Intent(BeginnerLevel3Activity.this, ImageCaptureActivity.class);
                in.putExtra("level", Config.BEGINNER_LEVEL_3);
                startActivityForResult(in, Config.BEGINNER_LEVEL_3);
            }
        });

        btnSubmitLevel3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                SharedPreferenceHelper.setSharedPreferenceInt(getApplicationContext(), Config.BEGINNERLEVEL, 3);
                SharedPreferenceHelper.setSharedPreferenceString(getApplicationContext(), Config.BEGINNER_LEVEL_3_RESULT, resultValue + "");

                Intent in = new Intent(BeginnerLevel3Activity.this, MainActivity.class);
                startActivity(in);
                finish();
            }
        });
    }
}
