package com.google.android.play.core.install.model;


public @interface InstallStatus {

   int UNKNOWN = 0;
   int REQUIRES_UI_INTENT = 10;
   int PENDING = 1;
   int DOWNLOADING = 2;
   int DOWNLOADED = 11;
   int INSTALLING = 3;
   int INSTALLED = 4;
   int FAILED = 5;
   int CANCELED = 6;

}
