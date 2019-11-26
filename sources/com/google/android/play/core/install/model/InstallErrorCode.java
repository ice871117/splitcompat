package com.google.android.play.core.install.model;


public @interface InstallErrorCode {

   int NO_ERROR = 0;
   int NO_ERROR_PARTIALLY_ALLOWED = 1;
   int ERROR_UNKNOWN = -2;
   int ERROR_API_NOT_AVAILABLE = -3;
   int ERROR_INVALID_REQUEST = -4;
   int ERROR_INSTALL_UNAVAILABLE = -5;
   int ERROR_INSTALL_NOT_ALLOWED = -6;
   int ERROR_DOWNLOAD_NOT_PRESENT = -7;
   int ERROR_INTERNAL_ERROR = -100;

}
