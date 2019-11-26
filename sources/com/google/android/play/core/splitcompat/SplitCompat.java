package com.google.android.play.core.splitcompat;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import android.os.Build.VERSION;
import android.util.Log;
import com.google.android.play.core.internal.class_123;
import com.google.android.play.core.internal.class_136;
import com.google.android.play.core.internal.class_137;
import com.google.android.play.core.internal.class_138;
import com.google.android.play.core.internal.class_144;
import com.google.android.play.core.internal.class_145;
import com.google.android.play.core.internal.class_17;
import com.google.android.play.core.splitinstall.class_56;
import com.google.android.play.core.splitinstall.class_58;
import com.google.android.play.core.splitinstall.class_66;
import com.google.android.play.core.splitinstall.class_67;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import java.util.zip.ZipFile;

public class SplitCompat {

   // $FF: renamed from: a java.util.concurrent.atomic.AtomicReference
   private static final AtomicReference sInstance;
   // $FF: renamed from: b com.google.android.play.core.splitcompat.e
   private final SplitFileLogic mSplitFileLogic;
   // $FF: renamed from: c java.util.Set
   private final Set field_162;


   // $FF: renamed from: a (android.content.Context) boolean
   public static boolean method_257(Context var0) {
      return doInstall(var0, true);
   }

   public static boolean install(Context var0) {
      return doInstall(var0, false);
   }

   public static boolean installActivity(Context var0) {
      if(method_258()) {
         return false;
      } else {
         SplitCompat splitCompat;
         if((splitCompat = (SplitCompat) sInstance.get()) == null) {
            throw new IllegalStateException("SplitCompat.installActivity can only be called if SplitCompat.install is first called at startup on application context.");
         } else {
            try {
               splitCompat.method_264(var0);
               return true;
            } catch (Exception e) {
               Log.e("SplitCompat", "Error installing additional splits", e);
               return false;
            }
         }
      }
   }

   // $FF: renamed from: b () boolean
   private static boolean method_258() {
      return VERSION.SDK_INT < 21;
   }

   // $FF: renamed from: c () java.util.Set
   private final synchronized Set method_259() {
      return new HashSet(this.field_162);
   }

   // $FF: renamed from: a (android.content.Context, boolean) boolean
   private static boolean doInstall(Context var0, boolean var1) {
      if(method_258()) {
         return false;
      } else {
         AtomicReference var10000 = sInstance;
         SplitCompat var10002 = new SplitCompat();
         var10002.method_261(var0);
         boolean var2 = var10000.compareAndSet((Object)null, var10002);
         SplitCompat splitCompat = (SplitCompat) sInstance.get();
         if(var2) {
            class_138 var6 = new class_138;
            Executor var10003 = class_89.method_255();
            class_144 var10004 = new class_144;
            SplitFileLogic var10007 = splitCompat.mSplitFileLogic;
            class_123 var10008 = new class_123;
            var10008.method_410();
            var10004.method_482(var0, var10007, var10008);
            SplitFileLogic var10005 = splitCompat.mSplitFileLogic;
            class_67 var10006 = new class_67;
            var10006.method_154();
            var6.method_463(var0, var10003, var10004, var10005, var10006);
            class_58.method_117(var6);
            class_76 var7 = new class_76;
            var7.method_199(splitCompat);
            class_56.method_109(var7);
            Executor var8 = class_89.method_255();
            class_79 var10001 = new class_79;
            var10001.method_204(var0);
            var8.execute(var10001);
         }

         try {
            splitCompat.method_263(var0, var1);
            return true;
         } catch (Exception var5) {
            Log.e("SplitCompat", "Error installing additional splits", var5);
            return false;
         }
      }
   }

   // $FF: renamed from: <init> (android.content.Context) void
   private void method_261(Context var1) {
      super();
      this.field_162 = new HashSet();

      try {
         SplitFileLogic var10001 = new SplitFileLogic;
         var10001.method_230(var1);
         this.mSplitFileLogic = var10001;
      } catch (IOException var3) {
         class_137 var10000 = new class_137;
         var10000.method_462("Failed to initialize FileStorage", var3);
         throw var10000;
      }
   }

   // $FF: renamed from: a () boolean
   public static boolean method_262() {
      return sInstance.get() != null;
   }

