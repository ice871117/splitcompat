package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.play.core.internal.class_145;
import com.google.android.play.core.listener.class_20;
import com.google.android.play.core.splitinstall.SplitInstallSessionState;
import com.google.android.play.core.splitinstall.class_0;
import com.google.android.play.core.splitinstall.class_1;
import com.google.android.play.core.splitinstall.class_58;
import com.google.android.play.core.splitinstall.class_60;
import com.google.android.play.core.splitinstall.class_65;
import java.util.List;

// $FF: renamed from: com.google.android.play.core.splitinstall.m
public final class class_22 extends class_20 {

   // $FF: renamed from: b com.google.android.play.core.splitinstall.m
   private static class_22 field_11;
   // $FF: renamed from: c android.os.Handler
   private final Handler field_12;
   // $FF: renamed from: d com.google.android.play.core.splitinstall.e
   private final class_0 field_13;


   // $FF: renamed from: a (android.content.Context) com.google.android.play.core.splitinstall.m
   public static synchronized class_22 method_54(Context var0) {
      if(field_11 == null) {
         class_22 var10000 = new class_22;
         var10000.method_55(var0, class_58.field_65);
         field_11 = var10000;
      }

      return field_11;
   }

   // $FF: renamed from: <init> (android.content.Context, com.google.android.play.core.splitinstall.e) void
   private void method_55(Context var1, class_0 var2) {
      class_145 var10001 = new class_145;
      var10001.method_489("SplitInstallListenerRegistry");
      super.method_46(var10001, new IntentFilter("com.google.android.play.core.splitinstall.receiver.SplitInstallUpdateIntentService"), var1);
      this.field_12 = new Handler(Looper.getMainLooper());
      this.field_13 = var2;
   }

   // $FF: renamed from: a (android.content.Context, android.content.Intent) void
   protected final void method_50(Context var1, Intent var2) {
      Bundle var3;
      if((var3 = var2.getBundleExtra("session_state")) != null) {
         SplitInstallSessionState var4 = SplitInstallSessionState.method_127(var3);
         this.field_5.method_491("ListenerRegistryBroadcastReceiver.onReceive: %s", new Object[]{var4});
         class_1 var5 = this.field_13.method_0();
         if(var4.status() == 3 && var5 != null) {
            List var10001 = var4.method_130();
            class_60 var10002 = new class_60;
            var10002.method_125(this, var4, var2, var1);
            var5.method_1(var10001, var10002);
         } else {
            this.method_51(var4);
         }
      }
   }

   // $FF: renamed from: a (com.google.android.play.core.splitinstall.SplitInstallSessionState, int, int) void
   private final void method_56(SplitInstallSessionState var1, int var2, int var3) {
      Handler var10000 = this.field_12;
      class_65 var10001 = new class_65;
      var10001.method_140(this, var1, var2, var3);
      var10000.post(var10001);
   }

   // $FF: renamed from: a (com.google.android.play.core.splitinstall.m, com.google.android.play.core.splitinstall.SplitInstallSessionState, int, int) void
   // $FF: synthetic method
   static void method_57(class_22 var0, SplitInstallSessionState var1, int var2, int var3) {
      var0.method_56(var1, var2, var3);
   }

   // $FF: renamed from: a (com.google.android.play.core.splitinstall.m) com.google.android.play.core.internal.ag
   // $FF: synthetic method
   static class_145 method_58(class_22 var0) {
      return var0.field_5;
   }

   // $FF: renamed from: <clinit> () void
   static void method_59() {
      field_11 = null;
   }
}
