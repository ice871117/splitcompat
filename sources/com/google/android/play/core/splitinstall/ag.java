package com.google.android.play.core.splitinstall;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.tasks.i;
import java.util.ArrayList;
import java.util.List;

final class ag extends ah<List<SplitInstallSessionState>> {
    ag(q qVar, i<List<SplitInstallSessionState>> iVar) {
        super(qVar, iVar);
    }

    public final void a(List<Bundle> list) throws RemoteException {
        super.a(list);
        ArrayList arrayList = new ArrayList(list.size());
        for (Bundle a : list) {
            arrayList.add(SplitInstallSessionState.a(a));
        }
        this.a.a(arrayList);
    }
}
