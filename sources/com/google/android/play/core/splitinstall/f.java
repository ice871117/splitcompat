package com.google.android.play.core.splitinstall;

import java.util.concurrent.atomic.AtomicReference;

public enum f implements e {
    INSTANCE;
    
    private static final AtomicReference<c> b = null;

    static {
        INSTANCE = new f("INSTANCE", 0);
        new f[1][0] = INSTANCE;
        b = new AtomicReference<>(null);
    }

    public static void a(c cVar) {
        b.compareAndSet(null, cVar);
    }

    public final c a() {
        return (c) b.get();
    }
}
