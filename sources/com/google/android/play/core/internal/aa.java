package com.google.android.play.core.internal;

public class aa extends RuntimeException {
    public aa() {
        super("Failed to bind to the service.");
    }

    public aa(String str) {
        super(str);
    }

    public aa(String str, Throwable th) {
        super(str, th);
    }
}
