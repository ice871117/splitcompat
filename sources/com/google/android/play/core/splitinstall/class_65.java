package com.google.android.play.core.splitinstall;

import com.google.android.play.core.splitinstall.SplitInstallSessionState;
import com.google.android.play.core.splitinstall.class_22;
import com.google.android.play.core.splitinstall.class_61;

// $FF: renamed from: com.google.android.play.core.splitinstall.l
final class class_65 implements Runnable {

   // $FF: renamed from: a com.google.android.play.core.splitinstall.SplitInstallSessionState
   // $FF: synthetic field
   private final SplitInstallSessionState field_89;
   // $FF: renamed from: b int
   // $FF: synthetic field
   private final int field_90;
   // $FF: renamed from: c int
   // $FF: synthetic field
   private final int field_91;
   // $FF: renamed from: d com.google.android.play.core.splitinstall.m
   // $FF: synthetic field
   private final class_22 field_92;


   // $FF: renamed from: <init> (com.google.android.play.core.splitinstall.m, com.google.android.play.core.splitinstall.SplitInstallSessionState, int, int) void
   void method_140(class_22 var1, SplitInstallSessionState var2, int var3, int var4) {
      this.field_92 = var1;
      this.field_89 = var2;
      this.field_90 = var3;
      this.field_91 = var4;
      super();
   }

   public final void run() {
      class_22 var10000 = this.field_92;
      int var3 = this.field_91;
      int var2 = this.field_90;
      SplitInstallSessionState var1 = this.field_89;
      class_61 var10001 = new class_61;
      var10001.method_131(var1.sessionId(), var2, var3, var1.bytesDownloaded(), var1.totalBytesToDownload(), var1.method_128(), var1.method_129(), var1.resolutionIntent(), var1.method_130());
      var10000.method_51(var10001);
   }
}
