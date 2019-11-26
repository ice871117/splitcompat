package com.google.android.play.core.internal;

import android.os.IBinder;
import android.os.IInterface;

final class z extends r {
    private final /* synthetic */ IBinder a;
    private final /* synthetic */ w b;

    z(w wVar, IBinder iBinder) {
        this.b = wVar;
        this.a = iBinder;
    }

    public final void a() {
        this.b.a.l = (IInterface) this.b.a.h.a(this.a);
        this.b.a.e();
        this.b.a.f = false;
        for (Runnable run : this.b.a.e) {
            run.run();
        }
        this.b.a.e.clear();
    }
}
