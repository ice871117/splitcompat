package com.google.android.play.core.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.play.core.internal.class_7;

// $FF: renamed from: com.google.android.play.core.internal.j
public class class_39 extends Binder implements IInterface {

   // $FF: renamed from: a com.google.android.play.core.internal.k
   private static class_7 field_55;


   // $FF: renamed from: <init> (java.lang.String) void
   protected void method_97(String var1) {
      super();
      this.attachInterface(this, var1);
   }

   public IBinder asBinder() {
      return this;
   }

   public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
      boolean var10000;
      if(var1 > 16777215) {
         var10000 = super.onTransact(var1, var2, var3, var4);
      } else {
         var2.enforceInterface(this.getInterfaceDescriptor());
         var10000 = false;
      }

      if(var10000) {
         return true;
      } else {
         Object var10 = null;
         return this.method_98(var1, var2);
      }
   }

   // $FF: renamed from: a (int, android.os.Parcel) boolean
   protected boolean method_98(int var1, Parcel var2) throws RemoteException {
      return false;
   }

   // $FF: renamed from: <clinit> () void
   static void method_99() {
      field_55 = null;
   }
}
