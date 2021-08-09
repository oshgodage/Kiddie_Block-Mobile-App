package lk.sliit.kiddieblocksapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.otaliastudios.cameraview.CameraListener;
import com.otaliastudios.cameraview.CameraView;
import lk.sliit.kiddieblocksapp.Utill.Config;

public class ImageCaptureActivity extends Activity
{
    public CameraView cameraView;
    public ImageView ivImageCaptured, ivBack;
    public TextView tvResult;
    public ImageButton btnImageCapture, btnResultSubmit;
    public boolean isImageCaptured = false;
    public int level = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_capture);

        Config.setStatusBarColor(getApplicationContext(), ImageCaptureActivity.this);

        initialize();
        eventHandler();
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        cameraView.start();
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        cameraView.stop();
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        cameraView.destroy();
    }

    @Override
    public void onBackPressed()
    {
        //super.onBackPressed();
        if(level != -1)
        {
            Intent intent = new Intent();
            intent.putExtra("result", 1.5);
            setResult(level, intent);
            finish();
        }
    }

    public void initialize()
    {
        cameraView = (CameraView) findViewById(R.id.cameraView);
        ivImageCaptured = (ImageView) findViewById(R.id.iv_capturedImage);
        ivBack = (ImageView) findViewById(R.id.iv_backCapture);
        tvResult = (TextView) findViewById(R.id.tv_result);
        btnImageCapture = (ImageButton) findViewById(R.id.btn_imageCapture);
        btnResultSubmit = (ImageButton) findViewById(R.id.btn_resultSubmit);

        getBundleData();
    }


    public void eventHandler()
    {
        cameraView.addCameraListener(new CameraListener()
        {
            @Override
            public void onPictureTaken(byte[] picture)
            {
                //Config.showToast(ImageCaptureActivity.this,"OK");
                Bitmap bitmap = BitmapFactory.decodeByteArray(picture, 0, picture.length);
                ivImageCaptured.setImageBitmap(bitmap);
                tvResult.setText("Image captured ok...");

                isImageCaptured = true;
            }
        });

        btnImageCapture.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                cameraView.capturePicture();
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

        btnResultSubmit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(level != -1)
                {
                    if(isImageCaptured)
                    {
                        Intent intent = new Intent();
                        intent.putExtra("result", 0.75);
                        setResult(level, intent);
                        finish();
                    }
                    else
                    {
                        Config.showToast(ImageCaptureActivity.this,"Please capture image first...");
                    }
                }
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
}
