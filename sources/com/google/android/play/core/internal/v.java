package com.google.android.play.core.internal;

final class v extends r {
    private final /* synthetic */ q a;

    v(q qVar) {
        this.a = qVar;
    }

    public final void a() {
        if (this.a.l != null) {
            this.a.c.a("Unbind from service.", new Object[0]);
            this.a.b.unbindService(this.a.k);
            this.a.f = false;
            this.a.l = null;
            this.a.k = null;
        }
    }
}
