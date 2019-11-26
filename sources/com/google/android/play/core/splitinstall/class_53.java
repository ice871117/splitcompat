package com.google.android.play.core.splitinstall;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.splitinstall.SplitInstallSessionState;
import com.google.android.play.core.splitinstall.class_38;
import com.google.android.play.core.splitinstall.class_47;
import com.google.android.play.core.tasks.class_98;

// $FF: renamed from: com.google.android.play.core.splitinstall.ad
final class class_53 extends class_47 {

   // $FF: renamed from: <init> (com.google.android.play.core.splitinstall.q, com.google.android.play.core.tasks.i) void
   void method_107(class_38 var1, class_98 var2) {
      super.method_107(var1, var2);
   }

   // $FF: renamed from: b (int, android.os.Bundle) void
   public final void method_24(int var1, Bundle var2) throws RemoteException {
      super.method_24(var1, var2);
      this.field_60.method_291(SplitInstallSessionState.method_127(var2));
   }
}
