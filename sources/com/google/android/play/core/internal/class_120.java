package com.google.android.play.core.internal;

import android.os.IBinder.DeathRecipient;
import com.google.android.play.core.internal.class_122;

// $FF: renamed from: com.google.android.play.core.internal.t
// $FF: synthetic class
final class class_120 implements DeathRecipient {

   // $FF: renamed from: a com.google.android.play.core.internal.q
   private final class_122 field_199;


   // $FF: renamed from: <init> (com.google.android.play.core.internal.q) void
   void method_374(class_122 var1) {
      super();
      this.field_199 = var1;
   }

   public final void binderDied() {
      this.field_199.method_399();
   }
}
