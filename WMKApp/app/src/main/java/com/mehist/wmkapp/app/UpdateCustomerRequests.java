package com.mehist.wmkapp.app;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by ardim_000 on 27/04/2014.
 */
public class UpdateCustomerRequests extends IntentService implements LocationListener {
    private static Context mainContext;

    public UpdateCustomerRequests() {
        super("UpdateCustomerRequests");
        mHandler = new Handler();
        me = this;
    }

    public static UpdateCustomerRequests getService() {
        if (me == null)
            me = new UpdateCustomerRequests();
        return me;
    }

    @Override
    final protected void onHandleIntent(Intent intent) {
        mainContext = getApplicationContext();
        Location myLocation;

        if (HomeScreen.getLocationManager() != null) {
            // this is needed to trigger a background location change. Since LocationManager does not work on Samsung phones. Its a hack needed.
            HomeScreen.getLocationManager().requestLocationUpdates(
                    LocationManager.NETWORK_PROVIDER, 0, 0, new LocationListener() {
                        @Override
                        public void onStatusChanged(String provider, int status, Bundle extras) {
                        }
                        @Override
                        public void onProviderEnabled(String provider) {
                        }
                        @Override
                        public void onProviderDisabled(String provider) {
                        }
                        @Override
                        public void onLocationChanged(final Location location) {
                        }
                    });
            myLocation = HomeScreen.getLocationManager().getLastKnownLocation(
                    LocationManager.NETWORK_PROVIDER);
            if (myLocation != null)
                onLocationChanged(myLocation);
            else {
                God.notifications.setSpeedNotification();
            }
        } else
            Log.e("Taxeeta:PullPendingRequets", "Not activated");

    }

    @Override
    public void onLocationChanged(final Location location) {
        // Do your background stuff
    }

}