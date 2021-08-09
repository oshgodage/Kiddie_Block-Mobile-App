package lk.sliit.kiddieblocksapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import lk.sliit.kiddieblocksapp.Utill.Config;
import lk.sliit.kiddieblocksapp.Utill.SharedPreferenceHelper;

public class BeginnerLevel1Activity extends Activity
{
    public Button btnCaptureLevel1, btnSubmitLevel1;
    public double resultValue = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beginner_level1);

        Config.setStatusBarColor(getApplicationContext(), BeginnerLevel1Activity.this);

        initialize();
        eventHandler();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode ==  Config.BEGINNER_LEVEL_1)
        {
            if(data != null)
            {
                resultValue = data.getDoubleExtra("result", 0.0);
                //Config.showToast(BeginnerLevel1Activity.this, resultValue + "");

                if(resultValue > 1.0)
                {
                    btnCaptureLevel1.setVisibility(View.VISIBLE);
                    btnSubmitLevel1.setVisibility(View.GONE);
                }
                else
                {
                    btnCaptureLevel1.setVisibility(View.GONE);
                    btnSubmitLevel1.setVisibility(View.VISIBLE);
                }
            }
        }
    }

    public void initialize()
    {
        btnCaptureLevel1 = (Button) findViewById(R.id.btn_captureLevel1);
        btnSubmitLevel1 = (Button) findViewById(R.id.btn_submitLevel1);
    }


    public void eventHandler()
    {
        btnCaptureLevel1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent in = new Intent(BeginnerLevel1Activity.this, ImageCaptureActivity.class);
                in.putExtra("level", Config.BEGINNER_LEVEL_1);
                startActivityForResult(in, Config.BEGINNER_LEVEL_1);
            }
        });

        btnSubmitLevel1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                SharedPreferenceHelper.setSharedPreferenceInt(getApplicationContext(), Config.BEGINNERLEVEL, 1);
                SharedPreferenceHelper.setSharedPreferenceString(getApplicationContext(), Config.BEGINNER_LEVEL_1_RESULT, resultValue + "");

                Intent in = new Intent(BeginnerLevel1Activity.this, BeginnerLevel2Activity.class);
                startActivity(in);
                finish();
            }
        });
    }
}
