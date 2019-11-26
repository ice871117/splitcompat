package com.google.android.play.core.install.model;

public @interface InstallErrorCode {
    public static final int ERROR_API_NOT_AVAILABLE = -3;
    public static final int ERROR_DOWNLOAD_NOT_PRESENT = -7;
    public static final int ERROR_INSTALL_NOT_ALLOWED = -6;
    public static final int ERROR_INSTALL_UNAVAILABLE = -5;
    public static final int ERROR_INTERNAL_ERROR = -100;
    public static final int ERROR_INVALID_REQUEST = -4;
    public static final int ERROR_UNKNOWN = -2;
    public static final int NO_ERROR = 0;
    public static final int NO_ERROR_PARTIALLY_ALLOWED = 1;
}
