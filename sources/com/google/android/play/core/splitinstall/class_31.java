package com.google.android.play.core.splitinstall;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.internal.class_10;
import com.google.android.play.core.internal.class_23;
import com.google.android.play.core.splitinstall.class_38;
import com.google.android.play.core.splitinstall.class_54;
import com.google.android.play.core.tasks.class_98;
import java.util.ArrayList;
import java.util.List;

// $FF: renamed from: com.google.android.play.core.splitinstall.r
final class class_31 extends class_23 {

   // $FF: renamed from: a java.util.List
   // $FF: synthetic field
   private final List field_29;
   // $FF: renamed from: b com.google.android.play.core.tasks.i
   // $FF: synthetic field
   private final class_98 field_30;
   // $FF: renamed from: c com.google.android.play.core.splitinstall.q
   // $FF: synthetic field
   private final class_38 field_31;


   // $FF: renamed from: <init> (com.google.android.play.core.splitinstall.q, com.google.android.play.core.tasks.i, java.util.List, com.google.android.play.core.tasks.i) void
   void method_71(class_38 var1, class_98 var2, List var3, class_98 var4) {
      this.field_31 = var1;
      this.field_29 = var3;
      this.field_30 = var4;
      super.method_61(var2);
   }

   // $FF: renamed from: a () void
   protected final void method_63() {
      try {
         class_10 var10000 = (class_10)this.field_31.field_54.method_380();
         String var10001 = class_38.method_93(this.field_31);
         ArrayList var10002 = class_38.method_91(this.field_29);
         Bundle var10003 = class_38.method_94();
         class_54 var10004 = new class_54;
         var10004.method_107(this.field_31, this.field_30);
         var10000.method_15(var10001, var10002, var10003, var10004);
      } catch (RemoteException var2) {
         class_38.method_95().method_494(var2, "deferredUninstall(%s)", new Object[]{this.field_29});
         this.field_30.method_292(new RuntimeException(var2));
      }
   }
}
