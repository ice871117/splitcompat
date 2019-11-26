package com.google.android.play.core.splitinstall;

import android.app.PendingIntent;
import android.content.Intent;
import java.util.List;

final class a extends SplitInstallSessionState {
    private final int a;
    private final int b;
    private final int c;
    private final long d;
    private final long e;
    private final List<String> f;
    private final List<String> g;
    private final PendingIntent h;
    private final List<Intent> i;

    a(int i2, int i3, int i4, long j, long j2, List<String> list, List<String> list2, PendingIntent pendingIntent, List<Intent> list3) {
        this.a = i2;
        this.b = i3;
        this.c = i4;
        this.d = j;
        this.e = j2;
        this.f = list;
        this.g = list2;
        this.h = pendingIntent;
        this.i = list3;
    }

    /* access modifiers changed from: 0000 */
    public final List<String> a() {
        return this.f;
    }

    /* access modifiers changed from: 0000 */
    public final List<String> b() {
        return this.g;
    }

    public final long bytesDownloaded() {
        return this.d;
    }

    /* access modifiers changed from: 0000 */
    public final List<Intent> c() {
        return this.i;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SplitInstallSessionState)) {
            return false;
        }
        SplitInstallSessionState splitInstallSessionState = (SplitInstallSessionState) obj;
        if (this.a == splitInstallSessionState.sessionId() && this.b == splitInstallSessionState.status() && this.c == splitInstallSessionState.errorCode() && this.d == splitInstallSessionState.bytesDownloaded() && this.e == splitInstallSessionState.totalBytesToDownload() && (this.f != null ? this.f.equals(splitInstallSessionState.a()) : splitInstallSessionState.a() == null) && (this.g != null ? this.g.equals(splitInstallSessionState.b()) : splitInstallSessionState.b() == null) && (this.h != null ? this.h.equals(splitInstallSessionState.resolutionIntent()) : splitInstallSessionState.resolutionIntent() == null)) {
            if (this.i == null) {
                if (splitInstallSessionState.c() == null) {
                    return true;
                }
            } else if (this.i.equals(splitInstallSessionState.c())) {
                return true;
            }
        }
        return false;
    }

    public final int errorCode() {
        return this.c;
    }

    public final int hashCode() {
        int i2 = 0;
        int hashCode = ((this.h == null ? 0 : this.h.hashCode()) ^ (((this.g == null ? 0 : this.g.hashCode()) ^ (((this.f == null ? 0 : this.f.hashCode()) ^ ((((((((((this.a ^ 1000003) * 1000003) ^ this.b) * 1000003) ^ this.c) * 1000003) ^ ((int) ((this.d >>> 32) ^ this.d))) * 1000003) ^ ((int) ((this.e >>> 32) ^ this.e))) * 1000003)) * 1000003)) * 1000003)) * 1000003;
        if (this.i != null) {
            i2 = this.i.hashCode();
        }
        return hashCode ^ i2;
    }

    public final PendingIntent resolutionIntent() {
        return this.h;
    }

    public final int sessionId() {
        return this.a;
    }

    public final int status() {
        return this.b;
    }

    public final String toString() {
        int i2 = this.a;
        int i3 = this.b;
        int i4 = this.c;
        long j = this.d;
        long j2 = this.e;
        String valueOf = String.valueOf(this.f);
        String valueOf2 = String.valueOf(this.g);
        String valueOf3 = String.valueOf(this.h);
        String valueOf4 = String.valueOf(this.i);
        return new StringBuilder(String.valueOf(valueOf).length() + 251 + String.valueOf(valueOf2).length() + String.valueOf(valueOf3).length() + String.valueOf(valueOf4).length()).append("SplitInstallSessionState{sessionId=").append(i2).append(", status=").append(i3).append(", errorCode=").append(i4).append(", bytesDownloaded=").append(j).append(", totalBytesToDownload=").append(j2).append(", moduleNamesNullable=").append(valueOf).append(", languagesNullable=").append(valueOf2).append(", resolutionIntent=").append(valueOf3).append(", splitFileIntents=").append(valueOf4).append("}").toString();
    }

    public final long totalBytesToDownload() {
        return this.e;
    }
}
