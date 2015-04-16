package com.wmkapp.wmkapp;

//http://www.coderzheaven.com/2012/04/22/create-simple-login-form-php-android-connect-php-android/

//http://developer.android.com/reference/org/apache/http/client/HttpClient.html

//http://developer.android.com/reference/org/apache/http/package-summary.html



import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;



import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

public class Connect {
	Context context;
	
	
	
	
	public class GetIdMAIN extends AsyncTask<ArrayList<String>, Void, String> {
		String result = "";
      protected String doInBackground(ArrayList<String>... data) {
    	
		HttpClient httpclient = new DefaultHttpClient();
	    HttpPost httppost = new HttpPost("http://wmk-app.com/android_connect.php?action=login");
	    
	    try{
	    List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
	    	nameValuePairs.add(new BasicNameValuePair("email", data[0].get(0)));
	    	nameValuePairs.add(new BasicNameValuePair("pass", data[0].get(1)));
	    	httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
	    	
	    	HttpResponse response = httpclient.execute(httppost);
	    	InputStream is = response.getEntity().getContent();
	    	String line = "";
		    StringBuilder total = new StringBuilder();
		    
		    BufferedReader rd = new BufferedReader(new InputStreamReader(is));

		    while ((line = rd.readLine()) != null) { 
		        total.append(line); 
		    }
	    	result = total.toString();

	    }
	    catch(Exception e){}
	    Log.d("Resul2", result);
	    return result;
     }
     @Override
    protected void onPreExecute() {
    // TODO Auto-generated method stub

    super.onPreExecute();
    }
     protected void onPostExecute(String result) {
    	 System.out.print("finish");
         }
 }
//
public String GetId(String email, String pass) throws InterruptedException, ExecutionException{
	ArrayList<String> data = new ArrayList<String>();
	data.add(email);
	data.add(pass);
	return new GetIdMAIN().execute(data).get();
}


public class SetIMEI extends AsyncTask<ArrayList<String>, Void, String> {
	String result = "";
  protected String doInBackground(ArrayList<String>... data) {
	
	HttpClient httpclient = new DefaultHttpClient();
    HttpPost httppost = new HttpPost("http://wmk-app.com/android_connect.php?action=imei");
    
    try{
    List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
    	nameValuePairs.add(new BasicNameValuePair("id", data[0].get(0)));
    	nameValuePairs.add(new BasicNameValuePair("imei", data[0].get(1)));

    	httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
    	
    	HttpResponse response = httpclient.execute(httppost);
    	InputStream is = response.getEntity().getContent();
    	String line = "";
	    StringBuilder total = new StringBuilder();
	    
	    BufferedReader rd = new BufferedReader(new InputStreamReader(is));

	    while ((line = rd.readLine()) != null) { 
	        total.append(line); 
	    }
    	result = total.toString();

    }
    catch(Exception e){}
    return result;
 }
 @Override
protected void onPreExecute() {
// TODO Auto-generated method stub
super.onPreExecute();
}
 protected void onPostExecute(String result) {
	 Log.d("Report", result.toString());
     }
}
//
public void SetID(int id, String imei) throws InterruptedException, ExecutionException{
ArrayList<String> data = new ArrayList<String>();
data.add(String.valueOf(id));
data.add(imei);
new SetIMEI().execute(data);
}


public class SetLoc extends AsyncTask<ArrayList<String>, Void, String> {
	String result = "";
  protected String doInBackground(ArrayList<String>... data) {
	
	HttpClient httpclient = new DefaultHttpClient();
    HttpPost httppost = new HttpPost("http://wmk-app.com/android_connect.php?action=gps");
    
    try{
    List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
    	nameValuePairs.add(new BasicNameValuePair("id", data[0].get(0)));
    	nameValuePairs.add(new BasicNameValuePair("Lat", data[0].get(1)));
    	nameValuePairs.add(new BasicNameValuePair("Long", data[0].get(2)));

    	httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
    	
    	HttpResponse response = httpclient.execute(httppost);
    	InputStream is = response.getEntity().getContent();
    	String line = "";
	    StringBuilder total = new StringBuilder();
	    
	    BufferedReader rd = new BufferedReader(new InputStreamReader(is));

	    while ((line = rd.readLine()) != null) { 
	        total.append(line); 
	    }
    	result = total.toString();

    }
    catch(Exception e){}
    return result;
 }
 @Override
protected void onPreExecute() {
// TODO Auto-generated method stub
super.onPreExecute();
}
 protected void onPostExecute(String result) {
	 Log.d("Report", result.toString());
     }
}
//
public void SetGPS(int id, String Lat, String Long) throws InterruptedException, ExecutionException{
ArrayList<String> data = new ArrayList<String>();
data.add(String.valueOf(id));
data.add(Lat);
data.add(Long);
new SetLoc().execute(data);
}


}
