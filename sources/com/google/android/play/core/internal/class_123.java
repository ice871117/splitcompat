package com.google.android.play.core.internal;

import android.os.Bundle;
import android.util.Base64;
import com.google.android.play.core.internal.class_110;
import com.google.android.play.core.internal.class_128;
import com.google.android.play.core.internal.class_129;
import com.google.android.play.core.internal.class_134;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// $FF: renamed from: com.google.android.play.core.internal.az
public class class_123 {

   // $FF: renamed from: a (java.lang.Object, java.lang.String, java.lang.Class, java.lang.Class, java.lang.Object) java.lang.Object
   public static Object method_401(Object var0, String var1, Class var2, Class var3, Object var4) {
      Method var5 = method_407(var0, var1, new Class[]{var3});

      try {
         return var2.cast(var5.invoke(var0, new Object[]{var4}));
      } catch (Exception var7) {
         class_128 var10000 = new class_128;
         var10000.method_423(String.format("Failed to invoke method %s on an object of type %s", new Object[]{var1, var0.getClass()}), var7);
         throw var10000;
      }
   }

   // $FF: renamed from: a (java.lang.Object, java.lang.String, java.lang.Class, java.lang.Class, java.lang.Object, java.lang.Class, java.lang.Object, java.lang.Class, java.lang.Object) java.lang.Object
   public static Object method_402(Object var0, String var1, Class var2, Class var3, Object var4, Class var5, Object var6, Class var7, Object var8) {
      Method var9 = method_407(var0, var1, new Class[]{var3, var5, var7});

      try {
         return var2.cast(var9.invoke(var0, new Object[]{var4, var6, var8}));
      } catch (Exception var11) {
         class_128 var10000 = new class_128;
         var10000.method_423(String.format("Failed to invoke method %s on an object of type %s", new Object[]{var1, var0.getClass()}), var11);
         throw var10000;
      }
   }

   // $FF: renamed from: a (java.lang.Class, java.lang.String, java.lang.Class, java.lang.Class, java.lang.Object) java.lang.Object
   public static Object method_403(Class var0, String var1, Class var2, Class var3, Object var4) {
      Method var5 = method_408(var0, var1, new Class[]{var3});

      try {
         return var2.cast(var5.invoke((Object)null, new Object[]{var4}));
      } catch (Exception var7) {
         class_128 var10000 = new class_128;
         var10000.method_423(String.format("Failed to invoke static method %s on type %s", new Object[]{var1, var0}), var7);
         throw var10000;
      }
   }

   // $FF: renamed from: a (java.lang.Class, java.lang.String, java.lang.Class, java.lang.Class, java.lang.Object, java.lang.Class, java.lang.Object) java.lang.Object
   public static Object method_404(Class var0, String var1, Class var2, Class var3, Object var4, Class var5, Object var6) {
      Method var7 = method_408(var0, var1, new Class[]{var3, var5});

      try {
         return var2.cast(var7.invoke((Object)null, new Object[]{var4, var6}));
      } catch (Exception var9) {
         class_128 var10000 = new class_128;
         var10000.method_423(String.format("Failed to invoke static method %s on type %s", new Object[]{var1, var0}), var9);
         throw var10000;
      }
   }

   // $FF: renamed from: a (java.lang.Object, java.lang.String, java.lang.Class) com.google.android.play.core.internal.ba
   public static class_129 method_405(Object var0, String var1, Class var2) {
      class_129 var10000 = new class_129;
      var10000.method_424(var0, method_409(var0, var1), var2);
      return var10000;
   }

   // $FF: renamed from: b (java.lang.Object, java.lang.String, java.lang.Class) com.google.android.play.core.internal.ba
   public static class_129 method_406(Object var0, String var1, Class var2) {
      class_129 var10000 = new class_129;
      var10000.method_427(var0, method_409(var0, var1), var2, (byte)0);
      return var10000;
   }

   // $FF: renamed from: a (java.lang.Object, java.lang.String, java.lang.Class[]) java.lang.reflect.Method
   private static Method method_407(Object var0, String var1, Class ... var2) {
      return method_408(var0.getClass(), var1, var2);
   }

   // $FF: renamed from: a (java.lang.Class, java.lang.String, java.lang.Class[]) java.lang.reflect.Method
   private static Method method_408(Class var0, String var1, Class ... var2) {
      Class var3 = var0;

      while(var3 != null) {
         try {
            Method var4;
            if(!(var4 = var3.getDeclaredMethod(var1, var2)).isAccessible()) {
               var4.setAccessible(true);
            }

            return var4;
         } catch (NoSuchMethodException var5) {
            var3 = var3.getSuperclass();
         }
      }

      class_128 var10000 = new class_128;
      var10000.method_422(String.format("Could not find a method named %s with parameters %s in type %s", new Object[]{var1, Arrays.asList(var2), var0}));
      throw var10000;
   }

   // $FF: renamed from: a (java.lang.Object, java.lang.String) java.lang.reflect.Field
   private static Field method_409(Object var0, String var1) {
      Class var2 = var0.getClass();

      while(var2 != null) {
         try {
            Field var3;
            if(!(var3 = var2.getDeclaredField(var1)).isAccessible()) {
               var3.setAccessible(true);
            }

            return var3;
         } catch (NoSuchFieldException var4) {
            var2 = var2.getSuperclass();
         }
      }

      class_128 var10000 = new class_128;
      var10000.method_422(String.format("Failed to find a field named %s on an object of instance %s", new Object[]{var1, var0.getClass().getName()}));
      throw var10000;
   }

   // $FF: renamed from: <init> () void
   public void method_410() {
      super();
   }

   // $FF: renamed from: a (java.lang.String) java.security.cert.X509Certificate[][]
   public static X509Certificate[][] method_411(String var0) throws class_134, IOException {
      return class_110.method_332(var0);
   }

   // $FF: renamed from: a (java.util.List, java.util.List) android.os.Bundle
   public static Bundle method_412(List var0, List var1) {
      Bundle var2;
      (var2 = new Bundle()).putInt("session_id", 0);
      var2.putInt("status", 5);
      var2.putInt("error_code", 0);
      if(!var0.isEmpty()) {
         var2.putStringArrayList("module_names", new ArrayList(var0));
      }

      if(!var1.isEmpty()) {
         var2.putStringArrayList("languages", new ArrayList(var1));
      }

      var2.putLong("total_bytes_to_download", 0L);
      var2.putLong("bytes_downloaded", 0L);
      return var2;
   }

   // $FF: renamed from: a (byte[]) java.lang.String
   public static String method_413(byte[] var0) {
      MessageDigest var1;
      try {
         var1 = MessageDigest.getInstance("SHA-256");
      } catch (NoSuchAlgorithmException var3) {
         return "";
      }

      var1.update(var0);
      return Base64.encodeToString(var1.digest(), 11);
   }

   // $FF: renamed from: a (java.lang.Object, java.lang.Object) java.lang.Object
   public static Object method_414(Object var0, Object var1) {
      if(var0 == null) {
         throw new NullPointerException(String.valueOf(var1));
      } else {
         return var0;
      }
   }

   // $FF: renamed from: a (boolean, java.lang.Object) void
   public static void method_415(boolean var0, Object var1) {
      if(!var0) {
         throw new IllegalStateException(String.valueOf(var1));
      }
   }
}
