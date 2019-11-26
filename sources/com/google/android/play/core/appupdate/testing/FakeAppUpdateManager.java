package com.google.android.play.core.appupdate.testing;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.appupdate.class_21;
import com.google.android.play.core.install.InstallException;
import com.google.android.play.core.install.InstallState;
import com.google.android.play.core.install.InstallStateUpdatedListener;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.Tasks;

public class FakeAppUpdateManager implements AppUpdateManager {

   // $FF: renamed from: a com.google.android.play.core.appupdate.a
   private final class_21 field_105;
   // $FF: renamed from: b android.content.Context
   private final Context field_106;
   // $FF: renamed from: c int
   private int field_107;
   // $FF: renamed from: d int
   private int field_108;
   // $FF: renamed from: e boolean
   private boolean field_109;
   // $FF: renamed from: f int
   private int field_110;
   // $FF: renamed from: g boolean
   private boolean field_111;
   // $FF: renamed from: h boolean
   private boolean field_112;
   // $FF: renamed from: i boolean
   private boolean field_113;
   // $FF: renamed from: j java.lang.Integer
   private Integer field_114;
   // $FF: renamed from: k java.lang.Integer
   private Integer field_115;


   // $FF: renamed from: <init> (android.content.Context) void
   public void method_168(Context var1) {
      super();
      this.field_107 = 0;
      this.field_108 = 0;
      this.field_109 = false;
      this.field_110 = 0;
      this.field_111 = false;
      this.field_112 = false;
      this.field_113 = false;
      class_21 var10001 = new class_21;
      var10001.method_53(var1);
      this.field_105 = var10001;
      this.field_106 = var1;
   }

   public void registerListener(InstallStateUpdatedListener var1) {
      this.field_105.method_48(var1);
   }

   public void unregisterListener(InstallStateUpdatedListener var1) {
      this.field_105.method_49(var1);
   }

   public Task getAppUpdateInfo() {
      if(this.field_108 != 0 && this.field_108 != 1) {
         InstallException var10000 = new InstallException;
         var10000.method_310(this.field_108);
         return Tasks.method_312(var10000);
      } else {
         PendingIntent var1 = null;
         PendingIntent var2 = null;
         if(this.method_169() == 2 && (this.field_108 == 0 || this.field_108 == 1 && Integer.valueOf(0).equals(this.field_114))) {
            var1 = PendingIntent.getBroadcast(this.field_106, 0, new Intent(), 0);
         }

         if(this.method_169() == 2 && (this.field_108 == 0 || this.field_108 == 1 && Integer.valueOf(1).equals(this.field_114))) {
            var2 = PendingIntent.getBroadcast(this.field_106, 0, new Intent(), 0);
         }

         return Tasks.method_311(AppUpdateInfo.method_190(this.field_106.getPackageName(), this.field_110, this.method_169(), this.field_107, var2, var1));
      }
   }

   public boolean startUpdateFlowForResult(AppUpdateInfo var1, int var2, Activity var3, int var4) {
      if(!var1.isUpdateTypeAllowed(var2)) {
         return false;
      } else {
         if(var2 == 1) {
            this.field_112 = true;
            this.field_115 = Integer.valueOf(1);
         } else {
            this.field_111 = true;
            this.field_115 = Integer.valueOf(0);
         }

         return true;
      }
   }

   public Task completeUpdate() {
      InstallException var10000;
      if(this.field_108 != 0 && this.field_108 != 1) {
         var10000 = new InstallException;
         var10000.method_310(this.field_108);
         return Tasks.method_312(var10000);
      } else if(this.field_107 == 11) {
         this.field_107 = 3;
         this.field_113 = true;
         if(Integer.valueOf(0).equals(this.field_115)) {
            this.method_170();
         }

         return Tasks.method_311((Object)null);
      } else if(this.field_107 == 3) {
         var10000 = new InstallException;
         var10000.method_310(-8);
         return Tasks.method_312(var10000);
      } else {
         var10000 = new InstallException;
         var10000.method_310(-7);
         return Tasks.method_312(var10000);
      }
   }

   public void setUpdateAvailable(int var1) {
      this.field_109 = true;
      this.field_110 = var1;
   }

   public void setUpdateNotAvailable() {
      this.field_109 = false;
   }

   public void userAcceptsUpdate() {
      if(this.field_111 || this.field_112) {
         this.field_111 = false;
         this.field_107 = 1;
         if(Integer.valueOf(0).equals(this.field_115)) {
            this.method_170();
         }
      }

   }

   public void userRejectsUpdate() {
      if(this.field_111 || this.field_112) {
         this.field_111 = false;
         this.field_112 = false;
         this.field_115 = null;
         this.field_107 = 0;
      }

   }

   public void downloadStarts() {
      if(this.field_107 == 1) {
         this.field_107 = 2;
         if(Integer.valueOf(0).equals(this.field_115)) {
            this.method_170();
         }
      }

   }

   public void downloadCompletes() {
      if(this.field_107 == 2 || this.field_107 == 1) {
         this.field_107 = 11;
         if(Integer.valueOf(0).equals(this.field_115)) {
            this.method_170();
            return;
         }

         if(Integer.valueOf(1).equals(this.field_115)) {
            this.completeUpdate();
         }
      }

   }

   public void installCompletes() {
      if(this.field_107 == 3) {
         this.field_107 = 4;
         this.field_109 = false;
         this.field_110 = 0;
         this.field_112 = false;
         this.field_113 = false;
         if(Integer.valueOf(0).equals(this.field_115)) {
            this.method_170();
         }

         this.field_115 = null;
         this.field_107 = 0;
      }

   }

   public void setInstallErrorCode(int var1) {
      this.field_108 = var1;
   }

   public void setPartiallyAllowedUpdateType(Integer var1) {
      this.field_114 = var1;
      this.field_108 = 1;
   }

   public void userCancelsDownload() {
      if(this.field_107 == 1 || this.field_107 == 2) {
         this.field_107 = 6;
         if(Integer.valueOf(0).equals(this.field_115)) {
            this.method_170();
         }

         this.field_115 = null;
         this.field_112 = false;
         this.field_107 = 0;
      }

   }

   public void downloadFails() {
      if(this.field_107 == 1 || this.field_107 == 2) {
         this.field_107 = 5;
         if(Integer.valueOf(0).equals(this.field_115)) {
            this.method_170();
         }

         this.field_115 = null;
         this.field_112 = false;
         this.field_107 = 0;
      }

   }

   public void installFails() {
      if(this.field_107 == 3) {
         this.field_107 = 5;
         if(Integer.valueOf(0).equals(this.field_115)) {
            this.method_170();
         }

         this.field_115 = null;
         this.field_113 = false;
         this.field_112 = false;
         this.field_107 = 0;
      }

   }

   public boolean isConfirmationDialogVisible() {
      return this.field_111;
   }

   public boolean isImmediateFlowVisible() {
      return this.field_112;
   }

   public Integer getTypeForUpdateInProgress() {
      return this.field_115;
   }

   public Integer getPartiallyAllowedUpdateType() {
      return this.field_114;
   }

   public boolean isInstallSplashScreenVisible() {
      return this.field_113;
   }

   // $FF: renamed from: a () int
   private final int method_169() {
      return this.field_109?(this.field_107 != 0 && this.field_107 != 4 && this.field_107 != 5 && this.field_107 != 6?3:2):1;
   }

   // $FF: renamed from: b () void
   private final void method_170() {
      this.field_105.method_51(InstallState.method_44(this.field_107, this.field_108, this.field_106.getPackageName()));
   }
}
