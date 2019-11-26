package com.google.android.play.core.tasks;

final class b implements Runnable {
    private final /* synthetic */ Task a;
    private final /* synthetic */ a b;

    b(a aVar, Task task) {
        this.b = aVar;
        this.a = task;
    }

    public final void run() {
        synchronized (this.b.b) {
            if (this.b.c != null) {
                this.b.c.onComplete(this.a);
            }
        }
    }
}
