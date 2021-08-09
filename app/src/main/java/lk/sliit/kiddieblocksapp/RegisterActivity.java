package lk.sliit.kiddieblocksapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import lk.sliit.kiddieblocksapp.Utill.Config;
import lk.sliit.kiddieblocksapp.Utill.SharedPreferenceHelper;

public class RegisterActivity extends Activity
{
    public EditText etName, etBirthday, etWeight, etHeight;
    public RadioGroup rgGender;
    public Button btnRegister;
    public Calendar myCalendar;
    public DatePickerDialog.OnDateSetListener date;
    public DatePickerDialog dialog;
    public ImageView ivBack;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Config.setStatusBarColor(getApplicationContext(), RegisterActivity.this);

        initialize();
        eventHandler();
    }


    public void initialize()
    {
        etName = (EditText) findViewById(R.id.et_name);
        etBirthday = (EditText) findViewById(R.id.et_birthday);
        etWeight = (EditText) findViewById(R.id.et_weight);
        etHeight = (EditText) findViewById(R.id.et_height);

        ivBack = (ImageView) findViewById(R.id.iv_backReg);

        rgGender = (RadioGroup) findViewById(R.id.rgGender);

        btnRegister = (Button) findViewById(R.id.btn_register);

        myCalendar = Calendar.getInstance();
    }

    public void eventHandler()
    {
        date = new DatePickerDialog.OnDateSetListener()
        {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth)
            {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }
        };


        etBirthday.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // TODO Auto-generated method stub
                dialog = new DatePickerDialog(RegisterActivity.this, AlertDialog.THEME_HOLO_LIGHT, date, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH));
                dialog.getDatePicker().setMaxDate(new Date().getTime());
                dialog.show();
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


        btnRegister.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String name = etName.getText().toString().trim();
                String dob = etBirthday.getText().toString().trim();
                int weight = getWeight();
                double height = getHeight();
                String gender = getGender();

                //Toast.makeText(RegisterActivity.this, gender, Toast.LENGTH_SHORT).show();
                if(!name.equals("") && !dob.equals("") && weight != -1 && height != -1.0 && !gender.equals(""))
                {
                    SharedPreferenceHelper.setSharedPreferenceBoolean(RegisterActivity.this, Config.ISREGISTERED, true);

                    SharedPreferenceHelper.setSharedPreferenceString(RegisterActivity.this, Config.KIDNAME, name);
                    SharedPreferenceHelper.setSharedPreferenceString(RegisterActivity.this, Config.KIDDOB, dob);
                    SharedPreferenceHelper.setSharedPreferenceString(RegisterActivity.this, Config.KIDGENDER, gender);
                    SharedPreferenceHelper.setSharedPreferenceInt(RegisterActivity.this, Config.KIDWEIGHT, weight);
                    SharedPreferenceHelper.setSharedPreferenceFloat(RegisterActivity.this, Config.KIDHEIGHT, (float) height);

                    Toast.makeText(RegisterActivity.this, "Successfully registered...", Toast.LENGTH_SHORT).show();
                    finish();
                }
                else
                {
                    Toast.makeText(RegisterActivity.this, "Some fields empty...", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    public int getWeight()
    {
        int weight = -1;

        try
        {
            String w = etWeight.getText().toString();
            weight = Integer.parseInt(w);
        }
        catch (Exception e)
        {
            weight = -1;
        }

        return weight;
    }


    public double getHeight()
    {
        double height = -1.0;

        try
        {
            String h = etHeight.getText().toString();
            height = Double.parseDouble(h);
        }
        catch (Exception e)
        {
            height = -1.0;
        }

        return height;
    }


    public String getGender()
    {
        String gender = "";

        int selectedId = rgGender.getCheckedRadioButtonId();

        if(selectedId != -1)
        {
            RadioButton rbGender = (RadioButton) findViewById(selectedId);
            gender = rbGender.getText().toString().trim();
        }
        else
        {
            gender = "";
        }

        return gender;
    }


    public void updateLabel()
    {
        String myFormat = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        etBirthday.setText(sdf.format(myCalendar.getTime()));
    }
}
