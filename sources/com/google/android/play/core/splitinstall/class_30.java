package com.google.android.play.core.splitinstall;

import android.os.RemoteException;
import com.google.android.play.core.internal.class_10;
import com.google.android.play.core.internal.class_23;
import com.google.android.play.core.splitinstall.class_38;
import com.google.android.play.core.splitinstall.class_52;
import com.google.android.play.core.tasks.class_98;

// $FF: renamed from: com.google.android.play.core.splitinstall.y
final class class_30 extends class_23 {

   // $FF: renamed from: a com.google.android.play.core.tasks.i
   // $FF: synthetic field
   private final class_98 field_27;
   // $FF: renamed from: b com.google.android.play.core.splitinstall.q
   // $FF: synthetic field
   private final class_38 field_28;


   // $FF: renamed from: <init> (com.google.android.play.core.splitinstall.q, com.google.android.play.core.tasks.i, com.google.android.play.core.tasks.i) void
   void method_70(class_38 var1, class_98 var2, class_98 var3) {
      this.field_28 = var1;
      this.field_27 = var3;
      super.method_61(var2);
   }

   // $FF: renamed from: a () void
   protected final void method_63() {
      try {
         class_10 var10000 = (class_10)this.field_28.field_54.method_380();
         String var10001 = class_38.method_93(this.field_28);
         class_52 var10002 = new class_52;
         var10002.method_107(this.field_28, this.field_27);
         var10000.method_14(var10001, var10002);
      } catch (RemoteException var2) {
         class_38.method_95().method_494(var2, "getSessionStates", new Object[0]);
         this.field_27.method_292(new RuntimeException(var2));
      }
   }
}
