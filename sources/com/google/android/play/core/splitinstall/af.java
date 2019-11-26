package com.google.android.play.core.splitinstall;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.tasks.i;

final class af extends ah<Integer> {
    af(q qVar, i<Integer> iVar) {
        super(qVar, iVar);
    }

    public final void c(int i, Bundle bundle) throws RemoteException {
        super.c(i, bundle);
        this.a.a(Integer.valueOf(i));
    }
}
