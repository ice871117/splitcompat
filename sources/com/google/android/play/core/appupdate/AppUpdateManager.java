package com.google.android.play.core.appupdate;

import android.app.Activity;
import android.content.IntentSender.SendIntentException;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.install.InstallStateUpdatedListener;
import com.google.android.play.core.tasks.Task;

public interface AppUpdateManager {

   void registerListener(InstallStateUpdatedListener var1);

   void unregisterListener(InstallStateUpdatedListener var1);

   Task getAppUpdateInfo();

   boolean startUpdateFlowForResult(AppUpdateInfo var1, int var2, Activity var3, int var4) throws SendIntentException;

   Task completeUpdate();
}
