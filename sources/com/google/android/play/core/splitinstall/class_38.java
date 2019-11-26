package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.play.core.internal.class_122;
import com.google.android.play.core.internal.class_145;
import com.google.android.play.core.splitinstall.class_30;
import com.google.android.play.core.splitinstall.class_31;
import com.google.android.play.core.splitinstall.class_32;
import com.google.android.play.core.splitinstall.class_33;
import com.google.android.play.core.splitinstall.class_34;
import com.google.android.play.core.splitinstall.class_35;
import com.google.android.play.core.splitinstall.class_36;
import com.google.android.play.core.splitinstall.class_37;
import com.google.android.play.core.splitinstall.class_62;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.class_98;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

// $FF: renamed from: com.google.android.play.core.splitinstall.q
final class class_38 {

   // $FF: renamed from: b com.google.android.play.core.internal.ag
   private static final class_145 field_51;
   // $FF: renamed from: c android.content.Intent
   private static final Intent field_52;
   // $FF: renamed from: d java.lang.String
   private final String field_53;
   // $FF: renamed from: a com.google.android.play.core.internal.q
   final class_122 field_54;


   // $FF: renamed from: <init> (android.content.Context) void
   public void method_78(Context var1) {
      this.method_79(var1, var1.getPackageName());
   }

   // $FF: renamed from: <init> (android.content.Context, java.lang.String) void
   private void method_79(Context var1, String var2) {
      super();
      this.field_53 = var2;
      class_122 var10001 = new class_122;
      var10001.method_376(var1.getApplicationContext(), field_51, "SplitInstallService", field_52, class_62.field_81);
      this.field_54 = var10001;
   }

   // $FF: renamed from: a (java.util.Collection, java.util.Collection) com.google.android.play.core.tasks.Task
   public final Task method_80(Collection var1, Collection var2) {
      field_51.method_490("startInstall(%s,%s)", new Object[]{var1, var2});
      class_98 var10000 = new class_98;
      var10000.method_290();
      class_98 var3 = var10000;
      class_122 var4 = this.field_54;
      class_32 var10001 = new class_32;
      var10001.method_72(this, var3, var1, var2, var3);
      var4.method_378(var10001);
      return var3.method_293();
   }

   // $FF: renamed from: a (java.util.List) com.google.android.play.core.tasks.Task
   public final Task method_81(List var1) {
      field_51.method_490("deferredUninstall(%s)", new Object[]{var1});
      class_98 var10000 = new class_98;
      var10000.method_290();
      class_98 var2 = var10000;
      class_122 var3 = this.field_54;
      class_31 var10001 = new class_31;
      var10001.method_71(this, var2, var1, var2);
      var3.method_378(var10001);
      return var2.method_293();
   }

   // $FF: renamed from: b (java.util.List) com.google.android.play.core.tasks.Task
   public final Task method_82(List var1) {
      field_51.method_490("deferredInstall(%s)", new Object[]{var1});
      class_98 var10000 = new class_98;
      var10000.method_290();
      class_98 var2 = var10000;
      class_122 var3 = this.field_54;
      class_34 var10001 = new class_34;
      var10001.method_74(this, var2, var1, var2);
      var3.method_378(var10001);
      return var2.method_293();
   }

   // $FF: renamed from: c (java.util.List) com.google.android.play.core.tasks.Task
   public final Task method_83(List var1) {
      field_51.method_490("deferredLanguageInstall(%s)", new Object[]{var1});
      class_98 var10000 = new class_98;
      var10000.method_290();
      class_98 var2 = var10000;
      class_122 var3 = this.field_54;
      class_33 var10001 = new class_33;
      var10001.method_73(this, var2, var1, var2);
      var3.method_378(var10001);
      return var2.method_293();
   }

