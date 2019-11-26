package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.play.core.internal.class_108;
import com.google.android.play.core.internal.class_112;
import com.google.android.play.core.internal.class_8;
import com.google.android.play.core.internal.class_9;

// $FF: renamed from: com.google.android.play.core.internal.o
public final class class_114 extends class_112 implements class_9 {

   // $FF: renamed from: <init> (android.os.IBinder) void
   void method_368(IBinder var1) {
      super.method_364(var1, "com.google.android.play.core.appupdate.protocol.IAppUpdateService");
   }

   // $FF: renamed from: a (java.lang.String, android.os.Bundle, com.google.android.play.core.internal.n) void
   public final void method_9(String var1, Bundle var2, class_8 var3) throws RemoteException {
      Parcel var4;
      (var4 = this.method_365()).writeString(var1);
      class_108.method_325(var4, var2);
      class_108.method_326(var4, var3);
      this.method_366(2, var4);
   }

   // $FF: renamed from: b (java.lang.String, android.os.Bundle, com.google.android.play.core.internal.n) void
   public final void method_10(String var1, Bundle var2, class_8 var3) throws RemoteException {
      Parcel var4;
      (var4 = this.method_365()).writeString(var1);
      class_108.method_325(var4, var2);
      class_108.method_326(var4, var3);
      this.method_366(3, var4);
   }
}
