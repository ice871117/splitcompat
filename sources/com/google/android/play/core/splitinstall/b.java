package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.content.Intent;

public class b {
    final /* synthetic */ SplitInstallSessionState a;
    final /* synthetic */ Intent b;
    final /* synthetic */ Context c;
    final /* synthetic */ m d;

    b(m mVar, SplitInstallSessionState splitInstallSessionState, Intent intent, Context context) {
        this.d = mVar;
        this.a = splitInstallSessionState;
        this.b = intent;
        this.c = context;
    }

    public void a() {
        this.d.a(this.a, 5, 0);
    }

    public void a(int i) {
        this.d.a(this.a, 6, i);
    }

    public void b() {
        if (!this.b.getBooleanExtra("triggered_from_app_after_verification", false)) {
            this.b.putExtra("triggered_from_app_after_verification", true);
            this.c.sendBroadcast(this.b);
            return;
        }
        this.d.a.d("Splits copied and verified more than once.", new Object[0]);
    }
}
