package com.google.android.play.core.splitinstall;

import android.os.RemoteException;
import com.google.android.play.core.internal.bd;
import com.google.android.play.core.tasks.i;
import java.util.Collection;
import java.util.List;

final class r extends com.google.android.play.core.internal.r {
    private final /* synthetic */ List a;
    private final /* synthetic */ i b;
    private final /* synthetic */ q c;

    r(q qVar, i iVar, List list, i iVar2) {
        this.c = qVar;
        this.a = list;
        this.b = iVar2;
        super(iVar);
    }

    /* access modifiers changed from: protected */
    public final void a() {
        try {
            ((bd) this.c.a.b()).b(this.c.d, q.d((Collection<String>) this.a), q.d(), new ae(this.c, this.b));
        } catch (RemoteException e) {
            q.b.a((Throwable) e, "deferredUninstall(%s)", this.a);
            this.b.a((Exception) new RuntimeException(e));
        }
    }
}
