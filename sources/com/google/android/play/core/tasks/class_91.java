package com.google.android.play.core.tasks;

import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.class_92;

// $FF: renamed from: com.google.android.play.core.tasks.c
final class class_91 implements Runnable {

   // $FF: renamed from: a com.google.android.play.core.tasks.Task
   // $FF: synthetic field
   private final Task field_165;
   // $FF: renamed from: b com.google.android.play.core.tasks.d
   // $FF: synthetic field
   private final class_92 field_166;


   // $FF: renamed from: <init> (com.google.android.play.core.tasks.d, com.google.android.play.core.tasks.Task) void
   void method_273(class_92 var1, Task var2) {
      this.field_166 = var1;
      this.field_165 = var2;
      super();
   }

   public final void run() {
      synchronized(class_92.method_275(this.field_166)) {
         if(class_92.method_276(this.field_166) != null) {
            class_92.method_276(this.field_166).onFailure(this.field_165.getException());
         }

      }
   }
}
