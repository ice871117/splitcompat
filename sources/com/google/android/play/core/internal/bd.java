package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import java.util.List;

public interface bd extends IInterface {
    void a(String str, int i, Bundle bundle, be beVar) throws RemoteException;

    void a(String str, int i, be beVar) throws RemoteException;

    void a(String str, be beVar) throws RemoteException;

    void a(String str, List<Bundle> list, Bundle bundle, be beVar) throws RemoteException;

    void b(String str, List<Bundle> list, Bundle bundle, be beVar) throws RemoteException;

    void c(String str, List<Bundle> list, Bundle bundle, be beVar) throws RemoteException;

    void d(String str, List<Bundle> list, Bundle bundle, be beVar) throws RemoteException;

    void e(String str, List<Bundle> list, Bundle bundle, be beVar) throws RemoteException;
}
