package com.google.android.play.core.splitinstall;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.os.Handler;
import android.os.Looper;
import android.os.Build.VERSION;
import com.google.android.play.core.splitinstall.SplitInstallException;
import com.google.android.play.core.splitinstall.SplitInstallManager;
import com.google.android.play.core.splitinstall.SplitInstallRequest;
import com.google.android.play.core.splitinstall.SplitInstallSessionState;
import com.google.android.play.core.splitinstall.SplitInstallStateUpdatedListener;
import com.google.android.play.core.splitinstall.class_22;
import com.google.android.play.core.splitinstall.class_38;
import com.google.android.play.core.splitinstall.class_64;
import com.google.android.play.core.splitinstall.class_66;
import com.google.android.play.core.splitinstall.class_80;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.Tasks;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

// $FF: renamed from: com.google.android.play.core.splitinstall.o
final class class_63 implements SplitInstallManager {

   // $FF: renamed from: a com.google.android.play.core.splitinstall.q
   private final class_38 field_82;
   // $FF: renamed from: b com.google.android.play.core.splitinstall.m
   private final class_22 field_83;
   // $FF: renamed from: c com.google.android.play.core.splitinstall.k
   private final class_66 field_84;
   // $FF: renamed from: d com.google.android.play.core.splitinstall.ai
   private final class_80 field_85;
   // $FF: renamed from: e android.os.Handler
   private final Handler field_86;


   // $FF: renamed from: <init> (com.google.android.play.core.splitinstall.q, android.content.Context) void
   void method_134(class_38 var1, Context var2) {
      this.method_135(var1, var2, var2.getPackageName());
   }

   // $FF: renamed from: <init> (com.google.android.play.core.splitinstall.q, android.content.Context, java.lang.String) void
   private void method_135(class_38 var1, Context var2, String var3) {
      super();
      this.field_86 = new Handler(Looper.getMainLooper());
      class_66 var10001 = new class_66;
      var10001.method_141(var2, var3);
      this.field_84 = var10001;
      this.field_82 = var1;
      this.field_83 = class_22.method_54(var2);
      class_80 var4 = new class_80;
      var4.method_205(var2);
      this.field_85 = var4;
   }

   public final synchronized void registerListener(SplitInstallStateUpdatedListener var1) {
      this.field_83.method_48(var1);
   }

   public final synchronized void unregisterListener(SplitInstallStateUpdatedListener var1) {
      this.field_83.method_49(var1);
   }

   public final Task startInstall(SplitInstallRequest var1) {
      if(!var1.getLanguages().isEmpty() && VERSION.SDK_INT < 21) {
         SplitInstallException var9 = new SplitInstallException;
         var9.method_39(-5);
         return Tasks.method_312(var9);
      } else {
         List var3 = var1.getLanguages();
         boolean var10000;
         Set var4;
         if((var4 = this.field_84.method_143()) == null) {
            var10000 = true;
         } else {
            HashSet var5 = new HashSet();
            Iterator var6 = var3.iterator();

            while(var6.hasNext()) {
               Locale var7 = (Locale)var6.next();
               var5.add(var7.getLanguage());
            }

            var10000 = var4.containsAll(var5);
         }

         if(var10000) {
            var3 = var1.getModuleNames();
            if(this.getInstalledModules().containsAll(var3)) {
               if(VERSION.SDK_INT >= 21) {
                  var3 = var1.getModuleNames();
                  var4 = this.field_85.method_206();
                  if(!Collections.disjoint(var3, var4)) {
                     return this.field_82.method_80(var1.getModuleNames(), method_136(var1.getLanguages()));
                  }
               }

               Handler var8 = this.field_86;
               class_64 var10001 = new class_64;
               var10001.method_139(this, var1);
               var8.post(var10001);
               return Tasks.method_311(Integer.valueOf(0));
            }
         }

         return this.field_82.method_80(var1.getModuleNames(), method_136(var1.getLanguages()));
      }
   }

   public final boolean startConfirmationDialogForResult(SplitInstallSessionState var1, Activity var2, int var3) throws SendIntentException {
      if(var1.status() == 8 && var1.resolutionIntent() != null) {
         var2.startIntentSenderForResult(var1.resolutionIntent().getIntentSender(), var3, (Intent)null, 0, 0, 0);
         return true;
      } else {
         return false;
      }
   }

   public final Task cancelInstall(int var1) {
      return this.field_82.method_87(var1);
   }

   public final Task getSessionState(int var1) {
      return this.field_82.method_85(var1);
   }

   public final Task getSessionStates() {
      return this.field_82.method_86();
   }

   public final Task deferredUninstall(List var1) {
      this.field_85.method_207(var1);
      return this.field_82.method_81(var1);
   }

   public final Task deferredInstall(List var1) {
      return this.field_82.method_82(var1);
   }

   public final Task deferredLanguageInstall(List var1) {
      if(VERSION.SDK_INT < 21) {
         SplitInstallException var10000 = new SplitInstallException;
         var10000.method_39(-5);
         return Tasks.method_312(var10000);
      } else {
         return this.field_82.method_83(method_136(var1));
      }
   }

   public final Task deferredLanguageUninstall(List var1) {
      if(VERSION.SDK_INT < 21) {
         SplitInstallException var10000 = new SplitInstallException;
         var10000.method_39(-5);
         return Tasks.method_312(var10000);
      } else {
         return this.field_82.method_84(method_136(var1));
      }
   }

   public final Set getInstalledModules() {
      return this.field_84.method_142();
   }

   public final Set getInstalledLanguages() {
      Set var1;
      return (var1 = this.field_84.method_143()) == null?Collections.emptySet():var1;
   }

   // $FF: renamed from: b (java.util.List) java.util.List
   private static List method_136(List var0) {
      ArrayList var1 = new ArrayList(var0.size());
      Iterator var2 = var0.iterator();

      while(var2.hasNext()) {
         Locale var3 = (Locale)var2.next();
         if(VERSION.SDK_INT >= 21) {
            var1.add(var3.toLanguageTag());
         }
      }

      return var1;
   }

   // $FF: renamed from: a (java.util.List) java.util.List
   // $FF: synthetic method
   static List method_137(List var0) {
      return method_136(var0);
   }

   // $FF: renamed from: a (com.google.android.play.core.splitinstall.o) com.google.android.play.core.splitinstall.m
   // $FF: synthetic method
   static class_22 method_138(class_63 var0) {
      return var0.field_83;
   }
}
