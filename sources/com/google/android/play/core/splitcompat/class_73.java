package com.google.android.play.core.splitcompat;

import android.util.Log;
import com.google.android.play.core.splitcompat.SplitCompat;

// $FF: renamed from: com.google.android.play.core.splitcompat.p
final class class_73 implements Runnable {

   // $FF: renamed from: a com.google.android.play.core.splitcompat.SplitCompat
   // $FF: synthetic field
   private final SplitCompat field_131;


   // $FF: renamed from: <init> (com.google.android.play.core.splitcompat.SplitCompat) void
   void method_194(SplitCompat var1) {
      this.field_131 = var1;
      super();
   }

   public final void run() {
      try {
         SplitCompat.method_269(this.field_131).method_232();
      } catch (Exception var2) {
         Log.e("SplitCompat", "Failed to cleanup splitcompat storage", var2);
      }
   }
}
