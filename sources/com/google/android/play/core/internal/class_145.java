package com.google.android.play.core.internal;

import android.os.Process;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.play.core.internal.class_105;
import com.google.android.play.core.internal.class_106;
import com.google.android.play.core.internal.class_107;
import com.google.android.play.core.internal.class_109;
import com.google.android.play.core.internal.class_111;
import com.google.android.play.core.internal.class_119;
import com.google.android.play.core.internal.class_126;
import com.google.android.play.core.internal.class_127;
import com.google.android.play.core.internal.class_146;
import com.google.android.play.core.internal.class_17;
import java.util.IllegalFormatException;
import java.util.Locale;

// $FF: renamed from: com.google.android.play.core.internal.ag
public class class_145 {

   // $FF: renamed from: a java.lang.String
   private final String field_249;


   // $FF: renamed from: a () com.google.android.play.core.internal.ad
   public static class_17 method_488() {
      class_127 var0;
      class_119 var10000;
      if(VERSION.SDK_INT >= 23 && VERSION.PREVIEW_SDK_INT != 0) {
         switch(VERSION.SDK_INT) {
         case 27:
            var0 = new class_127;
            var0.method_421();
            return var0;
         case 28:
            var10000 = new class_119;
            var10000.method_373();
            return var10000;
         }
      }

      if(VERSION.SDK_INT < 21) {
         throw new AssertionError("Unsupported Android Version");
      } else {
         switch(VERSION.SDK_INT) {
         case 21:
            class_146 var7 = new class_146;
            var7.method_497();
            return var7;
         case 22:
            class_109 var6 = new class_109;
            var6.method_328();
            return var6;
         case 23:
            class_111 var5 = new class_111;
            var5.method_359();
            return var5;
         case 24:
            class_105 var4 = new class_105;
            var4.method_318();
            return var4;
         case 25:
            class_106 var3 = new class_106;
            var3.method_319();
            return var3;
         case 26:
            class_107 var2 = new class_107;
            var2.method_320();
            return var2;
         case 27:
            class_126 var1 = new class_126;
            var1.method_420();
            return var1;
         case 28:
            if(!VERSION.CODENAME.equalsIgnoreCase("Q")) {
               var0 = new class_127;
               var0.method_421();
               return var0;
            }
         default:
            var10000 = new class_119;
            var10000.method_373();
            return var10000;
         }
      }
   }

   // $FF: renamed from: <init> (java.lang.String) void
   public void method_489(String var1) {
      super();
      int var3 = Process.myUid();
      int var4 = Process.myPid();
      String var2 = (new StringBuilder(39)).append("UID: [").append(var3).append("]  PID: [").append(var4).append("] ").toString();
      String var10001 = String.valueOf(var2);
      String var10002 = String.valueOf(var1);
      if(var10002.length() != 0) {
         var10001 = var10001.concat(var10002);
      } else {
         String var10003 = new String;
         var10002 = var10001;
         var10001 = var10003;
         var10003.<init>(var10002);
      }

      this.field_249 = var10001;
   }

   // $FF: renamed from: a (java.lang.String, java.lang.Object[]) int
   public int method_490(String var1, Object ... var2) {
      return this.method_495(4, var1, var2);
   }

   // $FF: renamed from: b (java.lang.String, java.lang.Object[]) int
   public int method_491(String var1, Object ... var2) {
      return this.method_495(3, var1, var2);
   }

   // $FF: renamed from: c (java.lang.String, java.lang.Object[]) int
   public int method_492(String var1, Object ... var2) {
      return this.method_495(5, var1, var2);
   }

   // $FF: renamed from: d (java.lang.String, java.lang.Object[]) int
   public int method_493(String var1, Object ... var2) {
      return this.method_495(6, var1, var2);
   }

   // $FF: renamed from: a (java.lang.Throwable, java.lang.String, java.lang.Object[]) int
   public int method_494(Throwable var1, String var2, Object ... var3) {
      return Log.isLoggable("PlayCore", 6)?Log.e("PlayCore", method_496(this.field_249, var2, var3), var1):0;
   }

   // $FF: renamed from: a (int, java.lang.String, java.lang.Object[]) int
   private int method_495(int var1, String var2, Object[] var3) {
      return Log.isLoggable("PlayCore", var1)?Log.i("PlayCore", method_496(this.field_249, var2, var3)):0;
   }

   // $FF: renamed from: a (java.lang.String, java.lang.String, java.lang.Object[]) java.lang.String
   private static String method_496(String var0, String var1, Object ... var2) {
      String var3 = var1;
      if(var2 != null && var2.length > 0) {
         try {
            var3 = String.format(Locale.US, var1, var2);
         } catch (IllegalFormatException var6) {
            String var10002 = String.valueOf(var1);
            Log.e("PlayCore", var10002.length() != 0?"Unable to format ".concat(var10002):new String("Unable to format "), var6);
            String var5 = TextUtils.join(", ", var2);
            var3 = (new StringBuilder(3 + String.valueOf(var1).length() + String.valueOf(var5).length())).append(var1).append(" [").append(var5).append("]").toString();
         }
      }

      return (new StringBuilder(3 + String.valueOf(var0).length() + String.valueOf(var3).length())).append(var0).append(" : ").append(var3).toString();
   }
}
