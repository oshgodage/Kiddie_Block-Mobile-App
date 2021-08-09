package lk.sliit.kiddieblocksapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class RecommendationsActivity extends Activity
{
    public ImageView ivBack;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommendations);

        initialize();
        eventHandler();
    }


    public void initialize()
    {
        ivBack = (ImageView) findViewById(R.id.iv_backRecommendations);
    }

    public void eventHandler()
    {
        ivBack.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                finish();
            }
        });
    }
}
