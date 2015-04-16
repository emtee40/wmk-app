package com.wmkapp.wmkapp;

//http://developer.android.com/reference/android/content/Intent.html

//http://developer.android.com/training/scheduling/alarms.html

//http://stackoverflow.com/questions/4459058/alarm-manager-example

//http://stackoverflow.com/questions/9869153/android-periodic-gps-location-updates-with-alarmmanager-inside-a-service

import java.util.Calendar;
import GPSTracker.GPSTracker;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {
	

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final SharedPreferences sp = new SharedPreferences(this);
		int usermainID = sp.GetIntSetting("userID", 0);
		boolean submitted = sp.GetBolSetting("IMEISet", false);
		
		if(usermainID == 0 && submitted == false){
			Intent IncInt = new Intent(MainActivity.this, LoginScreen.class);
    		MainActivity.this.startActivity(IncInt);	
		}
		else{
			Log.d("Info","Done");
		}
		GPSTracker gps = new GPSTracker(this);
		gps.UpdateLocation(sp.GetIntSetting("userID", 0));

		
		Calendar cal = Calendar.getInstance();
        cal.add(Calendar.SECOND, 1);
       
        Intent intent = new Intent(this, GPSRecordService.class);

        PendingIntent pintent = PendingIntent.getService(this, 0, intent, 0);
       
        AlarmManager alarm = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        //for 30 mint 60*60*1000
        alarm.setRepeating(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(),
                     15*60*1000, pintent);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
