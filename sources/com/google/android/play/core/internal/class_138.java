package com.google.android.play.core.internal;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.util.Log;
import com.google.android.play.core.internal.class_136;
import com.google.android.play.core.splitcompat.SplitFileLogic;
import com.google.android.play.core.splitinstall.class_1;
import com.google.android.play.core.splitinstall.class_60;
import com.google.android.play.core.splitinstall.class_67;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

// $FF: renamed from: com.google.android.play.core.internal.ac
public final class class_138 implements class_1 {

   // $FF: renamed from: a android.content.Context
   private final Context field_235;
   // $FF: renamed from: b com.google.android.play.core.splitcompat.e
   private final SplitFileLogic field_236;
   // $FF: renamed from: c com.google.android.play.core.internal.ae
   private final class_144 field_237;
   // $FF: renamed from: d java.util.concurrent.Executor
   private final Executor field_238;
   // $FF: renamed from: e com.google.android.play.core.splitinstall.i
   private final class_67 field_239;


   // $FF: renamed from: <init> (android.content.Context, java.util.concurrent.Executor, com.google.android.play.core.internal.ae, com.google.android.play.core.splitcompat.e, com.google.android.play.core.splitinstall.i) void
   public void method_463(Context var1, Executor var2, class_144 var3, SplitFileLogic var4, class_67 var5) {
      super();
      this.field_235 = var1;
      this.field_236 = var4;
      this.field_237 = var3;
      this.field_238 = var2;
      this.field_239 = var5;
   }

   // $FF: renamed from: a (java.util.List, com.google.android.play.core.splitinstall.b) void
   public final void method_1(List var1, class_60 var2) {
      if(!this.field_239.method_153()) {
         throw new IllegalStateException("Ingestion should only be called in SplitCompat mode.");
      } else {
         Executor var10000 = this.field_238;
         class_139 var10001 = new class_139;
         var10001.method_474(this, var1, var2);
         var10000.execute(var10001);
      }
   }

   // $FF: renamed from: b (java.util.List, com.google.android.play.core.splitinstall.b) void
   private final void method_464(List var1, class_60 var2) {
      Integer var3;
      if((var3 = this.method_465(var1)) != null) {
         if(var3.intValue() == 0) {
            var2.method_123();
         } else {
            var2.method_124(var3.intValue());
         }
      }
   }

   // $FF: renamed from: a (java.util.List) java.lang.Integer
   private final Integer method_465(List var1) {
      Integer var2 = null;

      try {
         FileChannel var4 = (new RandomAccessFile(this.field_236.method_237(), "rw")).getChannel();
         Throwable var5 = null;
         boolean var12 = false;

         try {
            FileLock var3;
            try {
               var12 = true;
               var3 = var4.tryLock();
            } catch (OverlappingFileLockException var13) {
               var3 = null;
            }

            if(var3 != null) {
               var2 = Integer.valueOf(this.method_466(var1));
               var3.release();
               var12 = false;
            } else {
               var12 = false;
            }
         } catch (Throwable var14) {
            var5 = var14;
            throw var14;
         } finally {
            if(var12) {
               if(var4 != null) {
                  method_471(var5, var4);
               }

            }
         }

         if(var4 != null) {
            method_471((Throwable)null, var4);
         }

         return var2;
      } catch (Exception var16) {
         Log.e("SplitCompat", "Error locking files.", var16);
         return Integer.valueOf(-13);
      }
   }

