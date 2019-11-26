package com.google.android.play.core.internal;

import com.google.android.play.core.tasks.class_98;

// $FF: renamed from: com.google.android.play.core.internal.r
public abstract class class_23 implements Runnable {

   // $FF: renamed from: a com.google.android.play.core.tasks.i
   private final class_98 field_14;


   // $FF: renamed from: <init> () void
   void method_60() {
      super();
      this.field_14 = null;
   }

   // $FF: renamed from: <init> (com.google.android.play.core.tasks.i) void
   public void method_61(class_98 var1) {
      super();
      this.field_14 = var1;
   }

   public final void run() {
      try {
         this.method_63();
      } catch (Exception var2) {
         if(this.field_14 != null) {
            this.field_14.method_292(var2);
         }

      }
   }

   // $FF: renamed from: b () com.google.android.play.core.tasks.i
   final class_98 method_62() {
      return this.field_14;
   }

   // $FF: renamed from: a () void
   protected abstract void method_63();
}
