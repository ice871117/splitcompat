package com.google.android.play.core.splitinstall;

import android.os.RemoteException;
import com.google.android.play.core.internal.bd;
import com.google.android.play.core.internal.be;
import com.google.android.play.core.internal.r;
import com.google.android.play.core.tasks.i;

final class x extends r {
    private final /* synthetic */ int a;
    private final /* synthetic */ i b;
    private final /* synthetic */ q c;

    x(q qVar, i iVar, int i, i iVar2) {
        this.c = qVar;
        this.a = i;
        this.b = iVar2;
        super(iVar);
    }

    /* access modifiers changed from: protected */
    public final void a() {
        try {
            ((bd) this.c.a.b()).a(this.c.d, this.a, q.d(), (be) new aa(this.c, this.b));
        } catch (RemoteException e) {
            q.b.a((Throwable) e, "cancelInstall(%d)", Integer.valueOf(this.a));
            this.b.a((Exception) new RuntimeException(e));
        }
    }
}
