package com.google.android.play.core.splitinstall;

import android.os.RemoteException;
import com.google.android.play.core.internal.class_10;
import com.google.android.play.core.internal.class_23;
import com.google.android.play.core.splitinstall.class_38;
import com.google.android.play.core.splitinstall.class_53;
import com.google.android.play.core.tasks.class_98;

// $FF: renamed from: com.google.android.play.core.splitinstall.v
final class class_35 extends class_23 {

   // $FF: renamed from: a int
   // $FF: synthetic field
   private final int field_42;
   // $FF: renamed from: b com.google.android.play.core.tasks.i
   // $FF: synthetic field
   private final class_98 field_43;
   // $FF: renamed from: c com.google.android.play.core.splitinstall.q
   // $FF: synthetic field
   private final class_38 field_44;


   // $FF: renamed from: <init> (com.google.android.play.core.splitinstall.q, com.google.android.play.core.tasks.i, int, com.google.android.play.core.tasks.i) void
   void method_75(class_38 var1, class_98 var2, int var3, class_98 var4) {
      this.field_44 = var1;
      this.field_42 = var3;
      this.field_43 = var4;
      super.method_61(var2);
   }

   // $FF: renamed from: a () void
   protected final void method_63() {
      try {
         class_10 var10000 = (class_10)this.field_44.field_54.method_380();
         String var10001 = class_38.method_93(this.field_44);
         int var10002 = this.field_42;
         class_53 var10003 = new class_53;
         var10003.method_107(this.field_44, this.field_43);
         var10000.method_13(var10001, var10002, var10003);
      } catch (RemoteException var2) {
         class_38.method_95().method_494(var2, "getSessionState(%d)", new Object[]{Integer.valueOf(this.field_42)});
         this.field_43.method_292(new RuntimeException(var2));
      }
   }
}
