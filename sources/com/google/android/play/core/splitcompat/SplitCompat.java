package com.google.android.play.core.splitcompat;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import android.os.Build.VERSION;
import android.util.Log;
import com.google.android.play.core.internal.aa;
import com.google.android.play.core.internal.ac;
import com.google.android.play.core.internal.ad;
import com.google.android.play.core.internal.ae;
import com.google.android.play.core.internal.ag;
import com.google.android.play.core.internal.az;
import com.google.android.play.core.splitinstall.f;
import com.google.android.play.core.splitinstall.h;
import com.google.android.play.core.splitinstall.i;
import com.google.android.play.core.splitinstall.k;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public class SplitCompat {
    private static final AtomicReference<SplitCompat> a = new AtomicReference<>(null);
    /* access modifiers changed from: private */
    public final e b;
    private final Set<String> c = new HashSet();

    private SplitCompat(Context context) {
        try {
            this.b = new e(context);
        } catch (NameNotFoundException | IOException e) {
            throw new aa("Failed to initialize FileStorage", e);
        }
    }

    private static void a(Context context, Set<File> set) {
        AssetManager assets = context.getAssets();
        for (File path : set) {
            Log.d("SplitCompat", "addAssetPath completed with " + ((Integer) az.a((Object) assets, "addAssetPath", Integer.class, String.class, path.getPath())).intValue());
        }
    }

    public static boolean a() {
        return a.get() != null;
    }

    public static boolean a(Context context) {
        return a(context, true);
    }

    private static boolean a(Context context, boolean z) {
        if (b()) {
            return false;
        }
        SplitCompat splitCompat = (SplitCompat) a.get();
        if (a.compareAndSet(null, new SplitCompat(context))) {
            f.a(new ac(context, c.a(), new ae(context, splitCompat.b, new az()), splitCompat.b, new i()));
            h.a(new n(splitCompat));
            c.a().execute(new m(context));
        }
        try {
            splitCompat.b(context, z);
            return true;
        } catch (Exception e) {
            Log.e("SplitCompat", "Error installing additional splits", e);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x001d A[SYNTHETIC, Splitter:B:14:0x001d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(com.google.android.play.core.splitcompat.q r3) throws java.io.IOException {
        /*
            r2 = 0
            java.util.zip.ZipFile r1 = new java.util.zip.ZipFile     // Catch:{ IOException -> 0x0019 }
            java.io.File r0 = r3.a()     // Catch:{ IOException -> 0x0019 }
            r1.<init>(r0)     // Catch:{ IOException -> 0x0019 }
            java.lang.String r0 = "classes.dex"
            java.util.zip.ZipEntry r0 = r1.getEntry(r0)     // Catch:{ IOException -> 0x0026 }
            if (r0 == 0) goto L_0x0017
            r0 = 1
        L_0x0013:
            r1.close()     // Catch:{ IOException -> 0x0026 }
            return r0
        L_0x0017:
            r0 = 0
            goto L_0x0013
        L_0x0019:
            r0 = move-exception
            r1 = r2
        L_0x001b:
            if (r1 == 0) goto L_0x0020
            r1.close()     // Catch:{ IOException -> 0x0021 }
        L_0x0020:
            throw r0
        L_0x0021:
            r1 = move-exception
            com.google.android.play.core.internal.bh.a(r0, r1)
            goto L_0x0020
        L_0x0026:
            r0 = move-exception
            goto L_0x001b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.splitcompat.SplitCompat.a(com.google.android.play.core.splitcompat.q):boolean");
    }

    private final synchronized void b(Context context) throws IOException {
        HashSet hashSet = new HashSet();
        SplitCompat splitCompat = (SplitCompat) a.get();
        for (String b2 : splitCompat == null ? Collections.emptySet() : splitCompat.c()) {
            hashSet.add(this.b.b(b2));
        }
        a(context, (Set<File>) hashSet);
    }

    private final synchronized void b(Context context, boolean z) throws IOException {
        if (z) {
            this.b.a();
        } else {
            c.a().execute(new p(this));
        }
        List<String> c2 = c(context);
        Set<q> d = this.b.d();
        HashSet hashSet = new HashSet();
        Iterator it = d.iterator();
        while (it.hasNext()) {
            String b2 = ((q) it.next()).b();
            if (c2.contains(b2)) {
                if (z) {
                    this.b.f(b2);
                } else {
                    hashSet.add(b2);
                }
                it.remove();
            }
        }
        if (!hashSet.isEmpty()) {
            c.a().execute(new o(this, hashSet));
        }
        HashSet hashSet2 = new HashSet();
        for (q b3 : d) {
            String b4 = b3.b();
            if (!k.b(b4)) {
                hashSet2.add(b4);
            }
        }
        for (String str : c2) {
            if (!k.b(str)) {
                hashSet2.add(str);
            }
        }
        HashSet<q> hashSet3 = new HashSet<>(d.size());
        for (q qVar : d) {
            if (k.a(qVar.b()) || hashSet2.contains(k.c(qVar.b()))) {
                hashSet3.add(qVar);
            }
        }
        d dVar = new d(this.b);
        ad a2 = ag.a();
        ClassLoader classLoader = context.getClassLoader();
        if (z) {
            a2.a(classLoader, dVar.a());
        } else {
            Iterator it2 = hashSet3.iterator();
            while (it2.hasNext()) {
                Set a3 = dVar.a((q) it2.next());
                if (a3 == null) {
                    it2.remove();
                } else {
                    a2.a(classLoader, a3);
                }
            }
        }
        HashSet hashSet4 = new HashSet();
        for (q qVar2 : hashSet3) {
            if (!a(qVar2) || a2.a(classLoader, this.b.c(qVar2.b()), qVar2.a(), z)) {
                hashSet4.add(qVar2.a());
            } else {
                String valueOf = String.valueOf(qVar2.a());
                Log.w("SplitCompat", new StringBuilder(String.valueOf(valueOf).length() + 24).append("split was not installed ").append(valueOf).toString());
            }
        }
        a(context, (Set<File>) hashSet4);
        for (q qVar3 : hashSet3) {
            if (hashSet4.contains(qVar3.a())) {
                String b5 = qVar3.b();
                Log.d("SplitCompat", new StringBuilder(String.valueOf(b5).length() + 30).append("Split '").append(b5).append("' installation emulated").toString());
                this.c.add(qVar3.b());
            } else {
                String b6 = qVar3.b();
                Log.d("SplitCompat", new StringBuilder(String.valueOf(b6).length() + 35).append("Split '").append(b6).append("' installation not emulated.").toString());
            }
        }
    }

    private static boolean b() {
        return VERSION.SDK_INT < 21;
    }

    private static List<String> c(Context context) throws IOException {
        String packageName = context.getPackageName();
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            return packageInfo.splitNames == null ? new ArrayList() : Arrays.asList(packageInfo.splitNames);
        } catch (NameNotFoundException e) {
            throw new IOException(String.format("Cannot load data for application '%s'", new Object[]{packageName}), e);
        }
    }

    /* access modifiers changed from: private */
    public final synchronized Set<String> c() {
        return new HashSet(this.c);
    }

    public static boolean install(Context context) {
        return a(context, false);
    }

    public static boolean installActivity(Context context) {
        if (b()) {
            return false;
        }
        SplitCompat splitCompat = (SplitCompat) a.get();
        if (splitCompat == null) {
            throw new IllegalStateException("SplitCompat.installActivity can only be called if SplitCompat.install is first called at startup on application context.");
        }
        try {
            splitCompat.b(context);
            return true;
        } catch (Exception e) {
            Log.e("SplitCompat", "Error installing additional splits", e);
            return false;
        }
    }
}
