package com.google.android.play.core.appupdate.testing;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.appupdate.a;
import com.google.android.play.core.install.InstallException;
import com.google.android.play.core.install.InstallState;
import com.google.android.play.core.install.InstallStateUpdatedListener;
import com.google.android.play.core.listener.StateUpdatedListener;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.Tasks;

public class FakeAppUpdateManager implements AppUpdateManager {
    private final a a;
    private final Context b;
    private int c = 0;
    private int d = 0;
    private boolean e = false;
    private int f = 0;
    private boolean g = false;
    private boolean h = false;
    private boolean i = false;
    private Integer j;
    private Integer k;

    public FakeAppUpdateManager(Context context) {
        this.a = new a(context);
        this.b = context;
    }

    private final int a() {
        if (this.e) {
            return (this.c == 0 || this.c == 4 || this.c == 5 || this.c == 6) ? 2 : 3;
        }
        return 1;
    }

    private final void b() {
        this.a.a(InstallState.a(this.c, this.d, this.b.getPackageName()));
    }

    public Task<Void> completeUpdate() {
        if (this.d != 0 && this.d != 1) {
            return Tasks.a((Exception) new InstallException(this.d));
        }
        if (this.c != 11) {
            return this.c == 3 ? Tasks.a((Exception) new InstallException(-8)) : Tasks.a((Exception) new InstallException(-7));
        }
        this.c = 3;
        this.i = true;
        if (Integer.valueOf(0).equals(this.k)) {
            b();
        }
        return Tasks.a(null);
    }

    public void downloadCompletes() {
        if (this.c == 2 || this.c == 1) {
            this.c = 11;
            if (Integer.valueOf(0).equals(this.k)) {
                b();
            } else if (Integer.valueOf(1).equals(this.k)) {
                completeUpdate();
            }
        }
    }

    public void downloadFails() {
        if (this.c == 1 || this.c == 2) {
            this.c = 5;
            if (Integer.valueOf(0).equals(this.k)) {
                b();
            }
            this.k = null;
            this.h = false;
            this.c = 0;
        }
    }

    public void downloadStarts() {
        if (this.c == 1) {
            this.c = 2;
            if (Integer.valueOf(0).equals(this.k)) {
                b();
            }
        }
    }

    public Task<AppUpdateInfo> getAppUpdateInfo() {
        if (this.d != 0 && this.d != 1) {
            return Tasks.a((Exception) new InstallException(this.d));
        }
        return Tasks.a(AppUpdateInfo.a(this.b.getPackageName(), this.f, a(), this.c, (a() != 2 || (this.d != 0 && (this.d != 1 || !Integer.valueOf(1).equals(this.j)))) ? null : PendingIntent.getBroadcast(this.b, 0, new Intent(), 0), (a() != 2 || (this.d != 0 && (this.d != 1 || !Integer.valueOf(0).equals(this.j)))) ? null : PendingIntent.getBroadcast(this.b, 0, new Intent(), 0)));
    }

    public Integer getPartiallyAllowedUpdateType() {
        return this.j;
    }

    public Integer getTypeForUpdateInProgress() {
        return this.k;
    }

    public void installCompletes() {
        if (this.c == 3) {
            this.c = 4;
            this.e = false;
            this.f = 0;
            this.h = false;
            this.i = false;
            if (Integer.valueOf(0).equals(this.k)) {
                b();
            }
            this.k = null;
            this.c = 0;
        }
    }

    public void installFails() {
        if (this.c == 3) {
            this.c = 5;
            if (Integer.valueOf(0).equals(this.k)) {
                b();
            }
            this.k = null;
            this.i = false;
            this.h = false;
            this.c = 0;
        }
    }

    public boolean isConfirmationDialogVisible() {
        return this.g;
    }

    public boolean isImmediateFlowVisible() {
        return this.h;
    }

    public boolean isInstallSplashScreenVisible() {
        return this.i;
    }

    public void registerListener(InstallStateUpdatedListener installStateUpdatedListener) {
        this.a.a((StateUpdatedListener<StateT>) installStateUpdatedListener);
    }

    public void setInstallErrorCode(int i2) {
        this.d = i2;
    }

    public void setPartiallyAllowedUpdateType(Integer num) {
        this.j = num;
        this.d = 1;
    }

    public void setUpdateAvailable(int i2) {
        this.e = true;
        this.f = i2;
    }

    public void setUpdateNotAvailable() {
        this.e = false;
    }

    public boolean startUpdateFlowForResult(AppUpdateInfo appUpdateInfo, int i2, Activity activity, int i3) {
        if (!appUpdateInfo.isUpdateTypeAllowed(i2)) {
            return false;
        }
        if (i2 == 1) {
            this.h = true;
            this.k = Integer.valueOf(1);
        } else {
            this.g = true;
            this.k = Integer.valueOf(0);
        }
        return true;
    }

    public void unregisterListener(InstallStateUpdatedListener installStateUpdatedListener) {
        this.a.b(installStateUpdatedListener);
    }

    public void userAcceptsUpdate() {
        if (this.g || this.h) {
            this.g = false;
            this.c = 1;
            if (Integer.valueOf(0).equals(this.k)) {
                b();
            }
        }
    }

    public void userCancelsDownload() {
        if (this.c == 1 || this.c == 2) {
            this.c = 6;
            if (Integer.valueOf(0).equals(this.k)) {
                b();
            }
            this.k = null;
            this.h = false;
            this.c = 0;
        }
    }

    public void userRejectsUpdate() {
        if (this.g || this.h) {
            this.g = false;
            this.h = false;
            this.k = null;
            this.c = 0;
        }
    }
}
