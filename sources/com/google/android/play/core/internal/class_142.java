package com.google.android.play.core.internal;

import com.google.android.play.core.internal.class_123;
import com.google.android.play.core.internal.class_15;
import java.io.File;

// $FF: renamed from: com.google.android.play.core.internal.ah
final class class_142 implements class_15 {

   // $FF: renamed from: <init> () void
   void method_479() {
      super();
   }

   // $FF: renamed from: a (java.lang.Object, java.io.File, java.io.File) boolean
   public final boolean method_35(Object var1, File var2, File var3) {
      String var4 = (String)class_123.method_404(var1.getClass(), "optimizedPathFor", String.class, File.class, var2, File.class, var3);
      return (new File(var4)).exists();
   }
}
