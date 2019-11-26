package com.google.android.play.core.missingsplits;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.AppTask;
import android.app.ActivityManager.RecentTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import com.google.android.play.core.internal.class_145;
import com.google.android.play.core.missingsplits.MissingSplitsManager;
import com.google.android.play.core.missingsplits.PlayCoreMissingSplitsActivity;
import com.google.android.play.core.missingsplits.class_99;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

// $FF: renamed from: com.google.android.play.core.missingsplits.b
final class class_103 implements MissingSplitsManager {

   // $FF: renamed from: a com.google.android.play.core.internal.ag
   private static final class_145 field_187;
   // $FF: renamed from: b android.content.Context
   private final Context field_188;
   // $FF: renamed from: c java.lang.Runtime
   private final Runtime field_189;
   // $FF: renamed from: d com.google.android.play.core.missingsplits.a
   private final class_99 field_190;
   // $FF: renamed from: e java.util.concurrent.atomic.AtomicReference
   private final AtomicReference field_191;


   // $FF: renamed from: <init> (android.content.Context, java.lang.Runtime, com.google.android.play.core.missingsplits.a, java.util.concurrent.atomic.AtomicReference) void
   void method_303(Context var1, Runtime var2, class_99 var3, AtomicReference var4) {
      super();
      this.field_188 = var1;
      this.field_189 = var2;
      this.field_190 = var3;
      this.field_191 = var4;
   }

   public final boolean disableAppIfMissingRequiredSplits() {
      if(VERSION.SDK_INT < 21) {
         return false;
      } else if(!this.isMissingRequiredSplits()) {
         if(this.field_190.method_295()) {
            this.field_190.method_297();
            this.field_189.exit(0);
         }

         return false;
      } else {
         Iterator var4 = this.method_307().iterator();

         boolean var10000;
         while(true) {
            if(var4.hasNext()) {
               AppTask var5;
               if((var5 = (AppTask)var4.next()).getTaskInfo() == null || var5.getTaskInfo().baseIntent == null || var5.getTaskInfo().baseIntent.getComponent() == null) {
                  continue;
               }

               String var6 = var5.getTaskInfo().baseIntent.getComponent().getClassName();
               if(!PlayCoreMissingSplitsActivity.class.getName().equals(var6)) {
                  continue;
               }

               var10000 = true;
               break;
            }

            var10000 = false;
            break;
         }

         if(!var10000) {
            class_103 var2 = this;
            Iterator var3 = this.method_307().iterator();

            while(true) {
               if(var3.hasNext()) {
                  RecentTaskInfo var8;
                  if((var8 = ((AppTask)var3.next()).getTaskInfo()) == null || var8.baseIntent == null || var8.baseIntent.getComponent() == null || !var2.method_306(var8.baseIntent.getComponent())) {
                     continue;
                  }

                  var10000 = true;
                  break;
               }

               var10000 = false;
               break;
            }

            boolean var1 = var10000;
            this.field_190.method_296();
            var3 = this.method_307().iterator();

            while(var3.hasNext()) {
               ((AppTask)var3.next()).finishAndRemoveTask();
            }

            if(var1) {
               this.field_188.getPackageManager().setComponentEnabledSetting(new ComponentName(this.field_188, PlayCoreMissingSplitsActivity.class), 1, 1);
               Intent var7 = (new Intent(this.field_188, PlayCoreMissingSplitsActivity.class)).addFlags(884998144);
               this.field_188.startActivity(var7);
            }

            this.field_189.exit(0);
         }

         return true;
      }
   }

   public final boolean isMissingRequiredSplits() {
      AtomicReference var1 = this.field_191;
      synchronized(this.field_191) {
         if((Boolean)this.field_191.get() == null) {
            Set var5;
            this.field_191.set(Boolean.valueOf(VERSION.SDK_INT >= 21 && this.method_304() && ((var5 = this.method_305()).isEmpty() || var5.size() == 1 && var5.contains(""))));
         }

         return ((Boolean)this.field_191.get()).booleanValue();
      }
   }

   // $FF: renamed from: a () boolean
   private final boolean method_304() {
      PackageManager var1 = this.field_188.getPackageManager();

      try {
         ApplicationInfo var2;
         return (var2 = var1.getApplicationInfo(this.field_188.getPackageName(), 128)).metaData != null && Boolean.TRUE.equals(var2.metaData.get("com.android.vending.splits.required"));
      } catch (NameNotFoundException var3) {
         field_187.method_492("App \'%s\' is not found in the PackageManager", new Object[]{this.field_188.getPackageName()});
         return false;
      }
   }

   // $FF: renamed from: b () java.util.Set
   private final Set method_305() {
      if(VERSION.SDK_INT < 21) {
         return Collections.emptySet();
      } else {
         try {
            PackageInfo var1 = this.field_188.getPackageManager().getPackageInfo(this.field_188.getPackageName(), 0);
            HashSet var2 = new HashSet();
            if(var1.splitNames != null) {
               Collections.addAll(var2, var1.splitNames);
            }

            return var2;
         } catch (NameNotFoundException var3) {
            field_187.method_492("App \'%s\' is not found in PackageManager", new Object[]{this.field_188.getPackageName()});
            return Collections.emptySet();
         }
      }
   }

   // $FF: renamed from: a (android.content.ComponentName) boolean
   private final boolean method_306(ComponentName var1) {
      String var2 = var1.getClassName();

      Class var3;
      try {
         var3 = Class.forName(var2);
      } catch (ClassNotFoundException var6) {
         field_187.method_492("ClassNotFoundException when scanning class hierarchy of \'%s\'", new Object[]{var2});

         try {
            if(this.field_188.getPackageManager().getActivityInfo(var1, 0) != null) {
               return true;
            }

            return false;
         } catch (NameNotFoundException var5) {
            return false;
         }
      }

      while(var3 != null) {
         if(var3.equals(Activity.class)) {
            return true;
         }

         Class var4;
         var3 = (var4 = var3.getSuperclass()) != var3?var4:null;
      }

      return false;
   }

   // $FF: renamed from: c () java.util.List
   private final List method_307() {
      List var2;
      return (var2 = ((ActivityManager)this.field_188.getSystemService("activity")).getAppTasks()) != null?var2:Collections.emptyList();
   }

   // $FF: renamed from: <clinit> () void
   static void method_308() {
      class_145 var10000 = new class_145;
      var10000.method_489("MissingSplitsManagerImpl");
      field_187 = var10000;
   }
}
