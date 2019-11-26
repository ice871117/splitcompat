package com.google.android.play.core.appupdate;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.class_28;
import com.google.android.play.core.appupdate.class_29;
import com.google.android.play.core.appupdate.class_70;
import com.google.android.play.core.internal.class_122;
import com.google.android.play.core.internal.class_145;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.class_98;

// $FF: renamed from: com.google.android.play.core.appupdate.d
final class class_69 {

   // $FF: renamed from: b com.google.android.play.core.internal.ag
   private static final class_145 field_116;
   // $FF: renamed from: c android.content.Intent
   private static final Intent field_117;
   // $FF: renamed from: a com.google.android.play.core.internal.q
   final class_122 field_118;
   // $FF: renamed from: d java.lang.String
   private final String field_119;
   // $FF: renamed from: e android.content.Context
   private final Context field_120;


   // $FF: renamed from: <init> (android.content.Context) void
   public void method_171(Context var1) {
      super();
      this.field_119 = var1.getPackageName();
      this.field_120 = var1;
      class_122 var10001 = new class_122;
      var10001.method_376(var1.getApplicationContext(), field_116, "AppUpdateService", field_117, class_70.field_121);
      this.field_118 = var10001;
   }

   // $FF: renamed from: a (java.lang.String) com.google.android.play.core.tasks.Task
   public final Task method_172(String var1) {
      field_116.method_490("requestUpdateInfo(%s)", new Object[]{var1});
      class_98 var10000 = new class_98;
      var10000.method_290();
      class_98 var2 = var10000;
      class_122 var3 = this.field_118;
      class_28 var10001 = new class_28;
      var10001.method_68(this, var2, var1, var2);
      var3.method_378(var10001);
      return var2.method_293();
   }

   // $FF: renamed from: b (java.lang.String) com.google.android.play.core.tasks.Task
   public final Task method_173(String var1) {
      field_116.method_490("completeUpdate(%s)", new Object[]{var1});
      class_98 var10000 = new class_98;
      var10000.method_290();
      class_98 var2 = var10000;
      class_122 var3 = this.field_118;
      class_29 var10001 = new class_29;
      var10001.method_69(this, var2, var2, var1);
      var3.method_378(var10001);
      return var2.method_293();
   }

   // $FF: renamed from: c (java.lang.String) android.os.Bundle
   private final Bundle method_174(String var1) {
      Bundle var2;
      (var2 = new Bundle()).putAll(method_175());
      var2.putString("package.name", var1);
      Integer var3;
      if((var3 = this.method_178()) != null) {
         var2.putInt("app.version.code", var3.intValue());
      }

      return var2;
   }

   // $FF: renamed from: c () android.os.Bundle
   private static Bundle method_175() {
      Bundle var0;
      (var0 = new Bundle()).putInt("playcore.version.code", 10603);
      return var0;
   }

   // $FF: renamed from: b (android.os.Bundle, java.lang.String) com.google.android.play.core.appupdate.AppUpdateInfo
   private static AppUpdateInfo method_176(Bundle var0, String var1) {
      return AppUpdateInfo.method_190(var1, var0.getInt("version.code", -1), var0.getInt("update.availability"), var0.getInt("install.status", 0), (PendingIntent)var0.getParcelable("blocking.intent"), (PendingIntent)var0.getParcelable("nonblocking.intent"));
   }

   // $FF: renamed from: b (android.os.Bundle) int
   private static int method_177(Bundle var0) {
      return var0.getInt("error.code", -2);
   }

   // $FF: renamed from: d () java.lang.Integer
   private final Integer method_178() {
      try {
         String var1 = this.field_120.getPackageName();
         return Integer.valueOf(this.field_120.getPackageManager().getPackageInfo(var1, 0).versionCode);
      } catch (NameNotFoundException var4) {
         field_116.method_493("The current version of the app could not be retrieved", new Object[0]);
         return null;
      }
   }

   // $FF: renamed from: a (com.google.android.play.core.appupdate.d) java.lang.String
   // $FF: synthetic method
   static String method_179(class_69 var0) {
      return var0.field_119;
   }

   // $FF: renamed from: a (com.google.android.play.core.appupdate.d, java.lang.String) android.os.Bundle
   // $FF: synthetic method
   static Bundle method_180(class_69 var0, String var1) {
      return var0.method_174(var1);
   }

   // $FF: renamed from: a () com.google.android.play.core.internal.ag
   // $FF: synthetic method
   static class_145 method_181() {
      return field_116;
   }

   // $FF: renamed from: b () android.os.Bundle
   // $FF: synthetic method
   static Bundle method_182() {
      return method_175();
   }

   // $FF: renamed from: a (android.os.Bundle) int
   // $FF: synthetic method
   static int method_183(Bundle var0) {
      return method_177(var0);
   }

   // $FF: renamed from: a (android.os.Bundle, java.lang.String) com.google.android.play.core.appupdate.AppUpdateInfo
   // $FF: synthetic method
   static AppUpdateInfo method_184(Bundle var0, String var1) {
      return method_176(var0, var1);
   }

   // $FF: renamed from: <clinit> () void
   static void method_185() {
      class_145 var10000 = new class_145;
      var10000.method_489("AppUpdateService");
      field_116 = var10000;
      field_117 = (new Intent("com.google.android.play.core.install.BIND_UPDATE_SERVICE")).setPackage("com.android.vending");
   }
}
