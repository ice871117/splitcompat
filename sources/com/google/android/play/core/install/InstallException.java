package com.google.android.play.core.install;

import com.google.android.play.core.install.model.class_143;

public class InstallException extends RuntimeException {

   // $FF: renamed from: a int
   private final int field_193;


   // $FF: renamed from: <init> (int) void
   public void method_310(int var1) {
      super(String.format("Install Error(%d): %s", new Object[]{Integer.valueOf(var1), class_143.method_480(var1)}));
      this.field_193 = var1;
   }

   public int getErrorCode() {
      return this.field_193;
   }
}
