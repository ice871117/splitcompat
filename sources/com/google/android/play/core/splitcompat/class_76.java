package com.google.android.play.core.splitcompat;

import com.google.android.play.core.splitcompat.SplitCompat;
import com.google.android.play.core.splitinstall.class_2;
import java.util.Set;

// $FF: renamed from: com.google.android.play.core.splitcompat.n
final class class_76 implements class_2 {

   // $FF: renamed from: a com.google.android.play.core.splitcompat.SplitCompat
   // $FF: synthetic field
   private final SplitCompat field_134;


   // $FF: renamed from: <init> (com.google.android.play.core.splitcompat.SplitCompat) void
   void method_199(SplitCompat var1) {
      this.field_134 = var1;
      super();
   }

   // $FF: renamed from: a () java.util.Set
   public final Set method_2() {
      return SplitCompat.method_268(this.field_134);
   }
}
