package com.google.android.play.core.splitcompat;

import java.io.IOException;
import java.util.Set;
import java.util.zip.ZipFile;

final class i implements k {
    private final /* synthetic */ Set a;
    private final /* synthetic */ q b;
    private final /* synthetic */ d c;

    i(d dVar, Set set, q qVar) {
        this.c = dVar;
        this.a = set;
        this.b = qVar;
    }

    public final void a(ZipFile zipFile, Set<l> set) throws IOException {
        this.a.addAll(this.c.a(set, this.b, zipFile));
    }
}
