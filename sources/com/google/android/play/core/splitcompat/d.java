package com.google.android.play.core.splitcompat;

import android.util.Log;
import com.google.android.play.core.internal.bh;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;
import java.util.zip.ZipFile;

public final class d {
    private static final Pattern a = Pattern.compile("lib/([^/]+)/(.*\\.so)$");
    private final e b;

    d(e eVar) throws IOException {
        this.b = eVar;
    }

    /* access modifiers changed from: private */
    public final Set<File> a(Set<l> set, q qVar, ZipFile zipFile) throws IOException {
        HashSet hashSet = new HashSet();
        a(qVar, set, (j) new h(hashSet, qVar, zipFile));
        return hashSet;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0072 A[SYNTHETIC, Splitter:B:16:0x0072] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(com.google.android.play.core.splitcompat.q r13, com.google.android.play.core.splitcompat.k r14) throws java.io.IOException {
        /*
            r3 = 0
            r1 = 0
            java.util.zip.ZipFile r2 = new java.util.zip.ZipFile     // Catch:{ IOException -> 0x0116 }
            java.io.File r0 = r13.a()     // Catch:{ IOException -> 0x0116 }
            r2.<init>(r0)     // Catch:{ IOException -> 0x0116 }
            java.lang.String r4 = r13.b()     // Catch:{ IOException -> 0x006e }
            java.util.HashMap r5 = new java.util.HashMap     // Catch:{ IOException -> 0x006e }
            r5.<init>()     // Catch:{ IOException -> 0x006e }
            java.util.Enumeration r6 = r2.entries()     // Catch:{ IOException -> 0x006e }
        L_0x0018:
            boolean r0 = r6.hasMoreElements()     // Catch:{ IOException -> 0x006e }
            if (r0 == 0) goto L_0x0076
            java.lang.Object r0 = r6.nextElement()     // Catch:{ IOException -> 0x006e }
            java.util.zip.ZipEntry r0 = (java.util.zip.ZipEntry) r0     // Catch:{ IOException -> 0x006e }
            java.lang.String r1 = r0.getName()     // Catch:{ IOException -> 0x006e }
            java.util.regex.Pattern r7 = a     // Catch:{ IOException -> 0x006e }
            java.util.regex.Matcher r1 = r7.matcher(r1)     // Catch:{ IOException -> 0x006e }
            boolean r7 = r1.matches()     // Catch:{ IOException -> 0x006e }
            if (r7 == 0) goto L_0x0018
            r7 = 1
            java.lang.String r7 = r1.group(r7)     // Catch:{ IOException -> 0x006e }
            r8 = 2
            java.lang.String r8 = r1.group(r8)     // Catch:{ IOException -> 0x006e }
            java.lang.String r1 = "SplitCompat"
            java.lang.String r9 = "NativeLibraryExtractor: split '%s' has native library '%s' for ABI '%s'"
            r10 = 3
            java.lang.Object[] r10 = new java.lang.Object[r10]     // Catch:{ IOException -> 0x006e }
            r11 = 0
            r10[r11] = r4     // Catch:{ IOException -> 0x006e }
            r11 = 1
            r10[r11] = r8     // Catch:{ IOException -> 0x006e }
            r11 = 2
            r10[r11] = r7     // Catch:{ IOException -> 0x006e }
            java.lang.String r9 = java.lang.String.format(r9, r10)     // Catch:{ IOException -> 0x006e }
            android.util.Log.d(r1, r9)     // Catch:{ IOException -> 0x006e }
            java.lang.Object r1 = r5.get(r7)     // Catch:{ IOException -> 0x006e }
            java.util.Set r1 = (java.util.Set) r1     // Catch:{ IOException -> 0x006e }
            if (r1 != 0) goto L_0x0065
            java.util.HashSet r1 = new java.util.HashSet     // Catch:{ IOException -> 0x006e }
            r1.<init>()     // Catch:{ IOException -> 0x006e }
            r5.put(r7, r1)     // Catch:{ IOException -> 0x006e }
        L_0x0065:
            com.google.android.play.core.splitcompat.l r7 = new com.google.android.play.core.splitcompat.l     // Catch:{ IOException -> 0x006e }
            r7.<init>(r0, r8)     // Catch:{ IOException -> 0x006e }
            r1.add(r7)     // Catch:{ IOException -> 0x006e }
            goto L_0x0018
        L_0x006e:
            r0 = move-exception
            r1 = r2
        L_0x0070:
            if (r1 == 0) goto L_0x0075
            r1.close()     // Catch:{ IOException -> 0x0110 }
        L_0x0075:
            throw r0
        L_0x0076:
            java.util.HashMap r4 = new java.util.HashMap     // Catch:{ IOException -> 0x006e }
            r4.<init>()     // Catch:{ IOException -> 0x006e }
            java.lang.String[] r6 = android.os.Build.SUPPORTED_ABIS     // Catch:{ IOException -> 0x006e }
            int r7 = r6.length     // Catch:{ IOException -> 0x006e }
            r1 = r3
        L_0x007f:
            if (r1 >= r7) goto L_0x0100
            r3 = r6[r1]     // Catch:{ IOException -> 0x006e }
            boolean r0 = r5.containsKey(r3)     // Catch:{ IOException -> 0x006e }
            if (r0 == 0) goto L_0x00eb
            java.lang.String r0 = "SplitCompat"
            java.lang.String r8 = "NativeLibraryExtractor: there are native libraries for supported ABI %s; will use this ABI"
            r9 = 1
            java.lang.Object[] r9 = new java.lang.Object[r9]     // Catch:{ IOException -> 0x006e }
            r10 = 0
            r9[r10] = r3     // Catch:{ IOException -> 0x006e }
            java.lang.String r8 = java.lang.String.format(r8, r9)     // Catch:{ IOException -> 0x006e }
            android.util.Log.d(r0, r8)     // Catch:{ IOException -> 0x006e }
            java.lang.Object r0 = r5.get(r3)     // Catch:{ IOException -> 0x006e }
            java.util.Set r0 = (java.util.Set) r0     // Catch:{ IOException -> 0x006e }
            java.util.Iterator r8 = r0.iterator()     // Catch:{ IOException -> 0x006e }
        L_0x00a4:
            boolean r0 = r8.hasNext()     // Catch:{ IOException -> 0x006e }
            if (r0 == 0) goto L_0x00fc
            java.lang.Object r0 = r8.next()     // Catch:{ IOException -> 0x006e }
            com.google.android.play.core.splitcompat.l r0 = (com.google.android.play.core.splitcompat.l) r0     // Catch:{ IOException -> 0x006e }
            java.lang.String r9 = r0.a     // Catch:{ IOException -> 0x006e }
            boolean r9 = r4.containsKey(r9)     // Catch:{ IOException -> 0x006e }
            if (r9 == 0) goto L_0x00cf
            java.lang.String r9 = "SplitCompat"
            java.lang.String r10 = "NativeLibraryExtractor: skipping library %s for ABI %s; already present for a better ABI"
            r11 = 2
            java.lang.Object[] r11 = new java.lang.Object[r11]     // Catch:{ IOException -> 0x006e }
            r12 = 0
            java.lang.String r0 = r0.a     // Catch:{ IOException -> 0x006e }
            r11[r12] = r0     // Catch:{ IOException -> 0x006e }
            r0 = 1
            r11[r0] = r3     // Catch:{ IOException -> 0x006e }
            java.lang.String r0 = java.lang.String.format(r10, r11)     // Catch:{ IOException -> 0x006e }
            android.util.Log.d(r9, r0)     // Catch:{ IOException -> 0x006e }
            goto L_0x00a4
        L_0x00cf:
            java.lang.String r9 = r0.a     // Catch:{ IOException -> 0x006e }
            r4.put(r9, r0)     // Catch:{ IOException -> 0x006e }
            java.lang.String r9 = "SplitCompat"
            java.lang.String r10 = "NativeLibraryExtractor: using library %s for ABI %s"
            r11 = 2
            java.lang.Object[] r11 = new java.lang.Object[r11]     // Catch:{ IOException -> 0x006e }
            r12 = 0
            java.lang.String r0 = r0.a     // Catch:{ IOException -> 0x006e }
            r11[r12] = r0     // Catch:{ IOException -> 0x006e }
            r0 = 1
            r11[r0] = r3     // Catch:{ IOException -> 0x006e }
            java.lang.String r0 = java.lang.String.format(r10, r11)     // Catch:{ IOException -> 0x006e }
            android.util.Log.d(r9, r0)     // Catch:{ IOException -> 0x006e }
            goto L_0x00a4
        L_0x00eb:
            java.lang.String r0 = "SplitCompat"
            java.lang.String r8 = "NativeLibraryExtractor: there are no native libraries for supported ABI %s"
            r9 = 1
            java.lang.Object[] r9 = new java.lang.Object[r9]     // Catch:{ IOException -> 0x006e }
            r10 = 0
            r9[r10] = r3     // Catch:{ IOException -> 0x006e }
            java.lang.String r3 = java.lang.String.format(r8, r9)     // Catch:{ IOException -> 0x006e }
            android.util.Log.d(r0, r3)     // Catch:{ IOException -> 0x006e }
        L_0x00fc:
            int r0 = r1 + 1
            r1 = r0
            goto L_0x007f
        L_0x0100:
            java.util.HashSet r0 = new java.util.HashSet     // Catch:{ IOException -> 0x006e }
            java.util.Collection r1 = r4.values()     // Catch:{ IOException -> 0x006e }
            r0.<init>(r1)     // Catch:{ IOException -> 0x006e }
            r14.a(r2, r0)     // Catch:{ IOException -> 0x006e }
            r2.close()     // Catch:{ IOException -> 0x006e }
            return
        L_0x0110:
            r1 = move-exception
            com.google.android.play.core.internal.bh.a(r0, r1)
            goto L_0x0075
        L_0x0116:
            r0 = move-exception
            goto L_0x0070
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.splitcompat.d.a(com.google.android.play.core.splitcompat.q, com.google.android.play.core.splitcompat.k):void");
    }

    /* access modifiers changed from: private */
    public final void a(q qVar, Set<l> set, j jVar) throws IOException {
        for (l lVar : set) {
            File a2 = this.b.a(qVar.b(), lVar.a);
            jVar.a(lVar, a2, a2.exists() && a2.length() == lVar.b.getSize());
        }
    }

    private static /* synthetic */ void a(Throwable th, FileOutputStream fileOutputStream) {
        if (th != null) {
            try {
                fileOutputStream.close();
            } catch (Throwable th2) {
                bh.a(th, th2);
            }
        } else {
            fileOutputStream.close();
        }
    }

    private static /* synthetic */ void a(Throwable th, InputStream inputStream) {
        if (th != null) {
            try {
                inputStream.close();
            } catch (Throwable th2) {
                bh.a(th, th2);
            }
        } else {
            inputStream.close();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        a((java.lang.Throwable) null, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x002f, code lost:
        if (r4 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0031, code lost:
        a((java.lang.Throwable) null, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void b(java.util.zip.ZipFile r6, java.util.zip.ZipEntry r7, java.io.File r8) throws java.io.IOException {
        /*
            r3 = 0
            r0 = 4096(0x1000, float:5.74E-42)
            byte[] r0 = new byte[r0]
            java.io.InputStream r4 = r6.getInputStream(r7)
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ Throwable -> 0x0021, all -> 0x0035 }
            r5.<init>(r8)     // Catch:{ Throwable -> 0x0021, all -> 0x0035 }
        L_0x000e:
            int r1 = r4.read(r0)     // Catch:{ Throwable -> 0x0019, all -> 0x0038 }
            if (r1 <= 0) goto L_0x002b
            r2 = 0
            r5.write(r0, r2, r1)     // Catch:{ Throwable -> 0x0019, all -> 0x0038 }
            goto L_0x000e
        L_0x0019:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x001b }
        L_0x001b:
            r1 = move-exception
            r2 = r0
        L_0x001d:
            a(r2, r5)     // Catch:{ Throwable -> 0x0021, all -> 0x0035 }
            throw r1     // Catch:{ Throwable -> 0x0021, all -> 0x0035 }
        L_0x0021:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0023 }
        L_0x0023:
            r1 = move-exception
            r3 = r0
        L_0x0025:
            if (r4 == 0) goto L_0x002a
            a(r3, r4)
        L_0x002a:
            throw r1
        L_0x002b:
            r0 = 0
            a(r0, r5)     // Catch:{ Throwable -> 0x0021, all -> 0x0035 }
            if (r4 == 0) goto L_0x0034
            a(r3, r4)
        L_0x0034:
            return
        L_0x0035:
            r0 = move-exception
            r1 = r0
            goto L_0x0025
        L_0x0038:
            r0 = move-exception
            r1 = r0
            r2 = r3
            goto L_0x001d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.splitcompat.d.b(java.util.zip.ZipFile, java.util.zip.ZipEntry, java.io.File):void");
    }

    /* access modifiers changed from: 0000 */
    public final Set<File> a() throws IOException {
        boolean z;
        Log.d("SplitCompat", "NativeLibraryExtractor: synchronizing native libraries");
        Set<q> d = this.b.d();
        for (String str : this.b.e()) {
            Iterator it = d.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (((q) it.next()).b().equals(str)) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (!z) {
                Log.i("SplitCompat", String.format("NativeLibraryExtractor: extracted split '%s' has no corresponding split; deleting", new Object[]{str}));
                this.b.d(str);
            }
        }
        HashSet hashSet = new HashSet();
        for (q qVar : d) {
            HashSet hashSet2 = new HashSet();
            a(qVar, (k) new i(this, hashSet2, qVar));
            for (File file : this.b.e(qVar.b())) {
                if (!hashSet2.contains(file)) {
                    Log.i("SplitCompat", String.format("NativeLibraryExtractor: file '%s' found in split '%s' that is not in the split file '%s'; removing", new Object[]{file.getAbsolutePath(), qVar.b(), qVar.a().getAbsolutePath()}));
                    this.b.b(file);
                }
            }
            hashSet.addAll(hashSet2);
        }
        return hashSet;
    }

    /* access modifiers changed from: 0000 */
    public final Set<File> a(q qVar) throws IOException {
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        HashSet hashSet = new HashSet();
        a(qVar, (k) new g(this, qVar, hashSet, atomicBoolean));
        if (atomicBoolean.get()) {
            return hashSet;
        }
        return null;
    }
}
