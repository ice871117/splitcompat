package com.google.android.play.core.internal;

import com.google.android.play.core.internal.class_141;
import com.google.android.play.core.internal.class_142;
import com.google.android.play.core.internal.class_146;
import com.google.android.play.core.internal.class_17;
import java.io.File;
import java.util.Set;

// $FF: renamed from: com.google.android.play.core.internal.am
final class class_109 implements class_17 {

   // $FF: renamed from: <init> () void
   void method_328() {
      super();
   }

   // $FF: renamed from: a (java.lang.ClassLoader, java.util.Set) void
   public final void method_37(ClassLoader var1, Set var2) {
      class_146.method_498(var1, var2);
   }

   // $FF: renamed from: a (java.lang.ClassLoader, java.io.File, java.io.File, boolean) boolean
   public final boolean method_38(ClassLoader var1, File var2, File var3, boolean var4) {
      class_141 var10004 = new class_141;
      var10004.method_478();
      class_142 var10006 = new class_142;
      var10006.method_479();
      return class_146.method_499(var1, var2, var3, var4, var10004, "zip", var10006);
   }
}
