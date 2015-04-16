package com.wmkapp.wmkapp;

//http://developer.android.com/reference/android/content/SharedPreferences.html

//https://github.com/android/platform_frameworks_base/blob/master/core/java/android/content/SharedPreferences.java

import java.util.Set;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.view.View;

public class SharedPreferences {

	 public static final String PREFS_NAME = "PREFERENCES_WMK";
	 Context context;
	 public SharedPreferences(Context context){
			this.context = context;
		}
	 
	 
	 
	 public String GetStringSetting(String setName, String def){
		 android.content.SharedPreferences settings = context.getSharedPreferences(PREFS_NAME, 0);
		 
	     String setting = settings.getString(setName, def);
	     return setting;
	 }
	 public int GetIntSetting(String setName, int def){
		 android.content.SharedPreferences settings = context.getSharedPreferences(PREFS_NAME, 0);
		 int setting = settings.getInt(setName, def);
		 return setting;
	 }
	 public boolean GetBolSetting(String setName, boolean def){
		 android.content.SharedPreferences settings = context.getSharedPreferences(PREFS_NAME, 0);
		 boolean setting = settings.getBoolean(setName, def);
		 return setting;
	 }
	 public int GetBoolInt(boolean query){
		 int result = 0;
		 if(query == false){
			 result = 0;
		 }
		 else if(query == true){
			 result = 1;
		 }
		 return result;
	 }
	 
	 public boolean GetIntBool(int query){
		 boolean result = false;
		 if(query == 0){
			 result = false;
		 }
		 else if(query == 1){
			 result = true;
		 }
		 return result;
	 }
	 
	 public void SetBooleanSetting(String setName, boolean value){
	 android.content.SharedPreferences settings = context.getSharedPreferences(PREFS_NAME, 0);
    Editor editor = settings.edit();
    editor.putBoolean(setName, value);
    editor.commit();
	 }
	 public void SetStringSetting(String setName, String value){
		 android.content.SharedPreferences settings = context.getSharedPreferences(PREFS_NAME, 0);
	     Editor editor = settings.edit();
	     editor.putString(setName, value);
	     editor.commit();
		 }
	 public void SetIntSetting(String setName, int value){
		 android.content.SharedPreferences settings = context.getSharedPreferences(PREFS_NAME, 0);
	     Editor editor = settings.edit();
	     editor.putInt(setName, value);
	     editor.commit();
		 }
	 public void WipeOut(){
		 android.content.SharedPreferences setings = context.getSharedPreferences(PREFS_NAME, 0);
		 Editor editor = setings.edit();
		 editor.clear();
		 editor.commit();
	 }
	 
	 public void Unset(String name){
		 android.content.SharedPreferences setings = context.getSharedPreferences(PREFS_NAME, 0);
		 Editor editor = setings.edit();
		 editor.remove(name);
		 editor.commit();
	 }
	 
}
