package com.google.android.play.core.internal;

import com.google.android.play.core.internal.class_116;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;

// $FF: renamed from: com.google.android.play.core.internal.f
final class class_117 extends class_116 {

   // $FF: renamed from: a byte[]
   private byte[] field_198;


   // $FF: renamed from: <init> (java.security.cert.X509Certificate, byte[]) void
   public void method_371(X509Certificate var1, byte[] var2) {
      super.method_370(var1);
      this.field_198 = var2;
   }

   public final byte[] getEncoded() throws CertificateEncodingException {
      return this.field_198;
   }
}
