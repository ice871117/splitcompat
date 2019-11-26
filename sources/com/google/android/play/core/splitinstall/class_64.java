package com.google.android.play.core.splitinstall;

import com.google.android.play.core.internal.class_123;
import com.google.android.play.core.splitinstall.SplitInstallRequest;
import com.google.android.play.core.splitinstall.SplitInstallSessionState;
import com.google.android.play.core.splitinstall.class_63;

// $FF: renamed from: com.google.android.play.core.splitinstall.n
final class class_64 implements Runnable {

   // $FF: renamed from: a com.google.android.play.core.splitinstall.SplitInstallRequest
   // $FF: synthetic field
   private final SplitInstallRequest field_87;
   // $FF: renamed from: b com.google.android.play.core.splitinstall.o
   // $FF: synthetic field
   private final class_63 field_88;


   // $FF: renamed from: <init> (com.google.android.play.core.splitinstall.o, com.google.android.play.core.splitinstall.SplitInstallRequest) void
   void method_139(class_63 var1, SplitInstallRequest var2) {
      this.field_88 = var1;
      this.field_87 = var2;
      super();
   }

   public final void run() {
      class_63.method_138(this.field_88).method_51(SplitInstallSessionState.method_127(class_123.method_412(this.field_87.getModuleNames(), class_63.method_137(this.field_87.getLanguages()))));
   }
}
