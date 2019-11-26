package com.google.android.play.core.internal;

import com.google.android.play.core.internal.class_115;
import com.google.android.play.core.internal.class_118;
import com.google.android.play.core.internal.class_123;
import com.google.android.play.core.internal.class_136;
import com.google.android.play.core.internal.class_137;
import com.google.android.play.core.internal.class_142;
import com.google.android.play.core.internal.class_146;
import com.google.android.play.core.internal.class_17;
import com.google.android.play.core.internal.class_6;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// $FF: renamed from: com.google.android.play.core.internal.al
final class class_111 implements class_17 {

   // $FF: renamed from: <init> () void
   void method_359() {
      super();
   }

   // $FF: renamed from: a (java.lang.ClassLoader, java.util.Set) void
   public final void method_37(ClassLoader var1, Set var2) {
      class_118 var10002 = new class_118;
      var10002.method_372();
      method_360(var1, var2, var10002);
   }

   // $FF: renamed from: a (java.lang.ClassLoader, java.util.Set, com.google.android.play.core.internal.aq) void
   public static void method_360(ClassLoader var0, Set var1, class_6 var2) {
      if(!var1.isEmpty()) {
         HashSet var3 = new HashSet();
         Iterator var4 = var1.iterator();

         while(var4.hasNext()) {
            File var5 = (File)var4.next();
            var3.add(var5.getParentFile());
         }

         Object var15 = class_146.method_500(var0);
         Class var16 = List.class;
         List var6 = (List)class_123.method_405(var15, "nativeLibraryDirectories", var16).method_425();
         var3.removeAll(var6);
         var6.addAll(var3);
         ArrayList var7 = new ArrayList();
         Object[] var8 = var2.method_6(var15, new ArrayList(var3), (File)null, var7);
         if(var7.isEmpty()) {
            class_123.method_406(var15, "nativeLibraryPathElements", Object.class).method_430(var8);
         } else {
            class_137 var10000 = new class_137;
            var10000.method_461("Error in makePathElements");
            class_137 var9 = var10000;
            ArrayList var12;
            int var13 = (var12 = (ArrayList)var7).size();
            int var14 = 0;
            Object var10 = null;

            while(var14 < var13) {
               Object var17 = var12.get(var14);
               ++var14;
               IOException var11 = (IOException)var17;
               class_136.method_453(var9, var11);
            }

            throw var9;
         }
      }
   }

   // $FF: renamed from: a (java.lang.ClassLoader, java.io.File, java.io.File, boolean) boolean
   public final boolean method_38(ClassLoader var1, File var2, File var3, boolean var4) {
      return method_361(var1, var2, var3, var4, "zip");
   }

   // $FF: renamed from: a (java.lang.ClassLoader, java.io.File, java.io.File, boolean, java.lang.String) boolean
   public static boolean method_361(ClassLoader var0, File var1, File var2, boolean var3, String var4) {
      class_115 var10004 = new class_115;
      var10004.method_369();
      class_142 var10006 = new class_142;
      var10006.method_479();
      return class_146.method_499(var0, var1, var2, var3, var10004, var4, var10006);
   }

   // $FF: renamed from: b (java.lang.Object, java.util.List, java.io.File, java.util.List) java.lang.Object[]
   private static Object[] method_362(Object var0, List var1, File var2, List var3) {
      return (Object[])class_123.method_402(var0, "makePathElements", Object[].class, List.class, var1, File.class, var2, List.class, var3);
   }

   // $FF: renamed from: a (java.lang.Object, java.util.List, java.io.File, java.util.List) java.lang.Object[]
   // $FF: synthetic method
   static Object[] method_363(Object var0, List var1, File var2, List var3) {
      return method_362(var0, var1, var2, var3);
   }
}
