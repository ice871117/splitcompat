package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public final class o extends g implements m {
    o(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.appupdate.protocol.IAppUpdateService");
    }

    public final void a(String str, Bundle bundle, n nVar) throws RemoteException {
        Parcel a = a();
        a.writeString(str);
        i.a(a, (Parcelable) bundle);
        i.a(a, (IInterface) nVar);
        a(2, a);
    }

    public final void b(String str, Bundle bundle, n nVar) throws RemoteException {
        Parcel a = a();
        a.writeString(str);
        i.a(a, (Parcelable) bundle);
        i.a(a, (IInterface) nVar);
        a(3, a);
    }
}
