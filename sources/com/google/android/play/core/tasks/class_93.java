package com.google.android.play.core.tasks;

import com.google.android.play.core.tasks.OnSuccessListener;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.class_5;
import com.google.android.play.core.tasks.class_96;
import java.util.concurrent.Executor;

// $FF: renamed from: com.google.android.play.core.tasks.e
final class class_93 implements class_5 {

   // $FF: renamed from: a java.util.concurrent.Executor
   private final Executor field_170;
   // $FF: renamed from: b java.lang.Object
   private final Object field_171;
   // $FF: renamed from: c com.google.android.play.core.tasks.OnSuccessListener
   private OnSuccessListener field_172;


   // $FF: renamed from: <init> (java.util.concurrent.Executor, com.google.android.play.core.tasks.OnSuccessListener) void
   public void method_277(Executor var1, OnSuccessListener var2) {
      super();
      this.field_171 = new Object();
      this.field_170 = var1;
      this.field_172 = var2;
   }

   // $FF: renamed from: a (com.google.android.play.core.tasks.Task) void
   public final void method_5(Task var1) {
      if(var1.isSuccessful()) {
         Object var2 = this.field_171;
         synchronized(this.field_171) {
            if(this.field_172 == null) {
               return;
            }
         }

         Executor var10000 = this.field_170;
         class_96 var10001 = new class_96;
         var10001.method_285(this, var1);
         var10000.execute(var10001);
      }

   }

   // $FF: renamed from: a (com.google.android.play.core.tasks.e) java.lang.Object
   // $FF: synthetic method
   static Object method_278(class_93 var0) {
      return var0.field_171;
   }

   // $FF: renamed from: b (com.google.android.play.core.tasks.e) com.google.android.play.core.tasks.OnSuccessListener
   // $FF: synthetic method
   static OnSuccessListener method_279(class_93 var0) {
      return var0.field_172;
   }
}
