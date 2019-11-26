package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.play.core.internal.class_108;
import com.google.android.play.core.internal.class_12;
import com.google.android.play.core.internal.class_39;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.play.core.internal.bg
public abstract class class_46 extends class_39 implements class_12 {

   // $FF: renamed from: <init> () void
   public void method_106() {
      super.method_97("com.google.android.play.core.splitinstall.protocol.ISplitInstallServiceCallback");
   }

   // $FF: renamed from: a (int, android.os.Parcel) boolean
   protected final boolean method_98(int var1, Parcel var2) throws RemoteException {
      Bundle var10000;
      Bundle var3;
      Bundle var4;
      int var5;
      switch(var1) {
      case 2:
         var5 = var2.readInt();
         var4 = (Bundle)class_108.method_324(var2, Bundle.CREATOR);
         this.method_21(var5, var4);
         break;
      case 3:
         var5 = var2.readInt();
         var10000 = (Bundle)class_108.method_324(var2, Bundle.CREATOR);
         this.method_22(var5);
         break;
      case 4:
         var5 = var2.readInt();
         var4 = (Bundle)class_108.method_324(var2, Bundle.CREATOR);
         this.method_23(var5, var4);
         break;
      case 5:
         var5 = var2.readInt();
         var4 = (Bundle)class_108.method_324(var2, Bundle.CREATOR);
         this.method_24(var5, var4);
         break;
      case 6:
         var3 = (Bundle)class_108.method_324(var2, Bundle.CREATOR);
         this.method_25(var3);
         break;
      case 7:
         ArrayList var6 = var2.createTypedArrayList(Bundle.CREATOR);
         this.method_26(var6);
         break;
      case 8:
         var3 = (Bundle)class_108.method_324(var2, Bundle.CREATOR);
         this.method_27(var3);
         break;
      case 9:
         var3 = (Bundle)class_108.method_324(var2, Bundle.CREATOR);
         this.method_28(var3);
         break;
      case 10:
         var10000 = (Bundle)class_108.method_324(var2, Bundle.CREATOR);
         this.method_29();
         break;
      case 11:
         var10000 = (Bundle)class_108.method_324(var2, Bundle.CREATOR);
         this.method_30();
         break;
      case 12:
         var3 = (Bundle)class_108.method_324(var2, Bundle.CREATOR);
         this.method_31(var3);
         break;
      case 13:
         var3 = (Bundle)class_108.method_324(var2, Bundle.CREATOR);
         this.method_32(var3);
         break;
      default:
         return false;
      }

      return true;
   }
}
