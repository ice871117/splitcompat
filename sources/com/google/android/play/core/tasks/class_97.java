package com.google.android.play.core.tasks;

import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.class_5;
import java.util.ArrayDeque;
import java.util.Queue;

// $FF: renamed from: com.google.android.play.core.tasks.g
final class class_97 {

   // $FF: renamed from: a java.lang.Object
   private final Object field_178;
   // $FF: renamed from: b java.util.Queue
   private Queue field_179;
   // $FF: renamed from: c boolean
   private boolean field_180;


   // $FF: renamed from: <init> () void
   void method_286() {
      super();
      this.field_178 = new Object();
   }

   // $FF: renamed from: a (com.google.android.play.core.tasks.h) void
   public final void method_287(class_5 var1) {
      Object var2 = this.field_178;
      synchronized(this.field_178) {
         if(this.field_179 == null) {
            this.field_179 = new ArrayDeque();
         }

         this.field_179.add(var1);
      }
   }

   // $FF: renamed from: a (com.google.android.play.core.tasks.Task) void
   public final void method_288(Task var1) {
      Object var2 = this.field_178;
      synchronized(this.field_178) {
         if(this.field_179 == null || this.field_180) {
            return;
         }

         this.field_180 = true;
      }

      while(true) {
         Object var3 = this.field_178;
         class_5 var7;
         synchronized(this.field_178) {
            if((var7 = (class_5)this.field_179.poll()) == null) {
               this.field_180 = false;
               return;
            }
         }

         var7.method_5(var1);
      }
   }
}
