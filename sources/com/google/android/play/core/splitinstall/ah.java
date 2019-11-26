package com.google.android.play.core.splitinstall;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.internal.bg;
import com.google.android.play.core.tasks.i;
import java.util.List;

class ah<T> extends bg {
    final i<T> a;
    private final /* synthetic */ q b;

    ah(q qVar, i<T> iVar) {
        this.b = qVar;
        this.a = iVar;
    }

    public final void a() throws RemoteException {
        this.b.a.a();
        q.b.a("onCompleteInstallForAppUpdate", new Object[0]);
    }

    public final void a(int i) throws RemoteException {
        this.b.a.a();
        q.b.a("onCompleteInstall(%d)", Integer.valueOf(i));
    }

    public void a(int i, Bundle bundle) throws RemoteException {
        this.b.a.a();
        q.b.a("onCancelInstall(%d)", Integer.valueOf(i));
    }

    public void a(Bundle bundle) throws RemoteException {
        this.b.a.a();
        q.b.a("onDeferredInstall", new Object[0]);
    }

    public void a(List<Bundle> list) throws RemoteException {
        this.b.a.a();
        q.b.a("onGetSessionStates", new Object[0]);
    }

    public final void b() throws RemoteException {
        this.b.a.a();
        q.b.a("onGetSplitsForAppUpdate", new Object[0]);
    }

    public void b(int i, Bundle bundle) throws RemoteException {
        this.b.a.a();
        q.b.a("onGetSession(%d)", Integer.valueOf(i));
    }

    public void b(Bundle bundle) throws RemoteException {
        this.b.a.a();
        q.b.a("onDeferredLanguageUninstall", new Object[0]);
    }

    public void c(int i, Bundle bundle) throws RemoteException {
        this.b.a.a();
        q.b.a("onStartInstall(%d)", Integer.valueOf(i));
    }

    public void c(Bundle bundle) throws RemoteException {
        this.b.a.a();
        q.b.a("onDeferredLanguageInstall", new Object[0]);
    }

    public void d(Bundle bundle) throws RemoteException {
        this.b.a.a();
        q.b.a("onDeferredUninstall", new Object[0]);
    }

    public final void e(Bundle bundle) throws RemoteException {
        this.b.a.a();
        int i = bundle.getInt("error_code");
        q.b.d("onError(%d)", Integer.valueOf(i));
        this.a.a((Exception) new SplitInstallException(i));
    }
}
