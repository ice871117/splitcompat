package com.google.android.play.core.splitinstall;

import com.google.android.play.core.splitinstall.class_2;
import java.util.concurrent.atomic.AtomicReference;

// $FF: renamed from: com.google.android.play.core.splitinstall.h
public final class class_56 {

   // $FF: renamed from: a java.util.concurrent.atomic.AtomicReference
   private static final AtomicReference field_62;


   // $FF: renamed from: a () com.google.android.play.core.splitinstall.j
   static class_2 method_108() {
      return (class_2)field_62.get();
   }

   // $FF: renamed from: a (com.google.android.play.core.splitinstall.j) void
   public static void method_109(class_2 var0) {
      field_62.compareAndSet((Object)null, var0);
   }

   // $FF: renamed from: <clinit> () void
   static void method_110() {
      field_62 = new AtomicReference((Object)null);
   }
}
