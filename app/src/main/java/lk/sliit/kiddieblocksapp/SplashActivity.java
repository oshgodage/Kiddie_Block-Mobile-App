package lk.sliit.kiddieblocksapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import lk.sliit.kiddieblocksapp.Utill.Config;
import lk.sliit.kiddieblocksapp.Utill.SharedPreferenceHelper;

public class SplashActivity extends Activity
{
    public Boolean isLogged = false;
    public int beginnerLevel = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Config.setStatusBarColor(getApplicationContext(), SplashActivity.this);

        isLogged = SharedPreferenceHelper.getSharedPreferenceBoolean(getApplicationContext(), Config.ISCLIENTLOGGEDIN, false);
        startApp(isLogged);
    }



    public void startApp(final boolean islogged)
    {
        new Handler().postDelayed(new Runnable()
        {
            public void run()
            {
                if(islogged)
                {
                    beginnerLevel = SharedPreferenceHelper.getSharedPreferenceInt(getApplicationContext(), Config.BEGINNERLEVEL, 0);

                    if(beginnerLevel == 0)
                    {
                        Intent in = new Intent(SplashActivity.this, BeginnerLevel1Activity.class);
                        startActivity(in);
                        finish();
                    }
                    else if(beginnerLevel == 1)
                    {
                        Intent in = new Intent(SplashActivity.this, BeginnerLevel2Activity.class);
                        startActivity(in);
                        finish();
                    }
                    else if(beginnerLevel == 2)
                    {
                        Intent in = new Intent(SplashActivity.this, BeginnerLevel3Activity.class);
                        startActivity(in);
                        finish();
                    }
                    else if(beginnerLevel == 3)
                    {
                        Intent in = new Intent(SplashActivity.this, MainActivity.class);
                        startActivity(in);
                        finish();
                    }
                }
                else
                {
                    Intent in = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(in);
                    finish();
                }
            }
        }, 5000);
    }
}
