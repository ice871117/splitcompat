package com.google.android.play.core.internal;

import android.content.Context;
import android.content.pm.Signature;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.play.core.internal.class_123;
import com.google.android.play.core.internal.class_145;

// $FF: renamed from: com.google.android.play.core.internal.bi
public final class class_133 {

   // $FF: renamed from: a com.google.android.play.core.internal.ag
   private static final class_145 field_227;


   // $FF: renamed from: a (android.content.Context) boolean
   public static boolean method_449(Context var0) {
      Signature[] var1;
      try {
         var1 = var0.getPackageManager().getPackageInfo("com.android.vending", 64).signatures;
      } catch (NameNotFoundException var7) {
         return false;
      }

      if(var1 != null && var1.length != 0) {
         Signature[] var2 = var1;
         int var3 = var1.length;

         for(int var4 = 0; var4 < var3; ++var4) {
            String var6 = class_123.method_413(var2[var4].toByteArray());
            if("8P1sW0EPJcslw7UzRsiXL64w-O50Ed-RBICtay1g24M".equals(var6) || "GXWy8XF3vIml3_MfnmSmyuKBpT3B0dWbHRR_4cgq-gA".equals(var6)) {
               return true;
            }
         }

         return false;
      } else {
         field_227.method_492("Phonesky package is not signed -- possibly self-built package. Could not verify.", new Object[0]);
         return false;
      }
   }

   // $FF: renamed from: <clinit> () void
   static void method_450() {
      class_145 var10000 = new class_145;
      var10000.method_489("PhoneskyVerificationUtils");
      field_227 = var10000;
   }
}
