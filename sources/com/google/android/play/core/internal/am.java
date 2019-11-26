package com.google.android.play.core.internal;

import java.io.File;
import java.util.Set;

final class am implements ad {
    am() {
    }

    public final void a(ClassLoader classLoader, Set<File> set) {
        af.b(classLoader, set);
    }

    public final boolean a(ClassLoader classLoader, File file, File file2, boolean z) {
        return af.a(classLoader, file, file2, z, new ai(), "zip", new ah());
    }
}
