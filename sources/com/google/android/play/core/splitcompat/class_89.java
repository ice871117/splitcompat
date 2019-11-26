package com.google.android.play.core.splitcompat;

import com.google.android.play.core.splitcompat.class_88;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// $FF: renamed from: com.google.android.play.core.splitcompat.c
public final class class_89 {

   // $FF: renamed from: a java.util.concurrent.ThreadPoolExecutor
   private static final ThreadPoolExecutor field_159;


   // $FF: renamed from: a () java.util.concurrent.Executor
   public static Executor method_255() {
      return field_159;
   }

   // $FF: renamed from: <clinit> () void
   static void method_256() {
      ThreadPoolExecutor var10000 = new ThreadPoolExecutor;
      TimeUnit var10005 = TimeUnit.SECONDS;
      LinkedBlockingQueue var10006 = new LinkedBlockingQueue();
      class_88 var10007 = new class_88;
      var10007.method_254();
      var10000.<init>(1, 1, 10L, var10005, var10006, var10007);
      field_159 = var10000;
      var10000.allowCoreThreadTimeOut(true);
   }
}
