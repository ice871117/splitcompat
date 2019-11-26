package com.google.android.play.core.splitinstall;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.internal.class_10;
import com.google.android.play.core.internal.class_23;
import com.google.android.play.core.splitinstall.class_38;
import com.google.android.play.core.splitinstall.class_49;
import com.google.android.play.core.tasks.class_98;
import java.util.ArrayList;
import java.util.List;

// $FF: renamed from: com.google.android.play.core.splitinstall.t
final class class_33 extends class_23 {

   // $FF: renamed from: a java.util.List
   // $FF: synthetic field
   private final List field_36;
   // $FF: renamed from: b com.google.android.play.core.tasks.i
   // $FF: synthetic field
   private final class_98 field_37;
   // $FF: renamed from: c com.google.android.play.core.splitinstall.q
   // $FF: synthetic field
   private final class_38 field_38;


   // $FF: renamed from: <init> (com.google.android.play.core.splitinstall.q, com.google.android.play.core.tasks.i, java.util.List, com.google.android.play.core.tasks.i) void
   void method_73(class_38 var1, class_98 var2, List var3, class_98 var4) {
      this.field_38 = var1;
      this.field_36 = var3;
      this.field_37 = var4;
      super.method_61(var2);
   }

   // $FF: renamed from: a () void
   protected final void method_63() {
      try {
         class_10 var10000 = (class_10)this.field_38.field_54.method_380();
         String var10001 = class_38.method_93(this.field_38);
         ArrayList var10002 = class_38.method_92(this.field_36);
         Bundle var10003 = class_38.method_94();
         class_49 var10004 = new class_49;
         var10004.method_107(this.field_38, this.field_37);
         var10000.method_17(var10001, var10002, var10003, var10004);
      } catch (RemoteException var2) {
         class_38.method_95().method_494(var2, "deferredLanguageInstall(%s)", new Object[]{this.field_36});
         this.field_37.method_292(new RuntimeException(var2));
      }
   }
}
