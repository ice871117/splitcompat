package com.google.android.play.core.internal;

import java.io.File;
import java.util.Set;

final class ar implements ad {
    ar() {
    }

    static void b(ClassLoader classLoader, Set<File> set) {
        al.a(classLoader, set, new au());
    }

    static boolean b(ClassLoader classLoader, File file, File file2, boolean z) {
        return af.a(classLoader, file, file2, z, new ao(), "path", new at());
    }

    public final void a(ClassLoader classLoader, Set<File> set) {
        b(classLoader, set);
    }

    public final boolean a(ClassLoader classLoader, File file, File file2, boolean z) {
        return b(classLoader, file, file2, z);
    }
}
