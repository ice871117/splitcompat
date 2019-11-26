package com.google.android.play.core.appupdate;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.appupdate.class_43;
import com.google.android.play.core.appupdate.class_69;
import com.google.android.play.core.install.InstallException;
import com.google.android.play.core.internal.class_145;
import com.google.android.play.core.tasks.class_98;

// $FF: renamed from: com.google.android.play.core.appupdate.j
final class class_45 extends class_43 {

   // $FF: renamed from: b java.lang.String
   private final String field_59;


   // $FF: renamed from: <init> (com.google.android.play.core.appupdate.d, com.google.android.play.core.tasks.i, java.lang.String) void
   void method_105(class_69 var1, class_98 var2, String var3) {
      class_145 var10002 = new class_145;
      var10002.method_489("OnRequestInstallCallback");
      super.method_103(var1, var10002, var2);
      this.field_59 = var3;
   }

   // $FF: renamed from: b (android.os.Bundle) void
   public final void method_7(Bundle var1) throws RemoteException {
      super.method_7(var1);
      if(class_69.method_183(var1) != 0 && class_69.method_183(var1) != 1) {
         class_98 var10000 = this.field_57;
         InstallException var10001 = new InstallException;
         var10001.method_310(class_69.method_183(var1));
         var10000.method_292(var10001);
      } else {
         this.field_57.method_291(class_69.method_184(var1, this.field_59));
      }
   }
}
