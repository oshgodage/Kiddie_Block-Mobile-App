package lk.sliit.kiddieblocksapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import lk.sliit.kiddieblocksapp.Utill.Config;
import lk.sliit.kiddieblocksapp.Utill.SharedPreferenceHelper;

public class BeginnerLevel2Activity extends Activity
{
    public Button btnCaptureLevel2, btnSubmitLevel2;
    public double resultValue = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beginner_level2);

        Config.setStatusBarColor(getApplicationContext(), BeginnerLevel2Activity.this);

        initialize();
        eventHandler();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode ==  Config.BEGINNER_LEVEL_2)
        {
            if(data != null)
            {
                resultValue = data.getDoubleExtra("result", 0.0);
                //Config.showToast(BeginnerLevel2Activity.this, resultValue + "");

                if(resultValue > 1.0)
                {
                    btnCaptureLevel2.setVisibility(View.VISIBLE);
                    btnSubmitLevel2.setVisibility(View.GONE);
                }
                else
                {
                    btnCaptureLevel2.setVisibility(View.GONE);
                    btnSubmitLevel2.setVisibility(View.VISIBLE);
                }
            }
        }
    }

    public void initialize()
    {
        btnCaptureLevel2 = (Button) findViewById(R.id.btn_captureLevel2);
        btnSubmitLevel2 = (Button) findViewById(R.id.btn_submitLevel2);
    }


    public void eventHandler()
    {
        btnCaptureLevel2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent in = new Intent(BeginnerLevel2Activity.this, ImageCaptureActivity.class);
                in.putExtra("level", Config.BEGINNER_LEVEL_2);
                startActivityForResult(in, Config.BEGINNER_LEVEL_2);
            }
        });

        btnSubmitLevel2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                SharedPreferenceHelper.setSharedPreferenceInt(getApplicationContext(), Config.BEGINNERLEVEL, 2);
                SharedPreferenceHelper.setSharedPreferenceString(getApplicationContext(), Config.BEGINNER_LEVEL_2_RESULT, resultValue + "");

                Intent in = new Intent(BeginnerLevel2Activity.this, BeginnerLevel3Activity.class);
                startActivity(in);
                finish();
            }
        });
    }
}
