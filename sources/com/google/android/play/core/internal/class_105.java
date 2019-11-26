package com.google.android.play.core.internal;

import com.google.android.play.core.internal.class_111;
import com.google.android.play.core.internal.class_118;
import com.google.android.play.core.internal.class_17;
import java.io.File;
import java.util.Set;

// $FF: renamed from: com.google.android.play.core.internal.ap
final class class_105 implements class_17 {

   // $FF: renamed from: <init> () void
   void method_318() {
      super();
   }

   // $FF: renamed from: a (java.lang.ClassLoader, java.util.Set) void
   public final void method_37(ClassLoader var1, Set var2) {
      class_118 var10002 = new class_118;
      var10002.method_372();
      class_111.method_360(var1, var2, var10002);
   }

   // $FF: renamed from: a (java.lang.ClassLoader, java.io.File, java.io.File, boolean) boolean
   public final boolean method_38(ClassLoader var1, File var2, File var3, boolean var4) {
      return class_111.method_361(var1, var2, var3, var4, "zip");
   }
}
