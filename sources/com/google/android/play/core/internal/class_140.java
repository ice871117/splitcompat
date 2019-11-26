package com.google.android.play.core.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.play.core.internal.class_122;
import com.google.android.play.core.internal.class_25;
import com.google.android.play.core.internal.class_26;

// $FF: renamed from: com.google.android.play.core.internal.w
final class class_140 implements ServiceConnection {

   // $FF: renamed from: a com.google.android.play.core.internal.q
   // $FF: synthetic field
   final class_122 field_243;


   // $FF: renamed from: <init> (com.google.android.play.core.internal.q) void
   private void method_475(class_122 var1) {
      this.field_243 = var1;
      super();
   }

   public final void onServiceConnected(ComponentName var1, IBinder var2) {
      class_122.method_388(this.field_243).method_490("ServiceConnectionImpl.onServiceConnected(%s)", new Object[]{var1});
      class_122 var10000 = this.field_243;
      class_26 var10001 = new class_26;
      var10001.method_66(this, var2);
      class_122.method_397(var10000, var10001);
   }

   public final void onServiceDisconnected(ComponentName var1) {
      class_122.method_388(this.field_243).method_490("ServiceConnectionImpl.onServiceDisconnected(%s)", new Object[]{var1});
      class_122 var10000 = this.field_243;
      class_25 var10001 = new class_25;
      var10001.method_65(this);
      class_122.method_397(var10000, var10001);
   }

   // $FF: renamed from: <init> (com.google.android.play.core.internal.q, byte) void
   // $FF: synthetic method
   void method_476(class_122 var1, byte var2) {
      this.method_475(var1);
   }
}
