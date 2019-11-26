package com.google.android.play.core.splitinstall;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.internal.class_10;
import com.google.android.play.core.internal.class_23;
import com.google.android.play.core.splitinstall.class_38;
import com.google.android.play.core.splitinstall.class_50;
import com.google.android.play.core.tasks.class_98;

// $FF: renamed from: com.google.android.play.core.splitinstall.x
final class class_37 extends class_23 {

   // $FF: renamed from: a int
   // $FF: synthetic field
   private final int field_48;
   // $FF: renamed from: b com.google.android.play.core.tasks.i
   // $FF: synthetic field
   private final class_98 field_49;
   // $FF: renamed from: c com.google.android.play.core.splitinstall.q
   // $FF: synthetic field
   private final class_38 field_50;


   // $FF: renamed from: <init> (com.google.android.play.core.splitinstall.q, com.google.android.play.core.tasks.i, int, com.google.android.play.core.tasks.i) void
   void method_77(class_38 var1, class_98 var2, int var3, class_98 var4) {
      this.field_50 = var1;
      this.field_48 = var3;
      this.field_49 = var4;
      super.method_61(var2);
   }

   // $FF: renamed from: a () void
   protected final void method_63() {
      try {
         class_10 var10000 = (class_10)this.field_50.field_54.method_380();
         String var10001 = class_38.method_93(this.field_50);
         int var10002 = this.field_48;
         Bundle var10003 = class_38.method_94();
         class_50 var10004 = new class_50;
         var10004.method_107(this.field_50, this.field_49);
         var10000.method_12(var10001, var10002, var10003, var10004);
      } catch (RemoteException var2) {
         class_38.method_95().method_494(var2, "cancelInstall(%d)", new Object[]{Integer.valueOf(this.field_48)});
         this.field_49.method_292(new RuntimeException(var2));
      }
   }
}
