package com.google.android.play.core.appupdate;

import android.app.Activity;
import android.content.IntentSender.SendIntentException;
import com.google.android.play.core.install.InstallStateUpdatedListener;
import com.google.android.play.core.tasks.Task;

public interface AppUpdateManager {
    Task<Void> completeUpdate();

    Task<AppUpdateInfo> getAppUpdateInfo();

    void registerListener(InstallStateUpdatedListener installStateUpdatedListener);

    boolean startUpdateFlowForResult(AppUpdateInfo appUpdateInfo, int i, Activity activity, int i2) throws SendIntentException;

    void unregisterListener(InstallStateUpdatedListener installStateUpdatedListener);
}
