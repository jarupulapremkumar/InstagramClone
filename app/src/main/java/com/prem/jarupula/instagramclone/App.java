package com.prem.jarupula.instagramclone;

import android.app.Application;

import com.parse.Parse;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("oic30W7Ma97OUpNRNiI4hkSoiszs66vBXAj9MeTy")
                .clientKey("GN9UNgpmvA5dp6jSnRiQBSH5E1OjMAcKOTWcJuwP")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
