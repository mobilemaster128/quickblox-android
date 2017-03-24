package com.mobilemaster.quickblox.core.gcm;

import android.os.Bundle;
import android.util.Log;

import com.quickblox.messages.services.gcm.QBGcmPushListenerService;
import com.mobilemaster.quickblox.core.utils.ActivityLifecycle;

public abstract class CoreGcmPushListenerService extends QBGcmPushListenerService {
    private static final String TAG = CoreGcmPushListenerService.class.getSimpleName();

    @Override
    public void sendPushMessage(Bundle data, String from, String message) {
        super.sendPushMessage(data, from, message);
        Log.v(TAG, "From: " + from);
        Log.v(TAG, "Message: " + message);

        if (ActivityLifecycle.getInstance().isBackground()) {
            showNotification(message);
        }
    }

    protected abstract void showNotification(String message);
}