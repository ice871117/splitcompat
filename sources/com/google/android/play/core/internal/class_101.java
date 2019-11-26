package com.google.android.play.core.internal;

import com.google.android.play.core.internal.class_100;
import com.google.android.play.core.internal.class_131;

// $FF: renamed from: com.google.android.play.core.internal.bl
final class class_101 extends class_100 {

   // $FF: renamed from: a com.google.android.play.core.internal.bj
   private final class_131 field_186;


   // $FF: renamed from: <init> () void
   void method_301() {
      super.method_301();
      class_131 var10001 = new class_131;
      var10001.method_436();
      this.field_186 = var10001;
   }

   // $FF: renamed from: a (java.lang.Throwable, java.lang.Throwable) void
   public final void method_302(Throwable var1, Throwable var2) {
      if(var2 == var1) {
         throw new IllegalArgumentException("Self suppression is not allowed.", var2);
      } else if(var2 == null) {
         throw new NullPointerException("The suppressed exception cannot be null.");
      } else {
         this.field_186.method_437(var1, true).add(var2);
      }
   }
}
