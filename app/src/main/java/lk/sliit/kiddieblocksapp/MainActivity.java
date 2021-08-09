package lk.sliit.kiddieblocksapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import lk.sliit.kiddieblocksapp.Utill.Config;
import lk.sliit.kiddieblocksapp.Utill.SharedPreferenceHelper;

public class MainActivity extends Activity
{
    public Button btnPlay, btnPerfomance, btnRecommendation, btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Config.setStatusBarColor(getApplicationContext(), MainActivity.this);

        initialize();
        eventHandler();
    }


    public void initialize()
    {
        btnPlay = (Button) findViewById(R.id.btn_play);
        btnPerfomance = (Button) findViewById(R.id.btn_performance);
        btnRecommendation = (Button) findViewById(R.id.btn_recommendations);
        btnLogout = (Button) findViewById(R.id.btn_logout);
    }

    public void eventHandler()
    {
        btnPlay.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent in = new Intent(MainActivity.this, PlayActivity.class);
                startActivity(in);
            }
        });

        btnPerfomance.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent in = new Intent(MainActivity.this, PerformanceActivity.class);
                startActivity(in);
            }
        });

        btnRecommendation.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent in = new Intent(MainActivity.this, RecommendationsActivity.class);
                startActivity(in);
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                SharedPreferenceHelper.setSharedPreferenceBoolean(getApplicationContext(), Config.ISCLIENTLOGGEDIN, false);

                Intent in = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(in);
                finish();
            }
        });
    }
}
