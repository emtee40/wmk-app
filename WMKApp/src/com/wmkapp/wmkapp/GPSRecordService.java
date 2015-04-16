package com.wmkapp.wmkapp;

//http://www.vogella.com/tutorials/AndroidServices/article.html

//https://developer.android.com/training/run-background-service/send-request.html

import GPSTracker.GPSTracker;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class GPSRecordService extends Service{

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	 @Override
     public void onCreate() {
            // TODO Auto-generated method stub

            Log.d("Report", "Started");
            super.onCreate();
     }
	 @Override
     public int onStartCommand(Intent intent, int flags, int startId) {
            // TODO Auto-generated method stub
		 	SharedPreferences sps = new SharedPreferences(this);
		 	GPSTracker gpt = new GPSTracker(this);
		 	gpt.UpdateLocation(sps.GetIntSetting("UserID", 0));
            return super.onStartCommand(intent, flags, startId);
     }
	
	
}
