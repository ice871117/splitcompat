package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.play.core.internal.ag;
import com.google.android.play.core.internal.bd;
import com.google.android.play.core.internal.r;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

final class q {
    /* access modifiers changed from: private */
    public static final ag b = new ag("SplitInstallService");
    private static final Intent c = new Intent("com.google.android.play.core.splitinstall.BIND_SPLIT_INSTALL_SERVICE").setPackage("com.android.vending");
    final com.google.android.play.core.internal.q<bd> a;
    /* access modifiers changed from: private */
    public final String d;

    public q(Context context) {
        this(context, context.getPackageName());
    }

    private q(Context context, String str) {
        this.d = str;
        this.a = new com.google.android.play.core.internal.q<>(context.getApplicationContext(), b, "SplitInstallService", c, p.a);
    }

    /* access modifiers changed from: private */
    public static ArrayList<Bundle> c(Collection<String> collection) {
        ArrayList<Bundle> arrayList = new ArrayList<>(collection.size());
        for (String str : collection) {
            Bundle bundle = new Bundle();
            bundle.putString("language", str);
            arrayList.add(bundle);
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public static Bundle d() {
        Bundle bundle = new Bundle();
        bundle.putInt("playcore_version_code", 10603);
        return bundle;
    }

    /* access modifiers changed from: private */
    public static ArrayList<Bundle> d(Collection<String> collection) {
        ArrayList<Bundle> arrayList = new ArrayList<>(collection.size());
        for (String str : collection) {
            Bundle bundle = new Bundle();
            bundle.putString("module_name", str);
            arrayList.add(bundle);
        }
        return arrayList;
    }

    public final Task<List<SplitInstallSessionState>> a() {
        b.a("getSessionStates", new Object[0]);
        i iVar = new i();
        this.a.a((r) new y(this, iVar, iVar));
        return iVar.a();
    }

    public final Task<SplitInstallSessionState> a(int i) {
        b.a("getSessionState(%d)", Integer.valueOf(i));
        i iVar = new i();
        this.a.a((r) new v(this, iVar, i, iVar));
        return iVar.a();
    }

    public final Task<Integer> a(Collection<String> collection, Collection<String> collection2) {
        b.a("startInstall(%s,%s)", collection, collection2);
        i iVar = new i();
        this.a.a((r) new s(this, iVar, collection, collection2, iVar));
        return iVar.a();
    }

    public final Task<Void> a(List<String> list) {
        b.a("deferredUninstall(%s)", list);
        i iVar = new i();
        this.a.a((r) new r(this, iVar, list, iVar));
        return iVar.a();
    }

    public final Task<Void> b(int i) {
        b.a("cancelInstall(%d)", Integer.valueOf(i));
        i iVar = new i();
        this.a.a((r) new x(this, iVar, i, iVar));
        return iVar.a();
    }

    public final Task<Void> b(List<String> list) {
        b.a("deferredInstall(%s)", list);
        i iVar = new i();
        this.a.a((r) new u(this, iVar, list, iVar));
        return iVar.a();
    }

    public final Task<Void> c(List<String> list) {
        b.a("deferredLanguageInstall(%s)", list);
        i iVar = new i();
        this.a.a((r) new t(this, iVar, list, iVar));
        return iVar.a();
    }

    public final Task<Void> d(List<String> list) {
        b.a("deferredLanguageUninstall(%s)", list);
        i iVar = new i();
        this.a.a((r) new w(this, iVar, list, iVar));
        return iVar.a();
    }
}
