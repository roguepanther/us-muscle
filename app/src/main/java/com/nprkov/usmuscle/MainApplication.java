package com.nprkov.usmuscle;

import android.app.Application;
import ie.imobile.extremepush.PushConnector;
import static ie.imobile.extremepush.PushConnector.mPushConnector;

public class MainApplication extends Application {

    @Override
    public void onCreate(){
        super.onCreate();

        new PushConnector.Builder("MkqIC6eiya13jEfNTkU0064-x8n12qhc", "315505963048")
                .turnOnDebugLogs(true)
                .setInboxEnabled(true)
                .requestNotificationPermission(true)
                .setEnableInApp(true)
                .setDeliveryReceiptsEnabled(true)
                .setEncryptedMessagesEnabled(true)
                .create(this);
    }
}
