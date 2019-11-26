package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.XmlResourceParser;
import android.content.res.Resources.NotFoundException;
import android.os.Bundle;
import android.os.Build.VERSION;
import com.google.android.play.core.internal.class_145;
import com.google.android.play.core.splitinstall.class_2;
import com.google.android.play.core.splitinstall.class_56;
import com.google.android.play.core.splitinstall.class_59;
import com.google.android.play.core.splitinstall.class_83;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

// $FF: renamed from: com.google.android.play.core.splitinstall.k
public final class class_66 {

   // $FF: renamed from: a com.google.android.play.core.internal.ag
   private static final class_145 field_93;
   // $FF: renamed from: b android.content.Context
   private final Context field_94;
   // $FF: renamed from: c java.lang.String
   private final String field_95;
   // $FF: renamed from: d com.google.android.play.core.splitinstall.j
   private class_2 field_96;
   // $FF: renamed from: e com.google.android.play.core.splitinstall.d
   private class_59 field_97;


   // $FF: renamed from: <init> (android.content.Context, java.lang.String) void
   public void method_141(Context var1, String var2) {
      super();
      this.field_96 = null;
      this.field_97 = null;
      this.field_94 = var1;
      this.field_95 = var2;
   }

   // $FF: renamed from: a () java.util.Set
   public final Set method_142() {
      HashSet var1 = new HashSet();
      Iterator var2 = this.method_145().iterator();

      while(var2.hasNext()) {
         String var3;
         if(!method_149(var3 = (String)var2.next())) {
            var1.add(var3);
         }
      }

      return var1;
   }

   // $FF: renamed from: b () java.util.Set
   final Set method_143() {
      class_59 var1;
      if((var1 = this.method_144()) == null) {
         return null;
      } else {
         HashSet var2 = new HashSet();
         Set var3;
         (var3 = this.method_145()).add("");
         Set var4;
         (var4 = this.method_142()).add("");
         Iterator var5 = var1.method_120(var4).entrySet().iterator();

         while(var5.hasNext()) {
            Entry var6 = (Entry)var5.next();
            if(var3.containsAll((Collection)var6.getValue())) {
               var2.add((String)var6.getKey());
            }
         }

         return var2;
      }
   }

   // $FF: renamed from: c () com.google.android.play.core.splitinstall.d
   private final class_59 method_144() {
      Bundle var1;
      if((var1 = this.method_147()) == null) {
         return null;
      } else {
         int var2;
         if((var2 = var1.getInt("com.android.vending.splits")) == 0) {
            field_93.method_492("No metadata found in AndroidManifest.", new Object[0]);
            return null;
         } else {
            XmlResourceParser var3;
            try {
               var3 = this.field_94.getResources().getXml(var2);
            } catch (NotFoundException var6) {
               field_93.method_492("Resource with languages metadata doesn\'t exist.", new Object[0]);
               return null;
            }

            class_83 var10000 = new class_83;
            var10000.method_211(var3);
            class_59 var5;
            if((var5 = var10000.method_212()) == null) {
               field_93.method_492("Can\'t parse languages metadata.", new Object[0]);
            }

            return var5;
         }
      }
   }

   // $FF: renamed from: d () java.util.Set
   private final Set method_145() {
      HashSet var5 = new HashSet();
      HashSet var10000;
      Bundle var6;
      if((var6 = this.method_147()) == null) {
         var10000 = var5;
      } else {
         String var7;
         if((var7 = var6.getString("com.android.dynamic.apk.fused.modules")) != null && !var7.isEmpty()) {
            Collections.addAll(var5, var7.split(",", -1));
            var5.remove("");
            var10000 = var5;
         } else {
            field_93.method_491("App has no fused modules.", new Object[0]);
            var10000 = var5;
         }
      }

      HashSet var1 = var10000;
      if(VERSION.SDK_INT < 21) {
         return var1;
      } else {
         String[] var2;
         if((var2 = this.method_146()) != null) {
            field_93.method_491("Adding splits from package manager: %s", new Object[]{Arrays.toString(var2)});
            Collections.addAll(var1, var2);
         } else {
            field_93.method_491("No splits are found or app cannot be found in package manager.", new Object[0]);
         }

         class_2 var3;
         if((var3 = class_56.method_108()) != null) {
            var1.addAll(var3.method_2());
         }

         return var1;
      }
   }

   // $FF: renamed from: e () java.lang.String[]
   private final String[] method_146() {
      try {
         PackageInfo var1;
         return (var1 = this.field_94.getPackageManager().getPackageInfo(this.field_95, 0)) != null?var1.splitNames:null;
      } catch (NameNotFoundException var2) {
         field_93.method_492("App is not found in PackageManager", new Object[0]);
         return null;
      }
   }

   // $FF: renamed from: f () android.os.Bundle
   private final Bundle method_147() {
      ApplicationInfo var1;
      try {
         var1 = this.field_94.getPackageManager().getApplicationInfo(this.field_95, 128);
      } catch (NameNotFoundException var2) {
         field_93.method_492("App is not found in PackageManager", new Object[0]);
         return null;
      }

      if(var1 != null && var1.metaData != null) {
         return var1.metaData;
      } else {
         field_93.method_491("App has no applicationInfo or metaData", new Object[0]);
         return null;
      }
   }

   // $FF: renamed from: a (java.lang.String) boolean
   public static boolean method_148(String var0) {
      return var0.startsWith("config.");
   }

   // $FF: renamed from: b (java.lang.String) boolean
   public static boolean method_149(String var0) {
      return var0.startsWith("config.") || var0.contains(".config.");
   }

   // $FF: renamed from: c (java.lang.String) java.lang.String
   public static String method_150(String var0) {
      return var0.startsWith("config.")?"":var0.split("\\.config\\.", 2)[0];
   }

   // $FF: renamed from: <clinit> () void
   static void method_151() {
      class_145 var10000 = new class_145;
      var10000.method_489("SplitInstallInfoProvider");
      field_93 = var10000;
   }
}
