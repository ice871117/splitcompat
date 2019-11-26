package com.google.android.play.core.internal;

import android.util.Log;
import com.google.android.play.core.internal.class_138;
import com.google.android.play.core.splitinstall.class_60;
import java.util.List;

// $FF: renamed from: com.google.android.play.core.internal.ab
final class class_139 implements Runnable {

   // $FF: renamed from: a java.util.List
   // $FF: synthetic field
   private final List field_240;
   // $FF: renamed from: b com.google.android.play.core.splitinstall.b
   // $FF: synthetic field
   private final class_60 field_241;
   // $FF: renamed from: c com.google.android.play.core.internal.ac
   // $FF: synthetic field
   private final class_138 field_242;


   // $FF: renamed from: <init> (com.google.android.play.core.internal.ac, java.util.List, com.google.android.play.core.splitinstall.b) void
   void method_474(class_138 var1, List var2, class_60 var3) {
      this.field_242 = var1;
      this.field_240 = var2;
      this.field_241 = var3;
      super();
   }

   public final void run() {
      boolean var1;
      try {
         var1 = class_138.method_468(this.field_242).method_484(this.field_240);
      } catch (Exception var3) {
         Log.e("SplitCompat", "Error checking verified files.", var3);
         this.field_241.method_124(-11);
         return;
      }

      if(var1) {
         class_138.method_469(this.field_242, this.field_241);
      } else {
         class_138.method_470(this.field_242, this.field_240, this.field_241);
      }
   }
}
