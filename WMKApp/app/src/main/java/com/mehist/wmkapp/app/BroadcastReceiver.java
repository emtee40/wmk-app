package com.mehist.wmkapp.app;

import android.content.Context;
import android.os.PowerManager;

/**
 * Created by ardim_000 on 27/04/2014.
 */
public class BroadcastReceiver {
    private static final String NAME = "com.commonsware.cwac.wakeful.WakefulIntentService";
    private static volatile PowerManager.WakeLock lockStatic = null;
    private static PowerManager.WakeLock lock;

    // Needed since network will to work when device is sleeping.
    synchronized private static PowerManager.WakeLock getLock(Context context) {
        if (lockStatic == null) {
            PowerManager mgr = (PowerManager) context.getSystemService(Context.POWER_SERVICE);

            lockStatic = mgr.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, NAME);
            lockStatic.setReferenceCounted(true);
        }

        return (lockStatic);
    }
}
