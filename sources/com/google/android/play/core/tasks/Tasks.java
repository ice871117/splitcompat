package com.google.android.play.core.tasks;

import com.google.android.play.core.internal.az;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class Tasks {

    interface a extends OnFailureListener, OnSuccessListener<Object> {
    }

    static final class b implements a {
        private final CountDownLatch a;

        private b() {
            this.a = new CountDownLatch(1);
        }

        /* synthetic */ b(byte b) {
            this();
        }

        public final void a() throws InterruptedException {
            this.a.await();
        }

        public final boolean a(long j, TimeUnit timeUnit) throws InterruptedException {
            return this.a.await(j, timeUnit);
        }

        public final void onFailure(Exception exc) {
            this.a.countDown();
        }

        public final void onSuccess(Object obj) {
            this.a.countDown();
        }
    }

    private Tasks() {
    }

    public static <ResultT> Task<ResultT> a(Exception exc) {
        k kVar = new k();
        kVar.a(exc);
        return kVar;
    }

    public static <ResultT> Task<ResultT> a(ResultT resultt) {
        k kVar = new k();
        kVar.a(resultt);
        return kVar;
    }

    private static <ResultT> ResultT a(Task<ResultT> task) throws ExecutionException {
        if (task.isSuccessful()) {
            return task.getResult();
        }
        throw new ExecutionException(task.getException());
    }

    private static void a(Task<?> task, a aVar) {
        task.addOnSuccessListener(TaskExecutors.a, aVar);
        task.addOnFailureListener(TaskExecutors.a, aVar);
    }

    public static <ResultT> ResultT await(Task<ResultT> task) throws ExecutionException, InterruptedException {
        az.a(task, (Object) "Task must not be null");
        if (task.isComplete()) {
            return a(task);
        }
        b bVar = new b(0);
        a(task, bVar);
        bVar.a();
        return a(task);
    }

    public static <ResultT> ResultT await(Task<ResultT> task, long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        az.a(task, (Object) "Task must not be null");
        az.a(timeUnit, (Object) "TimeUnit must not be null");
        if (task.isComplete()) {
            return a(task);
        }
        b bVar = new b(0);
        a(task, bVar);
        if (bVar.a(j, timeUnit)) {
            return a(task);
        }
        throw new TimeoutException("Timed out waiting for Task");
    }
}
