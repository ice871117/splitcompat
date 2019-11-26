package com.google.android.play.core.splitcompat;

import android.os.Build;
import android.util.Log;
import com.google.android.play.core.internal.class_136;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

// $FF: renamed from: com.google.android.play.core.splitcompat.d
public final class class_86 {

   // $FF: renamed from: a java.util.regex.Pattern
   private static final Pattern field_155;
   // $FF: renamed from: b com.google.android.play.core.splitcompat.e
   private final SplitFileLogic field_156;


   // $FF: renamed from: <init> (com.google.android.play.core.splitcompat.e) void
   void method_217(SplitFileLogic var1) throws IOException {
      super();
      this.field_156 = var1;
   }

   // $FF: renamed from: a () java.util.Set
   final Set method_218() throws IOException {
      Log.d("SplitCompat", "NativeLibraryExtractor: synchronizing native libraries");
      Set var1 = this.field_156.method_245();
      Set var3 = var1;
      class_86 var2 = this;
      Iterator var5 = this.field_156.method_246().iterator();

      while(var5.hasNext()) {
         String var6 = (String)var5.next();
         boolean var7 = false;
         Iterator var8 = var3.iterator();

         while(true) {
            if(var8.hasNext()) {
               if(!((class_74)var8.next()).method_197().equals(var6)) {
                  continue;
               }

               var7 = true;
            }

            if(!var7) {
               Log.i("SplitCompat", String.format("NativeLibraryExtractor: extracted split \'%s\' has no corresponding split; deleting", new Object[]{var6}));
               var2.field_156.method_247(var6);
            }
            break;
         }
      }

      var2 = this;
      HashSet var4 = new HashSet();
      var5 = var1.iterator();

      while(var5.hasNext()) {
         class_74 var14 = (class_74)var5.next();
         HashSet var15 = new HashSet();
         class_82 var10001 = new class_82;
         var10001.method_210(var2, var15, var14);
         method_220(var14, var10001);
         HashSet var10 = var15;
         class_74 var9 = var14;
         class_86 var16 = var2;
         Iterator var12 = var2.field_156.method_249(var14.method_197()).iterator();

         while(var12.hasNext()) {
            File var13 = (File)var12.next();
            if(!var10.contains(var13)) {
               Log.i("SplitCompat", String.format("NativeLibraryExtractor: file \'%s\' found in split \'%s\' that is not in the split file \'%s\'; removing", new Object[]{var13.getAbsolutePath(), var9.method_197(), var9.method_196().getAbsolutePath()}));
               var16.field_156.method_248(var13);
            }
         }

         var4.addAll(var15);
      }

      return var4;
   }

   // $FF: renamed from: a (com.google.android.play.core.splitcompat.q) java.util.Set
   final Set method_219(class_74 var1) throws IOException {
      AtomicBoolean var2 = new AtomicBoolean(true);
      HashSet var3 = new HashSet();
      class_85 var10001 = new class_85;
      var10001.method_216(this, var1, var3, var2);
      method_220(var1, var10001);
      return var2.get()?var3:null;
   }

   // $FF: renamed from: a (com.google.android.play.core.splitcompat.q, com.google.android.play.core.splitcompat.k) void
   private static void method_220(class_74 var0, class_4 var1) throws IOException {
      ZipFile var2 = null;

      try {
         ZipFile var10000 = var2 = new ZipFile(var0.method_196());
         String var6 = var0.method_197();
         String var16 = var6;
         ZipFile var15 = var10000;
         HashMap var17 = new HashMap();
         Enumeration var18 = var15.entries();

         while(var18.hasMoreElements()) {
            ZipEntry var19;
            String var20 = (var19 = (ZipEntry)var18.nextElement()).getName();
            Matcher var21;
            if((var21 = field_155.matcher(var20)).matches()) {
               String var22 = var21.group(1);
               String var23 = var21.group(2);
               Log.d("SplitCompat", String.format("NativeLibraryExtractor: split \'%s\' has native library \'%s\' for ABI \'%s\'", new Object[]{var16, var23, var22}));
               Object var24;
               if((var24 = (Set)var17.get(var22)) == null) {
                  var24 = new HashSet();
                  var17.put(var22, var24);
               }

               class_78 var10001 = new class_78;
               var10001.method_201(var19, var23);
               ((Set)var24).add(var10001);
            }
         }

         HashMap var7 = var17;
         HashMap var8 = new HashMap();
         String[] var9 = Build.SUPPORTED_ABIS;
         int var10 = Build.SUPPORTED_ABIS.length;

         for(int var11 = 0; var11 < var10; ++var11) {
            String var12 = var9[var11];
            if(var7.containsKey(var12)) {
               Log.d("SplitCompat", String.format("NativeLibraryExtractor: there are native libraries for supported ABI %s; will use this ABI", new Object[]{var12}));
               Iterator var13 = ((Set)var7.get(var12)).iterator();

               while(var13.hasNext()) {
                  class_78 var14 = (class_78)var13.next();
                  if(var8.containsKey(var14.field_137)) {
                     Log.d("SplitCompat", String.format("NativeLibraryExtractor: skipping library %s for ABI %s; already present for a better ABI", new Object[]{var14.field_137, var12}));
                  } else {
                     var8.put(var14.field_137, var14);
                     Log.d("SplitCompat", String.format("NativeLibraryExtractor: using library %s for ABI %s", new Object[]{var14.field_137, var12}));
                  }
               }
            } else {
               Log.d("SplitCompat", String.format("NativeLibraryExtractor: there are no native libraries for supported ABI %s", new Object[]{var12}));
            }
         }

         HashSet var3 = new HashSet(var8.values());
         var1.method_4(var2, var3);
         var2.close();
         var2 = null;
      } catch (IOException var26) {
         if(var2 != null) {
            try {
               var2.close();
            } catch (IOException var25) {
               class_136.method_453(var26, var25);
            }
         }

         throw var26;
      }
   }

