package com.google.android.play.core.internal;

import android.util.Log;
import com.google.android.play.core.splitinstall.b;
import java.util.List;

final class ab implements Runnable {
    private final /* synthetic */ List a;
    private final /* synthetic */ b b;
    private final /* synthetic */ ac c;

    ab(ac acVar, List list, b bVar) {
        this.c = acVar;
        this.a = list;
        this.b = bVar;
    }

    public final void run() {
        try {
            if (this.c.c.a(this.a)) {
                this.c.a(this.b);
            } else {
                this.c.b(this.a, this.b);
            }
        } catch (Exception e) {
            Log.e("SplitCompat", "Error checking verified files.", e);
            this.b.a(-11);
        }
    }
}
