package com.google.android.play.core.appupdate;

import android.app.PendingIntent;
import com.google.android.play.core.appupdate.class_72;

public abstract class AppUpdateInfo {

   // $FF: renamed from: <init> () void
   public void method_189() {
      super();
   }

   // $FF: renamed from: a (java.lang.String, int, int, int, android.app.PendingIntent, android.app.PendingIntent) com.google.android.play.core.appupdate.AppUpdateInfo
   public static AppUpdateInfo method_190(String var0, int var1, int var2, int var3, PendingIntent var4, PendingIntent var5) {
      class_72 var10000 = new class_72;
      var10000.method_193(var0, var1, var2, var3, var4, var5);
      return var10000;
   }

   public abstract String packageName();

   public abstract int availableVersionCode();

   public abstract int updateAvailability();

   public abstract int installStatus();

   // $FF: renamed from: a () android.app.PendingIntent
   abstract PendingIntent method_191();

   // $FF: renamed from: b () android.app.PendingIntent
   abstract PendingIntent method_192();

   public boolean isUpdateTypeAllowed(int var1) {
      return var1 == 0?this.method_192() != null:(var1 == 1?this.method_191() != null:false);
   }
}
