package lk.sliit.kiddieblocksapp.Utill;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by pc on 25/02/2017.
 */

public class SharedPreferenceHelper {
	private final static String PREF_FILE = "PREF";

	/**
	 * Set a string shared preference
	 * @param key - Key to set shared preference
	 * @param value - Value for the key
	 */
	public static void setSharedPreferenceString(Context context, String key, String value){
		SharedPreferences settings = context.getSharedPreferences(PREF_FILE, 0);
		SharedPreferences.Editor editor = settings.edit();
		editor.putString(key, value);
		editor.apply();
	}

	/**
	 * Set a integer shared preference
	 * @param key - Key to set shared preference
	 * @param value - Value for the key
	 */
	public static void setSharedPreferenceInt(Context context, String key, int value){
		SharedPreferences settings = context.getSharedPreferences(PREF_FILE, 0);
		SharedPreferences.Editor editor = settings.edit();
		editor.putInt(key, value);
		editor.apply();
	}

	/**
	 * Set a long shared preference
	 * @param key - Key to set shared preference
	 * @param value - Value for the key
	 */
	public static void setSharedPreferenceLong(Context context, String key, long value){
		SharedPreferences settings = context.getSharedPreferences(PREF_FILE, 0);
		SharedPreferences.Editor editor = settings.edit();
		editor.putLong(key, value);
		editor.apply();
	}


	/**
	 * Set a long shared preference
	 * @param key - Key to set shared preference
	 * @param value - Value for the key
	 */
	public static void setSharedPreferenceFloat(Context context, String key, float value){
		SharedPreferences settings = context.getSharedPreferences(PREF_FILE, 0);
		SharedPreferences.Editor editor = settings.edit();
		editor.putFloat(key, value);
		editor.apply();
	}

	/**
	 * Set a Boolean shared preference
	 * @param key - Key to set shared preference
	 * @param value - Value for the key
	 */
	public static void setSharedPreferenceBoolean(Context context, String key, boolean value){
		SharedPreferences settings = context.getSharedPreferences(PREF_FILE, 0);
		SharedPreferences.Editor editor = settings.edit();
		editor.putBoolean(key, value);
		editor.apply();
	}

	/**
	 * Get a string shared preference
	 * @param key - Key to look up in shared preferences.
	 * @param defValue - Default value to be returned if shared preference isn't found.
	 * @return value - String containing value of the shared preference if found.
	 */
	public static String getSharedPreferenceString(Context context, String key, String defValue){
		SharedPreferences settings = context.getSharedPreferences(PREF_FILE, 0);
		return settings.getString(key, defValue);
	}

	/**
	 * Get a integer shared preference
	 * @param key - Key to look up in shared preferences.
	 * @param defValue - Default value to be returned if shared preference isn't found.
	 * @return value - String containing value of the shared preference if found.
	 */
	public static int getSharedPreferenceInt(Context context, String key, int defValue){
		SharedPreferences settings = context.getSharedPreferences(PREF_FILE, 0);
		return settings.getInt(key, defValue);
	}


	/**
	 * Get a long shared preference
	 * @param key - Key to look up in shared preferences.
	 * @param defValue - Default value to be returned if shared preference isn't found.
	 * @return value - String containing value of the shared preference if found.
	 */
	public static long getSharedPreferenceLong(Context context, String key, long defValue){
		SharedPreferences settings = context.getSharedPreferences(PREF_FILE, 0);
		return settings.getLong(key, defValue);
	}

	/**
	 * Get a boolean shared preference
	 * @param key - Key to look up in shared preferences.
	 * @param defValue - Default value to be returned if shared preference isn't found.
	 * @return value - String containing value of the shared preference if found.
	 */
	public static boolean getSharedPreferenceBoolean(Context context, String key, boolean defValue){
		SharedPreferences settings = context.getSharedPreferences(PREF_FILE, 0);
		return settings.getBoolean(key, defValue);
	}


	/**
	 * Get a boolean shared preference
	 * @param key - Key to look up in shared preferences.
	 * @param defValue - Default value to be returned if shared preference isn't found.
	 * @return value - String containing value of the shared preference if found.
	 */
	public static float getSharedPreferenceFloat(Context context, String key, float defValue){
		SharedPreferences settings = context.getSharedPreferences(PREF_FILE, 0);
		return settings.getFloat(key, defValue);
	}
}