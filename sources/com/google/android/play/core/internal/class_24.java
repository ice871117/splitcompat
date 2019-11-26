package com.google.android.play.core.internal;

import android.content.ServiceConnection;
import android.os.IInterface;
import com.google.android.play.core.internal.class_122;
import com.google.android.play.core.internal.class_23;

// $FF: renamed from: com.google.android.play.core.internal.v
final class class_24 extends class_23 {

   // $FF: renamed from: a com.google.android.play.core.internal.q
   // $FF: synthetic field
   private final class_122 field_15;


   // $FF: renamed from: <init> (com.google.android.play.core.internal.q) void
   void method_64(class_122 var1) {
      this.field_15 = var1;
      super.method_60();
   }

   // $FF: renamed from: a () void
   public final void method_63() {
      if(class_122.method_387(this.field_15) != null) {
         class_122.method_388(this.field_15).method_490("Unbind from service.", new Object[0]);
         class_122.method_390(this.field_15).unbindService(class_122.method_389(this.field_15));
         class_122.method_391(this.field_15, false);
         class_122.method_392(this.field_15, (IInterface)null);
         class_122.method_393(this.field_15, (ServiceConnection)null);
      }

   }
}
