package com.google.android.play.core.splitcompat;

import android.util.Log;
import com.google.android.play.core.splitcompat.SplitCompat;
import java.util.Iterator;
import java.util.Set;

// $FF: renamed from: com.google.android.play.core.splitcompat.o
final class class_77 implements Runnable {

   // $FF: renamed from: a java.util.Set
   // $FF: synthetic field
   private final Set field_135;
   // $FF: renamed from: b com.google.android.play.core.splitcompat.SplitCompat
   // $FF: synthetic field
   private final SplitCompat field_136;


   // $FF: renamed from: <init> (com.google.android.play.core.splitcompat.SplitCompat, java.util.Set) void
   void method_200(SplitCompat var1, Set var2) {
      this.field_136 = var1;
      this.field_135 = var2;
      super();
   }

   public final void run() {
      try {
         Iterator var1 = this.field_135.iterator();

         while(var1.hasNext()) {
            String var2 = (String)var1.next();
            SplitCompat.method_269(this.field_136).method_251(var2);
         }

      } catch (Exception var3) {
         Log.e("SplitCompat", "Failed to remove from splitcompat storage split that is already installed", var3);
      }
   }
}
