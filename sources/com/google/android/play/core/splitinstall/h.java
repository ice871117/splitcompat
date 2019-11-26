package com.google.android.play.core.splitinstall;

import java.util.concurrent.atomic.AtomicReference;

public final class h {
    private static final AtomicReference<j> a = new AtomicReference<>(null);

    static j a() {
        return (j) a.get();
    }

    public static void a(j jVar) {
        a.compareAndSet(null, jVar);
    }
}
