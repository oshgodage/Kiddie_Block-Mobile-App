package lk.sliit.kiddieblocksapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import lk.sliit.kiddieblocksapp.Utill.Config;
import lk.sliit.kiddieblocksapp.Utill.SharedPreferenceHelper;

public class PlayPreviewActivity extends Activity
{
    public TextView tvHeader, tvLevelResults;
    public ImageView ivLevelImage, ivBack;
    public LinearLayout loToComplete, loCompleted;
    public ImageButton btnCapture, btnSubmit, btnCaptureCompleted, btnSubmitCompleted;
    public double resultValue = 0.0;

    public int level = 1, completedLevel = 1;

    public int levelImages[] = {R.mipmap.ic_level_1, R.mipmap.ic_level_2, R.mipmap.ic_level_3, R.mipmap.ic_level_4, R.mipmap.ic_level_5, R.mipmap.ic_level_6, R.mipmap.ic_level_7, R.mipmap.ic_level_8, R.mipmap.ic_level_9, R.mipmap.ic_level_10,
            R.mipmap.ic_level_11, R.mipmap.ic_level_12, R.mipmap.ic_level_13, R.mipmap.ic_level_14, R.mipmap.ic_level_15, R.mipmap.ic_level_16, R.mipmap.ic_level_17, R.mipmap.ic_level_18, R.mipmap.ic_level_19, R.mipmap.ic_level_20};

    public String completedLevelResultArray[] = {Config.COMPLETEDLEVELRESULT1, Config.COMPLETEDLEVELRESULT2, Config.COMPLETEDLEVELRESULT3, Config.COMPLETEDLEVELRESULT4, Config.COMPLETEDLEVELRESULT5, Config.COMPLETEDLEVELRESULT6, Config.COMPLETEDLEVELRESULT7, Config.COMPLETEDLEVELRESULT8, Config.COMPLETEDLEVELRESULT9, Config.COMPLETEDLEVELRESULT10,
            Config.COMPLETEDLEVELRESULT11, Config.COMPLETEDLEVELRESULT12, Config.COMPLETEDLEVELRESULT13, Config.COMPLETEDLEVELRESULT14, Config.COMPLETEDLEVELRESULT15, Config.COMPLETEDLEVELRESULT16, Config.COMPLETEDLEVELRESULT17, Config.COMPLETEDLEVELRESULT18, Config.COMPLETEDLEVELRESULT19, Config.COMPLETEDLEVELRESULT20};

    public int playLevelArray[] = {Config.PLAY_LEVEL_1, Config.PLAY_LEVEL_2, Config.PLAY_LEVEL_3, Config.PLAY_LEVEL_4, Config.PLAY_LEVEL_5, Config.PLAY_LEVEL_6, Config.PLAY_LEVEL_7, Config.PLAY_LEVEL_8, Config.PLAY_LEVEL_9, Config.PLAY_LEVEL_10,
            Config.PLAY_LEVEL_11, Config.PLAY_LEVEL_12, Config.PLAY_LEVEL_13, Config.PLAY_LEVEL_14, Config.PLAY_LEVEL_15, Config.PLAY_LEVEL_16, Config.PLAY_LEVEL_17, Config.PLAY_LEVEL_18, Config.PLAY_LEVEL_19, Config.PLAY_LEVEL_20};

