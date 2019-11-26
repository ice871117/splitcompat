package com.google.android.play.core.splitcompat;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.zip.ZipFile;

final class h implements j {
    private final /* synthetic */ Set a;
    private final /* synthetic */ q b;
    private final /* synthetic */ ZipFile c;

    h(Set set, q qVar, ZipFile zipFile) {
        this.a = set;
        this.b = qVar;
        this.c = zipFile;
    }

    public final void a(l lVar, File file, boolean z) throws IOException {
        this.a.add(file);
        if (!z) {
            Log.i("SplitCompat", String.format("NativeLibraryExtractor: split '%s' has native library '%s' that does not exist; extracting from '%s!%s' to '%s'", new Object[]{this.b.b(), lVar.a, this.b.a().getAbsolutePath(), lVar.b.getName(), file.getAbsolutePath()}));
            d.b(this.c, lVar.b, file);
        }
    }
}
