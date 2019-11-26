package com.google.android.play.core.internal;

import android.os.IBinder;
import android.os.IInterface;

public abstract class bc extends j implements bd {
    public static bd a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.play.core.splitinstall.protocol.ISplitInstallService");
        return queryLocalInterface instanceof bd ? (bd) queryLocalInterface : new bf(iBinder);
    }
}
