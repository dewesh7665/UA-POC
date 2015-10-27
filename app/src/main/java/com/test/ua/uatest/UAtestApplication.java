package com.test.ua.uatest;

import android.app.Application;
import android.support.v7.app.NotificationCompat;

import com.urbanairship.UAirship;
import com.urbanairship.push.notifications.DefaultNotificationFactory;

public class UAtestApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initUrbanAirship();
    }

    private void initUrbanAirship(){
        UAirship.takeOff(this, new UAirship.OnReadyCallback() {
            @Override
            public void onAirshipReady(UAirship airship) {
                // Enable user notifications
                // Enable user notifications
                DefaultNotificationFactory notificationFactory;
                notificationFactory = new DefaultNotificationFactory(getApplicationContext());

                // Custom notification icon
                notificationFactory.setSmallIconId(android.R.drawable.btn_default);

                // The accent color for Android Lollipop+
                notificationFactory.setColor(NotificationCompat.COLOR_DEFAULT);

                // Set the factory on the PushManager
                airship.getPushManager().setNotificationFactory(notificationFactory);
                airship.shared().getPushManager().setUserNotificationsEnabled(true);
            }
        });
    }
}

