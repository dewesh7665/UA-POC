package com.test.ua.uatest;

import android.content.Context;
import android.util.Log;

import com.urbanairship.actions.ActionValue;
import com.urbanairship.actions.ShareAction;
import com.urbanairship.push.BaseIntentReceiver;
import com.urbanairship.push.PushMessage;

import java.util.Map;

/**
 * @author Dewesh Kumar
 */
public class IntentReceiver extends BaseIntentReceiver {

    private static final String TAG = "IntentReceiver";

    @Override
    protected void onChannelRegistrationSucceeded(Context context, String channelId) {
        Log.i(TAG, "Channel registration updated. Channel Id:" + channelId + ".");
    }

    @Override
    protected void onChannelRegistrationFailed(Context context) {
        Log.i(TAG, "Channel registration failed.");
    }

    @Override
    protected void onPushReceived(Context context, PushMessage message, int notificationId) {
        Log.i(TAG, "Received push notification. Alert: " + message.getAlert() + ". Notification ID: " + notificationId);
    }

    @Override
    protected void onBackgroundPushReceived(Context context, PushMessage message) {
        Log.i(TAG, "Received background push message: " + message);
    }

    @Override
    protected boolean onNotificationOpened(Context context, PushMessage message, int notificationId) {
        Log.i(TAG, "User clicked notification. Alert: " + message.getAlert());
        // Return false to let UA handle launching the launch activity
        return false;
    }

    @Override
    protected boolean onNotificationActionOpened(Context context, PushMessage message, int notificationId, String buttonId, boolean isForeground) {
        Log.i(TAG, "User clicked notification button. Button ID: " + buttonId + " Alert: " + message.getAlert());
        Map<String, ActionValue> actions = message.getActions();
        if (actions.containsKey(ShareAction.DEFAULT_REGISTRY_NAME) || actions.containsKey(ShareAction.DEFAULT_REGISTRY_SHORT_NAME))  {
            return true;
        }
        // Return false to let UA handle launching the launch activity
        return false;
    }

    @Override
    protected void onNotificationDismissed(Context context, PushMessage message, int notificationId) {
        Log.i(TAG, "Notification dismissed. Alert: " + message.getAlert() + ". Notification ID: " + notificationId);
    }
}
