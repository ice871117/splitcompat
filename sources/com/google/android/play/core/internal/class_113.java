package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.play.core.internal.class_10;
import com.google.android.play.core.internal.class_108;
import com.google.android.play.core.internal.class_112;
import com.google.android.play.core.internal.class_12;
import java.util.List;

// $FF: renamed from: com.google.android.play.core.internal.bf
public final class class_113 extends class_112 implements class_10 {

   // $FF: renamed from: <init> (android.os.IBinder) void
   void method_367(IBinder var1) {
      super.method_364(var1, "com.google.android.play.core.splitinstall.protocol.ISplitInstallService");
   }

   // $FF: renamed from: a (java.lang.String, java.util.List, android.os.Bundle, com.google.android.play.core.internal.be) void
   public final void method_11(String var1, List var2, Bundle var3, class_12 var4) throws RemoteException {
      Parcel var5;
      (var5 = this.method_365()).writeString(var1);
      var5.writeTypedList(var2);
      class_108.method_325(var5, var3);
      class_108.method_326(var5, var4);
      this.method_366(2, var5);
   }

   // $FF: renamed from: a (java.lang.String, int, android.os.Bundle, com.google.android.play.core.internal.be) void
   public final void method_12(String var1, int var2, Bundle var3, class_12 var4) throws RemoteException {
      Parcel var5;
      (var5 = this.method_365()).writeString(var1);
      var5.writeInt(var2);
      class_108.method_325(var5, var3);
      class_108.method_326(var5, var4);
      this.method_366(4, var5);
   }

   // $FF: renamed from: a (java.lang.String, int, com.google.android.play.core.internal.be) void
   public final void method_13(String var1, int var2, class_12 var3) throws RemoteException {
      Parcel var4;
      (var4 = this.method_365()).writeString(var1);
      var4.writeInt(var2);
      class_108.method_326(var4, var3);
      this.method_366(5, var4);
   }

   // $FF: renamed from: a (java.lang.String, com.google.android.play.core.internal.be) void
   public final void method_14(String var1, class_12 var2) throws RemoteException {
      Parcel var3;
      (var3 = this.method_365()).writeString(var1);
      class_108.method_326(var3, var2);
      this.method_366(6, var3);
   }

   // $FF: renamed from: b (java.lang.String, java.util.List, android.os.Bundle, com.google.android.play.core.internal.be) void
   public final void method_15(String var1, List var2, Bundle var3, class_12 var4) throws RemoteException {
      Parcel var5;
      (var5 = this.method_365()).writeString(var1);
      var5.writeTypedList(var2);
      class_108.method_325(var5, var3);
      class_108.method_326(var5, var4);
      this.method_366(7, var5);
   }

   // $FF: renamed from: c (java.lang.String, java.util.List, android.os.Bundle, com.google.android.play.core.internal.be) void
   public final void method_16(String var1, List var2, Bundle var3, class_12 var4) throws RemoteException {
      Parcel var5;
      (var5 = this.method_365()).writeString(var1);
      var5.writeTypedList(var2);
      class_108.method_325(var5, var3);
      class_108.method_326(var5, var4);
      this.method_366(8, var5);
   }

   // $FF: renamed from: d (java.lang.String, java.util.List, android.os.Bundle, com.google.android.play.core.internal.be) void
   public final void method_17(String var1, List var2, Bundle var3, class_12 var4) throws RemoteException {
      Parcel var5;
      (var5 = this.method_365()).writeString(var1);
      var5.writeTypedList(var2);
      class_108.method_325(var5, var3);
      class_108.method_326(var5, var4);
      this.method_366(13, var5);
   }

   // $FF: renamed from: e (java.lang.String, java.util.List, android.os.Bundle, com.google.android.play.core.internal.be) void
   public final void method_18(String var1, List var2, Bundle var3, class_12 var4) throws RemoteException {
      Parcel var5;
      (var5 = this.method_365()).writeString(var1);
      var5.writeTypedList(var2);
      class_108.method_325(var5, var3);
      class_108.method_326(var5, var4);
      this.method_366(14, var5);
   }
}
