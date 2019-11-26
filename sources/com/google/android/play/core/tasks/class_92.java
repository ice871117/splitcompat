package com.google.android.play.core.tasks;

import com.google.android.play.core.tasks.OnFailureListener;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.class_5;
import com.google.android.play.core.tasks.class_91;
import java.util.concurrent.Executor;

// $FF: renamed from: com.google.android.play.core.tasks.d
final class class_92 implements class_5 {

   // $FF: renamed from: a java.util.concurrent.Executor
   private final Executor field_167;
   // $FF: renamed from: b java.lang.Object
   private final Object field_168;
   // $FF: renamed from: c com.google.android.play.core.tasks.OnFailureListener
   private OnFailureListener field_169;


   // $FF: renamed from: <init> (java.util.concurrent.Executor, com.google.android.play.core.tasks.OnFailureListener) void
   public void method_274(Executor var1, OnFailureListener var2) {
      super();
      this.field_168 = new Object();
      this.field_167 = var1;
      this.field_169 = var2;
   }

   // $FF: renamed from: a (com.google.android.play.core.tasks.Task) void
   public final void method_5(Task var1) {
      if(!var1.isSuccessful()) {
         Object var2 = this.field_168;
         synchronized(this.field_168) {
            if(this.field_169 == null) {
               return;
            }
         }

         Executor var10000 = this.field_167;
         class_91 var10001 = new class_91;
         var10001.method_273(this, var1);
         var10000.execute(var10001);
      }

   }

   // $FF: renamed from: a (com.google.android.play.core.tasks.d) java.lang.Object
   // $FF: synthetic method
   static Object method_275(class_92 var0) {
      return var0.field_168;
   }

   // $FF: renamed from: b (com.google.android.play.core.tasks.d) com.google.android.play.core.tasks.OnFailureListener
   // $FF: synthetic method
   static OnFailureListener method_276(class_92 var0) {
      return var0.field_169;
   }
}
