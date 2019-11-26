package com.google.android.play.core.internal;

import com.google.android.play.core.internal.class_104;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

// $FF: renamed from: com.google.android.play.core.internal.bj
final class class_131 {

   // $FF: renamed from: a java.util.concurrent.ConcurrentHashMap
   private final ConcurrentHashMap field_219;
   // $FF: renamed from: b java.lang.ref.ReferenceQueue
   private final ReferenceQueue field_220;


   // $FF: renamed from: <init> () void
   void method_436() {
      super();
      this.field_219 = new ConcurrentHashMap(16, 0.75F, 10);
      this.field_220 = new ReferenceQueue();
   }

   // $FF: renamed from: a (java.lang.Throwable, boolean) java.util.List
   public final List method_437(Throwable var1, boolean var2) {
      class_131 var6 = this;

      for(Reference var7 = this.field_220.poll(); var7 != null; var7 = var6.field_220.poll()) {
         var6.field_219.remove(var7);
      }

      class_104 var10000 = new class_104;
      var10000.method_309(var1, (ReferenceQueue)null);
      class_104 var3 = var10000;
      List var4;
      if((var4 = (List)this.field_219.get(var3)) != null) {
         return var4;
      } else {
         Vector var5 = new Vector(2);
         ConcurrentHashMap var8 = this.field_219;
         class_104 var10001 = new class_104;
         var10001.method_309(var1, this.field_220);
         return (List)((var4 = (List)var8.putIfAbsent(var10001, var5)) == null?var5:var4);
      }
   }
}
