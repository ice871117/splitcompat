package com.google.android.play.core.splitinstall;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.tasks.i;

final class ad extends ah<SplitInstallSessionState> {
    ad(q qVar, i<SplitInstallSessionState> iVar) {
        super(qVar, iVar);
    }

    public final void b(int i, Bundle bundle) throws RemoteException {
        super.b(i, bundle);
        this.a.a(SplitInstallSessionState.a(bundle));
    }
}
