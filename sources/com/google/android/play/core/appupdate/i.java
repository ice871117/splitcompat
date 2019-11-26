package com.google.android.play.core.appupdate;

import android.app.PendingIntent;

final class i extends AppUpdateInfo {
    private final String a;
    private final int b;
    private final int c;
    private final int d;
    private final PendingIntent e;
    private final PendingIntent f;

    i(String str, int i, int i2, int i3, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
        if (str == null) {
            throw new NullPointerException("Null packageName");
        }
        this.a = str;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = pendingIntent;
        this.f = pendingIntent2;
    }

    /* access modifiers changed from: 0000 */
    public final PendingIntent a() {
        return this.e;
    }

    public final int availableVersionCode() {
        return this.b;
    }

    /* access modifiers changed from: 0000 */
    public final PendingIntent b() {
        return this.f;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AppUpdateInfo)) {
            return false;
        }
        AppUpdateInfo appUpdateInfo = (AppUpdateInfo) obj;
        if (this.a.equals(appUpdateInfo.packageName()) && this.b == appUpdateInfo.availableVersionCode() && this.c == appUpdateInfo.updateAvailability() && this.d == appUpdateInfo.installStatus() && (this.e != null ? this.e.equals(appUpdateInfo.a()) : appUpdateInfo.a() == null)) {
            if (this.f == null) {
                if (appUpdateInfo.b() == null) {
                    return true;
                }
            } else if (this.f.equals(appUpdateInfo.b())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((this.e == null ? 0 : this.e.hashCode()) ^ ((((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b) * 1000003) ^ this.c) * 1000003) ^ this.d) * 1000003)) * 1000003;
        if (this.f != null) {
            i = this.f.hashCode();
        }
        return hashCode ^ i;
    }

    public final int installStatus() {
        return this.d;
    }

    public final String packageName() {
        return this.a;
    }

    public final String toString() {
        String str = this.a;
        int i = this.b;
        int i2 = this.c;
        int i3 = this.d;
        String valueOf = String.valueOf(this.e);
        String valueOf2 = String.valueOf(this.f);
        return new StringBuilder(String.valueOf(str).length() + 167 + String.valueOf(valueOf).length() + String.valueOf(valueOf2).length()).append("AppUpdateInfo{packageName=").append(str).append(", availableVersionCode=").append(i).append(", updateAvailability=").append(i2).append(", installStatus=").append(i3).append(", immediateUpdateIntent=").append(valueOf).append(", flexibleUpdateIntent=").append(valueOf2).append("}").toString();
    }

    public final int updateAvailability() {
        return this.c;
    }
}
