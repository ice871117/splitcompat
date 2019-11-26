package com.google.android.play.core.splitinstall.model;

import java.util.HashMap;
import java.util.Map;

public final class a {
    private static final Map<Integer, String> a = new HashMap();
    private static final Map<Integer, String> b = new HashMap();

    static {
        a.put(Integer.valueOf(-1), "Too many sessions are running for current app, existing sessions must be resolved first.");
        a.put(Integer.valueOf(-2), "A requested module is not available (to this user/device, for the installed apk).");
        a.put(Integer.valueOf(-3), "Request is otherwise invalid.");
        a.put(Integer.valueOf(-4), "Requested session is not found.");
        a.put(Integer.valueOf(-5), "Split Install API is not available.");
        a.put(Integer.valueOf(-6), "Network error: unable to obtain split details.");
        a.put(Integer.valueOf(-7), "Download not permitted under current device circumstances (e.g. in background).");
        a.put(Integer.valueOf(-8), "Requested session contains modules from an existing active session and also new");
        a.put(Integer.valueOf(-9), "Service handling split install has died.");
        a.put(Integer.valueOf(-10), "Install failed due to insufficient storage.");
        a.put(Integer.valueOf(-11), "Signature verification error when invoking SplitCompat.");
        a.put(Integer.valueOf(-12), "Error in SplitCompat emulation.");
        a.put(Integer.valueOf(-13), "Error in copying files for SplitCompat.");
        a.put(Integer.valueOf(-100), "Unknown error processing split install.");
        b.put(Integer.valueOf(-1), "ACTIVE_SESSIONS_LIMIT_EXCEEDED");
        b.put(Integer.valueOf(-2), "MODULE_UNAVAILABLE");
        b.put(Integer.valueOf(-3), "INVALID_REQUEST");
        b.put(Integer.valueOf(-4), "SESSION_NOT_FOUND");
        b.put(Integer.valueOf(-5), "API_NOT_AVAILABLE");
        b.put(Integer.valueOf(-6), "NETWORK_ERROR");
        b.put(Integer.valueOf(-7), "ACCESS_DENIED");
        b.put(Integer.valueOf(-8), "INCOMPATIBLE_WITH_EXISTING_SESSION");
        b.put(Integer.valueOf(-9), "SERVICE_DIED");
        b.put(Integer.valueOf(-10), "INSUFFICIENT_STORAGE");
        b.put(Integer.valueOf(-11), "SPLITCOMPAT_VERIFICATION_ERROR");
        b.put(Integer.valueOf(-12), "SPLITCOMPAT_EMULATION_ERROR");
        b.put(Integer.valueOf(-13), "SPLITCOMPAT_COPY_ERROR");
    }

    public static String a(int i) {
        if (!a.containsKey(Integer.valueOf(i)) || !b.containsKey(Integer.valueOf(i))) {
            return "";
        }
        String str = (String) a.get(Integer.valueOf(i));
        String str2 = (String) b.get(Integer.valueOf(i));
        return new StringBuilder(String.valueOf(str).length() + 118 + String.valueOf(str2).length()).append(str).append(" (https://developer.android.com/reference/com/google/android/play/core/splitinstall/model/SplitInstallErrorCode.html").append("#").append(str2).append(")").toString();
    }
}
