package com.google.android.play.core.tasks;

import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.class_94;

// $FF: renamed from: com.google.android.play.core.tasks.b
final class class_90 implements Runnable {

   // $FF: renamed from: a com.google.android.play.core.tasks.Task
   // $FF: synthetic field
   private final Task field_163;
   // $FF: renamed from: b com.google.android.play.core.tasks.a
   // $FF: synthetic field
   private final class_94 field_164;


   // $FF: renamed from: <init> (com.google.android.play.core.tasks.a, com.google.android.play.core.tasks.Task) void
   void method_272(class_94 var1, Task var2) {
      this.field_164 = var1;
      this.field_163 = var2;
      super();
   }

   public final void run() {
      synchronized(class_94.method_281(this.field_164)) {
         if(class_94.method_282(this.field_164) != null) {
            class_94.method_282(this.field_164).onComplete(this.field_163);
         }

      }
   }
}
