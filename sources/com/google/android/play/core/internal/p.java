package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class p extends j implements n {
    public p() {
        super("com.google.android.play.core.appupdate.protocol.IAppUpdateServiceCallback");
    }

    /* access modifiers changed from: protected */
    public final boolean a(int i, Parcel parcel) throws RemoteException {
        switch (i) {
            case 2:
                b((Bundle) i.a(parcel, Bundle.CREATOR));
                break;
            case 3:
                a((Bundle) i.a(parcel, Bundle.CREATOR));
                break;
            default:
                return false;
        }
        return true;
    }
}
