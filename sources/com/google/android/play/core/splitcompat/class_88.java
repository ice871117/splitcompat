package com.google.android.play.core.splitcompat;

import java.util.concurrent.ThreadFactory;

// $FF: renamed from: com.google.android.play.core.splitcompat.b
final class class_88 implements ThreadFactory {

   // $FF: renamed from: <init> () void
   void method_254() {
      super();
   }

   public final Thread newThread(Runnable var1) {
      return new Thread(var1, "SplitCompatBackgroundThread");
   }
}
