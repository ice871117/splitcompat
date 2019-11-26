package com.google.android.play.core.appupdate;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.install.InstallException;
import com.google.android.play.core.internal.ag;
import com.google.android.play.core.tasks.i;

final class j extends h<AppUpdateInfo> {
    private final String b;

    j(d dVar, i<AppUpdateInfo> iVar, String str) {
        super(dVar, new ag("OnRequestInstallCallback"), iVar);
        this.b = str;
    }

    public final void b(Bundle bundle) throws RemoteException {
        super.b(bundle);
        if (d.b(bundle) == 0 || d.b(bundle) == 1) {
            this.a.a(d.b(bundle, this.b));
        } else {
            this.a.a((Exception) new InstallException(d.b(bundle)));
        }
    }
}
