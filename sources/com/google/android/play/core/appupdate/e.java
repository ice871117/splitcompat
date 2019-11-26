package com.google.android.play.core.appupdate;

import android.os.RemoteException;
import com.google.android.play.core.internal.m;
import com.google.android.play.core.internal.r;
import com.google.android.play.core.tasks.i;

final class e extends r {
    private final /* synthetic */ i a;
    private final /* synthetic */ String b;
    private final /* synthetic */ d c;

    e(d dVar, i iVar, i iVar2, String str) {
        this.c = dVar;
        this.a = iVar2;
        this.b = str;
        super(iVar);
    }

    /* access modifiers changed from: protected */
    public final void a() {
        try {
            ((m) this.c.a.b()).b(this.c.d, d.c(), new g(this.c, this.a));
        } catch (RemoteException e) {
            d.b.a((Throwable) e, "completeUpdate(%s)", this.b);
            this.a.a((Exception) new RuntimeException(e));
        }
    }
}