    public int playLevelCompletedArray[] = {Config.PLAY_LEVEL_COMPLETED_1, Config.PLAY_LEVEL_COMPLETED_2, Config.PLAY_LEVEL_COMPLETED_3, Config.PLAY_LEVEL_COMPLETED_4, Config.PLAY_LEVEL_COMPLETED_5, Config.PLAY_LEVEL_COMPLETED_6, Config.PLAY_LEVEL_COMPLETED_7, Config.PLAY_LEVEL_COMPLETED_8, Config.PLAY_LEVEL_COMPLETED_9, Config.PLAY_LEVEL_COMPLETED_10,
            Config.PLAY_LEVEL_COMPLETED_11, Config.PLAY_LEVEL_COMPLETED_12, Config.PLAY_LEVEL_COMPLETED_13, Config.PLAY_LEVEL_COMPLETED_14, Config.PLAY_LEVEL_COMPLETED_15, Config.PLAY_LEVEL_COMPLETED_16, Config.PLAY_LEVEL_COMPLETED_17, Config.PLAY_LEVEL_COMPLETED_18, Config.PLAY_LEVEL_COMPLETED_19, Config.PLAY_LEVEL_COMPLETED_20};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_preview);

        initialize();
        eventHandler();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == playLevelArray[level - 1])
        {
            if(data != null)
            {
                resultValue = data.getDoubleExtra("result", 0.85);

                if(resultValue > 1.0)
                {
                    btnCapture.setVisibility(View.VISIBLE);
                    btnSubmit.setVisibility(View.GONE);
                }
                else
                {
                    btnCapture.setVisibility(View.GONE);
                    btnSubmit.setVisibility(View.VISIBLE);
                }
            }
        }
        else if(requestCode ==  playLevelCompletedArray[level - 1])
        {
            if(data != null)
            {
                resultValue = data.getDoubleExtra("result", 0.85);

                if(resultValue > 1.0)
                {
                    btnCaptureCompleted.setVisibility(View.VISIBLE);
                    btnSubmitCompleted.setVisibility(View.GONE);
                }
                else
                {
                    btnCaptureCompleted.setVisibility(View.GONE);
                    btnSubmitCompleted.setVisibility(View.VISIBLE);
                }
            }
        }
    }

    public void initialize()
    {
        getBundleData();

        completedLevel = SharedPreferenceHelper.getSharedPreferenceInt(getApplicationContext(), Config.COMPLETEDLEVELS, 1);

        tvHeader = (TextView) findViewById(R.id.tv_header);
        tvLevelResults = (TextView) findViewById(R.id.tv_levelResult);

        ivLevelImage = (ImageView) findViewById(R.id.iv_levelModelImage);
        ivBack = (ImageView) findViewById(R.id.iv_backPreview);

        loToComplete = (LinearLayout) findViewById(R.id.lo_toComplete);
        loCompleted = (LinearLayout) findViewById(R.id.lo_completed);

        btnCapture = (ImageButton) findViewById(R.id.btn_capture);
        btnSubmit = (ImageButton) findViewById(R.id.btn_submit);
        btnCaptureCompleted = (ImageButton) findViewById(R.id.btn_captureCompleted);
        btnSubmitCompleted = (ImageButton) findViewById(R.id.btn_submitCompleted);
    }


    public void eventHandler()
    {
        setImageByLevel();
        setCompletedOrToCompleteUI();

        btnCapture.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent in = new Intent(PlayPreviewActivity.this, ImageCaptureActivity.class);
                in.putExtra("level", playLevelArray[level - 1]);
                startActivityForResult(in, playLevelArray[level - 1]);
            }
        });

        btnCaptureCompleted.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent in = new Intent(PlayPreviewActivity.this, ImageCaptureActivity.class);
                in.putExtra("level", playLevelCompletedArray[level - 1]);
                startActivityForResult(in, playLevelCompletedArray[level - 1]);
            }
        });

        ivBack.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                finish();
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                SharedPreferenceHelper.setSharedPreferenceFloat(getApplicationContext(), completedLevelResultArray[level - 1], (float) resultValue);

                if(resultValue >= Config.ResultCutOff)
                {
                    SharedPreferenceHelper.setSharedPreferenceInt(getApplicationContext(), Config.COMPLETEDLEVELS, level);
                }
                else
                {

                }

                finish();
            }
        });

        btnSubmitCompleted.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                SharedPreferenceHelper.setSharedPreferenceFloat(getApplicationContext(), completedLevelResultArray[level - 1], (float) resultValue);

                finish();
            }
        });
    }

    public void getBundleData()
    {
        Intent intent = getIntent();
        if(intent != null)
        {
            level = intent.getIntExtra("level", -1);
        }
    }

    public void setImageByLevel()
    {
        if(level != -1)
        {
            for(int i = 0; i < 20; i++)
            {
                if(i == (level - 1))
                {
                    ivLevelImage.setImageResource(levelImages[i]);
                }
            }
        }
    }

    public void setCompletedOrToCompleteUI()
    {
        if(level <= completedLevel)
        {
            tvHeader.setText("Level " + level + " Completed");

            float resultValue = SharedPreferenceHelper.getSharedPreferenceFloat(getApplicationContext(), completedLevelResultArray[level - 1], 0.0f);
            tvLevelResults.setText("Result: " + resultValue);

            loCompleted.setVisibility(View.VISIBLE);
            loToComplete.setVisibility(View.GONE);
        }
        else
        {
            tvHeader.setText("Level " + level);

            loCompleted.setVisibility(View.GONE);
            loToComplete.setVisibility(View.VISIBLE);
        }
    }
}
