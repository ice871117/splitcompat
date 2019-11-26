package com.google.android.play.core.splitinstall;

import android.os.RemoteException;
import com.google.android.play.core.internal.bd;
import com.google.android.play.core.internal.r;
import com.google.android.play.core.tasks.i;

final class y extends r {
    private final /* synthetic */ i a;
    private final /* synthetic */ q b;

    y(q qVar, i iVar, i iVar2) {
        this.b = qVar;
        this.a = iVar2;
        super(iVar);
    }

    /* access modifiers changed from: protected */
    public final void a() {
        try {
            ((bd) this.b.a.b()).a(this.b.d, new ag(this.b, this.a));
        } catch (RemoteException e) {
            q.b.a((Throwable) e, "getSessionStates", new Object[0]);
            this.a.a((Exception) new RuntimeException(e));
        }
    }
}
