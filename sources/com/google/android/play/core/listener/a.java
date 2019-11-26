package com.google.android.play.core.listener;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.play.core.internal.ag;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public abstract class a<StateT> {
    protected final ag a;
    private final IntentFilter b;
    private final Context c;
    private final Set<StateUpdatedListener<StateT>> d = new HashSet();
    private b e = null;
    private volatile boolean f = false;

    protected a(ag agVar, IntentFilter intentFilter, Context context) {
        this.a = agVar;
        this.b = intentFilter;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        this.c = context;
    }

    private final void a() {
        if ((this.f || !this.d.isEmpty()) && this.e == null) {
            this.e = new b(this, 0);
            this.c.registerReceiver(this.e, this.b);
        }
        if (!this.f && this.d.isEmpty() && this.e != null) {
            this.c.unregisterReceiver(this.e);
            this.e = null;
        }
    }

    /* access modifiers changed from: protected */
    public abstract void a(Context context, Intent intent);

    public final synchronized void a(StateUpdatedListener<StateT> stateUpdatedListener) {
        this.a.a("registerListener", new Object[0]);
        this.d.add(stateUpdatedListener);
        a();
    }

    public final synchronized void a(StateT statet) {
        Iterator it = new HashSet(this.d).iterator();
        while (it.hasNext()) {
            ((StateUpdatedListener) it.next()).onStateUpdate(statet);
        }
    }

    public final synchronized void a(boolean z) {
        this.f = true;
        a();
    }

    public final synchronized void b(StateUpdatedListener<StateT> stateUpdatedListener) {
        this.a.a("unregisterListener", new Object[0]);
        this.d.remove(stateUpdatedListener);
        a();
    }
}
