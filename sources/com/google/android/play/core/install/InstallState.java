package com.google.android.play.core.install;

import com.google.android.play.core.install.class_19;

public abstract class InstallState {

   // $FF: renamed from: <init> () void
   public void method_43() {
      super();
   }

   // $FF: renamed from: a (int, int, java.lang.String) com.google.android.play.core.install.InstallState
   public static InstallState method_44(int var0, int var1, String var2) {
      class_19 var10000 = new class_19;
      var10000.method_45(var0, var1, var2);
      return var10000;
   }

   public abstract int installStatus();

   public abstract int installErrorCode();

   public abstract String packageName();
}
