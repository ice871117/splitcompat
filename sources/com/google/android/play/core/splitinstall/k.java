package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources.NotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.google.android.play.core.internal.ag;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

public final class k {
    private static final ag a = new ag("SplitInstallInfoProvider");
    private final Context b;
    private final String c;
    private j d = null;
    private d e = null;

    public k(Context context, String str) {
        this.b = context;
        this.c = str;
    }

    public static boolean a(String str) {
        return str.startsWith("config.");
    }

    public static boolean b(String str) {
        return str.startsWith("config.") || str.contains(".config.");
    }

    private final d c() {
        d dVar = null;
        Bundle f = f();
        if (f != null) {
            int i = f.getInt("com.android.vending.splits");
            if (i == 0) {
                a.c("No metadata found in AndroidManifest.", new Object[0]);
            } else {
                try {
                    dVar = new aj(this.b.getResources().getXml(i)).a();
                    if (dVar == null) {
                        a.c("Can't parse languages metadata.", new Object[0]);
                    }
                } catch (NotFoundException e2) {
                    a.c("Resource with languages metadata doesn't exist.", new Object[0]);
                }
            }
        }
        return dVar;
    }

    public static String c(String str) {
        return str.startsWith("config.") ? "" : str.split("\\.config\\.", 2)[0];
    }

    private final Set<String> d() {
        HashSet hashSet = new HashSet();
        Bundle f = f();
        if (f != null) {
            String string = f.getString("com.android.dynamic.apk.fused.modules");
            if (string == null || string.isEmpty()) {
                a.b("App has no fused modules.", new Object[0]);
            } else {
                Collections.addAll(hashSet, string.split(",", -1));
                hashSet.remove("");
            }
        }
        if (VERSION.SDK_INT >= 21) {
            String[] e2 = e();
            if (e2 != null) {
                a.b("Adding splits from package manager: %s", Arrays.toString(e2));
                Collections.addAll(hashSet, e2);
            } else {
                a.b("No splits are found or app cannot be found in package manager.", new Object[0]);
            }
            j a2 = h.a();
            if (a2 != null) {
                hashSet.addAll(a2.a());
            }
        }
        return hashSet;
    }

    private final String[] e() {
        try {
            PackageInfo packageInfo = this.b.getPackageManager().getPackageInfo(this.c, 0);
            if (packageInfo != null) {
                return packageInfo.splitNames;
            }
            return null;
        } catch (NameNotFoundException e2) {
            a.c("App is not found in PackageManager", new Object[0]);
            return null;
        }
    }

    private final Bundle f() {
        try {
            ApplicationInfo applicationInfo = this.b.getPackageManager().getApplicationInfo(this.c, 128);
            if (applicationInfo != null && applicationInfo.metaData != null) {
                return applicationInfo.metaData;
            }
            a.b("App has no applicationInfo or metaData", new Object[0]);
            return null;
        } catch (NameNotFoundException e2) {
            a.c("App is not found in PackageManager", new Object[0]);
            return null;
        }
    }

    public final Set<String> a() {
        HashSet hashSet = new HashSet();
        for (String str : d()) {
            if (!b(str)) {
                hashSet.add(str);
            }
        }
        return hashSet;
    }

    /* access modifiers changed from: 0000 */
    public final Set<String> b() {
        d c2 = c();
        if (c2 == null) {
            return null;
        }
        HashSet hashSet = new HashSet();
        Set d2 = d();
        d2.add("");
        Set a2 = a();
        a2.add("");
        for (Entry entry : c2.a(a2).entrySet()) {
            if (d2.containsAll((Collection) entry.getValue())) {
                hashSet.add((String) entry.getKey());
            }
        }
        return hashSet;
    }
}
