package com.google.android.play.core.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.Signature;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;

import com.google.android.play.core.splitcompat.SplitFileLogic;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

// $FF: renamed from: com.google.android.play.core.internal.ae
public final class class_144 {

   // $FF: renamed from: a com.google.android.play.core.splitcompat.e
   private final SplitFileLogic field_246;
   // $FF: renamed from: b com.google.android.play.core.internal.az
   private final class_123 field_247;
   // $FF: renamed from: c android.content.Context
   private final Context field_248;


   // $FF: renamed from: <init> (android.content.Context, com.google.android.play.core.splitcompat.e, com.google.android.play.core.internal.az) void
   public void method_482(Context var1, SplitFileLogic var2, class_123 var3) {
      super();
      this.field_246 = var2;
      this.field_247 = var3;
      this.field_248 = var1;
   }

   // $FF: renamed from: a () boolean
   public final boolean method_483() {
      File var1;
      try {
         var1 = this.field_246.method_238();
      } catch (IOException var16) {
         Log.e("SplitCompat", "Cannot access directory for unverified splits.", var16);
         return false;
      }

      Signature[] var8;
      ArrayList var10000;
      if((var8 = this.method_486()) == null) {
         var10000 = null;
      } else {
         ArrayList var9 = new ArrayList();
         Signature[] var10 = var8;
         int var11 = var8.length;

         for(int var12 = 0; var12 < var11; ++var12) {
            X509Certificate var14;
            if((var14 = method_487(var10[var12])) != null) {
               var9.add(var14);
            }
         }

         var10000 = var9;
      }

      ArrayList var2 = var10000;
      if(var10000 != null && !var2.isEmpty()) {
         File[] var3;
         Arrays.sort(var3 = var1.listFiles());

         for(int var4 = var3.length - 1; var4 >= 0; --var4) {
            File var5 = var3[var4];

            try {
               if(!this.method_485(var5.getAbsolutePath(), var2)) {
                  Log.e("SplitCompat", "Split verification failure.");
                  return false;
               }
            } catch (Exception var17) {
               Log.e("SplitCompat", "Split verification error.", var17);
               return false;
            }

            try {
               var5.renameTo(this.field_246.method_235(var5));
            } catch (IOException var15) {
               Log.e("SplitCompat", "Cannot write verified split.", var15);
               return false;
            }
         }

         return true;
      } else {
         Log.e("SplitCompat", "No app certificates found.");
         return false;
      }
   }

   // $FF: renamed from: a (java.util.List) boolean
   public final boolean method_484(List var1) throws IOException {
      Iterator var2 = var1.iterator();

      String var4;
      do {
         if(!var2.hasNext()) {
            return true;
         }

         var4 = ((Intent)var2.next()).getStringExtra("split_id");
      } while(this.field_246.method_234(var4).exists());

      return false;
   }

   // $FF: renamed from: a (java.lang.String, java.util.List) boolean
   private final boolean method_485(String var1, List var2) {
      X509Certificate[][] var3;
      try {
         var3 = class_123.method_411(var1);
      } catch (Exception var14) {
         Log.e("SplitCompat", (new StringBuilder(32 + String.valueOf(var1).length())).append("Downloaded split ").append(var1).append(" is not signed.").toString(), var14);
         return false;
      }

      if(var3 != null && var3.length != 0 && var3[0].length != 0) {
         X509Certificate[][] var5 = var3;
         if(var2.isEmpty()) {
            Log.e("SplitCompat", "No certificates found for app.");
            return false;
         } else {
            Iterator var7 = var2.iterator();

            while(var7.hasNext()) {
               X509Certificate var8 = (X509Certificate)var7.next();
               boolean var9 = false;
               X509Certificate[][] var10 = var5;
               int var11 = var5.length;
               int var12 = 0;

               while(true) {
                  if(var12 < var11) {
                     if(!var10[var12][0].equals(var8)) {
                        ++var12;
                        continue;
                     }

                     var9 = true;
                  }

                  if(!var9) {
                     Log.i("SplitCompat", "There\'s an app certificate that doesn\'t sign the split.");
                     return false;
                  }
                  break;
               }
            }

            return true;
         }
      } else {
         Log.e("SplitCompat", (new StringBuilder(32 + String.valueOf(var1).length())).append("Downloaded split ").append(var1).append(" is not signed.").toString());
         return false;
      }
   }

   // $FF: renamed from: b () android.content.pm.Signature[]
   private final Signature[] method_486() {
      try {
         return this.field_248.getPackageManager().getPackageInfo(this.field_248.getPackageName(), 64).signatures;
      } catch (NameNotFoundException var1) {
         return null;
      }
   }

   // $FF: renamed from: a (android.content.pm.Signature) java.security.cert.X509Certificate
   private static X509Certificate method_487(Signature var0) {
      try {
         return (X509Certificate)CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(var0.toByteArray()));
      } catch (CertificateException var2) {
         Log.e("SplitCompat", "Cannot decode certificate.", var2);
         return null;
      }
   }
}
