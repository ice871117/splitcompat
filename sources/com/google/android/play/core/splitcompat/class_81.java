package com.google.android.play.core.splitcompat;

import android.util.Log;
import com.google.android.play.core.splitcompat.class_3;
import com.google.android.play.core.splitcompat.class_74;
import com.google.android.play.core.splitcompat.class_78;
import com.google.android.play.core.splitcompat.class_86;
import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.zip.ZipFile;

// $FF: renamed from: com.google.android.play.core.splitcompat.h
final class class_81 implements class_3 {

   // $FF: renamed from: a java.util.Set
   // $FF: synthetic field
   private final Set field_142;
   // $FF: renamed from: b com.google.android.play.core.splitcompat.q
   // $FF: synthetic field
   private final class_74 field_143;
   // $FF: renamed from: c java.util.zip.ZipFile
   // $FF: synthetic field
   private final ZipFile field_144;


   // $FF: renamed from: <init> (java.util.Set, com.google.android.play.core.splitcompat.q, java.util.zip.ZipFile) void
   void method_209(Set var1, class_74 var2, ZipFile var3) {
      this.field_142 = var1;
      this.field_143 = var2;
      this.field_144 = var3;
      super();
   }

   // $FF: renamed from: a (com.google.android.play.core.splitcompat.l, java.io.File, boolean) void
   public final void method_3(class_78 var1, File var2, boolean var3) throws IOException {
      this.field_142.add(var2);
      if(!var3) {
         Log.i("SplitCompat", String.format("NativeLibraryExtractor: split \'%s\' has native library \'%s\' that does not exist; extracting from \'%s!%s\' to \'%s\'", new Object[]{this.field_143.method_197(), var1.field_137, this.field_143.method_196().getAbsolutePath(), var1.field_138.getName(), var2.getAbsolutePath()}));
         class_86.method_226(this.field_144, var1.field_138, var2);
      }

   }
}
