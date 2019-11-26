package com.google.android.play.core.internal;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder.DeathRecipient;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.play.core.tasks.i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class q<T extends IInterface> {
    private static final Map<String, Handler> a = Collections.synchronizedMap(new HashMap());
    /* access modifiers changed from: private */
    public final Context b;
    /* access modifiers changed from: private */
    public final ag c;
    private final String d;
    /* access modifiers changed from: private */
    public final List<r> e;
    /* access modifiers changed from: private */
    public boolean f;
    private final Intent g;
    /* access modifiers changed from: private */
    public final x<T> h;
    private final WeakReference<u> i;
    private final DeathRecipient j;
    /* access modifiers changed from: private */
    public ServiceConnection k;
    /* access modifiers changed from: private */
    public T l;

    public q(Context context, ag agVar, String str, Intent intent, x<T> xVar) {
        this(context, agVar, str, intent, xVar, null);
    }

    private q(Context context, ag agVar, String str, Intent intent, x<T> xVar, u uVar) {
        this.e = new ArrayList();
        this.j = new t(this);
        this.b = context;
        this.c = agVar;
        this.d = str;
        this.g = intent;
        this.h = xVar;
        this.i = new WeakReference<>(null);
    }

    /* access modifiers changed from: private */
    public final void b(r rVar) {
        if (this.l == null && !this.f) {
            this.c.a("Initiate binding to the service.", new Object[0]);
            this.e.add(rVar);
            this.k = new w(this, 0);
            this.f = true;
            if (!this.b.bindService(this.g, this.k, 1)) {
                this.c.a("Failed to bind to the service.", new Object[0]);
                this.f = false;
                for (r b2 : this.e) {
                    i b3 = b2.b();
                    if (b3 != null) {
                        b3.a((Exception) new aa());
                    }
                }
                this.e.clear();
            }
        } else if (this.f) {
            this.c.a("Waiting to bind to the service.", new Object[0]);
            this.e.add(rVar);
        } else {
            rVar.run();
        }
    }

    /* access modifiers changed from: private */
    public final void c(r rVar) {
        d().post(rVar);
    }

    private final Handler d() {
        Handler handler;
        synchronized (a) {
            if (!a.containsKey(this.d)) {
                HandlerThread handlerThread = new HandlerThread(this.d, 10);
                handlerThread.start();
                a.put(this.d, new Handler(handlerThread.getLooper()));
            }
            handler = (Handler) a.get(this.d);
        }
        return handler;
    }

    /* access modifiers changed from: private */
    public final void e() {
        this.c.a("linkToDeath", new Object[0]);
        try {
            this.l.asBinder().linkToDeath(this.j, 0);
        } catch (RemoteException e2) {
            this.c.a((Throwable) e2, "linkToDeath failed", new Object[0]);
        }
    }

    /* access modifiers changed from: private */
    public final void f() {
        this.c.a("unlinkToDeath", new Object[0]);
        this.l.asBinder().unlinkToDeath(this.j, 0);
    }

    public final void a() {
        c((r) new v(this));
    }

    public final void a(r rVar) {
        c((r) new s(this, rVar.b(), rVar));
    }

    public final T b() {
        return this.l;
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void c() {
        this.c.a("reportBinderDeath", new Object[0]);
        u uVar = (u) this.i.get();
        if (uVar != null) {
            this.c.a("calling onBinderDied", new Object[0]);
            uVar.a();
            return;
        }
        this.c.a("%s : Binder has died.", this.d);
        for (r b2 : this.e) {
            i b3 = b2.b();
            if (b3 != null) {
                b3.a((Exception) VERSION.SDK_INT < 15 ? new RemoteException() : new RemoteException(String.valueOf(this.d).concat(" : Binder has died.")));
            }
        }
        this.e.clear();
    }
}
