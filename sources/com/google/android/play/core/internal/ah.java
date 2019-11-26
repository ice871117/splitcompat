package com.google.android.play.core.internal;

import java.io.File;

final class ah implements ak {
    ah() {
    }

    public final boolean a(Object obj, File file, File file2) {
        return new File((String) az.a(obj.getClass(), "optimizedPathFor", String.class, File.class, file, File.class, file2)).exists();
    }
}
