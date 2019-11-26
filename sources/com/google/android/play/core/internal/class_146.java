package com.google.android.play.core.internal;

import android.util.Log;
import com.google.android.play.core.internal.class_123;
import com.google.android.play.core.internal.class_129;
import com.google.android.play.core.internal.class_136;
import com.google.android.play.core.internal.class_137;
import com.google.android.play.core.internal.class_141;
import com.google.android.play.core.internal.class_142;
import com.google.android.play.core.internal.class_15;
import com.google.android.play.core.internal.class_16;
import com.google.android.play.core.internal.class_17;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// $FF: renamed from: com.google.android.play.core.internal.af
final class class_146 implements class_17 {

   // $FF: renamed from: <init> () void
   void method_497() {
      super();
   }

   // $FF: renamed from: a (java.lang.ClassLoader, java.util.Set) void
   public final void method_37(ClassLoader var1, Set var2) {
      method_498(var1, var2);
   }

   // $FF: renamed from: a (java.lang.ClassLoader, java.io.File, java.io.File, boolean) boolean
   public final boolean method_38(ClassLoader var1, File var2, File var3, boolean var4) {
      class_141 var10004 = new class_141;
      var10004.method_478();
      class_142 var10006 = new class_142;
      var10006.method_479();
      return method_499(var1, var2, var3, var4, var10004, "zip", var10006);
   }

   // $FF: renamed from: b (java.lang.ClassLoader, java.util.Set) void
   static void method_498(ClassLoader var0, Set var1) {
      if(!var1.isEmpty()) {
         HashSet var2 = new HashSet();
         Iterator var3 = var1.iterator();

         while(var3.hasNext()) {
            File var4 = (File)var3.next();
            String var10002 = String.valueOf(var4.getParentFile().getAbsolutePath());
            Log.d("Splitcompat", var10002.length() != 0?"Adding native library parent directory: ".concat(var10002):new String("Adding native library parent directory: "));
            var2.add(var4.getParentFile());
         }

         class_129 var6 = class_123.method_406(method_500(var0), "nativeLibraryDirectories", File.class);
         var2.removeAll(Arrays.asList((File[])var6.method_425()));
         int var5 = var2.size();
         Log.d("Splitcompat", (new StringBuilder(30)).append("Adding directories ").append(var5).toString());
         var6.method_431(var2);
      }
   }

   // $FF: renamed from: a (java.lang.ClassLoader, java.io.File, java.io.File, boolean, com.google.android.play.core.internal.aj, java.lang.String, com.google.android.play.core.internal.ak) boolean
   static boolean method_499(ClassLoader var0, File var1, File var2, boolean var3, class_16 var4, String var5, class_15 var6) {
      ArrayList var7 = new ArrayList();
      Object var8;
      class_129 var9;
      List var10 = Arrays.asList((Object[])(var9 = class_123.method_406(var8 = method_500(var0), "dexElements", Object.class)).method_425());
      ArrayList var11 = new ArrayList();
      Iterator var12 = var10.iterator();

      Object var13;
      while(var12.hasNext()) {
         var13 = var12.next();
         var11.add((File)class_123.method_405(var13, var5, File.class).method_425());
      }

      if(var11.contains(var2)) {
         return true;
      } else if(!var3 && !var6.method_35(var8, var2, var1)) {
         String var10002 = String.valueOf(var2.getPath());
         Log.w("SplitCompat", var10002.length() != 0?"Should be optimized ".concat(var10002):new String("Should be optimized "));
         return false;
      } else {
         var9.method_428(var4.method_36(var8, new ArrayList(Collections.singleton(var2)), var1, var7));
         if(var7.isEmpty()) {
            return true;
         } else {
            class_137 var10000 = new class_137;
            var10000.method_461("DexPathList.makeDexElement failed");
            class_137 var18 = var10000;
            ArrayList var15;
            int var16 = (var15 = (ArrayList)var7).size();
            int var17 = 0;
            var13 = null;

            while(var17 < var16) {
               Object var19 = var15.get(var17);
               ++var17;
               IOException var14 = (IOException)var19;
               Log.e("SplitCompat", "DexPathList.makeDexElement failed", var14);
               class_136.method_453(var18, var14);
            }

            class_123.method_406(var8, "dexElementsSuppressedExceptions", IOException.class).method_429(var7);
            throw var18;
         }
      }
   }

   // $FF: renamed from: a (java.lang.ClassLoader) java.lang.Object
   static Object method_500(ClassLoader var0) {
      return class_123.method_405(var0, "pathList", Object.class).method_425();
   }
}
