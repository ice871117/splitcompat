package com.google.android.play.core.internal;

import android.os.IBinder.DeathRecipient;

final /* synthetic */ class t implements DeathRecipient {
    private final q a;

    t(q qVar) {
        this.a = qVar;
    }

    public final void binderDied() {
        this.a.c();
    }
}
