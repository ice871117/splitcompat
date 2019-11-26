package com.google.android.play.core.splitcompat;

import android.content.Context;

final class m implements Runnable {
    private final /* synthetic */ Context a;

    m(Context context) {
        this.a = context;
    }

    public final void run() {
        com.google.android.play.core.splitinstall.m.a(this.a).a(true);
    }
}
