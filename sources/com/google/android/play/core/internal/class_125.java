package com.google.android.play.core.internal;

import android.util.Log;
import com.google.android.play.core.internal.class_123;
import com.google.android.play.core.internal.class_15;
import java.io.File;

// $FF: renamed from: com.google.android.play.core.internal.at
final class class_125 implements class_15 {

   // $FF: renamed from: <init> () void
   void method_419() {
      super();
   }

   // $FF: renamed from: a (java.lang.Object, java.io.File, java.io.File) boolean
   public final boolean method_35(Object var1, File var2, File var3) {
      try {
         return !((Boolean)class_123.method_403(Class.forName("dalvik.system.DexFile"), "isDexOptNeeded", Boolean.class, String.class, var2.getPath())).booleanValue();
      } catch (ClassNotFoundException var4) {
         Log.e("SplitCompat", "Unexpected missing dalvik.system.DexFile.");
         return false;
      }
   }
}
