package com.google.android.play.core.appupdate;

import android.content.Context;

public class AppUpdateManagerFactory {
    public static AppUpdateManager create(Context context) {
        return new b(new d(context), context);
    }
}
