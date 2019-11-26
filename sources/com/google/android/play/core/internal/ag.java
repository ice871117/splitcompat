package com.google.android.play.core.internal;

import android.os.Build.VERSION;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import java.util.IllegalFormatException;
import java.util.Locale;

public class ag {
    private final String a;

    public ag(String str) {
        String valueOf = String.valueOf("UID: [" + Process.myUid() + "]  PID: [" + Process.myPid() + "] ");
        String valueOf2 = String.valueOf(str);
        this.a = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    private int a(int i, String str, Object[] objArr) {
        if (Log.isLoggable("PlayCore", i)) {
            return Log.i("PlayCore", a(this.a, str, objArr));
        }
        return 0;
    }

    public static ad a() {
        if (VERSION.SDK_INT >= 23 && VERSION.PREVIEW_SDK_INT != 0) {
            switch (VERSION.SDK_INT) {
                case 27:
                    return new av();
                case 28:
                    return new ay();
            }
        }
        if (VERSION.SDK_INT < 21) {
            throw new AssertionError("Unsupported Android Version");
        }
        switch (VERSION.SDK_INT) {
            case 21:
                return new af();
            case 22:
                return new am();
            case 23:
                return new al();
            case 24:
                return new ap();
            case 25:
                return new as();
            case 26:
                return new ar();
            case 27:
                return new aw();
            case 28:
                if (!VERSION.CODENAME.equalsIgnoreCase("Q")) {
                    return new av();
                }
                break;
        }
        return new ay();
    }

    private static String a(String str, String str2, Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            try {
                str2 = String.format(Locale.US, str2, objArr);
            } catch (IllegalFormatException e) {
                IllegalFormatException illegalFormatException = e;
                String str3 = "PlayCore";
                String str4 = "Unable to format ";
                String valueOf = String.valueOf(str2);
                Log.e(str3, valueOf.length() != 0 ? str4.concat(valueOf) : new String(str4), illegalFormatException);
                String join = TextUtils.join(", ", objArr);
                str2 = new StringBuilder(String.valueOf(str2).length() + 3 + String.valueOf(join).length()).append(str2).append(" [").append(join).append("]").toString();
            }
        }
        return new StringBuilder(String.valueOf(str).length() + 3 + String.valueOf(str2).length()).append(str).append(" : ").append(str2).toString();
    }

    public int a(String str, Object... objArr) {
        return a(4, str, objArr);
    }

    public int a(Throwable th, String str, Object... objArr) {
        if (Log.isLoggable("PlayCore", 6)) {
            return Log.e("PlayCore", a(this.a, str, objArr), th);
        }
        return 0;
    }

    public int b(String str, Object... objArr) {
        return a(3, str, objArr);
    }

    public int c(String str, Object... objArr) {
        return a(5, str, objArr);
    }

    public int d(String str, Object... objArr) {
        return a(6, str, objArr);
    }
}
