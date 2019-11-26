package com.google.android.play.core.install.model;

import java.util.HashMap;
import java.util.Map;

public final class a {
    private static final Map<Integer, String> a = new HashMap();
    private static final Map<Integer, String> b = new HashMap();

    static {
        a.put(Integer.valueOf(1), "No error occurred; only some types of update flow are allowed, while others are forbidden.");
        a.put(Integer.valueOf(-2), "An unknown error occurred.");
        a.put(Integer.valueOf(-3), "The API is not available on this device.");
        a.put(Integer.valueOf(-4), "The request that was sent by the app is malformed.");
        a.put(Integer.valueOf(-5), "The install is unavailable to this user or device.");
        a.put(Integer.valueOf(-6), "The download/install is not allowed, due to the current device state (e.g. low battery, low disk space, ...).");
        a.put(Integer.valueOf(-7), "The install/update has not been (fully) downloaded yet.");
        a.put(Integer.valueOf(-8), "The install is already in progress and there is no UI flow to resume.");
        a.put(Integer.valueOf(-100), "An internal error happened in the Play Store.");
        b.put(Integer.valueOf(1), "NO_ERROR_PARTIALLY_ALLOWED");
        b.put(Integer.valueOf(-2), "ERROR_UNKNOWN");
        b.put(Integer.valueOf(-3), "ERROR_API_NOT_AVAILABLE");
        b.put(Integer.valueOf(-4), "ERROR_INVALID_REQUEST");
        b.put(Integer.valueOf(-5), "ERROR_INSTALL_UNAVAILABLE");
        b.put(Integer.valueOf(-6), "ERROR_INSTALL_NOT_ALLOWED");
        b.put(Integer.valueOf(-7), "ERROR_DOWNLOAD_NOT_PRESENT");
        b.put(Integer.valueOf(-8), "ERROR_INSTALL_IN_PROGRESS");
        b.put(Integer.valueOf(-100), "ERROR_INTERNAL_ERROR");
    }

    public static String a(int i) {
        if (!a.containsKey(Integer.valueOf(i)) || !b.containsKey(Integer.valueOf(i))) {
            return "";
        }
        String str = (String) a.get(Integer.valueOf(i));
        String str2 = (String) b.get(Integer.valueOf(i));
        return new StringBuilder(String.valueOf(str).length() + 103 + String.valueOf(str2).length()).append(str).append(" (https://developer.android.com/reference/com/google/android/play/core/install/model/InstallErrorCode").append("#").append(str2).append(")").toString();
    }
}
