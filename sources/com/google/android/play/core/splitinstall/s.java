package com.google.android.play.core.splitinstall;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.internal.bd;
import com.google.android.play.core.internal.be;
import com.google.android.play.core.internal.r;
import com.google.android.play.core.tasks.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

final class s extends r {
    private final /* synthetic */ Collection a;
    private final /* synthetic */ Collection b;
    private final /* synthetic */ i c;
    private final /* synthetic */ q d;

    s(q qVar, i iVar, Collection collection, Collection collection2, i iVar2) {
        this.d = qVar;
        this.a = collection;
        this.b = collection2;
        this.c = iVar2;
        super(iVar);
    }

    /* access modifiers changed from: protected */
    public final void a() {
        ArrayList a2 = q.d(this.a);
        a2.addAll(q.c(this.b));
        try {
            ((bd) this.d.a.b()).a(this.d.d, (List<Bundle>) a2, q.d(), (be) new af(this.d, this.c));
        } catch (RemoteException e) {
            q.b.a((Throwable) e, "startInstall(%s,%s)", this.a, this.b);
            this.c.a((Exception) new RuntimeException(e));
        }
    }
}
