package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.play.core.internal.class_108;
import com.google.android.play.core.internal.class_39;
import com.google.android.play.core.internal.class_8;

// $FF: renamed from: com.google.android.play.core.internal.p
public abstract class class_42 extends class_39 implements class_8 {

   // $FF: renamed from: <init> () void
   public void method_102() {
      super.method_97("com.google.android.play.core.appupdate.protocol.IAppUpdateServiceCallback");
   }

   // $FF: renamed from: a (int, android.os.Parcel) boolean
   protected final boolean method_98(int var1, Parcel var2) throws RemoteException {
      Bundle var3;
      switch(var1) {
      case 2:
         var3 = (Bundle)class_108.method_324(var2, Bundle.CREATOR);
         this.method_7(var3);
         break;
      case 3:
         var3 = (Bundle)class_108.method_324(var2, Bundle.CREATOR);
         this.method_8(var3);
         break;
      default:
         return false;
      }

      return true;
   }
}
