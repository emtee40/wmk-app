package com.mehist.wmkapp.app;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
    Intent notifyintent = new Intent(this, OnAlarmReceiver.class);
    notifyintent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    notifyintent.setAction("android.intent.action.NOTIFY");
    PendingIntent notifysender = PendingIntent.getBroadcast(this, 0, notifyintent,
            PendingIntent.FLAG_UPDATE_CURRENT);
    am.setInexactRepeating(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), 20 * 1000,
    notifysender);
}
