package com.google.android.play.core.splitcompat;

import java.io.File;
import java.io.IOException;

final class f implements j {
    private final /* synthetic */ g a;

    f(g gVar) {
        this.a = gVar;
    }

    public final void a(l lVar, File file, boolean z) throws IOException {
        this.a.a.add(file);
        if (!z) {
            this.a.b.set(false);
        }
    }
}
