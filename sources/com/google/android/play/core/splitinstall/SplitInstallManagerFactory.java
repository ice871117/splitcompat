package com.google.android.play.core.splitinstall;

import android.content.Context;
import com.google.android.play.core.splitinstall.SplitInstallManager;
import com.google.android.play.core.splitinstall.class_38;
import com.google.android.play.core.splitinstall.class_63;

public class SplitInstallManagerFactory {

   // $FF: renamed from: <init> () void
   public void method_271() {
      super();
   }

   public static SplitInstallManager create(Context var0) {
      class_63 var10000 = new class_63;
      class_38 var10002 = new class_38;
      var10002.method_78(var0);
      var10000.method_134(var10002, var0);
      return var10000;
   }
}
