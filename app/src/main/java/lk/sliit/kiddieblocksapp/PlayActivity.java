package lk.sliit.kiddieblocksapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import lk.sliit.kiddieblocksapp.Utill.Config;
import lk.sliit.kiddieblocksapp.Utill.SharedPreferenceHelper;

public class PlayActivity extends Activity
{
    public LinearLayout loLevel1, loLevel2, loLevel3, loLevel4, loLevel5, loLevel6, loLevel7, loLevel8, loLevel9, loLevel10;
    public LinearLayout loLevel11, loLevel12, loLevel13, loLevel14, loLevel15, loLevel16, loLevel17, loLevel18, loLevel19, loLevel20;
    public ImageView ivBlockLevel1, ivBlockLevel2, ivBlockLevel3, ivBlockLevel4, ivBlockLevel5, ivBlockLevel6, ivBlockLevel7, ivBlockLevel8, ivBlockLevel9, ivBlockLevel10;
    public ImageView ivBlockLevel11, ivBlockLevel12, ivBlockLevel13, ivBlockLevel14, ivBlockLevel15, ivBlockLevel16, ivBlockLevel17, ivBlockLevel18, ivBlockLevel19, ivBlockLevel20;
    public ImageView ivCompleteLevel1, ivCompleteLevel2, ivCompleteLevel3, ivCompleteLevel4, ivCompleteLevel5, ivCompleteLevel6, ivCompleteLevel7, ivCompleteLevel8, ivCompleteLevel9, ivCompleteLevel10;
    public ImageView ivCompleteLevel11, ivCompleteLevel12, ivCompleteLevel13, ivCompleteLevel14, ivCompleteLevel15, ivCompleteLevel16, ivCompleteLevel17, ivCompleteLevel18, ivCompleteLevel19, ivCompleteLevel20;
    public ImageView ivBack;

    int completedLevels = 0;

    public int[] clickablePosition = new int[20];

    public boolean[] clickableStatus = new boolean[20];

    public int linearLayoutsArray[] =  {R.id.lo_level1, R.id.lo_level2, R.id.lo_level3, R.id.lo_level4, R.id.lo_level5, R.id.lo_level6, R.id.lo_level7, R.id.lo_level8, R.id.lo_level9, R.id.lo_level10,
        R.id.lo_level11, R.id.lo_level12, R.id.lo_level13, R.id.lo_level14, R.id.lo_level15, R.id.lo_level16, R.id.lo_level17, R.id.lo_level18, R.id.lo_level19, R.id.lo_level20};

    public int blockImagesArray[] = {R.id.iv_blockLevel1, R.id.iv_blockLevel2, R.id.iv_blockLevel3, R.id.iv_blockLevel4, R.id.iv_blockLevel5, R.id.iv_blockLevel6, R.id.iv_blockLevel7, R.id.iv_blockLevel8, R.id.iv_blockLevel9, R.id.iv_blockLevel10
            , R.id.iv_blockLevel11, R.id.iv_blockLevel12, R.id.iv_blockLevel13, R.id.iv_blockLevel14, R.id.iv_blockLevel15, R.id.iv_blockLevel16, R.id.iv_blockLevel17, R.id.iv_blockLevel18, R.id.iv_blockLevel19, R.id.iv_blockLevel20};

    public int completeImagesArray[] = {R.id.iv_completeLevel1, R.id.iv_completeLevel2, R.id.iv_completeLevel3, R.id.iv_completeLevel4, R.id.iv_completeLevel5, R.id.iv_completeLevel6, R.id.iv_completeLevel7, R.id.iv_completeLevel8, R.id.iv_completeLevel9, R.id.iv_completeLevel10,
            R.id.iv_completeLevel11, R.id.iv_completeLevel12, R.id.iv_completeLevel13, R.id.iv_completeLevel14, R.id.iv_completeLevel15, R.id.iv_completeLevel16, R.id.iv_completeLevel17, R.id.iv_completeLevel18, R.id.iv_completeLevel19, R.id.iv_completeLevel20};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        Config.setStatusBarColor(getApplicationContext(), PlayActivity.this);

