package com.google.android.play.core.internal;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.play.core.internal.class_114;
import com.google.android.play.core.internal.class_39;
import com.google.android.play.core.internal.class_9;

// $FF: renamed from: com.google.android.play.core.internal.l
public abstract class class_41 extends class_39 implements class_9 {

   // $FF: renamed from: a (android.os.IBinder) com.google.android.play.core.internal.m
   public static class_9 method_101(IBinder var0) {
      if(var0 == null) {
         return null;
      } else {
         IInterface var1;
         if((var1 = var0.queryLocalInterface("com.google.android.play.core.appupdate.protocol.IAppUpdateService")) instanceof class_9) {
            return (class_9)var1;
         } else {
            class_114 var10000 = new class_114;
            var10000.method_368(var0);
            return var10000;
         }
      }
   }
}
