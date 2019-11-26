package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.play.core.internal.ag;
import com.google.android.play.core.listener.a;

public final class m extends a<SplitInstallSessionState> {
    private static m b = null;
    private final Handler c = new Handler(Looper.getMainLooper());
    private final e d;

    private m(Context context, e eVar) {
        super(new ag("SplitInstallListenerRegistry"), new IntentFilter("com.google.android.play.core.splitinstall.receiver.SplitInstallUpdateIntentService"), context);
        this.d = eVar;
    }

    public static synchronized m a(Context context) {
        m mVar;
        synchronized (m.class) {
            if (b == null) {
                b = new m(context, f.INSTANCE);
            }
            mVar = b;
        }
        return mVar;
    }

    /* access modifiers changed from: private */
    public final void a(SplitInstallSessionState splitInstallSessionState, int i, int i2) {
        this.c.post(new l(this, splitInstallSessionState, i, i2));
    }

    /* access modifiers changed from: protected */
    public final void a(Context context, Intent intent) {
        Bundle bundleExtra = intent.getBundleExtra("session_state");
        if (bundleExtra != null) {
            SplitInstallSessionState a = SplitInstallSessionState.a(bundleExtra);
            this.a.b("ListenerRegistryBroadcastReceiver.onReceive: %s", a);
            c a2 = this.d.a();
            if (a.status() != 3 || a2 == null) {
                a(a);
            } else {
                a2.a(a.c(), new b(this, a, intent, context));
            }
        }
    }
}
