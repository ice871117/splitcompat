package com.google.android.play.core.listener;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.play.core.listener.class_20;

// $FF: renamed from: com.google.android.play.core.listener.b
final class class_18 extends BroadcastReceiver {

   // $FF: renamed from: a com.google.android.play.core.listener.a
   // $FF: synthetic field
   private final class_20 field_1;


   // $FF: renamed from: <init> (com.google.android.play.core.listener.a) void
   private void method_40(class_20 var1) {
      this.field_1 = var1;
      super();
   }

   public final void onReceive(Context var1, Intent var2) {
      this.field_1.method_50(var1, var2);
   }

   // $FF: renamed from: <init> (com.google.android.play.core.listener.a, byte) void
   // $FF: synthetic method
   void method_41(class_20 var1, byte var2) {
      this.method_40(var1);
   }
}
