package com.google.android.play.core.tasks;

import android.os.Handler;
import android.os.Looper;
import com.google.android.play.core.tasks.class_95;
import java.util.concurrent.Executor;

public final class TaskExecutors {

   public static final Executor MAIN_THREAD;
   // $FF: renamed from: a java.util.concurrent.Executor
   static final Executor field_139;


   // $FF: renamed from: <init> () void
   private void method_202() {
      super();
   }

   // $FF: renamed from: <clinit> () void
   static void method_203() {
      TaskExecutors.class_147 var10000 = new TaskExecutors.class_147;
      var10000.method_167();
      MAIN_THREAD = var10000;
      class_95 var0 = new class_95;
      var0.method_283();
      field_139 = var0;
   }

   static final class class_147 implements Executor {

      // $FF: renamed from: a android.os.Handler
      private final Handler field_104;


      // $FF: renamed from: <init> () void
      public void method_167() {
         super();
         this.field_104 = new Handler(Looper.getMainLooper());
      }

      public final void execute(Runnable var1) {
         this.field_104.post(var1);
      }
   }
}
