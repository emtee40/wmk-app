package com.mehist.wmkapp.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by ardim_000 on 27/04/2014.
 */
public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        // PullPendingRequests.acquireStaticLock(context)
        try {
            lock = getLock(context);
            lock.acquire();
            context.startService(new Intent(context, UpdateCustomerRequests.class));
        } finally {
            if (lock.isHeld()) {
                lock.release();
            }
        }
}}


