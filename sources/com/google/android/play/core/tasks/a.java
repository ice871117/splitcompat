package com.google.android.play.core.tasks;

import java.util.concurrent.Executor;

final class a<ResultT> implements h<ResultT> {
    private final Executor a;
    /* access modifiers changed from: private */
    public final Object b = new Object();
    /* access modifiers changed from: private */
    public OnCompleteListener<ResultT> c;

    public a(Executor executor, OnCompleteListener<ResultT> onCompleteListener) {
        this.a = executor;
        this.c = onCompleteListener;
    }

    public final void a(Task<ResultT> task) {
        synchronized (this.b) {
            if (this.c != null) {
                this.a.execute(new b(this, task));
            }
        }
    }
}
