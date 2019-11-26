package com.google.android.play.core.appupdate;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.play.core.install.InstallState;
import com.google.android.play.core.internal.ag;

public final class a extends com.google.android.play.core.listener.a<InstallState> {
    public a(Context context) {
        super(new ag("AppUpdateListenerRegistry"), new IntentFilter("com.google.android.play.core.install.ACTION_INSTALL_STATUS"), context);
    }

    /* access modifiers changed from: protected */
    public final void a(Context context, Intent intent) {
        if (!context.getPackageName().equals(intent.getStringExtra("package.name"))) {
            this.a.b("ListenerRegistryBroadcastReceiver received broadcast for third party app: %s", intent.getStringExtra("package.name"));
            return;
        }
        this.a.b("List of extras in received intent:", new Object[0]);
        for (String str : intent.getExtras().keySet()) {
            this.a.b("Key: %s; value: %s", str, intent.getExtras().get(str));
        }
        ag agVar = this.a;
        agVar.b("List of extras in received intent needed by fromUpdateIntent:", new Object[0]);
        agVar.b("Key: %s; value: %s", "install.status", Integer.valueOf(intent.getIntExtra("install.status", 0)));
        agVar.b("Key: %s; value: %s", "error.code", Integer.valueOf(intent.getIntExtra("error.code", 0)));
        InstallState a = InstallState.a(intent.getIntExtra("install.status", 0), intent.getIntExtra("error.code", 0), intent.getStringExtra("package.name"));
        this.a.b("ListenerRegistryBroadcastReceiver.onReceive: %s", a);
        a(a);
    }
}
