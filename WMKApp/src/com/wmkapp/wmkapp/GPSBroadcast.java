package com.wmkapp.wmkapp;
//http://stackoverflow.com/questions/7709030/get-gps-location-in-a-broadcast-receiver-or-service-to-broadcast-receiver-data-t
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class GPSBroadcast extends BroadcastReceiver{

	    @Override
	    public void onReceive(Context context, Intent intent) {

	     Intent myIntent = new Intent(context, GPSRecordService.class);
	     context.startService(myIntent);
}
}