   // $FF: renamed from: b (android.content.Context, boolean) void
   private final synchronized void method_263(Context var1, boolean syncDelete) throws IOException {
      Executor var10000;
      if(syncDelete) {
         this.mSplitFileLogic.method_232();
      } else {
         var10000 = class_89.method_255();
         class_73 var10001 = new class_73;
         var10001.method_194(this);
         var10000.execute(var10001);
      }

      List var3 = method_267(var1);
      List var15 = var3;
      SplitCompat var14 = this;
      Set var17 = this.mSplitFileLogic.method_245();
      HashSet var18 = new HashSet();
      Iterator var19 = var17.iterator();

      while(var19.hasNext()) {
         String var20 = ((class_74)var19.next()).method_197();
         if(var15.contains(var20)) {
            if(syncDelete) {
               var14.mSplitFileLogic.method_251(var20);
            } else {
               var18.add(var20);
            }

            var19.remove();
         }
      }

      if(!var18.isEmpty()) {
         var10000 = class_89.method_255();
         class_77 var27 = new class_77;
         var27.method_200(var14, var18);
         var10000.execute(var27);
      }

      Set var24 = var17;
      HashSet var25 = new HashSet();
      Iterator var28 = var17.iterator();

      while(var28.hasNext()) {
         String var32;
         if(!class_66.method_149(var32 = ((class_74)var28.next()).method_197())) {
            var25.add(var32);
         }
      }

      var28 = var3.iterator();

      while(var28.hasNext()) {
         String var30;
         if(!class_66.method_149(var30 = (String)var28.next())) {
            var25.add(var30);
         }
      }

      HashSet var29 = new HashSet(var24.size());
      Iterator var31 = var24.iterator();

      while(var31.hasNext()) {
         class_74 var33;
         if(class_66.method_148((var33 = (class_74)var31.next()).method_197()) || var25.contains(class_66.method_150(var33.method_197()))) {
            var29.add(var33);
         }
      }

      class_86 var26 = new class_86;
      var26.method_217(this.mSplitFileLogic);
      class_86 var6 = var26;
      class_17 var7 = class_145.method_488();
      ClassLoader var8 = var1.getClassLoader();
      if(syncDelete) {
         Set var9 = var6.method_218();
         var7.method_37(var8, var9);
      } else {
         Iterator var21 = var29.iterator();

         while(var21.hasNext()) {
            Set var10;
            if((var10 = var6.method_219((class_74)var21.next())) == null) {
               var21.remove();
            } else {
               var7.method_37(var8, var10);
            }
         }
      }

      HashSet var22 = new HashSet();
      Iterator var23 = var29.iterator();

      class_74 var11;
      while(var23.hasNext()) {
         if(!method_266(var11 = (class_74)var23.next()) || var7.method_38(var8, this.mSplitFileLogic.method_240(var11.method_197()), var11.method_196(), syncDelete)) {
            var22.add(var11.method_196());
         } else {
            String var13 = String.valueOf(var11.method_196());
            Log.w("SplitCompat", (new StringBuilder(24 + String.valueOf(var13).length())).append("split was not installed ").append(var13).toString());
         }
      }

      method_265(var1, var22);
      var23 = var29.iterator();

      while(var23.hasNext()) {
         var11 = (class_74)var23.next();
         String var12;
         if(var22.contains(var11.method_196())) {
            var12 = var11.method_197();
            Log.d("SplitCompat", (new StringBuilder(30 + String.valueOf(var12).length())).append("Split \'").append(var12).append("\' installation emulated").toString());
            this.field_162.add(var11.method_197());
         } else {
            var12 = var11.method_197();
            Log.d("SplitCompat", (new StringBuilder(35 + String.valueOf(var12).length())).append("Split \'").append(var12).append("\' installation not emulated.").toString());
         }
      }

   }

   // $FF: renamed from: b (android.content.Context) void
   private final synchronized void method_264(Context var1) throws IOException {
      HashSet var2 = new HashSet();
      SplitCompat var5;
      Iterator var3 = ((var5 = (SplitCompat) sInstance.get()) == null?Collections.emptySet():var5.method_259()).iterator();

      while(var3.hasNext()) {
         String var4 = (String)var3.next();
         var2.add(this.mSplitFileLogic.method_234(var4));
      }

      method_265(var1, var2);
   }

   // $FF: renamed from: a (android.content.Context, java.util.Set) void
   private static void method_265(Context var0, Set var1) {
      AssetManager var2 = var0.getAssets();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         File var4 = (File)var3.next();
         int var5 = ((Integer)class_123.method_401(var2, "addAssetPath", Integer.class, String.class, var4.getPath())).intValue();
         Log.d("SplitCompat", (new StringBuilder(39)).append("addAssetPath completed with ").append(var5).toString());
      }

   }

   // $FF: renamed from: a (com.google.android.play.core.splitcompat.q) boolean
   private static boolean method_266(class_74 var0) throws IOException {
      ZipFile var1 = null;

      try {
         boolean var2 = (var1 = new ZipFile(var0.method_196())).getEntry("classes.dex") != null;
         var1.close();
         return var2;
      } catch (IOException var5) {
         if(var1 != null) {
            try {
               var1.close();
            } catch (IOException var4) {
               class_136.method_453(var5, var4);
            }
         }

         throw var5;
      }
   }

   // $FF: renamed from: c (android.content.Context) java.util.List
   private static List method_267(Context var0) throws IOException {
      String var1 = var0.getPackageName();

      try {
         Object var2;
         PackageInfo var4;
         if((var4 = var0.getPackageManager().getPackageInfo(var1, 0)).splitNames == null) {
            var2 = new ArrayList();
         } else {
            var2 = Arrays.asList(var4.splitNames);
         }

         return (List)var2;
      } catch (NameNotFoundException var5) {
         throw new IOException(String.format("Cannot load data for application \'%s\'", new Object[]{var1}), var5);
      }
   }

   // $FF: renamed from: a (com.google.android.play.core.splitcompat.SplitCompat) java.util.Set
   // $FF: synthetic method
   static Set method_268(SplitCompat var0) {
      return var0.method_259();
   }

   // $FF: renamed from: b (com.google.android.play.core.splitcompat.SplitCompat) com.google.android.play.core.splitcompat.e
   // $FF: synthetic method
   static SplitFileLogic method_269(SplitCompat var0) {
      return var0.mSplitFileLogic;
   }

   // $FF: renamed from: <clinit> () void
   static void method_270() {
      sInstance = new AtomicReference((Object)null);
   }
}
