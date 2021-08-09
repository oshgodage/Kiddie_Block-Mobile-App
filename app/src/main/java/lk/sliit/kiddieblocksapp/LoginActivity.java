package lk.sliit.kiddieblocksapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import lk.sliit.kiddieblocksapp.Utill.Config;
import lk.sliit.kiddieblocksapp.Utill.SharedPreferenceHelper;

public class LoginActivity extends Activity
{
    public EditText etUN;
    public TextView tvRegister;
    public Button btnLogin;

    public static final String un = "Sam";
    //public static final String pwd = "user123";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Config.setStatusBarColor(getApplicationContext(), LoginActivity.this);

        initialize();
        eventHandler();
    }


    public void initialize()
    {
        etUN = (EditText) findViewById(R.id.et_un);
       // etPWD = (EditText) findViewById(R.id.et_pwd);

        tvRegister = (TextView) findViewById(R.id.tv_register3);

        btnLogin = (Button) findViewById(R.id.btn_login);

    }

    public void eventHandler()
    {
        btnLogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                boolean isRegistered =  SharedPreferenceHelper.getSharedPreferenceBoolean(LoginActivity.this, Config.ISREGISTERED, false);

               String un = "";
               un = etUN.getText().toString().trim();
               //pwd = etPWD.getText().toString().trim();

               if(isRegistered)
               {
                   if(un.equals("") )
                   {
                       Config.showToast(LoginActivity.this, "Some fields empty...");
                   }
                   else
                   {
                       if(un.equals("Sam"))
                       {
                           SharedPreferenceHelper.setSharedPreferenceBoolean(getApplicationContext(), Config.ISCLIENTLOGGEDIN, true);

                           int beginnerLevel = SharedPreferenceHelper.getSharedPreferenceInt(getApplicationContext(), Config.BEGINNERLEVEL, 0);

                           if(beginnerLevel == 0)
                           {
                               Intent in = new Intent(LoginActivity.this, BeginnerLevel1Activity.class);
                               startActivity(in);
                               finish();
                           }
                           else if(beginnerLevel == 1)
                           {
                               Intent in = new Intent(LoginActivity.this, BeginnerLevel2Activity.class);
                               startActivity(in);
                               finish();
                           }
                           else if(beginnerLevel == 2)
                           {
                               Intent in = new Intent(LoginActivity.this, BeginnerLevel3Activity.class);
                               startActivity(in);
                               finish();
                           }
                           else if(beginnerLevel == 3)
                           {
                               Intent in = new Intent(LoginActivity.this, MainActivity.class);
                               startActivity(in);
                               finish();
                           }
                       }
                       else
                       {
                           Config.showToast(LoginActivity.this, "User name wrong...");
                       }
                   }
               }
               else
               {
                   Config.showToast(LoginActivity.this, "Please register your child first...");
               }
            }
        });

        tvRegister.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent in = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(in);
            }
        });
    }
}
