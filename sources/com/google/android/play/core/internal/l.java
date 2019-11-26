package com.google.android.play.core.internal;

import android.os.IBinder;
import android.os.IInterface;

public abstract class l extends j implements m {
    public static m a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.play.core.appupdate.protocol.IAppUpdateService");
        return queryLocalInterface instanceof m ? (m) queryLocalInterface : new o(iBinder);
    }
}
