package com.google.android.play.core.appupdate;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.appupdate.class_69;
import com.google.android.play.core.internal.class_145;
import com.google.android.play.core.internal.class_42;
import com.google.android.play.core.tasks.class_98;

// $FF: renamed from: com.google.android.play.core.appupdate.h
class class_43 extends class_42 {

   // $FF: renamed from: b com.google.android.play.core.internal.ag
   private final class_145 field_56;
   // $FF: renamed from: a com.google.android.play.core.tasks.i
   final class_98 field_57;
   // $FF: renamed from: c com.google.android.play.core.appupdate.d
   // $FF: synthetic field
   private final class_69 field_58;


   // $FF: renamed from: <init> (com.google.android.play.core.appupdate.d, com.google.android.play.core.internal.ag, com.google.android.play.core.tasks.i) void
   void method_103(class_69 var1, class_145 var2, class_98 var3) {
      this.field_58 = var1;
      super.method_102();
      this.field_56 = var2;
      this.field_57 = var3;
   }

   // $FF: renamed from: b (android.os.Bundle) void
   public void method_7(Bundle var1) throws RemoteException {
      this.field_58.field_118.method_379();
      this.field_56.method_490("onRequestInfo", new Object[0]);
   }

   // $FF: renamed from: a (android.os.Bundle) void
   public void method_8(Bundle var1) throws RemoteException {
      this.field_58.field_118.method_379();
      this.field_56.method_490("onCompleteUpdate", new Object[0]);
   }
}
