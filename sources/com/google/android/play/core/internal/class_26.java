package com.google.android.play.core.internal;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.play.core.internal.class_122;
import com.google.android.play.core.internal.class_140;
import com.google.android.play.core.internal.class_23;
import java.util.Iterator;

// $FF: renamed from: com.google.android.play.core.internal.z
final class class_26 extends class_23 {

   // $FF: renamed from: a android.os.IBinder
   // $FF: synthetic field
   private final IBinder field_17;
   // $FF: renamed from: b com.google.android.play.core.internal.w
   // $FF: synthetic field
   private final class_140 field_18;


   // $FF: renamed from: <init> (com.google.android.play.core.internal.w, android.os.IBinder) void
   void method_66(class_140 var1, IBinder var2) {
      this.field_18 = var1;
      this.field_17 = var2;
      super.method_60();
   }

   // $FF: renamed from: a () void
   public final void method_63() {
      class_122.method_392(this.field_18.field_243, (IInterface)class_122.method_394(this.field_18.field_243).method_33(this.field_17));
      class_122.method_395(this.field_18.field_243);
      class_122.method_391(this.field_18.field_243, false);
      Iterator var1 = class_122.method_396(this.field_18.field_243).iterator();

      while(var1.hasNext()) {
         ((Runnable)var1.next()).run();
      }

      class_122.method_396(this.field_18.field_243).clear();
   }
}
