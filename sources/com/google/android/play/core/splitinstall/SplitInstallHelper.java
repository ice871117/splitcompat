package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.os.Build.VERSION;
import com.google.android.play.core.internal.class_145;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class SplitInstallHelper {

   // $FF: renamed from: a com.google.android.play.core.internal.ag
   private static final class_145 field_63;


   public static void updateAppInfo(Context var0) {
      if(VERSION.SDK_INT > 25 && VERSION.SDK_INT < 28) {
         field_63.method_490("Calling dispatchPackageBroadcast", new Object[0]);

         try {
            Class var1;
            Method var2;
            (var2 = (var1 = Class.forName("android.app.ActivityThread")).getMethod("currentActivityThread", new Class[0])).setAccessible(true);
            Object var3 = var2.invoke((Object)null, new Object[0]);
            Field var4;
            (var4 = var1.getDeclaredField("mAppThread")).setAccessible(true);
            Object var5;
            (var5 = var4.get(var3)).getClass().getMethod("dispatchPackageBroadcast", new Class[]{Integer.TYPE, String[].class}).invoke(var5, new Object[]{Integer.valueOf(3), new String[]{var0.getPackageName()}});
            field_63.method_490("Called dispatchPackageBroadcast", new Object[0]);
         } catch (Exception var6) {
            field_63.method_494(var6, "Update app info with dispatchPackageBroadcast failed!", new Object[0]);
         }
      }
   }

   public static void loadLibrary(Context var0, String var1) throws UnsatisfiedLinkError {
      try {
         System.loadLibrary(var1);
      } catch (UnsatisfiedLinkError var8) {
         boolean var3 = false;

         try {
            String var5 = var0.getApplicationInfo().nativeLibraryDir;
            String var6 = System.mapLibraryName(var1);
            String var4 = (new StringBuilder(1 + String.valueOf(var5).length() + String.valueOf(var6).length())).append(var5).append("/").append(var6).toString();
            if((new File(var4)).exists()) {
               System.load(var4);
               var3 = true;
            }
         } catch (UnsatisfiedLinkError var7) {
            throw var7;
         }

         if(!var3) {
            throw var8;
         }
      }
   }

   // $FF: renamed from: <init> () void
   private void method_111() {
      super();
   }

   // $FF: renamed from: <clinit> () void
   static void method_112() {
      class_145 var10000 = new class_145;
      var10000.method_489("SplitInstallHelper");
      field_63 = var10000;
   }
}
