package com.google.android.play.core.install;

import com.google.android.play.core.install.model.a;

public class InstallException extends RuntimeException {
    private final int a;

    public InstallException(int i) {
        super(String.format("Install Error(%d): %s", new Object[]{Integer.valueOf(i), a.a(i)}));
        this.a = i;
    }

    public int getErrorCode() {
        return this.a;
    }
}
