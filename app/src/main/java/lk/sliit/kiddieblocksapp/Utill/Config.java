package lk.sliit.kiddieblocksapp.Utill;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import lk.sliit.kiddieblocksapp.R;

public class Config
{
    public static final String TAG = "Kiddie Blocks ";
    public static boolean LOG_ENABLE = true;

    // TAGS for Shared Preferences
    public static String USERDATA = "USERDATA";
    public static String ISCLIENTLOGGEDIN = "IS_CLIENT_LOGGED_IN";
    public static String ISREGISTERED = "IS_REGISTERED";
    public static String BEGINNERLEVEL = "BEGINNER_LEVEL";
    public static String COMPLETEDLEVELS = "COMPLETED_LEVELS";

    public static String KIDNAME = "KID_NAME";
    public static String KIDDOB = "KID_DOB";
    public static String KIDWEIGHT = "KID_WEIGHT";
    public static String KIDHEIGHT = "KID_HEIGHT";
    public static String KIDGENDER = "KID_GENDER";

    public static String COMPLETEDLEVELRESULT1 = "COMPLETED_LEVEL_RESULT_1";
    public static String COMPLETEDLEVELRESULT2 = "COMPLETED_LEVEL_RESULT_2";
    public static String COMPLETEDLEVELRESULT3 = "COMPLETED_LEVEL_RESULT_3";
    public static String COMPLETEDLEVELRESULT4 = "COMPLETED_LEVEL_RESULT_4";
    public static String COMPLETEDLEVELRESULT5 = "COMPLETED_LEVEL_RESULT_5";
    public static String COMPLETEDLEVELRESULT6 = "COMPLETED_LEVEL_RESULT_6";
    public static String COMPLETEDLEVELRESULT7 = "COMPLETED_LEVEL_RESULT_7";
    public static String COMPLETEDLEVELRESULT8 = "COMPLETED_LEVEL_RESULT_8";
    public static String COMPLETEDLEVELRESULT9 = "COMPLETED_LEVEL_RESULT_9";
    public static String COMPLETEDLEVELRESULT10 = "COMPLETED_LEVEL_RESULT_10";
    public static String COMPLETEDLEVELRESULT11 = "COMPLETED_LEVEL_RESULT_11";
    public static String COMPLETEDLEVELRESULT12 = "COMPLETED_LEVEL_RESULT_12";
    public static String COMPLETEDLEVELRESULT13 = "COMPLETED_LEVEL_RESULT_13";
    public static String COMPLETEDLEVELRESULT14 = "COMPLETED_LEVEL_RESULT_14";
    public static String COMPLETEDLEVELRESULT15 = "COMPLETED_LEVEL_RESULT_15";
    public static String COMPLETEDLEVELRESULT16 = "COMPLETED_LEVEL_RESULT_16";
    public static String COMPLETEDLEVELRESULT17 = "COMPLETED_LEVEL_RESULT_17";
    public static String COMPLETEDLEVELRESULT18 = "COMPLETED_LEVEL_RESULT_18";
    public static String COMPLETEDLEVELRESULT19 = "COMPLETED_LEVEL_RESULT_19";
    public static String COMPLETEDLEVELRESULT20 = "COMPLETED_LEVEL_RESULT_20";

    public static int BEGINNER_LEVEL_1 = 1;
    public static int BEGINNER_LEVEL_2 = 2;
    public static int BEGINNER_LEVEL_3 = 3;

    public static int PLAY_LEVEL_1 = 101;
    public static int PLAY_LEVEL_2 = 102;
    public static int PLAY_LEVEL_3 = 103;
    public static int PLAY_LEVEL_4 = 104;
    public static int PLAY_LEVEL_5 = 105;
    public static int PLAY_LEVEL_6 = 106;
    public static int PLAY_LEVEL_7 = 107;
    public static int PLAY_LEVEL_8 = 108;
    public static int PLAY_LEVEL_9 = 109;
    public static int PLAY_LEVEL_10 = 110;
    public static int PLAY_LEVEL_11 = 111;
    public static int PLAY_LEVEL_12 = 112;
    public static int PLAY_LEVEL_13 = 113;
    public static int PLAY_LEVEL_14 = 114;
    public static int PLAY_LEVEL_15 = 115;
    public static int PLAY_LEVEL_16 = 116;
    public static int PLAY_LEVEL_17 = 117;
    public static int PLAY_LEVEL_18 = 118;
    public static int PLAY_LEVEL_19 = 119;
    public static int PLAY_LEVEL_20 = 120;

    public static int PLAY_LEVEL_COMPLETED_1 = 201;
    public static int PLAY_LEVEL_COMPLETED_2 = 202;
    public static int PLAY_LEVEL_COMPLETED_3 = 203;
    public static int PLAY_LEVEL_COMPLETED_4 = 204;
    public static int PLAY_LEVEL_COMPLETED_5 = 205;
    public static int PLAY_LEVEL_COMPLETED_6 = 206;
    public static int PLAY_LEVEL_COMPLETED_7 = 207;
    public static int PLAY_LEVEL_COMPLETED_8 = 208;
    public static int PLAY_LEVEL_COMPLETED_9 = 209;
    public static int PLAY_LEVEL_COMPLETED_10 = 210;
    public static int PLAY_LEVEL_COMPLETED_11 = 211;
    public static int PLAY_LEVEL_COMPLETED_12 = 212;
    public static int PLAY_LEVEL_COMPLETED_13 = 213;
    public static int PLAY_LEVEL_COMPLETED_14 = 214;
    public static int PLAY_LEVEL_COMPLETED_15 = 215;
    public static int PLAY_LEVEL_COMPLETED_16 = 216;
    public static int PLAY_LEVEL_COMPLETED_17 = 217;
    public static int PLAY_LEVEL_COMPLETED_18 = 218;
    public static int PLAY_LEVEL_COMPLETED_19 = 219;
    public static int PLAY_LEVEL_COMPLETED_20 = 220;

    public static String BEGINNER_LEVEL_1_RESULT = "BEGINNERLEVEL1RESULT";
    public static String BEGINNER_LEVEL_2_RESULT = "BEGINNERLEVEL2RESULT";
    public static String BEGINNER_LEVEL_3_RESULT = "BEGINNERLEVEL3RESULT";

    public static final double ResultCutOff = 0.72;


    public static void showToast(Context context, String msg)
    {
        try
        {
            Toast.makeText(context, msg + "", Toast.LENGTH_SHORT).show();
        }
        catch (Exception e)
        {
            Config.logPrint(Config.TAG + "Config showToast error: " + e.getMessage());
        }
    }

    public static void logPrint(String msg)
    {
        try
        {
            if(Config.LOG_ENABLE)
            {
                System.out.println(msg);
            }
        }
        catch (Exception e)
        {
            Config.logPrint(Config.TAG + "Config logPrint error: " + e.getMessage());
        }
    }

    public static void setStatusBarColor(Context context, Activity activity)
    {
        try
        {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            {
                Window window = activity.getWindow();
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(context.getResources().getColor(R.color.colorPrimaryDark));
            }
        }
        catch (Exception e)
        {
            Config.logPrint(Config.TAG + "Config setStatusBarColor error: " + e.getMessage());
        }
    }
}
