package com.google.android.play.core.internal;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

final class af implements ad {
    af() {
    }

    static Object a(ClassLoader classLoader) {
        return az.a((Object) classLoader, "pathList", Object.class).a();
    }

    static boolean a(ClassLoader classLoader, File file, File file2, boolean z, aj ajVar, String str, ak akVar) {
        int i = 0;
        ArrayList arrayList = new ArrayList();
        Object a = a(classLoader);
        ba b = az.b(a, "dexElements", Object.class);
        List<Object> asList = Arrays.asList((Object[]) b.a());
        ArrayList arrayList2 = new ArrayList();
        for (Object a2 : asList) {
            arrayList2.add((File) az.a(a2, str, File.class).a());
        }
        if (arrayList2.contains(file2)) {
            return true;
        }
        if (z || akVar.a(a, file2, file)) {
            b.a((T[]) ajVar.a(a, new ArrayList(Collections.singleton(file2)), file, arrayList));
            if (arrayList.isEmpty()) {
                return true;
            }
            aa aaVar = new aa("DexPathList.makeDexElement failed");
            ArrayList arrayList3 = arrayList;
            int size = arrayList3.size();
            while (i < size) {
                Object obj = arrayList3.get(i);
                i++;
                IOException iOException = (IOException) obj;
                Log.e("SplitCompat", "DexPathList.makeDexElement failed", iOException);
                bh.a(aaVar, iOException);
            }
            az.b(a, "dexElementsSuppressedExceptions", IOException.class).a((Collection<T>) arrayList);
            throw aaVar;
        }
        String str2 = "SplitCompat";
        String str3 = "Should be optimized ";
        String valueOf = String.valueOf(file2.getPath());
        Log.w(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
        return false;
    }

    static void b(ClassLoader classLoader, Set<File> set) {
        if (!set.isEmpty()) {
            HashSet hashSet = new HashSet();
            for (File file : set) {
                String str = "Splitcompat";
                String str2 = "Adding native library parent directory: ";
                String valueOf = String.valueOf(file.getParentFile().getAbsolutePath());
                Log.d(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                hashSet.add(file.getParentFile());
            }
            ba b = az.b(a(classLoader), "nativeLibraryDirectories", File.class);
            hashSet.removeAll(Arrays.asList((File[]) b.a()));
            Log.d("Splitcompat", "Adding directories " + hashSet.size());
            b.b((Collection<T>) hashSet);
        }
    }

    public final void a(ClassLoader classLoader, Set<File> set) {
        b(classLoader, set);
    }

    public final boolean a(ClassLoader classLoader, File file, File file2, boolean z) {
        return a(classLoader, file, file2, z, new ai(), "zip", new ah());
    }
}
