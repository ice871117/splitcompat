package com.google.android.play.core.appupdate;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.internal.ag;
import com.google.android.play.core.internal.p;
import com.google.android.play.core.tasks.i;

class h<T> extends p {
    final i<T> a;
    private final ag b;
    private final /* synthetic */ d c;

    h(d dVar, ag agVar, i<T> iVar) {
        this.c = dVar;
        this.b = agVar;
        this.a = iVar;
    }

    public void a(Bundle bundle) throws RemoteException {
        this.c.a.a();
        this.b.a("onCompleteUpdate", new Object[0]);
    }

    public void b(Bundle bundle) throws RemoteException {
        this.c.a.a();
        this.b.a("onRequestInfo", new Object[0]);
    }
}
