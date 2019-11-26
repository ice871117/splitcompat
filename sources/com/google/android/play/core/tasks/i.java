package com.google.android.play.core.tasks;

public final class i<ResultT> {
    private final k<ResultT> a = new k<>();

    public final Task<ResultT> a() {
        return this.a;
    }

    public final boolean a(Exception exc) {
        return this.a.b(exc);
    }

    public final boolean a(ResultT resultt) {
        return this.a.b(resultt);
    }
}
