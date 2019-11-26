package com.google.android.play.core.splitcompat;

import android.util.Log;

final class p implements Runnable {
    private final /* synthetic */ SplitCompat a;

    p(SplitCompat splitCompat) {
        this.a = splitCompat;
    }

    public final void run() {
        try {
            this.a.b.a();
        } catch (Exception e) {
            Log.e("SplitCompat", "Failed to cleanup splitcompat storage", e);
        }
    }
}
