package com.google.android.play.core.splitinstall.model;


public @interface SplitInstallErrorCode {

   int NO_ERROR = 0;
   int ACTIVE_SESSIONS_LIMIT_EXCEEDED = -1;
   int MODULE_UNAVAILABLE = -2;
   int INVALID_REQUEST = -3;
   int SESSION_NOT_FOUND = -4;
   int API_NOT_AVAILABLE = -5;
   int NETWORK_ERROR = -6;
   int ACCESS_DENIED = -7;
   int INCOMPATIBLE_WITH_EXISTING_SESSION = -8;
   int SERVICE_DIED = -9;
   int INSUFFICIENT_STORAGE = -10;
   int SPLITCOMPAT_VERIFICATION_ERROR = -11;
   int SPLITCOMPAT_EMULATION_ERROR = -12;
   int SPLITCOMPAT_COPY_ERROR = -13;
   int INTERNAL_ERROR = -100;

}
