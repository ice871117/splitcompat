package com.google.android.play.core.internal;

import com.google.android.play.core.tasks.i;

public abstract class r implements Runnable {
    private final i<?> a;

    r() {
        this.a = null;
    }

    public r(i<?> iVar) {
        this.a = iVar;
    }

    /* access modifiers changed from: protected */
    public abstract void a();

    /* access modifiers changed from: 0000 */
    public final i<?> b() {
        return this.a;
    }

    public final void run() {
        try {
            a();
        } catch (Exception e) {
            if (this.a != null) {
                this.a.a(e);
            }
        }
    }
}
