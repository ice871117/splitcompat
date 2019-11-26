package com.google.android.play.core.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

// $FF: renamed from: com.google.android.play.core.internal.i
public class class_108 {

   // $FF: renamed from: <init> () void
   private void method_323() {
      super();
   }

   // $FF: renamed from: a (android.os.Parcel, android.os.Parcelable.Creator) android.os.Parcelable
   public static Parcelable method_324(Parcel var0, Creator var1) {
      return var0.readInt() == 0?null:(Parcelable)var1.createFromParcel(var0);
   }

   // $FF: renamed from: a (android.os.Parcel, android.os.Parcelable) void
   public static void method_325(Parcel var0, Parcelable var1) {
      if(var1 == null) {
         var0.writeInt(0);
      } else {
         var0.writeInt(1);
         var1.writeToParcel(var0, 0);
      }
   }

   // $FF: renamed from: a (android.os.Parcel, android.os.IInterface) void
   public static void method_326(Parcel var0, IInterface var1) {
      if(var1 == null) {
         var0.writeStrongBinder((IBinder)null);
      } else {
         var0.writeStrongBinder(var1.asBinder());
      }
   }

   // $FF: renamed from: <clinit> () void
   static void method_327() {
      class_108.class.getClassLoader();
   }
}
