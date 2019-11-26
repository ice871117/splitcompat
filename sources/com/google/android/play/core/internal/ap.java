package com.google.android.play.core.internal;

import java.io.File;
import java.util.Set;

final class ap implements ad {
    ap() {
    }

    public final void a(ClassLoader classLoader, Set<File> set) {
        al.a(classLoader, set, new an());
    }

    public final boolean a(ClassLoader classLoader, File file, File file2, boolean z) {
        return al.a(classLoader, file, file2, z, "zip");
    }
}
