package com.google.android.play.core.internal;

import com.google.android.play.core.internal.class_11;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.security.MessageDigest;

// $FF: renamed from: com.google.android.play.core.internal.a
final class class_135 implements class_11 {

   // $FF: renamed from: a java.nio.channels.FileChannel
   private final FileChannel field_228;
   // $FF: renamed from: b long
   private final long field_229;
   // $FF: renamed from: c long
   private final long field_230;


   // $FF: renamed from: <init> (java.nio.channels.FileChannel, long, long) void
   public void method_452(FileChannel var1, long var2, long var4) {
      super();
      this.field_228 = var1;
      this.field_229 = var2;
      this.field_230 = var4;
   }

   // $FF: renamed from: a () long
   public final long method_19() {
      return this.field_230;
   }

   // $FF: renamed from: a (java.security.MessageDigest[], long, int) void
   public final void method_20(MessageDigest[] var1, long var2, int var4) throws IOException {
      long var5 = this.field_229 + var2;
      MappedByteBuffer var7;
      (var7 = this.field_228.map(MapMode.READ_ONLY, var5, (long)var4)).load();
      MessageDigest[] var8 = var1;
      int var9 = var1.length;

      for(int var10 = 0; var10 < var9; ++var10) {
         MessageDigest var11 = var8[var10];
         var7.position(0);
         var11.update(var7);
      }

   }
}
