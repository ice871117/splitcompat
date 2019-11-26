package com.google.android.play.core.internal;

import com.google.android.play.core.internal.class_107;
import com.google.android.play.core.internal.class_115;
import com.google.android.play.core.internal.class_121;
import com.google.android.play.core.internal.class_146;
import com.google.android.play.core.internal.class_17;
import java.io.File;
import java.util.Set;

// $FF: renamed from: com.google.android.play.core.internal.ay
final class class_119 implements class_17 {

   // $FF: renamed from: <init> () void
   void method_373() {
      super();
   }

   // $FF: renamed from: a (java.lang.ClassLoader, java.util.Set) void
   public final void method_37(ClassLoader var1, Set var2) {
      class_107.method_321(var1, var2);
   }

   // $FF: renamed from: a (java.lang.ClassLoader, java.io.File, java.io.File, boolean) boolean
   public final boolean method_38(ClassLoader var1, File var2, File var3, boolean var4) {
      class_115 var10004 = new class_115;
      var10004.method_369();
      class_121 var10006 = new class_121;
      var10006.method_375();
      return class_146.method_499(var1, var2, var3, var4, var10004, "path", var10006);
   }
}
