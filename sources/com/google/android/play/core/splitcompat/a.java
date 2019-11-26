package com.google.android.play.core.splitcompat;

import java.io.File;

final class a extends q {
    private final File a;
    private final String b;

    a(File file, String str) {
        if (file == null) {
            throw new NullPointerException("Null splitFile");
        }
        this.a = file;
        if (str == null) {
            throw new NullPointerException("Null splitId");
        }
        this.b = str;
    }

    /* access modifiers changed from: 0000 */
    public final File a() {
        return this.a;
    }

    /* access modifiers changed from: 0000 */
    public final String b() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return this.a.equals(qVar.a()) && this.b.equals(qVar.b());
    }

    public final int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode();
    }

    public final String toString() {
        String valueOf = String.valueOf(this.a);
        String str = this.b;
        return new StringBuilder(String.valueOf(valueOf).length() + 35 + String.valueOf(str).length()).append("SplitFileInfo{splitFile=").append(valueOf).append(", splitId=").append(str).append("}").toString();
    }
}
