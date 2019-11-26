package com.google.android.play.core.missingsplits;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.play.core.internal.class_145;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// $FF: renamed from: com.google.android.play.core.missingsplits.a
final class class_99 {

   // $FF: renamed from: a com.google.android.play.core.internal.ag
   private static final class_145 field_183;
   // $FF: renamed from: b android.content.Context
   private final Context field_184;
   // $FF: renamed from: c android.content.pm.PackageManager
   private final PackageManager field_185;


   // $FF: renamed from: <init> (android.content.Context, android.content.pm.PackageManager) void
   void method_294(Context var1, PackageManager var2) {
      super();
      this.field_184 = var1;
      this.field_185 = var2;
   }

   // $FF: renamed from: a () boolean
   final boolean method_295() {
      Iterator var1 = this.method_299().iterator();

      ComponentInfo var2;
      do {
         if(!var1.hasNext()) {
            field_183.method_491("All non-activity components are disabled", new Object[0]);
            return true;
         }

         var2 = (ComponentInfo)var1.next();
      } while(this.field_185.getComponentEnabledSetting(new ComponentName(var2.packageName, var2.name)) == 2);

      field_183.method_491("Not all non-activity components are disabled", new Object[0]);
      return false;
   }

   // $FF: renamed from: b () void
   final void method_296() {
      field_183.method_490("Disabling all non-activity components", new Object[0]);
      this.method_298(this.method_299(), 2);
   }

   // $FF: renamed from: c () void
   final void method_297() {
      field_183.method_490("Resetting enabled state of all non-activity components", new Object[0]);
      this.method_298(this.method_299(), 0);
   }

   // $FF: renamed from: a (java.util.List, int) void
   private final void method_298(List var1, int var2) {
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         ComponentInfo var4 = (ComponentInfo)var3.next();
         this.field_185.setComponentEnabledSetting(new ComponentName(var4.packageName, var4.name), var2, 1);
      }

   }

   // $FF: renamed from: d () java.util.List
   private final List method_299() {
      try {
         ArrayList var1 = new ArrayList();
         PackageInfo var2;
         if((var2 = this.field_185.getPackageInfo(this.field_184.getPackageName(), 526)).providers != null) {
            Collections.addAll(var1, var2.providers);
         }

         if(var2.receivers != null) {
            Collections.addAll(var1, var2.receivers);
         }

         if(var2.services != null) {
            Collections.addAll(var1, var2.services);
         }

         return var1;
      } catch (NameNotFoundException var3) {
         field_183.method_492("Failed to resolve own package : %s", new Object[]{var3});
         return Collections.emptyList();
      }
   }

   // $FF: renamed from: <clinit> () void
   static void method_300() {
      class_145 var10000 = new class_145;
      var10000.method_489("MissingSplitsAppComponentsHelper");
      field_183 = var10000;
   }
}
