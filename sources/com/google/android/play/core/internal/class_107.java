package com.google.android.play.core.internal;

import com.google.android.play.core.internal.class_111;
import com.google.android.play.core.internal.class_115;
import com.google.android.play.core.internal.class_124;
import com.google.android.play.core.internal.class_125;
import com.google.android.play.core.internal.class_146;
import com.google.android.play.core.internal.class_17;
import java.io.File;
import java.util.Set;

// $FF: renamed from: com.google.android.play.core.internal.ar
final class class_107 implements class_17 {

   // $FF: renamed from: <init> () void
   void method_320() {
      super();
   }

   // $FF: renamed from: a (java.lang.ClassLoader, java.util.Set) void
   public final void method_37(ClassLoader var1, Set var2) {
      method_321(var1, var2);
   }

   // $FF: renamed from: b (java.lang.ClassLoader, java.util.Set) void
   static void method_321(ClassLoader var0, Set var1) {
      class_124 var10002 = new class_124;
      var10002.method_418();
      class_111.method_360(var0, var1, var10002);
   }

   // $FF: renamed from: a (java.lang.ClassLoader, java.io.File, java.io.File, boolean) boolean
   public final boolean method_38(ClassLoader var1, File var2, File var3, boolean var4) {
      return method_322(var1, var2, var3, var4);
   }

   // $FF: renamed from: b (java.lang.ClassLoader, java.io.File, java.io.File, boolean) boolean
   static boolean method_322(ClassLoader var0, File var1, File var2, boolean var3) {
      class_115 var10004 = new class_115;
      var10004.method_369();
      class_125 var10006 = new class_125;
      var10006.method_419();
      return class_146.method_499(var0, var1, var2, var3, var10004, "path", var10006);
   }
}
