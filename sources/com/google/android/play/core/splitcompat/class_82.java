package com.google.android.play.core.splitcompat;

import com.google.android.play.core.splitcompat.class_4;
import com.google.android.play.core.splitcompat.class_74;
import com.google.android.play.core.splitcompat.class_86;
import java.io.IOException;
import java.util.Set;
import java.util.zip.ZipFile;

// $FF: renamed from: com.google.android.play.core.splitcompat.i
final class class_82 implements class_4 {

   // $FF: renamed from: a java.util.Set
   // $FF: synthetic field
   private final Set field_145;
   // $FF: renamed from: b com.google.android.play.core.splitcompat.q
   // $FF: synthetic field
   private final class_74 field_146;
   // $FF: renamed from: c com.google.android.play.core.splitcompat.d
   // $FF: synthetic field
   private final class_86 field_147;


   // $FF: renamed from: <init> (com.google.android.play.core.splitcompat.d, java.util.Set, com.google.android.play.core.splitcompat.q) void
   void method_210(class_86 var1, Set var2, class_74 var3) {
      this.field_147 = var1;
      this.field_145 = var2;
      this.field_146 = var3;
      super();
   }

   // $FF: renamed from: a (java.util.zip.ZipFile, java.util.Set) void
   public final void method_4(ZipFile var1, Set var2) throws IOException {
      this.field_145.addAll(class_86.method_225(this.field_147, var2, this.field_146, var1));
   }
}
