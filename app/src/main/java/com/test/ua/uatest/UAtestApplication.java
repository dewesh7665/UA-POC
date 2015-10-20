package com.test.ua.uatest;

import android.app.Application;
import com.urbanairship.UAirship;

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
                airship.getPushManager().setUserNotificationsEnabled(true);
            }
        });
    }
}

