package com.google.android.play.core.splitinstall;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.internal.class_10;
import com.google.android.play.core.internal.class_23;
import com.google.android.play.core.splitinstall.class_38;
import com.google.android.play.core.splitinstall.class_51;
import com.google.android.play.core.tasks.class_98;
import java.util.ArrayList;
import java.util.Collection;

// $FF: renamed from: com.google.android.play.core.splitinstall.s
final class class_32 extends class_23 {

   // $FF: renamed from: a java.util.Collection
   // $FF: synthetic field
   private final Collection field_32;
   // $FF: renamed from: b java.util.Collection
   // $FF: synthetic field
   private final Collection field_33;
   // $FF: renamed from: c com.google.android.play.core.tasks.i
   // $FF: synthetic field
   private final class_98 field_34;
   // $FF: renamed from: d com.google.android.play.core.splitinstall.q
   // $FF: synthetic field
   private final class_38 field_35;


   // $FF: renamed from: <init> (com.google.android.play.core.splitinstall.q, com.google.android.play.core.tasks.i, java.util.Collection, java.util.Collection, com.google.android.play.core.tasks.i) void
   void method_72(class_38 var1, class_98 var2, Collection var3, Collection var4, class_98 var5) {
      this.field_35 = var1;
      this.field_32 = var3;
      this.field_33 = var4;
      this.field_34 = var5;
      super.method_61(var2);
   }

   // $FF: renamed from: a () void
   protected final void method_63() {
      ArrayList var1;
      (var1 = class_38.method_91(this.field_32)).addAll(class_38.method_92(this.field_33));

      try {
         class_10 var10000 = (class_10)this.field_35.field_54.method_380();
         String var10001 = class_38.method_93(this.field_35);
         Bundle var10003 = class_38.method_94();
         class_51 var10004 = new class_51;
         var10004.method_107(this.field_35, this.field_34);
         var10000.method_11(var10001, var1, var10003, var10004);
      } catch (RemoteException var3) {
         class_38.method_95().method_494(var3, "startInstall(%s,%s)", new Object[]{this.field_32, this.field_33});
         this.field_34.method_292(new RuntimeException(var3));
      }
   }
}
