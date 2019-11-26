package com.google.android.play.core.appupdate;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.appupdate.class_44;
import com.google.android.play.core.appupdate.class_69;
import com.google.android.play.core.internal.class_23;
import com.google.android.play.core.internal.class_9;
import com.google.android.play.core.tasks.class_98;

// $FF: renamed from: com.google.android.play.core.appupdate.e
final class class_29 extends class_23 {

   // $FF: renamed from: a com.google.android.play.core.tasks.i
   // $FF: synthetic field
   private final class_98 field_24;
   // $FF: renamed from: b java.lang.String
   // $FF: synthetic field
   private final String field_25;
   // $FF: renamed from: c com.google.android.play.core.appupdate.d
   // $FF: synthetic field
   private final class_69 field_26;


   // $FF: renamed from: <init> (com.google.android.play.core.appupdate.d, com.google.android.play.core.tasks.i, com.google.android.play.core.tasks.i, java.lang.String) void
   void method_69(class_69 var1, class_98 var2, class_98 var3, String var4) {
      this.field_26 = var1;
      this.field_24 = var3;
      this.field_25 = var4;
      super.method_61(var2);
   }

   // $FF: renamed from: a () void
   protected final void method_63() {
      try {
         class_9 var10000 = (class_9)this.field_26.field_118.method_380();
         String var10001 = class_69.method_179(this.field_26);
         Bundle var10002 = class_69.method_182();
         class_44 var10003 = new class_44;
         var10003.method_104(this.field_26, this.field_24);
         var10000.method_10(var10001, var10002, var10003);
      } catch (RemoteException var2) {
         class_69.method_181().method_494(var2, "completeUpdate(%s)", new Object[]{this.field_25});
         this.field_24.method_292(new RuntimeException(var2));
      }
   }
}
