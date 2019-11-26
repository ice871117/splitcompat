package com.google.android.play.core.tasks;

final class f implements Runnable {
    private final /* synthetic */ Task a;
    private final /* synthetic */ e b;

    f(e eVar, Task task) {
        this.b = eVar;
        this.a = task;
    }

    public final void run() {
        synchronized (this.b.b) {
            if (this.b.c != null) {
                this.b.c.onSuccess(this.a.getResult());
            }
        }
    }
}
