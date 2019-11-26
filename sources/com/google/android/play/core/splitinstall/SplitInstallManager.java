package com.google.android.play.core.splitinstall;

import android.app.Activity;
import android.content.IntentSender.SendIntentException;
import com.google.android.play.core.splitinstall.SplitInstallRequest;
import com.google.android.play.core.splitinstall.SplitInstallSessionState;
import com.google.android.play.core.splitinstall.SplitInstallStateUpdatedListener;
import com.google.android.play.core.tasks.Task;
import java.util.List;
import java.util.Set;

public interface SplitInstallManager {

   void registerListener(SplitInstallStateUpdatedListener var1);

   void unregisterListener(SplitInstallStateUpdatedListener var1);

   Task startInstall(SplitInstallRequest var1);

   boolean startConfirmationDialogForResult(SplitInstallSessionState var1, Activity var2, int var3) throws SendIntentException;

   Task cancelInstall(int var1);

   Task getSessionState(int var1);

   Task getSessionStates();

   Task deferredUninstall(List var1);

   Task deferredInstall(List var1);

   Task deferredLanguageInstall(List var1);

   Task deferredLanguageUninstall(List var1);

   Set getInstalledLanguages();

   Set getInstalledModules();
}
