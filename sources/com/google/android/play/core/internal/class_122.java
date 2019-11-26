package com.google.android.play.core.internal;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IInterface;
import android.os.RemoteException;
import android.os.Build.VERSION;
import android.os.IBinder.DeathRecipient;
import com.google.android.play.core.internal.class_120;
import com.google.android.play.core.internal.class_13;
import com.google.android.play.core.internal.class_137;
import com.google.android.play.core.internal.class_14;
import com.google.android.play.core.internal.class_140;
import com.google.android.play.core.internal.class_145;
import com.google.android.play.core.internal.class_23;
import com.google.android.play.core.internal.class_24;
import com.google.android.play.core.internal.class_27;
import com.google.android.play.core.tasks.class_98;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// $FF: renamed from: com.google.android.play.core.internal.q
public final class class_122 {

   // $FF: renamed from: a java.util.Map
   private static final Map field_200;
   // $FF: renamed from: b android.content.Context
   private final Context field_201;
   // $FF: renamed from: c com.google.android.play.core.internal.ag
   private final class_145 field_202;
   // $FF: renamed from: d java.lang.String
   private final String field_203;
   // $FF: renamed from: e java.util.List
   private final List field_204;
   // $FF: renamed from: f boolean
   private boolean field_205;
   // $FF: renamed from: g android.content.Intent
   private final Intent field_206;
   // $FF: renamed from: h com.google.android.play.core.internal.x
   private final class_13 field_207;
   // $FF: renamed from: i java.lang.ref.WeakReference
   private final WeakReference field_208;
   // $FF: renamed from: j android.os.IBinder.DeathRecipient
   private final DeathRecipient field_209;
   // $FF: renamed from: k android.content.ServiceConnection
   private ServiceConnection field_210;
   // $FF: renamed from: l android.os.IInterface
   private IInterface field_211;


   // $FF: renamed from: <init> (android.content.Context, com.google.android.play.core.internal.ag, java.lang.String, android.content.Intent, com.google.android.play.core.internal.x) void
   public void method_376(Context var1, class_145 var2, String var3, Intent var4, class_13 var5) {
      this.method_377(var1, var2, var3, var4, var5, (class_14)null);
   }

   // $FF: renamed from: <init> (android.content.Context, com.google.android.play.core.internal.ag, java.lang.String, android.content.Intent, com.google.android.play.core.internal.x, com.google.android.play.core.internal.u) void
   private void method_377(Context var1, class_145 var2, String var3, Intent var4, class_13 var5, class_14 var6) {
      super();
      this.field_204 = new ArrayList();
      class_120 var10001 = new class_120;
      var10001.method_374(this);
      this.field_209 = var10001;
      this.field_201 = var1;
      this.field_202 = var2;
      this.field_203 = var3;
      this.field_206 = var4;
      this.field_207 = var5;
      this.field_208 = new WeakReference((Object)null);
   }

   // $FF: renamed from: a (com.google.android.play.core.internal.r) void
   public final void method_378(class_23 var1) {
      class_27 var10001 = new class_27;
      var10001.method_67(this, var1.method_62(), var1);
      this.method_383(var10001);
   }

   // $FF: renamed from: a () void
   public final void method_379() {
      class_24 var10001 = new class_24;
      var10001.method_64(this);
      this.method_383(var10001);
   }

   // $FF: renamed from: b () android.os.IInterface
   public final IInterface method_380() {
      return this.field_211;
   }

   // $FF: renamed from: d () android.os.Handler
   private final Handler method_381() {
      Map var1 = field_200;
      synchronized(field_200) {
         if(!field_200.containsKey(this.field_203)) {
            HandlerThread var2;
            (var2 = new HandlerThread(this.field_203, 10)).start();
            field_200.put(this.field_203, new Handler(var2.getLooper()));
         }

         return (Handler)field_200.get(this.field_203);
      }
   }

   // $FF: renamed from: b (com.google.android.play.core.internal.r) void
   private final void method_382(class_23 var1) {
      if(this.field_211 == null && !this.field_205) {
         this.field_202.method_490("Initiate binding to the service.", new Object[0]);
         this.field_204.add(var1);
         class_140 var10001 = new class_140;
         var10001.method_476(this, (byte)0);
         this.field_210 = var10001;
         this.field_205 = true;
         if(!this.field_201.bindService(this.field_206, this.field_210, 1)) {
            this.field_202.method_490("Failed to bind to the service.", new Object[0]);
            this.field_205 = false;
            Iterator var2 = this.field_204.iterator();

            while(var2.hasNext()) {
               class_98 var4;
               if((var4 = ((class_23)var2.next()).method_62()) != null) {
                  class_137 var5 = new class_137;
                  var5.method_460();
                  var4.method_292(var5);
               }
            }

            this.field_204.clear();
            return;
         }
      } else {
         if(this.field_205) {
            this.field_202.method_490("Waiting to bind to the service.", new Object[0]);
            this.field_204.add(var1);
            return;
         }

         var1.run();
      }

   }

