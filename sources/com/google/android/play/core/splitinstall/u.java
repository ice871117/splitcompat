package com.google.android.play.core.splitinstall;

import android.os.RemoteException;
import com.google.android.play.core.internal.bd;
import com.google.android.play.core.internal.r;
import com.google.android.play.core.tasks.i;
import java.util.Collection;
import java.util.List;

final class u extends r {
    private final /* synthetic */ List a;
    private final /* synthetic */ i b;
    private final /* synthetic */ q c;

    u(q qVar, i iVar, List list, i iVar2) {
        this.c = qVar;
        this.a = list;
        this.b = iVar2;
        super(iVar);
    }

    /* access modifiers changed from: protected */
    public final void a() {
        try {
            ((bd) this.c.a.b()).c(this.c.d, q.d((Collection<String>) this.a), q.d(), new z(this.c, this.b));
        } catch (RemoteException e) {
            q.b.a((Throwable) e, "deferredInstall(%s)", this.a);
            this.b.a((Exception) new RuntimeException(e));
        }
    }
}
