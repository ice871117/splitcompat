package com.google.android.play.core.appupdate;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.appupdate.class_21;
import com.google.android.play.core.appupdate.class_69;
import com.google.android.play.core.install.InstallStateUpdatedListener;
import com.google.android.play.core.tasks.Task;

// $FF: renamed from: com.google.android.play.core.appupdate.b
final class class_71 implements AppUpdateManager {

   // $FF: renamed from: a com.google.android.play.core.appupdate.d
   private final class_69 field_122;
   // $FF: renamed from: b com.google.android.play.core.appupdate.a
   private final class_21 field_123;
   // $FF: renamed from: c android.content.Context
   private final Context field_124;


   // $FF: renamed from: <init> (com.google.android.play.core.appupdate.d, android.content.Context) void
   void method_188(class_69 var1, Context var2) {
      super();
      this.field_122 = var1;
      class_21 var10001 = new class_21;
      var10001.method_53(var2);
      this.field_123 = var10001;
      this.field_124 = var2;
   }

   public final synchronized void registerListener(InstallStateUpdatedListener var1) {
      this.field_123.method_48(var1);
   }

   public final synchronized void unregisterListener(InstallStateUpdatedListener var1) {
      this.field_123.method_49(var1);
   }

   public final Task getAppUpdateInfo() {
      return this.field_122.method_172(this.field_124.getPackageName());
   }

   public final boolean startUpdateFlowForResult(AppUpdateInfo var1, int var2, Activity var3, int var4) throws SendIntentException {
      if(!var1.isUpdateTypeAllowed(var2)) {
         return false;
      } else {
         var3.startIntentSenderForResult((var2 == 0?var1.method_192():(var2 == 1?var1.method_191():null)).getIntentSender(), var4, (Intent)null, 0, 0, 0);
         return true;
      }
   }

   public final Task completeUpdate() {
      return this.field_122.method_173(this.field_124.getPackageName());
   }
}
