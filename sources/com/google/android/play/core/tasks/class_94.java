package com.google.android.play.core.tasks;

import com.google.android.play.core.tasks.OnCompleteListener;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.class_5;
import com.google.android.play.core.tasks.class_90;
import java.util.concurrent.Executor;

// $FF: renamed from: com.google.android.play.core.tasks.a
final class class_94 implements class_5 {

   // $FF: renamed from: a java.util.concurrent.Executor
   private final Executor field_173;
   // $FF: renamed from: b java.lang.Object
   private final Object field_174;
   // $FF: renamed from: c com.google.android.play.core.tasks.OnCompleteListener
   private OnCompleteListener field_175;


   // $FF: renamed from: <init> (java.util.concurrent.Executor, com.google.android.play.core.tasks.OnCompleteListener) void
   public void method_280(Executor var1, OnCompleteListener var2) {
      super();
      this.field_174 = new Object();
      this.field_173 = var1;
      this.field_175 = var2;
   }

   // $FF: renamed from: a (com.google.android.play.core.tasks.Task) void
   public final void method_5(Task var1) {
      Object var2 = this.field_174;
      synchronized(this.field_174) {
         if(this.field_175 == null) {
            return;
         }
      }

      Executor var10000 = this.field_173;
      class_90 var10001 = new class_90;
      var10001.method_272(this, var1);
      var10000.execute(var10001);
   }

   // $FF: renamed from: a (com.google.android.play.core.tasks.a) java.lang.Object
   // $FF: synthetic method
   static Object method_281(class_94 var0) {
      return var0.field_174;
   }

   // $FF: renamed from: b (com.google.android.play.core.tasks.a) com.google.android.play.core.tasks.OnCompleteListener
   // $FF: synthetic method
   static OnCompleteListener method_282(class_94 var0) {
      return var0.field_175;
   }
}
