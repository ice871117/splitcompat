package com.google.android.play.core.appupdate;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.install.InstallException;
import com.google.android.play.core.internal.ag;
import com.google.android.play.core.tasks.i;

final class g extends h<Void> {
    g(d dVar, i<Void> iVar) {
        super(dVar, new ag("OnCompleteUpdateCallback"), iVar);
    }

    public final void a(Bundle bundle) throws RemoteException {
        super.a(bundle);
        if (d.b(bundle) != 0) {
            this.a.a((Exception) new InstallException(d.b(bundle)));
        } else {
            this.a.a(null);
        }
    }
}
