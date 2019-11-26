package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.content.Intent;
import com.google.android.play.core.splitinstall.SplitInstallSessionState;
import com.google.android.play.core.splitinstall.class_22;

// $FF: renamed from: com.google.android.play.core.splitinstall.b
public class class_60 {

   // $FF: renamed from: a com.google.android.play.core.splitinstall.SplitInstallSessionState
   // $FF: synthetic field
   final SplitInstallSessionState field_68;
   // $FF: renamed from: b android.content.Intent
   // $FF: synthetic field
   final Intent field_69;
   // $FF: renamed from: c android.content.Context
   // $FF: synthetic field
   final Context field_70;
   // $FF: renamed from: d com.google.android.play.core.splitinstall.m
   // $FF: synthetic field
   final class_22 field_71;


   // $FF: renamed from: a () void
   public void method_122() {
      class_22.method_57(this.field_71, this.field_68, 5, 0);
   }

   // $FF: renamed from: b () void
   public void method_123() {
      if(!this.field_69.getBooleanExtra("triggered_from_app_after_verification", false)) {
         this.field_69.putExtra("triggered_from_app_after_verification", true);
         this.field_70.sendBroadcast(this.field_69);
      } else {
         class_22.method_58(this.field_71).method_493("Splits copied and verified more than once.", new Object[0]);
      }
   }

   // $FF: renamed from: a (int) void
   public void method_124(int var1) {
      class_22.method_57(this.field_71, this.field_68, 6, var1);
   }

   // $FF: renamed from: <init> (com.google.android.play.core.splitinstall.m, com.google.android.play.core.splitinstall.SplitInstallSessionState, android.content.Intent, android.content.Context) void
   void method_125(class_22 var1, SplitInstallSessionState var2, Intent var3, Context var4) {
      this.field_71 = var1;
      this.field_68 = var2;
      this.field_69 = var3;
      this.field_70 = var4;
      super();
   }
}
