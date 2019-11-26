package com.google.android.play.core.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

final class w implements ServiceConnection {
    final /* synthetic */ q a;

    private w(q qVar) {
        this.a = qVar;
    }

    /* synthetic */ w(q qVar, byte b) {
        this(qVar);
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.a.c.a("ServiceConnectionImpl.onServiceConnected(%s)", componentName);
        this.a.c((r) new z(this, iBinder));
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        this.a.c.a("ServiceConnectionImpl.onServiceDisconnected(%s)", componentName);
        this.a.c((r) new y(this));
    }
}
