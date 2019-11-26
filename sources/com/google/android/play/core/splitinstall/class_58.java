package com.google.android.play.core.splitinstall;

import com.google.android.play.core.splitinstall.class_0;
import com.google.android.play.core.splitinstall.class_1;
import java.util.concurrent.atomic.AtomicReference;

// $FF: renamed from: com.google.android.play.core.splitinstall.f
public enum class_58 implements class_0 {

   // $FF: renamed from: a com.google.android.play.core.splitinstall.f
   field_65;
   // $FF: renamed from: b java.util.concurrent.atomic.AtomicReference
   private static final AtomicReference field_66;


   // $FF: renamed from: <init> (java.lang.String, int) void
   private void method_116(String var1, int var2) {
      super(var1, 0);
   }

   // $FF: renamed from: a () com.google.android.play.core.splitinstall.c
   public final class_1 method_0() {
      return (class_1)field_66.get();
   }

   // $FF: renamed from: a (com.google.android.play.core.splitinstall.c) void
   public static void method_117(class_1 var0) {
      field_66.compareAndSet((Object)null, var0);
   }

   // $FF: renamed from: <clinit> () void
   static void method_118() {
      class_58 var10000 = new class_58;
      var10000.method_116("INSTANCE", 0);
      field_65 = var10000;
      class_58[] var0 = new class_58[]{field_65};
      field_66 = new AtomicReference((Object)null);
   }
}
