package com.google.android.play.core.listener;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.play.core.internal.class_145;
import com.google.android.play.core.listener.StateUpdatedListener;
import com.google.android.play.core.listener.class_18;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// $FF: renamed from: com.google.android.play.core.listener.a
public abstract class class_20 {

   // $FF: renamed from: a com.google.android.play.core.internal.ag
   protected final class_145 field_5;
   // $FF: renamed from: b android.content.IntentFilter
   private final IntentFilter field_6;
   // $FF: renamed from: c android.content.Context
   private final Context field_7;
   // $FF: renamed from: d java.util.Set
   private final Set field_8;
   // $FF: renamed from: e com.google.android.play.core.listener.b
   private class_18 field_9;
   // $FF: renamed from: f boolean
   private volatile boolean field_10;


   // $FF: renamed from: <init> (com.google.android.play.core.internal.ag, android.content.IntentFilter, android.content.Context) void
   protected void method_46(class_145 var1, IntentFilter var2, Context var3) {
      super();
      this.field_8 = new HashSet();
      this.field_9 = null;
      this.field_10 = false;
      this.field_5 = var1;
      this.field_6 = var2;
      Context var4 = var3.getApplicationContext();
      this.field_7 = var4 != null?var4:var3;
   }

   // $FF: renamed from: a (boolean) void
   public final synchronized void method_47(boolean var1) {
      this.field_10 = true;
      this.method_52();
   }

   // $FF: renamed from: a (com.google.android.play.core.listener.StateUpdatedListener) void
   public final synchronized void method_48(StateUpdatedListener var1) {
      this.field_5.method_490("registerListener", new Object[0]);
      this.field_8.add(var1);
      this.method_52();
   }

   // $FF: renamed from: b (com.google.android.play.core.listener.StateUpdatedListener) void
   public final synchronized void method_49(StateUpdatedListener var1) {
      this.field_5.method_490("unregisterListener", new Object[0]);
      this.field_8.remove(var1);
      this.method_52();
   }

   // $FF: renamed from: a (android.content.Context, android.content.Intent) void
   protected abstract void method_50(Context var1, Intent var2);

   // $FF: renamed from: a (java.lang.Object) void
   public final synchronized void method_51(Object var1) {
      Iterator var2 = (new HashSet(this.field_8)).iterator();

      while(var2.hasNext()) {
         ((StateUpdatedListener)var2.next()).onStateUpdate(var1);
      }

   }

   // $FF: renamed from: a () void
   private final void method_52() {
      if((this.field_10 || !this.field_8.isEmpty()) && this.field_9 == null) {
         class_18 var10001 = new class_18;
         var10001.method_41(this, (byte)0);
         this.field_9 = var10001;
         this.field_7.registerReceiver(this.field_9, this.field_6);
      }

      if(!this.field_10 && this.field_8.isEmpty() && this.field_9 != null) {
         this.field_7.unregisterReceiver(this.field_9);
         this.field_9 = null;
      }

   }
}
