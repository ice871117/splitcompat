package com.google.android.play.core.splitinstall;

import android.os.RemoteException;
import com.google.android.play.core.internal.bd;
import com.google.android.play.core.internal.r;
import com.google.android.play.core.tasks.i;

final class v extends r {
    private final /* synthetic */ int a;
    private final /* synthetic */ i b;
    private final /* synthetic */ q c;

    v(q qVar, i iVar, int i, i iVar2) {
        this.c = qVar;
        this.a = i;
        this.b = iVar2;
        super(iVar);
    }

    /* access modifiers changed from: protected */
    public final void a() {
        try {
            ((bd) this.c.a.b()).a(this.c.d, this.a, new ad(this.c, this.b));
        } catch (RemoteException e) {
            q.b.a((Throwable) e, "getSessionState(%d)", Integer.valueOf(this.a));
            this.b.a((Exception) new RuntimeException(e));
        }
    }
}
