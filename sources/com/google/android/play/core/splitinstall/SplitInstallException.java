package com.google.android.play.core.splitinstall;

import com.google.android.play.core.splitinstall.model.a;

public class SplitInstallException extends RuntimeException {
    private final int a;

    public SplitInstallException(int i) {
        super(String.format("Split Install Error(%d): %s", new Object[]{Integer.valueOf(i), a.a(i)}));
        this.a = i;
    }

    public int getErrorCode() {
        return this.a;
    }
}
