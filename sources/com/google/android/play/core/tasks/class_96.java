package com.google.android.play.core.tasks;

import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.class_93;

// $FF: renamed from: com.google.android.play.core.tasks.f
final class class_96 implements Runnable {

   // $FF: renamed from: a com.google.android.play.core.tasks.Task
   // $FF: synthetic field
   private final Task field_176;
   // $FF: renamed from: b com.google.android.play.core.tasks.e
   // $FF: synthetic field
   private final class_93 field_177;


   // $FF: renamed from: <init> (com.google.android.play.core.tasks.e, com.google.android.play.core.tasks.Task) void
   void method_285(class_93 var1, Task var2) {
      this.field_177 = var1;
      this.field_176 = var2;
      super();
   }

   public final void run() {
      synchronized(class_93.method_278(this.field_177)) {
         if(class_93.method_279(this.field_177) != null) {
            class_93.method_279(this.field_177).onSuccess(this.field_176.getResult());
         }

      }
   }
}