        initialize();
        //setInitialUI();

        eventHandler();
    }

    @Override
    protected void onResume()
    {
        super.onResume();

        setInitialUI();
    }

    public void initialize()
    {
        ivBack = (ImageView) findViewById(R.id.iv_backPlay);

        /*loLevel1 = (LinearLayout) findViewById(R.id.lo_level1);
        loLevel2 = (LinearLayout) findViewById(R.id.lo_level2);
        loLevel3 = (LinearLayout) findViewById(R.id.lo_level3);
        loLevel4 = (LinearLayout) findViewById(R.id.lo_level4);
        loLevel5 = (LinearLayout) findViewById(R.id.lo_level5);
        loLevel6 = (LinearLayout) findViewById(R.id.lo_level6);
        loLevel7 = (LinearLayout) findViewById(R.id.lo_level7);
        loLevel8 = (LinearLayout) findViewById(R.id.lo_level8);
        loLevel9 = (LinearLayout) findViewById(R.id.lo_level9);
        loLevel10 = (LinearLayout) findViewById(R.id.lo_level10);
        loLevel11 = (LinearLayout) findViewById(R.id.lo_level11);
        loLevel12 = (LinearLayout) findViewById(R.id.lo_level12);
        loLevel13 = (LinearLayout) findViewById(R.id.lo_level13);
        loLevel14 = (LinearLayout) findViewById(R.id.lo_level14);
        loLevel15 = (LinearLayout) findViewById(R.id.lo_level15);
        loLevel16 = (LinearLayout) findViewById(R.id.lo_level16);
        loLevel17 = (LinearLayout) findViewById(R.id.lo_level17);
        loLevel18 = (LinearLayout) findViewById(R.id.lo_level18);
        loLevel19 = (LinearLayout) findViewById(R.id.lo_level19);
        loLevel20 = (LinearLayout) findViewById(R.id.lo_level20);

        ivBlockLevel1 = (ImageView) findViewById(R.id.iv_blockLevel1);
        ivBlockLevel2 = (ImageView) findViewById(R.id.iv_blockLevel2);
        ivBlockLevel3 = (ImageView) findViewById(R.id.iv_blockLevel3);
        ivBlockLevel4 = (ImageView) findViewById(R.id.iv_blockLevel4);
        ivBlockLevel5 = (ImageView) findViewById(R.id.iv_blockLevel5);
        ivBlockLevel6 = (ImageView) findViewById(R.id.iv_blockLevel6);
        ivBlockLevel7 = (ImageView) findViewById(R.id.iv_blockLevel7);
        ivBlockLevel8 = (ImageView) findViewById(R.id.iv_blockLevel8);
        ivBlockLevel9 = (ImageView) findViewById(R.id.iv_blockLevel9);
        ivBlockLevel10 = (ImageView) findViewById(R.id.iv_blockLevel10);
        ivBlockLevel11 = (ImageView) findViewById(R.id.iv_blockLevel11);
        ivBlockLevel12 = (ImageView) findViewById(R.id.iv_blockLevel12);
        ivBlockLevel13 = (ImageView) findViewById(R.id.iv_blockLevel13);
        ivBlockLevel14 = (ImageView) findViewById(R.id.iv_blockLevel14);
        ivBlockLevel15 = (ImageView) findViewById(R.id.iv_blockLevel15);
        ivBlockLevel16 = (ImageView) findViewById(R.id.iv_blockLevel16);
        ivBlockLevel17 = (ImageView) findViewById(R.id.iv_blockLevel17);
        ivBlockLevel18 = (ImageView) findViewById(R.id.iv_blockLevel18);
        ivBlockLevel19 = (ImageView) findViewById(R.id.iv_blockLevel19);
        ivBlockLevel20 = (ImageView) findViewById(R.id.iv_blockLevel20);

        ivCompleteLevel1 = (ImageView) findViewById(R.id.iv_completeLevel1);
        ivCompleteLevel2 = (ImageView) findViewById(R.id.iv_completeLevel1);
        ivCompleteLevel3 = (ImageView) findViewById(R.id.iv_completeLevel1);
        ivCompleteLevel4 = (ImageView) findViewById(R.id.iv_completeLevel1);
        ivCompleteLevel5 = (ImageView) findViewById(R.id.iv_completeLevel1);
        ivCompleteLevel6 = (ImageView) findViewById(R.id.iv_completeLevel1);
        ivCompleteLevel7 = (ImageView) findViewById(R.id.iv_completeLevel1);
        ivCompleteLevel8 = (ImageView) findViewById(R.id.iv_completeLevel1);
        ivCompleteLevel9 = (ImageView) findViewById(R.id.iv_completeLevel1);
        ivCompleteLevel10 = (ImageView) findViewById(R.id.iv_completeLevel1);
        ivCompleteLevel11 = (ImageView) findViewById(R.id.iv_completeLevel1);
        ivCompleteLevel12 = (ImageView) findViewById(R.id.iv_completeLevel1);
        ivCompleteLevel13 = (ImageView) findViewById(R.id.iv_completeLevel1);
        ivCompleteLevel14 = (ImageView) findViewById(R.id.iv_completeLevel1);
        ivCompleteLevel15 = (ImageView) findViewById(R.id.iv_completeLevel1);
        ivCompleteLevel16 = (ImageView) findViewById(R.id.iv_completeLevel1);
        ivCompleteLevel17 = (ImageView) findViewById(R.id.iv_completeLevel1);
        ivCompleteLevel18 = (ImageView) findViewById(R.id.iv_completeLevel1);
        ivCompleteLevel19 = (ImageView) findViewById(R.id.iv_completeLevel1);
        ivCompleteLevel20 = (ImageView) findViewById(R.id.iv_completeLevel1);*/
    }

    public void eventHandler()
    {
        setLoClickable();

        ivBack.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                finish();
            }
        });
    }

    public void setInitialUI()
    {
        completedLevels = SharedPreferenceHelper.getSharedPreferenceInt(getApplicationContext(), Config.COMPLETEDLEVELS, 1);

        for(int i = 0; i < completedLevels; i++)
        {
            ImageView ivComplete1 = (ImageView) findViewById(completeImagesArray[i]);
            ivComplete1.setVisibility(View.VISIBLE);

            ImageView ivBlock1 = (ImageView) findViewById(blockImagesArray[i]);
            ivBlock1.setVisibility(View.GONE);

            clickableStatus[i] = true;
            clickablePosition[i] = i;
        }

        if(completedLevels <= 19)
        {
            ImageView ivComplete2 = (ImageView) findViewById(completeImagesArray[completedLevels]);
            ivComplete2.setVisibility(View.GONE);

            ImageView ivBlock2 = (ImageView) findViewById(blockImagesArray[completedLevels]);
            ivBlock2.setVisibility(View.GONE);

            clickableStatus[completedLevels] = true;
            clickablePosition[completedLevels] = completedLevels;

            for(int j = completedLevels + 1; j < 20; j++)
            {
                ImageView ivComplete3 = (ImageView) findViewById(completeImagesArray[j]);
                ivComplete3.setVisibility(View.GONE);

                ImageView ivBlock3 = (ImageView) findViewById(blockImagesArray[j]);
                ivBlock3.setVisibility(View.VISIBLE);

                clickableStatus[j] = false;
            }
        }
    }


    public void setLoClickable()
    {
        for(int i = 0; i < 20; i++)
        {
            final int n = i;

            LinearLayout lo = (LinearLayout) findViewById(linearLayoutsArray[i]);
            lo.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    if(clickableStatus[n])
                    {
                        //Toast.makeText(PlayActivity.this, "OK", Toast.LENGTH_SHORT).show();
                        Intent in = new Intent(PlayActivity.this, PlayPreviewActivity.class);
                        in.putExtra("level", (n + 1));
                        startActivity(in);
                    }
                    else
                    {
                        Toast.makeText(PlayActivity.this,"Please unlock the level " + (n + 1) + " for play", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}