   // $FF: renamed from: b (java.util.List) int
   private final int method_466(List var1) {
      try {
         Log.i("SplitCompat", "Copying splits.");
         class_138 var4 = this;
         Iterator var6 = var1.iterator();

         while(true) {
            if(!var6.hasNext()) {
               Log.i("SplitCompat", "Splits copied.");
               break;
            }

            Intent var7;
            String var8 = (var7 = (Intent)var6.next()).getStringExtra("split_id");
            AssetFileDescriptor var9 = var4.field_235.getContentResolver().openAssetFileDescriptor(var7.getData(), "r");
            File var10;
            if(((var10 = var4.field_236.method_233(var8)).exists() && var10.length() != var9.getLength() || !var10.exists()) && !var4.field_236.method_234(var8).exists()) {
               BufferedInputStream var12 = new BufferedInputStream(var9.createInputStream());
               Throwable var13 = null;
               boolean var29 = false;

               try {
                  var29 = true;
                  FileOutputStream var14 = new FileOutputStream(var10);
                  Throwable var15 = null;
                  boolean var36 = false;

                  BufferedInputStream var19;
                  try {
                     var36 = true;
                     FileOutputStream var20 = var14;
                     var19 = var12;
                     byte[] var21 = new byte[4096];

                     int var22;
                     while((var22 = var19.read(var21)) > 0) {
                        var20.write(var21, 0, var22);
                     }

                     var36 = false;
                  } catch (Throwable var38) {
                     var15 = var38;
                     throw var38;
                  } finally {
                     if(var36) {
                        method_472(var15, var14);
                     }
                  }

                  var19 = null;
                  var14.close();
                  var29 = false;
               } catch (Throwable var40) {
                  var13 = var40;
                  throw var40;
               } finally {
                  if(var29) {
                     method_473(var13, var12);
                  }
               }

               method_473((Throwable)null, var12);
            }
         }
      } catch (Exception var42) {
         Log.e("SplitCompat", "Error copying splits.", var42);
         return -13;
      }

      boolean var2;
      try {
         var2 = this.field_237.method_483();
      } catch (Exception var37) {
         Log.e("SplitCompat", "Error verifying splits.", var37);
         return -11;
      }

      if(!var2) {
         Log.e("SplitCompat", "Split verification failed.");
         return -11;
      } else {
         Log.i("SplitCompat", "Splits verified.");
         return 0;
      }
   }

   // $FF: renamed from: a (com.google.android.play.core.splitinstall.b) void
   private final void method_467(class_60 var1) {
      boolean var2;
      try {
         var2 = this.field_239.method_152(this.field_235.getApplicationContext());
      } catch (Exception var4) {
         Log.e("SplitCompat", "Error emulating splits.", var4);
         var1.method_124(-12);
         return;
      }

      if(!var2) {
         Log.e("SplitCompat", "Emulating splits failed.");
         var1.method_124(-12);
      } else {
         Log.i("SplitCompat", "Splits installed.");
         var1.method_122();
      }
   }

   // $FF: renamed from: a (com.google.android.play.core.internal.ac) com.google.android.play.core.internal.ae
   // $FF: synthetic method
   static class_144 method_468(class_138 var0) {
      return var0.field_237;
   }

   // $FF: renamed from: a (com.google.android.play.core.internal.ac, com.google.android.play.core.splitinstall.b) void
   // $FF: synthetic method
   static void method_469(class_138 var0, class_60 var1) {
      var0.method_467(var1);
   }

   // $FF: renamed from: a (com.google.android.play.core.internal.ac, java.util.List, com.google.android.play.core.splitinstall.b) void
   // $FF: synthetic method
   static void method_470(class_138 var0, List var1, class_60 var2) {
      var0.method_464(var1, var2);
   }

   // $FF: renamed from: a (java.lang.Throwable, java.nio.channels.FileChannel) void
   // $FF: synthetic method
   private static void method_471(Throwable var0, FileChannel var1) {
      if(var0 != null) {
         try {
            var1.close();
         } catch (Throwable var3) {
            class_136.method_453(var0, var3);
         }
      } else {
         var1.close();
      }
   }

   // $FF: renamed from: a (java.lang.Throwable, java.io.OutputStream) void
   // $FF: synthetic method
   private static void method_472(Throwable var0, OutputStream var1) {
      if(var0 != null) {
         try {
            var1.close();
         } catch (Throwable var3) {
            class_136.method_453(var0, var3);
         }
      } else {
         var1.close();
      }
   }

   // $FF: renamed from: a (java.lang.Throwable, java.io.InputStream) void
   // $FF: synthetic method
   private static void method_473(Throwable var0, InputStream var1) {
      if(var0 != null) {
         try {
            var1.close();
         } catch (Throwable var3) {
            class_136.method_453(var0, var3);
         }
      } else {
         var1.close();
      }
   }
}
