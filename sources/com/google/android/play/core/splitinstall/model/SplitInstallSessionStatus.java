package com.google.android.play.core.splitinstall.model;


public @interface SplitInstallSessionStatus {

   int UNKNOWN = 0;
   int PENDING = 1;
   int REQUIRES_USER_CONFIRMATION = 8;
   int DOWNLOADING = 2;
   int DOWNLOADED = 3;
   int INSTALLING = 4;
   int INSTALLED = 5;
   int FAILED = 6;
   int CANCELING = 9;
   int CANCELED = 7;

}
