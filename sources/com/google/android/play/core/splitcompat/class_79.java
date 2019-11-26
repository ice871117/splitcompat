package com.google.android.play.core.splitcompat;

import android.content.Context;
import com.google.android.play.core.splitinstall.class_22;

// $FF: renamed from: com.google.android.play.core.splitcompat.m
final class class_79 implements Runnable {

   // $FF: renamed from: a android.content.Context
   // $FF: synthetic field
   private final Context field_140;


   // $FF: renamed from: <init> (android.content.Context) void
   void method_204(Context var1) {
      this.field_140 = var1;
      super();
   }

   public final void run() {
      class_22.method_54(this.field_140).method_47(true);
   }
}
