package com.google.android.play.core.appupdate;

import android.app.PendingIntent;

public abstract class AppUpdateInfo {
    public static AppUpdateInfo a(String str, int i, int i2, int i3, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
        return new i(str, i, i2, i3, pendingIntent, pendingIntent2);
    }

    /* access modifiers changed from: 0000 */
    public abstract PendingIntent a();

    public abstract int availableVersionCode();

    /* access modifiers changed from: 0000 */
    public abstract PendingIntent b();

    public abstract int installStatus();

    public boolean isUpdateTypeAllowed(int i) {
        if (i == 0) {
            return b() != null;
        }
        if (i == 1) {
            return a() != null;
        }
        return false;
    }

    public abstract String packageName();

    public abstract int updateAvailability();
}
