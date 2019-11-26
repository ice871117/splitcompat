package com.google.android.play.core.install;

final class a extends InstallState {
    private final int a;
    private final int b;
    private final String c;

    a(int i, int i2, String str) {
        this.a = i;
        this.b = i2;
        if (str == null) {
            throw new NullPointerException("Null packageName");
        }
        this.c = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InstallState)) {
            return false;
        }
        InstallState installState = (InstallState) obj;
        return this.a == installState.installStatus() && this.b == installState.installErrorCode() && this.c.equals(installState.packageName());
    }

    public final int hashCode() {
        return ((((this.a ^ 1000003) * 1000003) ^ this.b) * 1000003) ^ this.c.hashCode();
    }

    public final int installErrorCode() {
        return this.b;
    }

    public final int installStatus() {
        return this.a;
    }

    public final String packageName() {
        return this.c;
    }

    public final String toString() {
        int i = this.a;
        int i2 = this.b;
        String str = this.c;
        return new StringBuilder(String.valueOf(str).length() + 83).append("InstallState{installStatus=").append(i).append(", installErrorCode=").append(i2).append(", packageName=").append(str).append("}").toString();
    }
}
