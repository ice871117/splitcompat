package com.google.android.play.core.install.model;


public @interface UpdateAvailability {

   int UNKNOWN = 0;
   int UPDATE_NOT_AVAILABLE = 1;
   int UPDATE_AVAILABLE = 2;
   int DEVELOPER_TRIGGERED_UPDATE_IN_PROGRESS = 3;

}
