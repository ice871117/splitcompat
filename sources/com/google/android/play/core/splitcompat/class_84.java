package com.google.android.play.core.splitcompat;

import com.google.android.play.core.splitcompat.class_3;
import com.google.android.play.core.splitcompat.class_78;
import com.google.android.play.core.splitcompat.class_85;
import java.io.File;
import java.io.IOException;

// $FF: renamed from: com.google.android.play.core.splitcompat.f
final class class_84 implements class_3 {

   // $FF: renamed from: a com.google.android.play.core.splitcompat.g
   // $FF: synthetic field
   private final class_85 field_150;


   // $FF: renamed from: <init> (com.google.android.play.core.splitcompat.g) void
   void method_215(class_85 var1) {
      this.field_150 = var1;
      super();
   }

   // $FF: renamed from: a (com.google.android.play.core.splitcompat.l, java.io.File, boolean) void
   public final void method_3(class_78 var1, File var2, boolean var3) throws IOException {
      this.field_150.field_152.add(var2);
      if(!var3) {
         this.field_150.field_153.set(false);
      }

   }
}
