package com.google.android.play.core.install;

public abstract class InstallState {
    public static InstallState a(int i, int i2, String str) {
        return new a(i, i2, str);
    }

    public abstract int installErrorCode();

    public abstract int installStatus();

    public abstract String packageName();
}
