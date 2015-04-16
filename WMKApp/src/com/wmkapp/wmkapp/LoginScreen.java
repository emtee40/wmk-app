package com.wmkapp.wmkapp;

//http://stackoverflow.com/questions/4531396/get-value-of-a-edit-text-field

//http://javapapers.com/android/get-user-input-in-android/

//http://developer.android.com/reference/android/content/SharedPreferences.html

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginScreen extends Activity {
	
	public void Login(View v) throws Exception{
		EditText user_em = (EditText)findViewById(R.id.user_email);
		String email = user_em.getText().toString();
		EditText user_pass = (EditText)findViewById(R.id.user_pass);
		String pass = user_pass.getText().toString();
		
		Connect and_con = new Connect();
		
		String userid = and_con.GetId(email, pass);
		SharedPreferences shareds = new SharedPreferences(this);
		shareds.SetIntSetting("userID", Integer.valueOf(userid));
		Log.d("UserID", userid);
		if(Integer.valueOf(userid) == 0){
			TextView errorText = (TextView)findViewById(R.id.error);
			errorText.setText("Wrong password or email.");
		}
		else if(Integer.valueOf(userid) != 0){
			TelephonyManager telephonyManager = (TelephonyManager)getSystemService(TELEPHONY_SERVICE);
			final String PhoneID = telephonyManager.getDeviceId();
			and_con.SetID(Integer.valueOf(userid), PhoneID);
			shareds.SetBooleanSetting("IMEISet", true);
			Intent IncInt = new Intent(LoginScreen.this, MainActivity.class);
    		LoginScreen.this.startActivity(IncInt);
		}
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login_screen);
		
		
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login_screen, menu);
		return true;
	}

}
