package com.google.android.play.core.internal;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

// $FF: renamed from: com.google.android.play.core.internal.bm
final class class_104 extends WeakReference {

   // $FF: renamed from: a int
   private final int field_192;


   // $FF: renamed from: <init> (java.lang.Throwable, java.lang.ref.ReferenceQueue) void
   public void method_309(Throwable var1, ReferenceQueue var2) {
      super(var1, var2);
      if(var1 == null) {
         throw new NullPointerException("The referent cannot be null");
      } else {
         this.field_192 = System.identityHashCode(var1);
      }
   }

   public final int hashCode() {
      return this.field_192;
   }

   public final boolean equals(Object var1) {
      if(var1 != null && var1.getClass() == this.getClass()) {
         if(this == var1) {
            return true;
         } else {
            class_104 var2 = (class_104)var1;
            return this.field_192 == var2.field_192 && this.get() == var2.get();
         }
      } else {
         return false;
      }
   }
}
