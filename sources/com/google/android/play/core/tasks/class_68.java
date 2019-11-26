package com.google.android.play.core.tasks;

import com.google.android.play.core.internal.class_123;
import com.google.android.play.core.tasks.OnCompleteListener;
import com.google.android.play.core.tasks.OnFailureListener;
import com.google.android.play.core.tasks.OnSuccessListener;
import com.google.android.play.core.tasks.RuntimeExecutionException;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.TaskExecutors;
import com.google.android.play.core.tasks.class_92;
import com.google.android.play.core.tasks.class_93;
import com.google.android.play.core.tasks.class_94;
import com.google.android.play.core.tasks.class_97;
import java.util.concurrent.Executor;

// $FF: renamed from: com.google.android.play.core.tasks.k
final class class_68 extends Task {

   // $FF: renamed from: a java.lang.Object
   private final Object field_98;
   // $FF: renamed from: b com.google.android.play.core.tasks.g
   private final class_97 field_99;
   // $FF: renamed from: c boolean
   private boolean field_100;
   // $FF: renamed from: d java.lang.Object
   private Object field_101;
   // $FF: renamed from: e java.lang.Exception
   private Exception field_102;


   // $FF: renamed from: <init> () void
   void method_155() {
      super.method_155();
      this.field_98 = new Object();
      class_97 var10001 = new class_97;
      var10001.method_286();
      this.field_99 = var10001;
   }

   public final boolean isComplete() {
      Object var1 = this.field_98;
      synchronized(this.field_98) {
         return this.field_100;
      }
   }

   public final boolean isSuccessful() {
      Object var1 = this.field_98;
      synchronized(this.field_98) {
         return this.field_100 && this.field_102 == null;
      }
   }

   public final Object getResult() {
      Object var1 = this.field_98;
      synchronized(this.field_98) {
         this.method_160();
         if(this.field_102 != null) {
            RuntimeExecutionException var10000 = new RuntimeExecutionException;
            var10000.method_42(this.field_102);
            throw var10000;
         } else {
            return this.field_101;
         }
      }
   }

   public final Object getResult(Class var1) throws Throwable {
      Object var2 = this.field_98;
      synchronized(this.field_98) {
         this.method_160();
         if(var1.isInstance(this.field_102)) {
            throw (Throwable)var1.cast(this.field_102);
         } else if(this.field_102 != null) {
            RuntimeExecutionException var10000 = new RuntimeExecutionException;
            var10000.method_42(this.field_102);
            throw var10000;
         } else {
            return this.field_101;
         }
      }
   }

   public final Exception getException() {
      Object var1 = this.field_98;
      synchronized(this.field_98) {
         return this.field_102;
      }
   }

   public final Task addOnSuccessListener(OnSuccessListener var1) {
      return this.addOnSuccessListener(TaskExecutors.MAIN_THREAD, var1);
   }

   public final Task addOnSuccessListener(Executor var1, OnSuccessListener var2) {
      class_97 var10000 = this.field_99;
      class_93 var10001 = new class_93;
      var10001.method_277(var1, var2);
      var10000.method_287(var10001);
      this.method_162();
      return this;
   }

   public final Task addOnFailureListener(OnFailureListener var1) {
      return this.addOnFailureListener(TaskExecutors.MAIN_THREAD, var1);
   }

   public final Task addOnFailureListener(Executor var1, OnFailureListener var2) {
      class_97 var10000 = this.field_99;
      class_92 var10001 = new class_92;
      var10001.method_274(var1, var2);
      var10000.method_287(var10001);
      this.method_162();
      return this;
   }

   public final Task addOnCompleteListener(OnCompleteListener var1) {
      return this.addOnCompleteListener(TaskExecutors.MAIN_THREAD, var1);
   }

   public final Task addOnCompleteListener(Executor var1, OnCompleteListener var2) {
      class_97 var10000 = this.field_99;
      class_94 var10001 = new class_94;
      var10001.method_280(var1, var2);
      var10000.method_287(var10001);
      this.method_162();
      return this;
   }

   // $FF: renamed from: a (java.lang.Object) void
   public final void method_156(Object var1) {
      Object var2 = this.field_98;
      synchronized(this.field_98) {
         this.method_161();
         this.field_100 = true;
         this.field_101 = var1;
      }

      this.field_99.method_288(this);
   }

   // $FF: renamed from: b (java.lang.Object) boolean
   public final boolean method_157(Object var1) {
      Object var2 = this.field_98;
      synchronized(this.field_98) {
         if(this.field_100) {
            return false;
         }

         this.field_100 = true;
         this.field_101 = var1;
      }

      this.field_99.method_288(this);
      return true;
   }

   // $FF: renamed from: a (java.lang.Exception) void
   public final void method_158(Exception var1) {
      class_123.method_414(var1, "Exception must not be null");
      Object var2 = this.field_98;
      synchronized(this.field_98) {
         this.method_161();
         this.field_100 = true;
         this.field_102 = var1;
      }

      this.field_99.method_288(this);
   }

   // $FF: renamed from: b (java.lang.Exception) boolean
   public final boolean method_159(Exception var1) {
      class_123.method_414(var1, "Exception must not be null");
      Object var2 = this.field_98;
      synchronized(this.field_98) {
         if(this.field_100) {
            return false;
         }

         this.field_100 = true;
         this.field_102 = var1;
      }

      this.field_99.method_288(this);
      return true;
   }

   // $FF: renamed from: a () void
   private final void method_160() {
      class_123.method_415(this.field_100, "Task is not yet complete");
   }

   // $FF: renamed from: b () void
   private final void method_161() {
      class_123.method_415(!this.field_100, "Task is already complete");
   }

   // $FF: renamed from: c () void
   private final void method_162() {
      Object var1 = this.field_98;
      synchronized(this.field_98) {
         if(!this.field_100) {
            return;
         }
      }

      this.field_99.method_288(this);
   }
}
