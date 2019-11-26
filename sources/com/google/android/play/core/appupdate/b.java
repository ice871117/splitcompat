package com.google.android.play.core.appupdate;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.IntentSender.SendIntentException;
import com.google.android.play.core.install.InstallStateUpdatedListener;
import com.google.android.play.core.listener.StateUpdatedListener;
import com.google.android.play.core.tasks.Task;

final class b implements AppUpdateManager {
    private final d a;
    private final a b;
    private final Context c;

    b(d dVar, Context context) {
        this.a = dVar;
        this.b = new a(context);
        this.c = context;
    }

    public final Task<Void> completeUpdate() {
        return this.a.b(this.c.getPackageName());
    }

    public final Task<AppUpdateInfo> getAppUpdateInfo() {
        return this.a.a(this.c.getPackageName());
    }

    public final synchronized void registerListener(InstallStateUpdatedListener installStateUpdatedListener) {
        this.b.a((StateUpdatedListener<StateT>) installStateUpdatedListener);
    }

    public final boolean startUpdateFlowForResult(AppUpdateInfo appUpdateInfo, int i, Activity activity, int i2) throws SendIntentException {
        if (!appUpdateInfo.isUpdateTypeAllowed(i)) {
            return false;
        }
        PendingIntent pendingIntent = i == 0 ? appUpdateInfo.b() : i == 1 ? appUpdateInfo.a() : null;
        activity.startIntentSenderForResult(pendingIntent.getIntentSender(), i2, null, 0, 0, 0);
        return true;
    }

    public final synchronized void unregisterListener(InstallStateUpdatedListener installStateUpdatedListener) {
        this.b.b(installStateUpdatedListener);
    }
}
