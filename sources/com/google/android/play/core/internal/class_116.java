package com.google.android.play.core.internal;

import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.Set;

// $FF: renamed from: com.google.android.play.core.internal.e
class class_116 extends X509Certificate {

   // $FF: renamed from: a java.security.cert.X509Certificate
   private final X509Certificate field_197;


   // $FF: renamed from: <init> (java.security.cert.X509Certificate) void
   public void method_370(X509Certificate var1) {
      super();
      this.field_197 = var1;
   }

   public Set getCriticalExtensionOIDs() {
      return this.field_197.getCriticalExtensionOIDs();
   }

   public byte[] getExtensionValue(String var1) {
      return this.field_197.getExtensionValue(var1);
   }

   public Set getNonCriticalExtensionOIDs() {
      return this.field_197.getNonCriticalExtensionOIDs();
   }

   public boolean hasUnsupportedCriticalExtension() {
      return this.field_197.hasUnsupportedCriticalExtension();
   }

   public void checkValidity() throws CertificateExpiredException, CertificateNotYetValidException {
      this.field_197.checkValidity();
   }

   public void checkValidity(Date var1) throws CertificateExpiredException, CertificateNotYetValidException {
      this.field_197.checkValidity(var1);
   }

   public int getVersion() {
      return this.field_197.getVersion();
   }

   public BigInteger getSerialNumber() {
      return this.field_197.getSerialNumber();
   }

   public Principal getIssuerDN() {
      return this.field_197.getIssuerDN();
   }

   public Principal getSubjectDN() {
      return this.field_197.getSubjectDN();
   }

   public Date getNotBefore() {
      return this.field_197.getNotBefore();
   }

   public Date getNotAfter() {
      return this.field_197.getNotAfter();
   }

   public byte[] getTBSCertificate() throws CertificateEncodingException {
      return this.field_197.getTBSCertificate();
   }

   public byte[] getSignature() {
      return this.field_197.getSignature();
   }

   public String getSigAlgName() {
      return this.field_197.getSigAlgName();
   }

   public String getSigAlgOID() {
      return this.field_197.getSigAlgOID();
   }

   public byte[] getSigAlgParams() {
      return this.field_197.getSigAlgParams();
   }

   public boolean[] getIssuerUniqueID() {
      return this.field_197.getIssuerUniqueID();
   }

   public boolean[] getSubjectUniqueID() {
      return this.field_197.getSubjectUniqueID();
   }

   public boolean[] getKeyUsage() {
      return this.field_197.getKeyUsage();
   }

   public int getBasicConstraints() {
      return this.field_197.getBasicConstraints();
   }

   public byte[] getEncoded() throws CertificateEncodingException {
      return this.field_197.getEncoded();
   }

   public void verify(PublicKey var1) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
      this.field_197.verify(var1);
   }

   public void verify(PublicKey var1, String var2) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
      this.field_197.verify(var1, var2);
   }

   public String toString() {
      return this.field_197.toString();
   }

   public PublicKey getPublicKey() {
      return this.field_197.getPublicKey();
   }
}
