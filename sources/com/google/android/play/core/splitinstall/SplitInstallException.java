package com.google.android.play.core.splitinstall;

import com.google.android.play.core.splitinstall.model.class_130;

public class SplitInstallException extends RuntimeException {

   // $FF: renamed from: a int
   private final int field_0;


   // $FF: renamed from: <init> (int) void
   public void method_39(int var1) {
      super(String.format("Split Install Error(%d): %s", new Object[]{Integer.valueOf(var1), class_130.method_434(var1)}));
      this.field_0 = var1;
   }

   public int getErrorCode() {
      return this.field_0;
   }
}