   // $FF: renamed from: d (java.util.List) com.google.android.play.core.tasks.Task
   public final Task method_84(List var1) {
      field_51.method_490("deferredLanguageUninstall(%s)", new Object[]{var1});
      class_98 var10000 = new class_98;
      var10000.method_290();
      class_98 var2 = var10000;
      class_122 var3 = this.field_54;
      class_36 var10001 = new class_36;
      var10001.method_76(this, var2, var1, var2);
      var3.method_378(var10001);
      return var2.method_293();
   }

   // $FF: renamed from: a (int) com.google.android.play.core.tasks.Task
   public final Task method_85(int var1) {
      field_51.method_490("getSessionState(%d)", new Object[]{Integer.valueOf(var1)});
      class_98 var10000 = new class_98;
      var10000.method_290();
      class_98 var2 = var10000;
      class_122 var3 = this.field_54;
      class_35 var10001 = new class_35;
      var10001.method_75(this, var2, var1, var2);
      var3.method_378(var10001);
      return var2.method_293();
   }

   // $FF: renamed from: a () com.google.android.play.core.tasks.Task
   public final Task method_86() {
      field_51.method_490("getSessionStates", new Object[0]);
      class_98 var10000 = new class_98;
      var10000.method_290();
      class_98 var1 = var10000;
      class_122 var2 = this.field_54;
      class_30 var10001 = new class_30;
      var10001.method_70(this, var1, var1);
      var2.method_378(var10001);
      return var1.method_293();
   }

   // $FF: renamed from: b (int) com.google.android.play.core.tasks.Task
   public final Task method_87(int var1) {
      field_51.method_490("cancelInstall(%d)", new Object[]{Integer.valueOf(var1)});
      class_98 var10000 = new class_98;
      var10000.method_290();
      class_98 var2 = var10000;
      class_122 var3 = this.field_54;
      class_37 var10001 = new class_37;
      var10001.method_77(this, var2, var1, var2);
      var3.method_378(var10001);
      return var2.method_293();
   }

   // $FF: renamed from: c (java.util.Collection) java.util.ArrayList
   private static ArrayList method_88(Collection var0) {
      ArrayList var1 = new ArrayList(var0.size());
      Iterator var2 = var0.iterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();
         Bundle var4;
         (var4 = new Bundle()).putString("language", var3);
         var1.add(var4);
      }

      return var1;
   }

   // $FF: renamed from: d (java.util.Collection) java.util.ArrayList
   private static ArrayList method_89(Collection var0) {
      ArrayList var1 = new ArrayList(var0.size());
      Iterator var2 = var0.iterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();
         Bundle var4;
         (var4 = new Bundle()).putString("module_name", var3);
         var1.add(var4);
      }

      return var1;
   }

   // $FF: renamed from: d () android.os.Bundle
   private static Bundle method_90() {
      Bundle var0;
      (var0 = new Bundle()).putInt("playcore_version_code", 10603);
      return var0;
   }

   // $FF: renamed from: a (java.util.Collection) java.util.ArrayList
   // $FF: synthetic method
   static ArrayList method_91(Collection var0) {
      return method_89(var0);
   }

   // $FF: renamed from: b (java.util.Collection) java.util.ArrayList
   // $FF: synthetic method
   static ArrayList method_92(Collection var0) {
      return method_88(var0);
   }

   // $FF: renamed from: a (com.google.android.play.core.splitinstall.q) java.lang.String
   // $FF: synthetic method
   static String method_93(class_38 var0) {
      return var0.field_53;
   }

   // $FF: renamed from: b () android.os.Bundle
   // $FF: synthetic method
   static Bundle method_94() {
      return method_90();
   }

   // $FF: renamed from: c () com.google.android.play.core.internal.ag
   // $FF: synthetic method
   static class_145 method_95() {
      return field_51;
   }

   // $FF: renamed from: <clinit> () void
   static void method_96() {
      class_145 var10000 = new class_145;
      var10000.method_489("SplitInstallService");
      field_51 = var10000;
      field_52 = (new Intent("com.google.android.play.core.splitinstall.BIND_SPLIT_INSTALL_SERVICE")).setPackage("com.android.vending");
   }
}
