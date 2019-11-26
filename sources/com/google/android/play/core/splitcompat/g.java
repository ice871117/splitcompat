package com.google.android.play.core.splitcompat;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.ZipFile;

final class g implements k {
    final /* synthetic */ Set a;
    final /* synthetic */ AtomicBoolean b;
    private final /* synthetic */ q c;
    private final /* synthetic */ d d;

    g(d dVar, q qVar, Set set, AtomicBoolean atomicBoolean) {
        this.d = dVar;
        this.c = qVar;
        this.a = set;
        this.b = atomicBoolean;
    }

    public final void a(ZipFile zipFile, Set<l> set) throws IOException {
        this.d.a(this.c, set, (j) new f(this));
    }
}