   // $FF: renamed from: a (java.util.Set, com.google.android.play.core.splitcompat.q, java.util.zip.ZipFile) java.util.Set
   private final Set method_221(Set var1, class_74 var2, ZipFile var3) throws IOException {
      HashSet var4 = new HashSet();
      class_81 var10003 = new class_81;
      var10003.method_209(var4, var2, var3);
      this.method_222(var2, var1, var10003);
      return var4;
   }

   // $FF: renamed from: a (com.google.android.play.core.splitcompat.q, java.util.Set, com.google.android.play.core.splitcompat.j) void
   private final void method_222(class_74 var1, Set var2, class_3 var3) throws IOException {
      Iterator var4 = var2.iterator();

      while(var4.hasNext()) {
         class_78 var5 = (class_78)var4.next();
         File var6;
         boolean var7 = (var6 = this.field_156.method_236(var1.method_197(), var5.field_137)).exists() && var6.length() == var5.field_138.getSize();
         var3.method_3(var5, var6, var7);
      }

   }

   // $FF: renamed from: b (java.util.zip.ZipFile, java.util.zip.ZipEntry, java.io.File) void
   private static void method_223(ZipFile var0, ZipEntry var1, File var2) throws IOException {
      byte[] var3 = new byte[4096];
      InputStream var4 = var0.getInputStream(var1);
      Throwable var5 = null;
      boolean var15 = false;

      try {
         var15 = true;
         FileOutputStream var6 = new FileOutputStream(var2);
         Throwable var7 = null;

         while(true) {
            boolean var20 = false;

            try {
               var20 = true;
               int var8;
               if((var8 = var4.read(var3)) > 0) {
                  var6.write(var3, 0, var8);
                  continue;
               }

               var20 = false;
            } catch (Throwable var21) {
               var7 = var21;
               throw var21;
            } finally {
               if(var20) {
                  method_228(var7, var6);
               }
            }

            method_228((Throwable)null, var6);
            var15 = false;
            break;
         }
      } catch (Throwable var23) {
         var5 = var23;
         throw var23;
      } finally {
         if(var15) {
            if(var4 != null) {
               method_229(var5, var4);
            }

         }
      }

      if(var4 != null) {
         method_229((Throwable)null, var4);
      }
   }

   // $FF: renamed from: a (com.google.android.play.core.splitcompat.d, com.google.android.play.core.splitcompat.q, java.util.Set, com.google.android.play.core.splitcompat.j) void
   // $FF: synthetic method
   static void method_224(class_86 var0, class_74 var1, Set var2, class_3 var3) throws IOException {
      var0.method_222(var1, var2, var3);
   }

   // $FF: renamed from: a (com.google.android.play.core.splitcompat.d, java.util.Set, com.google.android.play.core.splitcompat.q, java.util.zip.ZipFile) java.util.Set
   // $FF: synthetic method
   static Set method_225(class_86 var0, Set var1, class_74 var2, ZipFile var3) throws IOException {
      return var0.method_221(var1, var2, var3);
   }

   // $FF: renamed from: a (java.util.zip.ZipFile, java.util.zip.ZipEntry, java.io.File) void
   // $FF: synthetic method
   static void method_226(ZipFile var0, ZipEntry var1, File var2) throws IOException {
      method_223(var0, var1, var2);
   }

   // $FF: renamed from: <clinit> () void
   static void method_227() {
      field_155 = Pattern.compile("lib/([^/]+)/(.*\\.so)$");
   }

   // $FF: renamed from: a (java.lang.Throwable, java.io.FileOutputStream) void
   // $FF: synthetic method
   private static void method_228(Throwable var0, FileOutputStream var1) {
      if(var0 != null) {
         try {
            var1.close();
         } catch (Throwable var3) {
            class_136.method_453(var0, var3);
         }
      } else {
         var1.close();
      }
   }

   // $FF: renamed from: a (java.lang.Throwable, java.io.InputStream) void
   // $FF: synthetic method
   private static void method_229(Throwable var0, InputStream var1) {
      if(var0 != null) {
         try {
            var1.close();
         } catch (Throwable var3) {
            class_136.method_453(var0, var3);
         }
      } else {
         var1.close();
      }
   }
}
