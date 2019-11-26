package com.google.android.play.core.appupdate;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import com.google.android.play.core.internal.ag;
import com.google.android.play.core.internal.m;
import com.google.android.play.core.internal.q;
import com.google.android.play.core.internal.r;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.i;

final class d {
    /* access modifiers changed from: private */
    public static final ag b = new ag("AppUpdateService");
    private static final Intent c = new Intent("com.google.android.play.core.install.BIND_UPDATE_SERVICE").setPackage("com.android.vending");
    final q<m> a;
    /* access modifiers changed from: private */
    public final String d;
    private final Context e;

    public d(Context context) {
        this.d = context.getPackageName();
        this.e = context;
        this.a = new q<>(context.getApplicationContext(), b, "AppUpdateService", c, c.a);
    }

    /* access modifiers changed from: private */
    public static int b(Bundle bundle) {
        return bundle.getInt("error.code", -2);
    }

    /* access modifiers changed from: private */
    public static AppUpdateInfo b(Bundle bundle, String str) {
        return AppUpdateInfo.a(str, bundle.getInt("version.code", -1), bundle.getInt("update.availability"), bundle.getInt("install.status", 0), (PendingIntent) bundle.getParcelable("blocking.intent"), (PendingIntent) bundle.getParcelable("nonblocking.intent"));
    }

    /* access modifiers changed from: private */
    public static Bundle c() {
        Bundle bundle = new Bundle();
        bundle.putInt("playcore.version.code", 10603);
        return bundle;
    }

    /* access modifiers changed from: private */
    public final Bundle c(String str) {
        Bundle bundle = new Bundle();
        bundle.putAll(c());
        bundle.putString("package.name", str);
        Integer d2 = d();
        if (d2 != null) {
            bundle.putInt("app.version.code", d2.intValue());
        }
        return bundle;
    }

    private final Integer d() {
        try {
            return Integer.valueOf(this.e.getPackageManager().getPackageInfo(this.e.getPackageName(), 0).versionCode);
        } catch (NameNotFoundException e2) {
            b.d("The current version of the app could not be retrieved", new Object[0]);
            return null;
        }
    }

    public final Task<AppUpdateInfo> a(String str) {
        b.a("requestUpdateInfo(%s)", str);
        i iVar = new i();
        this.a.a((r) new f(this, iVar, str, iVar));
        return iVar.a();
    }

    public final Task<Void> b(String str) {
        b.a("completeUpdate(%s)", str);
        i iVar = new i();
        this.a.a((r) new e(this, iVar, iVar, str));
        return iVar.a();
    }
}
