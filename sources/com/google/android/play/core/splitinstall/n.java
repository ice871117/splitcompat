package com.google.android.play.core.splitinstall;

import com.google.android.play.core.internal.az;

final class n implements Runnable {
    private final /* synthetic */ SplitInstallRequest a;
    private final /* synthetic */ o b;

    n(o oVar, SplitInstallRequest splitInstallRequest) {
        this.b = oVar;
        this.a = splitInstallRequest;
    }

    public final void run() {
        this.b.b.a(SplitInstallSessionState.a(az.a(this.a.getModuleNames(), o.b(this.a.getLanguages()))));
    }
}
