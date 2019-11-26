package com.google.android.play.core.internal;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.play.core.internal.class_10;
import com.google.android.play.core.internal.class_113;
import com.google.android.play.core.internal.class_39;

// $FF: renamed from: com.google.android.play.core.internal.bc
public abstract class class_40 extends class_39 implements class_10 {

   // $FF: renamed from: a (android.os.IBinder) com.google.android.play.core.internal.bd
   public static class_10 method_100(IBinder var0) {
      if(var0 == null) {
         return null;
      } else {
         IInterface var1;
         if((var1 = var0.queryLocalInterface("com.google.android.play.core.splitinstall.protocol.ISplitInstallService")) instanceof class_10) {
            return (class_10)var1;
         } else {
            class_113 var10000 = new class_113;
            var10000.method_367(var0);
            return var10000;
         }
      }
   }
}
