package com.google.android.play.core.splitcompat;

import com.google.android.play.core.splitcompat.class_4;
import com.google.android.play.core.splitcompat.class_74;
import com.google.android.play.core.splitcompat.class_84;
import com.google.android.play.core.splitcompat.class_86;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.ZipFile;

// $FF: renamed from: com.google.android.play.core.splitcompat.g
final class class_85 implements class_4 {

   // $FF: renamed from: c com.google.android.play.core.splitcompat.q
   // $FF: synthetic field
   private final class_74 field_151;
   // $FF: renamed from: a java.util.Set
   // $FF: synthetic field
   final Set field_152;
   // $FF: renamed from: b java.util.concurrent.atomic.AtomicBoolean
   // $FF: synthetic field
   final AtomicBoolean field_153;
   // $FF: renamed from: d com.google.android.play.core.splitcompat.d
   // $FF: synthetic field
   private final class_86 field_154;


   // $FF: renamed from: <init> (com.google.android.play.core.splitcompat.d, com.google.android.play.core.splitcompat.q, java.util.Set, java.util.concurrent.atomic.AtomicBoolean) void
   void method_216(class_86 var1, class_74 var2, Set var3, AtomicBoolean var4) {
      this.field_154 = var1;
      this.field_151 = var2;
      this.field_152 = var3;
      this.field_153 = var4;
      super();
   }

   // $FF: renamed from: a (java.util.zip.ZipFile, java.util.Set) void
   public final void method_4(ZipFile var1, Set var2) throws IOException {
      class_86 var10000 = this.field_154;
      class_74 var10001 = this.field_151;
      class_84 var10003 = new class_84;
      var10003.method_215(this);
      class_86.method_224(var10000, var10001, var2, var10003);
   }
}
