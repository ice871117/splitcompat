package com.google.android.play.core.appupdate;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.appupdate.class_45;
import com.google.android.play.core.appupdate.class_69;
import com.google.android.play.core.internal.class_23;
import com.google.android.play.core.internal.class_9;
import com.google.android.play.core.tasks.class_98;

// $FF: renamed from: com.google.android.play.core.appupdate.f
final class class_28 extends class_23 {

   // $FF: renamed from: a java.lang.String
   // $FF: synthetic field
   private final String field_21;
   // $FF: renamed from: b com.google.android.play.core.tasks.i
   // $FF: synthetic field
   private final class_98 field_22;
   // $FF: renamed from: c com.google.android.play.core.appupdate.d
   // $FF: synthetic field
   private final class_69 field_23;


   // $FF: renamed from: <init> (com.google.android.play.core.appupdate.d, com.google.android.play.core.tasks.i, java.lang.String, com.google.android.play.core.tasks.i) void
   void method_68(class_69 var1, class_98 var2, String var3, class_98 var4) {
      this.field_23 = var1;
      this.field_21 = var3;
      this.field_22 = var4;
      super.method_61(var2);
   }

   // $FF: renamed from: a () void
   protected final void method_63() {
      try {
         class_9 var10000 = (class_9)this.field_23.field_118.method_380();
         String var10001 = class_69.method_179(this.field_23);
         Bundle var10002 = class_69.method_180(this.field_23, this.field_21);
         class_45 var10003 = new class_45;
         var10003.method_105(this.field_23, this.field_22, this.field_21);
         var10000.method_9(var10001, var10002, var10003);
      } catch (RemoteException var2) {
         class_69.method_181().method_494(var2, "requestUpdateInfo(%s)", new Object[]{this.field_21});
         this.field_22.method_292(new RuntimeException(var2));
      }
   }
}
