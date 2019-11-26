package com.google.android.play.core.appupdate;

import android.content.Context;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.appupdate.class_69;
import com.google.android.play.core.appupdate.class_71;

public class AppUpdateManagerFactory {

   // $FF: renamed from: <init> () void
   public void method_163() {
      super();
   }

   public static AppUpdateManager create(Context var0) {
      class_71 var10000 = new class_71;
      class_69 var10002 = new class_69;
      var10002.method_171(var0);
      var10000.method_188(var10002, var0);
      return var10000;
   }
}
