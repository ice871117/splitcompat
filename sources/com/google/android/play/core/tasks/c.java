package com.google.android.play.core.tasks;

final class c implements Runnable {
    private final /* synthetic */ Task a;
    private final /* synthetic */ d b;

    c(d dVar, Task task) {
        this.b = dVar;
        this.a = task;
    }

    public final void run() {
        synchronized (this.b.b) {
            if (this.b.c != null) {
                this.b.c.onFailure(this.a.getException());
            }
        }
    }
}
