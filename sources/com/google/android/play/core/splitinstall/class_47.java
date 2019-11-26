package com.google.android.play.core.splitinstall;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.internal.class_46;
import com.google.android.play.core.splitinstall.SplitInstallException;
import com.google.android.play.core.splitinstall.class_38;
import com.google.android.play.core.tasks.class_98;
import java.util.List;

// $FF: renamed from: com.google.android.play.core.splitinstall.ah
class class_47 extends class_46 {

   // $FF: renamed from: a com.google.android.play.core.tasks.i
   final class_98 field_60;
   // $FF: renamed from: b com.google.android.play.core.splitinstall.q
   // $FF: synthetic field
   private final class_38 field_61;


   // $FF: renamed from: <init> (com.google.android.play.core.splitinstall.q, com.google.android.play.core.tasks.i) void
   void method_107(class_38 var1, class_98 var2) {
      this.field_61 = var1;
      super.method_106();
      this.field_60 = var2;
   }

   // $FF: renamed from: c (int, android.os.Bundle) void
   public void method_21(int var1, Bundle var2) throws RemoteException {
      this.field_61.field_54.method_379();
      class_38.method_95().method_490("onStartInstall(%d)", new Object[]{Integer.valueOf(var1)});
   }

   // $FF: renamed from: a (int) void
   public final void method_22(int var1) throws RemoteException {
      this.field_61.field_54.method_379();
      class_38.method_95().method_490("onCompleteInstall(%d)", new Object[]{Integer.valueOf(var1)});
   }

   // $FF: renamed from: a (int, android.os.Bundle) void
   public void method_23(int var1, Bundle var2) throws RemoteException {
      this.field_61.field_54.method_379();
      class_38.method_95().method_490("onCancelInstall(%d)", new Object[]{Integer.valueOf(var1)});
   }

   // $FF: renamed from: b (int, android.os.Bundle) void
   public void method_24(int var1, Bundle var2) throws RemoteException {
      this.field_61.field_54.method_379();
      class_38.method_95().method_490("onGetSession(%d)", new Object[]{Integer.valueOf(var1)});
   }

   // $FF: renamed from: d (android.os.Bundle) void
   public void method_27(Bundle var1) throws RemoteException {
      this.field_61.field_54.method_379();
      class_38.method_95().method_490("onDeferredUninstall", new Object[0]);
   }

   // $FF: renamed from: a (android.os.Bundle) void
   public void method_28(Bundle var1) throws RemoteException {
      this.field_61.field_54.method_379();
      class_38.method_95().method_490("onDeferredInstall", new Object[0]);
   }

   // $FF: renamed from: b (android.os.Bundle) void
   public void method_32(Bundle var1) throws RemoteException {
      this.field_61.field_54.method_379();
      class_38.method_95().method_490("onDeferredLanguageUninstall", new Object[0]);
   }

   // $FF: renamed from: c (android.os.Bundle) void
   public void method_31(Bundle var1) throws RemoteException {
      this.field_61.field_54.method_379();
      class_38.method_95().method_490("onDeferredLanguageInstall", new Object[0]);
   }

   // $FF: renamed from: a () void
   public final void method_30() throws RemoteException {
      this.field_61.field_54.method_379();
      class_38.method_95().method_490("onCompleteInstallForAppUpdate", new Object[0]);
   }

   // $FF: renamed from: b () void
   public final void method_29() throws RemoteException {
      this.field_61.field_54.method_379();
      class_38.method_95().method_490("onGetSplitsForAppUpdate", new Object[0]);
   }

   // $FF: renamed from: e (android.os.Bundle) void
   public final void method_25(Bundle var1) throws RemoteException {
      this.field_61.field_54.method_379();
      int var2 = var1.getInt("error_code");
      class_38.method_95().method_493("onError(%d)", new Object[]{Integer.valueOf(var2)});
      class_98 var10000 = this.field_60;
      SplitInstallException var10001 = new SplitInstallException;
      var10001.method_39(var2);
      var10000.method_292(var10001);
   }

   // $FF: renamed from: a (java.util.List) void
   public void method_26(List var1) throws RemoteException {
      this.field_61.field_54.method_379();
      class_38.method_95().method_490("onGetSessionStates", new Object[0]);
   }
}
