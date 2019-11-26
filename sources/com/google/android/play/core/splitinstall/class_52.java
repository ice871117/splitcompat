package com.google.android.play.core.splitinstall;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.splitinstall.SplitInstallSessionState;
import com.google.android.play.core.splitinstall.class_38;
import com.google.android.play.core.splitinstall.class_47;
import com.google.android.play.core.tasks.class_98;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// $FF: renamed from: com.google.android.play.core.splitinstall.ag
final class class_52 extends class_47 {

   // $FF: renamed from: <init> (com.google.android.play.core.splitinstall.q, com.google.android.play.core.tasks.i) void
   void method_107(class_38 var1, class_98 var2) {
      super.method_107(var1, var2);
   }

   // $FF: renamed from: a (java.util.List) void
   public final void method_26(List var1) throws RemoteException {
      super.method_26(var1);
      ArrayList var2 = new ArrayList(var1.size());
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         Bundle var4 = (Bundle)var3.next();
         var2.add(SplitInstallSessionState.method_127(var4));
      }

      this.field_60.method_291(var2);
   }
}
