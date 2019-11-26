package com.google.android.play.core.tasks;

import com.google.android.play.core.internal.class_123;
import com.google.android.play.core.tasks.OnFailureListener;
import com.google.android.play.core.tasks.OnSuccessListener;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.TaskExecutors;
import com.google.android.play.core.tasks.class_68;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class Tasks {

   // $FF: renamed from: a (java.lang.Object) com.google.android.play.core.tasks.Task
   public static Task method_311(Object var0) {
      class_68 var10000 = new class_68;
      var10000.method_155();
      class_68 var1 = var10000;
      var10000.method_156(var0);
      return var1;
   }

   // $FF: renamed from: a (java.lang.Exception) com.google.android.play.core.tasks.Task
   public static Task method_312(Exception var0) {
      class_68 var10000 = new class_68;
      var10000.method_155();
      class_68 var1 = var10000;
      var10000.method_158(var0);
      return var1;
   }

   public static Object await(Task var0) throws ExecutionException, InterruptedException {
      class_123.method_414(var0, "Task must not be null");
      if(var0.isComplete()) {
         return method_313(var0);
      } else {
         Tasks.class_149 var10000 = new Tasks.class_149;
         var10000.method_448((byte)0);
         Tasks.class_149 var1 = var10000;
         method_314(var0, var1);
         var1.method_446();
         return method_313(var0);
      }
   }

   public static Object await(Task var0, long var1, TimeUnit var3) throws ExecutionException, InterruptedException, TimeoutException {
      class_123.method_414(var0, "Task must not be null");
      class_123.method_414(var3, "TimeUnit must not be null");
      if(var0.isComplete()) {
         return method_313(var0);
      } else {
         Tasks.class_149 var10000 = new Tasks.class_149;
         var10000.method_448((byte)0);
         Tasks.class_149 var4 = var10000;
         method_314(var0, var4);
         if(!var4.method_447(var1, var3)) {
            throw new TimeoutException("Timed out waiting for Task");
         } else {
            return method_313(var0);
         }
      }
   }

   // $FF: renamed from: a (com.google.android.play.core.tasks.Task) java.lang.Object
   private static Object method_313(Task var0) throws ExecutionException {
      if(var0.isSuccessful()) {
         return var0.getResult();
      } else {
         throw new ExecutionException(var0.getException());
      }
   }

   // $FF: renamed from: a (com.google.android.play.core.tasks.Task, com.google.android.play.core.tasks.Tasks$a) void
   private static void method_314(Task var0, Tasks.class_150 var1) {
      var0.addOnSuccessListener(TaskExecutors.field_139, var1);
      var0.addOnFailureListener(TaskExecutors.field_139, var1);
   }

   // $FF: renamed from: <init> () void
   private void method_315() {
      super();
   }

   static final class class_149 implements Tasks.class_150 {

      // $FF: renamed from: a java.util.concurrent.CountDownLatch
      private final CountDownLatch field_226;


      // $FF: renamed from: <init> () void
      private void method_445() {
         super();
         this.field_226 = new CountDownLatch(1);
      }

      public final void onSuccess(Object var1) {
         this.field_226.countDown();
      }

      public final void onFailure(Exception var1) {
         this.field_226.countDown();
      }

      // $FF: renamed from: a () void
      public final void method_446() throws InterruptedException {
         this.field_226.await();
      }

      // $FF: renamed from: a (long, java.util.concurrent.TimeUnit) boolean
      public final boolean method_447(long var1, TimeUnit var3) throws InterruptedException {
         return this.field_226.await(var1, var3);
      }

      // $FF: renamed from: <init> (byte) void
      // $FF: synthetic method
      void method_448(byte var1) {
         this.method_445();
      }
   }

   interface class_150 extends OnFailureListener, OnSuccessListener {
   }
}