   // $FF: renamed from: c (com.google.android.play.core.internal.r) void
   private final void method_383(class_23 var1) {
      this.method_381().post(var1);
   }

   // $FF: renamed from: e () void
   private final void method_384() {
      this.field_202.method_490("linkToDeath", new Object[0]);

      try {
         this.field_211.asBinder().linkToDeath(this.field_209, 0);
      } catch (RemoteException var2) {
         this.field_202.method_494(var2, "linkToDeath failed", new Object[0]);
      }
   }

   // $FF: renamed from: f () void
   private final void method_385() {
      this.field_202.method_490("unlinkToDeath", new Object[0]);
      this.field_211.asBinder().unlinkToDeath(this.field_209, 0);
   }

   // $FF: renamed from: a (com.google.android.play.core.internal.q, com.google.android.play.core.internal.r) void
   // $FF: synthetic method
   static void method_386(class_122 var0, class_23 var1) {
      var0.method_382(var1);
   }

   // $FF: renamed from: a (com.google.android.play.core.internal.q) android.os.IInterface
   // $FF: synthetic method
   static IInterface method_387(class_122 var0) {
      return var0.field_211;
   }

   // $FF: renamed from: b (com.google.android.play.core.internal.q) com.google.android.play.core.internal.ag
   // $FF: synthetic method
   static class_145 method_388(class_122 var0) {
      return var0.field_202;
   }

   // $FF: renamed from: c (com.google.android.play.core.internal.q) android.content.ServiceConnection
   // $FF: synthetic method
   static ServiceConnection method_389(class_122 var0) {
      return var0.field_210;
   }

   // $FF: renamed from: d (com.google.android.play.core.internal.q) android.content.Context
   // $FF: synthetic method
   static Context method_390(class_122 var0) {
      return var0.field_201;
   }

   // $FF: renamed from: a (com.google.android.play.core.internal.q, boolean) boolean
   // $FF: synthetic method
   static boolean method_391(class_122 var0, boolean var1) {
      return var0.field_205 = false;
   }

   // $FF: renamed from: a (com.google.android.play.core.internal.q, android.os.IInterface) android.os.IInterface
   // $FF: synthetic method
   static IInterface method_392(class_122 var0, IInterface var1) {
      return var0.field_211 = var1;
   }

   // $FF: renamed from: a (com.google.android.play.core.internal.q, android.content.ServiceConnection) android.content.ServiceConnection
   // $FF: synthetic method
   static ServiceConnection method_393(class_122 var0, ServiceConnection var1) {
      return var0.field_210 = null;
   }

   // $FF: renamed from: e (com.google.android.play.core.internal.q) com.google.android.play.core.internal.x
   // $FF: synthetic method
   static class_13 method_394(class_122 var0) {
      return var0.field_207;
   }

   // $FF: renamed from: f (com.google.android.play.core.internal.q) void
   // $FF: synthetic method
   static void method_395(class_122 var0) {
      var0.method_384();
   }

   // $FF: renamed from: g (com.google.android.play.core.internal.q) java.util.List
   // $FF: synthetic method
   static List method_396(class_122 var0) {
      return var0.field_204;
   }

   // $FF: renamed from: b (com.google.android.play.core.internal.q, com.google.android.play.core.internal.r) void
   // $FF: synthetic method
   static void method_397(class_122 var0, class_23 var1) {
      var0.method_383(var1);
   }

   // $FF: renamed from: h (com.google.android.play.core.internal.q) void
   // $FF: synthetic method
   static void method_398(class_122 var0) {
      var0.method_385();
   }

   // $FF: renamed from: c () void
   // $FF: synthetic method
   final void method_399() {
      this.field_202.method_490("reportBinderDeath", new Object[0]);
      class_14 var2;
      if((var2 = (class_14)this.field_208.get()) != null) {
         this.field_202.method_490("calling onBinderDied", new Object[0]);
         var2.method_34();
      } else {
         class_122 var3 = this;
         this.field_202.method_490("%s : Binder has died.", new Object[]{this.field_203});
         Iterator var4 = this.field_204.iterator();

         while(var4.hasNext()) {
            class_98 var6;
            if((var6 = ((class_23)var4.next()).method_62()) != null) {
               var6.method_292(VERSION.SDK_INT < 15?new RemoteException():new RemoteException(String.valueOf(var3.field_203).concat(" : Binder has died.")));
            }
         }

         var3.field_204.clear();
      }
   }

   // $FF: renamed from: <clinit> () void
   static void method_400() {
      field_200 = Collections.synchronizedMap(new HashMap());
   }
}
