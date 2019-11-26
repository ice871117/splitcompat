package com.google.android.play.core.appupdate;

import android.os.RemoteException;
import com.google.android.play.core.internal.m;
import com.google.android.play.core.internal.r;
import com.google.android.play.core.tasks.i;

final class f extends r {
    private final /* synthetic */ String a;
    private final /* synthetic */ i b;
    private final /* synthetic */ d c;

    f(d dVar, i iVar, String str, i iVar2) {
        this.c = dVar;
        this.a = str;
        this.b = iVar2;
        super(iVar);
    }

    /* access modifiers changed from: protected */
    public final void a() {
        try {
            ((m) this.c.a.b()).a(this.c.d, this.c.c(this.a), new j(this.c, this.b, this.a));
        } catch (RemoteException e) {
            d.b.a((Throwable) e, "requestUpdateInfo(%s)", this.a);
            this.b.a((Exception) new RuntimeException(e));
        }
    }
}
