package com.google.android.play.core.splitcompat;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.google.android.play.core.internal.class_123;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// $FF: renamed from: com.google.android.play.core.splitcompat.e
public final class SplitFileLogic {

   // $FF: renamed from: a java.io.File
   private final File mFile;
   // $FF: renamed from: b long
   private final long mVersionCode;


   // $FF: renamed from: <init> (android.content.Context) void
   public void method_230(Context var1) throws IOException, NameNotFoundException {
      this.method_231(var1.getFilesDir(), (long)var1.getPackageManager().getPackageInfo(var1.getPackageName(), 0).versionCode);
   }

   // $FF: renamed from: <init> (java.io.File, long) void
   private void method_231(File var1, long var2) {
      super();
      String var4 = var1.getAbsolutePath();
      Log.d("SplitCompat", (new StringBuilder(82 + String.valueOf(var4).length())).append("FileStorage: initializing (files directory = ").append(var4).append(", versionCode = ").append(var2).append(")").toString());
      this.mFile = var1;
      this.mVersionCode = var2;
   }

   // $FF: renamed from: a () void
   public final void method_232() throws IOException {
      File var1;
      String[] var2;
      if((var2 = (var1 = this.method_242()).list()) != null) {
         String[] var3 = var2;
         int var4 = var2.length;

         for(int var5 = 0; var5 < var4; ++var5) {
            String var6;
            if(!(var6 = var3[var5]).equals(Long.toString(this.mVersionCode))) {
               File var7 = new File(var1, var6);
               String var8 = String.valueOf(var7);
               long var9 = this.mVersionCode;
               Log.d("SplitCompat", (new StringBuilder(118 + String.valueOf(var8).length())).append("FileStorage: removing directory for different version code (directory = ").append(var8).append(", current version code = ").append(var9).append(")").toString());
               method_253(var7);
            }
         }
      }

   }

   // $FF: renamed from: a (java.lang.String) java.io.File
   public final File method_233(String var1) throws IOException {
      return new File(this.method_238(), method_250(var1));
   }

   // $FF: renamed from: b (java.lang.String) java.io.File
   public final File method_234(String var1) throws IOException {
      return new File(this.method_239(), method_250(var1));
   }

   // $FF: renamed from: a (java.io.File) java.io.File
   public final File method_235(File var1) throws IOException {
      return new File(this.method_239(), var1.getName());
   }

   // $FF: renamed from: a (java.lang.String, java.lang.String) java.io.File
   public final File method_236(String var1, String var2) throws IOException {
      return new File(this.method_244(var1), var2);
   }

   // $FF: renamed from: b () java.io.File
   public final File method_237() throws IOException {
      return new File(this.method_241(), "lock.tmp");
   }

   // $FF: renamed from: c () java.io.File
   public final File method_238() throws IOException {
      return method_252(new File(this.method_241(), "unverified-splits"));
   }

   // $FF: renamed from: f () java.io.File
   private final File method_239() throws IOException {
      return method_252(new File(this.method_241(), "verified-splits"));
   }

   // $FF: renamed from: c (java.lang.String) java.io.File
   public final File method_240(String var1) throws IOException {
      return method_252(new File(method_252(new File(this.method_241(), "dex")), var1));
   }

   // $FF: renamed from: g () java.io.File
   private final File method_241() throws IOException {
      return method_252(new File(this.method_242(), Long.toString(this.mVersionCode)));
   }

   // $FF: renamed from: h () java.io.File
   private final File method_242() throws IOException {
      return method_252(new File(this.mFile, "splitcompat"));
   }

   // $FF: renamed from: i () java.io.File
   private final File method_243() throws IOException {
      return method_252(new File(this.method_241(), "native-libraries"));
   }

   // $FF: renamed from: g (java.lang.String) java.io.File
   private final File method_244(String var1) throws IOException {
      return method_252(new File(this.method_243(), var1));
   }

   // $FF: renamed from: d () java.util.Set
   final Set method_245() throws IOException {
      File var1 = this.method_239();
      HashSet var2 = new HashSet();
      File[] var3;
      if((var3 = var1.listFiles()) != null) {
         File[] var4 = var3;
         int var5 = var3.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            File var7;
            if((var7 = var4[var6]).isFile() && var7.getName().endsWith(".apk")) {
               String var8;
               String var9 = (var8 = var7.getName()).substring(0, var8.length() - 4);
               class_75 var10001 = new class_75;
               var10001.method_198(var7, var9);
               var2.add(var10001);
            }
         }
      }

      return var2;
   }

   // $FF: renamed from: e () java.util.List
   final List method_246() throws IOException {
      ArrayList var1 = new ArrayList();
      File[] var2;
      if((var2 = this.method_243().listFiles()) != null) {
         File[] var3 = var2;
         int var4 = var2.length;

         for(int var5 = 0; var5 < var4; ++var5) {
            File var6;
            if((var6 = var3[var5]).isDirectory()) {
               var1.add(var6.getName());
            }
         }
      }

      return var1;
   }

   // $FF: renamed from: d (java.lang.String) void
   final void method_247(String var1) throws IOException {
      method_253(this.method_244(var1));
   }

   // $FF: renamed from: b (java.io.File) void
   final void method_248(File var1) throws IOException {
      class_123.method_415(var1.getParentFile().getParentFile().equals(this.method_243()), "File to remove is not a native library");
      method_253(var1);
   }

   // $FF: renamed from: e (java.lang.String) java.util.Set
   final Set method_249(String var1) throws IOException {
      HashSet var2 = new HashSet();
      File[] var3;
      if((var3 = this.method_244(var1).listFiles()) != null) {
         File[] var4 = var3;
         int var5 = var3.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            File var7;
            if((var7 = var4[var6]).isFile()) {
               var2.add(var7);
            }
         }
      }

      return var2;
   }

   // $FF: renamed from: h (java.lang.String) java.lang.String
   private static String method_250(String var0) {
      String var10000 = String.valueOf(var0);
      String var10001 = String.valueOf(".apk");
      return var10001.length() != 0?var10000.concat(var10001):new String(var10000);
   }

   // $FF: renamed from: f (java.lang.String) void
   final void method_251(String var1) throws IOException {
      method_253(this.method_234(var1));
   }

   // $FF: renamed from: c (java.io.File) java.io.File
   private static File method_252(File var0) throws IOException {
      if(var0.exists()) {
         if(var0.isDirectory()) {
            return var0;
         } else {
            throw new IllegalArgumentException("File input must be directory when it exists.");
         }
      } else {
         var0.mkdirs();
         if(!var0.isDirectory()) {
            IOException var10000 = new IOException;
            String var10003 = String.valueOf(var0.getAbsolutePath());
            var10000.<init>(var10003.length() != 0?"Unable to create directory: ".concat(var10003):new String("Unable to create directory: "));
            throw var10000;
         } else {
            return var0;
         }
      }
   }

   // $FF: renamed from: d (java.io.File) void
   private static void method_253(File var0) throws IOException {
      File[] var1;
      if(var0.isDirectory() && (var1 = var0.listFiles()) != null) {
         File[] var2 = var1;
         int var3 = var1.length;

         for(int var4 = 0; var4 < var3; ++var4) {
            method_253(var2[var4]);
         }
      }

      if(var0.exists() && !var0.delete()) {
         throw new IOException(String.format("Failed to delete \'%s\'", new Object[]{var0.getAbsolutePath()}));
      }
   }
}
