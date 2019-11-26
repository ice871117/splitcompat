package com.google.android.play.core.tasks;

import java.util.concurrent.Executor;

final class j implements Executor {
    j() {
    }

    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
