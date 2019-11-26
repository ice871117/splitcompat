package com.google.android.play.core.internal;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

final class al implements ad {
    al() {
    }

    public static void a(ClassLoader classLoader, Set<File> set, aq aqVar) {
        if (!set.isEmpty()) {
            HashSet hashSet = new HashSet();
            for (File parentFile : set) {
                hashSet.add(parentFile.getParentFile());
            }
            Object a = af.a(classLoader);
            List list = (List) az.a(a, "nativeLibraryDirectories", List.class).a();
            hashSet.removeAll(list);
            list.addAll(hashSet);
            ArrayList arrayList = new ArrayList();
            Object[] a2 = aqVar.a(a, new ArrayList(hashSet), null, arrayList);
            if (!arrayList.isEmpty()) {
                aa aaVar = new aa("Error in makePathElements");
                ArrayList arrayList2 = arrayList;
                int size = arrayList2.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList2.get(i);
                    i++;
                    bh.a(aaVar, (IOException) obj);
                }
                throw aaVar;
            }
            az.b(a, "nativeLibraryPathElements", Object.class).b((T[]) a2);
        }
    }

    public static boolean a(ClassLoader classLoader, File file, File file2, boolean z, String str) {
        return af.a(classLoader, file, file2, z, new ao(), str, new ah());
    }

    /* access modifiers changed from: private */
    public static Object[] b(Object obj, List<File> list, File file, List<IOException> list2) {
        return (Object[]) az.a(obj, "makePathElements", Object[].class, List.class, list, File.class, file, List.class, list2);
    }

    public final void a(ClassLoader classLoader, Set<File> set) {
        a(classLoader, set, new an());
    }

    public final boolean a(ClassLoader classLoader, File file, File file2, boolean z) {
        return a(classLoader, file, file2, z, "zip");
    }
}
