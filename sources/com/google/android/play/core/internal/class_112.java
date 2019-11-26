package com.google.android.play.core.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

// $FF: renamed from: com.google.android.play.core.internal.g
public class class_112 implements IInterface {

   // $FF: renamed from: a android.os.IBinder
   private final IBinder field_195;
   // $FF: renamed from: b java.lang.String
   private final String field_196;


   // $FF: renamed from: <init> (android.os.IBinder, java.lang.String) void
   protected void method_364(IBinder var1, String var2) {
      super();
      this.field_195 = var1;
      this.field_196 = var2;
   }

   public IBinder asBinder() {
      return this.field_195;
   }

   // $FF: renamed from: a () android.os.Parcel
   protected final Parcel method_365() {
      Parcel var1;
      (var1 = Parcel.obtain()).writeInterfaceToken(this.field_196);
      return var1;
   }

   // $FF: renamed from: a (int, android.os.Parcel) void
   protected final void method_366(int var1, Parcel var2) throws RemoteException {
      try {
         this.field_195.transact(var1, var2, (Parcel)null, 1);
      } finally {
         var2.recycle();
      }

   }
}
