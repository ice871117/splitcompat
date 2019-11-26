package com.google.android.play.core.tasks;

import com.google.android.play.core.internal.az;
import java.util.concurrent.Executor;

final class k<ResultT> extends Task<ResultT> {
    private final Object a = new Object();
    private final g<ResultT> b = new g<>();
    private boolean c;
    private ResultT d;
    private Exception e;

    k() {
    }

    private final void a() {
        az.a(this.c, (Object) "Task is not yet complete");
    }

    private final void b() {
        az.a(!this.c, (Object) "Task is already complete");
    }

    private final void c() {
        synchronized (this.a) {
            if (this.c) {
                this.b.a((Task<ResultT>) this);
            }
        }
    }

    public final void a(Exception exc) {
        az.a(exc, (Object) "Exception must not be null");
        synchronized (this.a) {
            b();
            this.c = true;
            this.e = exc;
        }
        this.b.a((Task<ResultT>) this);
    }

    public final void a(ResultT resultt) {
        synchronized (this.a) {
            b();
            this.c = true;
            this.d = resultt;
        }
        this.b.a((Task<ResultT>) this);
    }

    public final Task<ResultT> addOnCompleteListener(OnCompleteListener<ResultT> onCompleteListener) {
        return addOnCompleteListener(TaskExecutors.MAIN_THREAD, onCompleteListener);
    }

    public final Task<ResultT> addOnCompleteListener(Executor executor, OnCompleteListener<ResultT> onCompleteListener) {
        this.b.a((h<ResultT>) new a<ResultT>(executor, onCompleteListener));
        c();
        return this;
    }

    public final Task<ResultT> addOnFailureListener(OnFailureListener onFailureListener) {
        return addOnFailureListener(TaskExecutors.MAIN_THREAD, onFailureListener);
    }

    public final Task<ResultT> addOnFailureListener(Executor executor, OnFailureListener onFailureListener) {
        this.b.a((h<ResultT>) new d<ResultT>(executor, onFailureListener));
        c();
        return this;
    }

    public final Task<ResultT> addOnSuccessListener(OnSuccessListener<? super ResultT> onSuccessListener) {
        return addOnSuccessListener(TaskExecutors.MAIN_THREAD, onSuccessListener);
    }

    public final Task<ResultT> addOnSuccessListener(Executor executor, OnSuccessListener<? super ResultT> onSuccessListener) {
        this.b.a((h<ResultT>) new e<ResultT>(executor, onSuccessListener));
        c();
        return this;
    }

    public final boolean b(Exception exc) {
        boolean z = true;
        az.a(exc, (Object) "Exception must not be null");
        synchronized (this.a) {
            if (this.c) {
                z = false;
            } else {
                this.c = true;
                this.e = exc;
                this.b.a((Task<ResultT>) this);
            }
        }
        return z;
    }

    public final boolean b(ResultT resultt) {
        boolean z = true;
        synchronized (this.a) {
            if (this.c) {
                z = false;
            } else {
                this.c = true;
                this.d = resultt;
                this.b.a((Task<ResultT>) this);
            }
        }
        return z;
    }

    public final Exception getException() {
        Exception exc;
        synchronized (this.a) {
            exc = this.e;
        }
        return exc;
    }

    public final ResultT getResult() {
        ResultT resultt;
        synchronized (this.a) {
            a();
            if (this.e != null) {
                throw new RuntimeExecutionException(this.e);
            }
            resultt = this.d;
        }
        return resultt;
    }

    public final <X extends Throwable> ResultT getResult(Class<X> cls) throws Throwable {
        ResultT resultt;
        synchronized (this.a) {
            a();
            if (cls.isInstance(this.e)) {
                throw ((Throwable) cls.cast(this.e));
            } else if (this.e != null) {
                throw new RuntimeExecutionException(this.e);
            } else {
                resultt = this.d;
            }
        }
        return resultt;
    }

    public final boolean isComplete() {
        boolean z;
        synchronized (this.a) {
            z = this.c;
        }
        return z;
    }

    public final boolean isSuccessful() {
        boolean z;
        synchronized (this.a) {
            z = this.c && this.e == null;
        }
        return z;
    }
}
