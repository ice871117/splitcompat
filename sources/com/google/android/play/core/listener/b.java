package com.google.android.play.core.listener;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class b extends BroadcastReceiver {
    private final /* synthetic */ a a;

    private b(a aVar) {
        this.a = aVar;
    }

    /* synthetic */ b(a aVar, byte b) {
        this(aVar);
    }

    public final void onReceive(Context context, Intent intent) {
        this.a.a(context, intent);
    }
}
