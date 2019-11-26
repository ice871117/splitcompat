package com.google.android.play.core.splitinstall;

final class l implements Runnable {
    private final /* synthetic */ SplitInstallSessionState a;
    private final /* synthetic */ int b;
    private final /* synthetic */ int c;
    private final /* synthetic */ m d;

    l(m mVar, SplitInstallSessionState splitInstallSessionState, int i, int i2) {
        this.d = mVar;
        this.a = splitInstallSessionState;
        this.b = i;
        this.c = i2;
    }

    public final void run() {
        m mVar = this.d;
        SplitInstallSessionState splitInstallSessionState = this.a;
        mVar.a(new a(splitInstallSessionState.sessionId(), this.b, this.c, splitInstallSessionState.bytesDownloaded(), splitInstallSessionState.totalBytesToDownload(), splitInstallSessionState.a(), splitInstallSessionState.b(), splitInstallSessionState.resolutionIntent(), splitInstallSessionState.c()));
    }
}
