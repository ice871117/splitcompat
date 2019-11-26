package com.google.android.play.core.tasks;

import java.util.concurrent.Executor;

final class e<ResultT> implements h<ResultT> {
    private final Executor a;
    /* access modifiers changed from: private */
    public final Object b = new Object();
    /* access modifiers changed from: private */
    public OnSuccessListener<? super ResultT> c;

    public e(Executor executor, OnSuccessListener<? super ResultT> onSuccessListener) {
        this.a = executor;
        this.c = onSuccessListener;
    }

    public final void a(Task<ResultT> task) {
        if (task.isSuccessful()) {
            synchronized (this.b) {
                if (this.c != null) {
                    this.a.execute(new f(this, task));
                }
            }
        }
    }
}
