package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import java.util.List;

public final class bf extends g implements bd {
    bf(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.splitinstall.protocol.ISplitInstallService");
    }

    public final void a(String str, int i, Bundle bundle, be beVar) throws RemoteException {
        Parcel a = a();
        a.writeString(str);
        a.writeInt(i);
        i.a(a, (Parcelable) bundle);
        i.a(a, (IInterface) beVar);
        a(4, a);
    }

    public final void a(String str, int i, be beVar) throws RemoteException {
        Parcel a = a();
        a.writeString(str);
        a.writeInt(i);
        i.a(a, (IInterface) beVar);
        a(5, a);
    }

    public final void a(String str, be beVar) throws RemoteException {
        Parcel a = a();
        a.writeString(str);
        i.a(a, (IInterface) beVar);
        a(6, a);
    }

    public final void a(String str, List<Bundle> list, Bundle bundle, be beVar) throws RemoteException {
        Parcel a = a();
        a.writeString(str);
        a.writeTypedList(list);
        i.a(a, (Parcelable) bundle);
        i.a(a, (IInterface) beVar);
        a(2, a);
    }

    public final void b(String str, List<Bundle> list, Bundle bundle, be beVar) throws RemoteException {
        Parcel a = a();
        a.writeString(str);
        a.writeTypedList(list);
        i.a(a, (Parcelable) bundle);
        i.a(a, (IInterface) beVar);
        a(7, a);
    }

    public final void c(String str, List<Bundle> list, Bundle bundle, be beVar) throws RemoteException {
        Parcel a = a();
        a.writeString(str);
        a.writeTypedList(list);
        i.a(a, (Parcelable) bundle);
        i.a(a, (IInterface) beVar);
        a(8, a);
    }

    public final void d(String str, List<Bundle> list, Bundle bundle, be beVar) throws RemoteException {
        Parcel a = a();
        a.writeString(str);
        a.writeTypedList(list);
        i.a(a, (Parcelable) bundle);
        i.a(a, (IInterface) beVar);
        a(13, a);
    }

    public final void e(String str, List<Bundle> list, Bundle bundle, be beVar) throws RemoteException {
        Parcel a = a();
        a.writeString(str);
        a.writeTypedList(list);
        i.a(a, (Parcelable) bundle);
        i.a(a, (IInterface) beVar);
        a(14, a);
    }
}
