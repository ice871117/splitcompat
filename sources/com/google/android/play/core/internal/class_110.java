package com.google.android.play.core.internal;

import android.util.Pair;
import com.google.android.play.core.internal.class_11;
import com.google.android.play.core.internal.class_117;
import com.google.android.play.core.internal.class_132;
import com.google.android.play.core.internal.class_134;
import com.google.android.play.core.internal.class_135;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.security.DigestException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// $FF: renamed from: com.google.android.play.core.internal.h
public class class_110 implements class_11 {

   // $FF: renamed from: a java.nio.ByteBuffer
   private final ByteBuffer field_194;


   // $FF: renamed from: a (java.io.RandomAccessFile, int) android.util.Pair
   private static Pair method_329(RandomAccessFile var0, int var1) throws IOException {
      if(var1 >= 0 && var1 <= '\uffff') {
         long var2;
         if((var2 = var0.length()) < 22L) {
            return null;
         } else {
            ByteBuffer var4;
            long var5;
            int var10000;
            label33: {
               var1 = (int)Math.min((long)var1, var2 - 22L);
               (var4 = ByteBuffer.allocate(var1 + 22)).order(ByteOrder.LITTLE_ENDIAN);
               var5 = var2 - (long)var4.capacity();
               var0.seek(var5);
               var0.readFully(var4.array(), var4.arrayOffset(), var4.capacity());
               ByteBuffer var9 = var4;
               method_330(var4);
               int var10;
               if((var10 = var4.capacity()) >= 22) {
                  int var11 = Math.min(var10 - 22, '\uffff');
                  int var12 = var10 - 22;

                  for(int var13 = 0; var13 < var11; ++var13) {
                     int var14 = var12 - var13;
                     if(var9.getInt(var14) == 101010256) {
                        int var17 = var14 + 20;
                        if((var9.getShort(var17) & '\uffff') == var13) {
                           var10000 = var14;
                           break label33;
                        }
                     }
                  }
               }

               var10000 = -1;
            }

            int var7 = var10000;
            if(var10000 == -1) {
               return null;
            } else {
               var4.position(var7);
               ByteBuffer var8;
               (var8 = var4.slice()).order(ByteOrder.LITTLE_ENDIAN);
               return Pair.create(var8, Long.valueOf(var5 + (long)var7));
            }
         }
      } else {
         throw new IllegalArgumentException((new StringBuilder(27)).append("maxCommentSize: ").append(var1).toString());
      }
   }

   // $FF: renamed from: a (java.nio.ByteBuffer) void
   private static void method_330(ByteBuffer var0) {
      if(var0.order() != ByteOrder.LITTLE_ENDIAN) {
         throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
      }
   }

   // $FF: renamed from: a (java.nio.ByteBuffer, int) long
   private static long method_331(ByteBuffer var0, int var1) {
      return (long)var0.getInt(var1) & 4294967295L;
   }

   // $FF: renamed from: a (java.lang.String) java.security.cert.X509Certificate[][]
   public static X509Certificate[][] method_332(String var0) throws class_134, SecurityException, IOException {
      RandomAccessFile var1 = new RandomAccessFile(var0, "r");

      X509Certificate[][] var3;
      try {
         X509Certificate[][] var2 = method_333(var1);
         var1.close();
         var3 = var2;
      } finally {
         try {
            var1.close();
         } catch (IOException var8) {
            ;
         }

      }

      return var3;
   }

   // $FF: renamed from: a (java.io.RandomAccessFile) java.security.cert.X509Certificate[][]
   private static X509Certificate[][] method_333(RandomAccessFile var0) throws class_134, SecurityException, IOException {
      class_132 var1 = method_334(var0);
      return method_335(var0.getChannel(), var1);
   }

   // $FF: renamed from: b (java.io.RandomAccessFile) com.google.android.play.core.internal.d
   private static class_132 method_334(RandomAccessFile var0) throws IOException, class_134 {
      ByteBuffer var2;
      long var3;
      boolean var10000;
      label16: {
         Pair var1;
         var2 = (ByteBuffer)(var1 = method_339(var0)).first;
         var3 = ((Long)var1.second).longValue();
         long var15;
         if((var15 = var3 - 20L) >= 0L) {
            var0.seek(var15);
            if(var0.readInt() == 1347094023) {
               var10000 = true;
               break label16;
            }
         }

         var10000 = false;
      }

      if(var10000) {
         class_134 var18 = new class_134;
         var18.method_451("ZIP64 APK not supported");
         throw var18;
      } else {
         long var5 = method_340(var2, var3);
         Pair var7;
         ByteBuffer var8 = (ByteBuffer)(var7 = method_355(var0, var5)).first;
         long var9 = ((Long)var7.second).longValue();
         ByteBuffer var11 = method_356(var8);
         class_132 var17 = new class_132;
         var17.method_439(var11, var9, var5, var3, var2, (byte)0);
         return var17;
      }
   }

   // $FF: renamed from: a (java.nio.channels.FileChannel, com.google.android.play.core.internal.d) java.security.cert.X509Certificate[][]
   private static X509Certificate[][] method_335(FileChannel var0, class_132 var1) throws SecurityException {
      int var2 = 0;
      HashMap var3 = new HashMap();
      ArrayList var4 = new ArrayList();

      CertificateFactory var5;
      try {
         var5 = CertificateFactory.getInstance("X.509");
      } catch (CertificateException var11) {
         throw new RuntimeException("Failed to obtain X.509 CertificateFactory", var11);
      }

      ByteBuffer var6;
      try {
         var6 = method_352(class_132.method_440(var1));
      } catch (IOException var10) {
         throw new SecurityException("Failed to read list of signers", var10);
      }

      while(var6.hasRemaining()) {
         ++var2;

         try {
            X509Certificate[] var8 = method_336(method_352(var6), var3, var5);
            var4.add(var8);
         } catch (SecurityException var9) {
            throw new SecurityException((new StringBuilder(48)).append("Failed to parse/verify signer #").append(var2).append(" block").toString(), var9);
         }
      }

      if(var2 <= 0) {
         throw new SecurityException("No signers found");
      } else if(var3.isEmpty()) {
         throw new SecurityException("No content digests found");
      } else {
         method_337(var3, var0, class_132.method_441(var1), class_132.method_442(var1), class_132.method_443(var1), class_132.method_444(var1));
         return (X509Certificate[][])var4.toArray(new X509Certificate[var4.size()][]);
      }
   }

   // $FF: renamed from: a (java.nio.ByteBuffer, java.util.Map, java.security.cert.CertificateFactory) java.security.cert.X509Certificate[]
   private static X509Certificate[] method_336(ByteBuffer var0, Map var1, CertificateFactory var2) throws SecurityException, IOException {
      ByteBuffer var3 = method_352(var0);
      ByteBuffer var4 = method_352(var0);
      byte[] var5 = method_353(var0);
      int var6 = 0;
      int var7 = -1;
      byte[] var8 = null;
      ArrayList var9 = new ArrayList();

      while(var4.hasRemaining()) {
         ++var6;

         try {
            ByteBuffer var10;
            if((var10 = method_352(var4)).remaining() < 8) {
               throw new SecurityException("Signature record too short");
            }

            int var11 = var10.getInt();
            var9.add(Integer.valueOf(var11));
            if(method_342(var11) && (var7 == -1 || method_343(var11, var7) > 0)) {
               var7 = var11;
               var8 = method_353(var10);
            }
         } catch (BufferUnderflowException var31) {
            throw new SecurityException((new StringBuilder(45)).append("Failed to parse signature record #").append(var6).toString(), var31);
         }
      }

      if(var7 == -1) {
         if(var6 == 0) {
            throw new SecurityException("No signatures found");
         } else {
            throw new SecurityException("No supported signatures found");
         }
      } else {
         String var32 = method_348(var7);
         Pair var33;
         String var12 = (String)(var33 = method_349(var7)).first;
         AlgorithmParameterSpec var13 = (AlgorithmParameterSpec)var33.second;

         boolean var14;
         try {
            PublicKey var15 = KeyFactory.getInstance(var32).generatePublic(new X509EncodedKeySpec(var5));
            Signature var16;
            (var16 = Signature.getInstance(var12)).initVerify(var15);
            if(var13 != null) {
               var16.setParameter(var13);
            }

            var16.update(var3);
            var14 = var16.verify(var8);
         } catch (SignatureException var30) {
            throw new SecurityException((new StringBuilder(27 + String.valueOf(var12).length())).append("Failed to verify ").append(var12).append(" signature").toString(), var30);
         }

         if(!var14) {
            throw new SecurityException(String.valueOf(var12).concat(" signature did not verify"));
         } else {
            byte[] var34 = null;
            var3.clear();
            ByteBuffer var35 = method_352(var3);
            ArrayList var17 = new ArrayList();
            int var18 = 0;

            while(var35.hasRemaining()) {
               ++var18;

               try {
                  ByteBuffer var19;
                  if((var19 = method_352(var35)).remaining() < 8) {
                     throw new IOException("Record too short");
                  }

                  int var20 = var19.getInt();
                  var17.add(Integer.valueOf(var20));
                  if(var20 == var7) {
                     var34 = method_353(var19);
                  }
               } catch (BufferUnderflowException var29) {
                  throw new IOException((new StringBuilder(42)).append("Failed to parse digest record #").append(var18).toString(), var29);
               }
            }

            if(!var9.equals(var17)) {
               throw new SecurityException("Signature algorithms don\'t match between digests and signatures records");
            } else {
               int var36 = method_345(var7);
               byte[] var37;
               if((var37 = (byte[])var1.put(Integer.valueOf(var36), var34)) != null && !MessageDigest.isEqual(var37, var34)) {
                  throw new SecurityException(String.valueOf(method_346(var36)).concat(" contents digest does not match the digest specified by a preceding signer"));
               } else {
                  ByteBuffer var21 = method_352(var3);
                  ArrayList var22 = new ArrayList();
                  int var23 = 0;

                  while(var21.hasRemaining()) {
                     ++var23;
                     byte[] var24 = method_353(var21);

                     X509Certificate var25;
                     try {
                        var25 = (X509Certificate)var2.generateCertificate(new ByteArrayInputStream(var24));
                     } catch (CertificateException var28) {
                        throw new SecurityException((new StringBuilder(41)).append("Failed to decode certificate #").append(var23).toString(), var28);
                     }

                     class_117 var10000 = new class_117;
                     var10000.method_371(var25, var24);
                     class_117 var38 = var10000;
                     var22.add(var38);
                  }

                  if(var22.isEmpty()) {
                     throw new SecurityException("No certificates listed");
                  } else {
                     byte[] var39 = ((X509Certificate)var22.get(0)).getPublicKey().getEncoded();
                     if(!Arrays.equals(var5, var39)) {
                        throw new SecurityException("Public key mismatch between certificate and signature record");
                     } else {
                        return (X509Certificate[])var22.toArray(new X509Certificate[var22.size()]);
                     }
                  }
               }
            }
         }
      }
   }

   // $FF: renamed from: a (java.util.Map, java.nio.channels.FileChannel, long, long, long, java.nio.ByteBuffer) void
   private static void method_337(Map var0, FileChannel var1, long var2, long var4, long var6, ByteBuffer var8) throws SecurityException {
      if(var0.isEmpty()) {
         throw new SecurityException("No digests provided");
      } else {
         class_135 var10000 = new class_135;
         var10000.method_452(var1, 0L, var2);
         class_135 var9 = var10000;
         var10000 = new class_135;
         var10000.method_452(var1, var4, var6 - var4);
         class_135 var10 = var10000;
         (var8 = var8.duplicate()).order(ByteOrder.LITTLE_ENDIAN);
         method_330(var8);
         int var23 = var8.position() + 16;
         if(var2 >= 0L && var2 <= 4294967295L) {
            var8.putInt(var8.position() + var23, (int)var2);
            class_110 var28 = new class_110;
            var28.method_358(var8);
            class_110 var11 = var28;
            int[] var12 = new int[var0.size()];
            int var13 = 0;

            int var15;
            for(Iterator var14 = var0.keySet().iterator(); var14.hasNext(); ++var13) {
               var15 = ((Integer)var14.next()).intValue();
               var12[var13] = var15;
            }

            byte[][] var27;
            try {
               var27 = method_338(var12, new class_11[]{var9, var10, var11});
            } catch (DigestException var26) {
               throw new SecurityException("Failed to compute digest(s) of contents", var26);
            }

            for(var15 = 0; var15 < var12.length; ++var15) {
               int var16 = var12[var15];
               byte[] var17 = (byte[])var0.get(Integer.valueOf(var16));
               byte[] var18 = var27[var15];
               if(!MessageDigest.isEqual(var17, var18)) {
                  throw new SecurityException(String.valueOf(method_346(var16)).concat(" digest of contents did not verify"));
               }
            }

         } else {
            throw new IllegalArgumentException((new StringBuilder(47)).append("uint32 value of out range: ").append(var2).toString());
         }
      }
   }

   // $FF: renamed from: a (int[], com.google.android.play.core.internal.b[]) byte[][]
   private static byte[][] method_338(int[] var0, class_11[] var1) throws DigestException {
      long var2 = 0L;
      class_11[] var4 = var1;
      int var5 = var1.length;

      int var6;
      for(var6 = 0; var6 < var5; ++var6) {
         class_11 var7 = var4[var6];
         var2 += method_341(var7.method_19());
      }

      if(var2 >= 2097151L) {
         throw new DigestException((new StringBuilder(37)).append("Too many chunks: ").append(var2).toString());
      } else {
         int var29 = (int)var2;
         byte[][] var30 = new byte[var0.length][];

         for(var6 = 0; var6 < var0.length; ++var6) {
            int var8 = method_347(var0[var6]);
            byte[] var9;
            (var9 = new byte[5 + var29 * var8])[0] = 90;
            method_354(var29, var9, 1);
            var30[var6] = var9;
         }

         byte[] var31;
         (var31 = new byte[5])[0] = -91;
         int var32 = 0;
         MessageDigest[] var33 = new MessageDigest[var0.length];

         int var34;
         for(var34 = 0; var34 < var0.length; ++var34) {
            String var10 = method_346(var0[var34]);

            try {
               var33[var34] = MessageDigest.getInstance(var10);
            } catch (NoSuchAlgorithmException var28) {
               throw new RuntimeException(String.valueOf(var10).concat(" digest not supported"), var28);
            }
         }

         var34 = 0;
         class_11[] var35 = var1;
         int var11 = var1.length;

         int var12;
         for(var12 = 0; var12 < var11; ++var12) {
            class_11 var13 = var35[var12];
            long var14 = 0L;

            for(long var16 = var13.method_19(); var16 > 0L; ++var32) {
               int var18;
               method_354(var18 = (int)Math.min(var16, 1048576L), var31, 1);

               int var19;
               for(var19 = 0; var19 < var33.length; ++var19) {
                  var33[var19].update(var31);
               }

               try {
                  var13.method_20(var33, var14, var18);
               } catch (IOException var27) {
                  throw new DigestException((new StringBuilder(59)).append("Failed to digest chunk #").append(var32).append(" of section #").append(var34).toString(), var27);
               }

               for(var19 = 0; var19 < var0.length; ++var19) {
                  int var20 = var0[var19];
                  byte[] var21 = var30[var19];
                  int var22 = method_347(var20);
                  MessageDigest var23;
                  int var24;
                  if((var24 = (var23 = var33[var19]).digest(var21, 5 + var32 * var22, var22)) != var22) {
                     RuntimeException var10000 = new RuntimeException;
                     String var25 = var23.getAlgorithm();
                     var10000.<init>((new StringBuilder(46 + String.valueOf(var25).length())).append("Unexpected output size of ").append(var25).append(" digest: ").append(var24).toString());
                     throw var10000;
                  }
               }

               var14 += (long)var18;
               var16 -= (long)var18;
            }

            ++var34;
         }

         byte[][] var36 = new byte[var0.length][];

         for(var11 = 0; var11 < var0.length; ++var11) {
            var12 = var0[var11];
            byte[] var37 = var30[var11];
            String var38 = method_346(var12);

            MessageDigest var15;
            try {
               var15 = MessageDigest.getInstance(var38);
            } catch (NoSuchAlgorithmException var26) {
               throw new RuntimeException(String.valueOf(var38).concat(" digest not supported"), var26);
            }

            byte[] var39 = var15.digest(var37);
            var36[var11] = var39;
         }

         return var36;
      }
   }

   // $FF: renamed from: c (java.io.RandomAccessFile) android.util.Pair
   private static Pair method_339(RandomAccessFile var0) throws IOException, class_134 {
      Pair var1;
      Pair var7;
      if((var1 = var0.length() < 22L?null:((var7 = method_329(var0, 0)) != null?var7:method_329(var0, '\uffff'))) == null) {
         class_134 var10000 = new class_134;
         long var2 = var0.length();
         var10000.method_451((new StringBuilder(102)).append("Not an APK file: ZIP End of Central Directory record not found in file with ").append(var2).append(" bytes").toString());
         throw var10000;
      } else {
         return var1;
      }
   }

   // $FF: renamed from: a (java.nio.ByteBuffer, long) long
   private static long method_340(ByteBuffer var0, long var1) throws class_134 {
      method_330(var0);
      class_134 var10000;
      long var3;
      if((var3 = method_331(var0, var0.position() + 16)) >= var1) {
         var10000 = new class_134;
         var10000.method_451((new StringBuilder(122)).append("ZIP Central Directory offset out of range: ").append(var3).append(". ZIP End of Central Directory offset: ").append(var1).toString());
         throw var10000;
      } else {
         method_330(var0);
         long var5 = method_331(var0, var0.position() + 12);
         if(var3 + var5 != var1) {
            var10000 = new class_134;
            var10000.method_451("ZIP Central Directory is not immediately followed by End of Central Directory");
            throw var10000;
         } else {
            return var3;
         }
      }
   }

   // $FF: renamed from: a (long) long
   private static long method_341(long var0) {
      return (var0 + 1048576L - 1L) / 1048576L;
   }

   // $FF: renamed from: a (int) boolean
   private static boolean method_342(int var0) {
      switch(var0) {
      case 257:
      case 258:
      case 259:
      case 260:
      case 513:
      case 514:
      case 769:
         return true;
      default:
         return false;
      }
   }

   // $FF: renamed from: a (int, int) int
   private static int method_343(int var0, int var1) {
      int var2 = method_345(var0);
      int var3 = method_345(var1);
      return method_344(var2, var3);
   }

   // $FF: renamed from: b (int, int) int
   private static int method_344(int var0, int var1) {
      switch(var0) {
      case 1:
         switch(var1) {
         case 1:
            return 0;
         case 2:
            return -1;
         default:
            throw new IllegalArgumentException((new StringBuilder(37)).append("Unknown digestAlgorithm2: ").append(var1).toString());
         }
      case 2:
         switch(var1) {
         case 1:
            return 1;
         case 2:
            return 0;
         default:
            throw new IllegalArgumentException((new StringBuilder(37)).append("Unknown digestAlgorithm2: ").append(var1).toString());
         }
      default:
         throw new IllegalArgumentException((new StringBuilder(37)).append("Unknown digestAlgorithm1: ").append(var0).toString());
      }
   }

   // $FF: renamed from: b (int) int
   private static int method_345(int var0) {
      switch(var0) {
      case 257:
      case 259:
      case 513:
      case 769:
         return 1;
      case 258:
      case 260:
      case 514:
         return 2;
      default:
         IllegalArgumentException var10000 = new IllegalArgumentException;
         String var10003 = String.valueOf(Long.toHexString((long)var0));
         var10000.<init>(var10003.length() != 0?"Unknown signature algorithm: 0x".concat(var10003):new String("Unknown signature algorithm: 0x"));
         throw var10000;
      }
   }

   // $FF: renamed from: c (int) java.lang.String
   private static String method_346(int var0) {
      switch(var0) {
      case 1:
         return "SHA-256";
      case 2:
         return "SHA-512";
      default:
         throw new IllegalArgumentException((new StringBuilder(44)).append("Unknown content digest algorthm: ").append(var0).toString());
      }
   }

   // $FF: renamed from: d (int) int
   private static int method_347(int var0) {
      switch(var0) {
      case 1:
         return 32;
      case 2:
         return 64;
      default:
         throw new IllegalArgumentException((new StringBuilder(44)).append("Unknown content digest algorthm: ").append(var0).toString());
      }
   }

   // $FF: renamed from: e (int) java.lang.String
   private static String method_348(int var0) {
      switch(var0) {
      case 257:
      case 258:
      case 259:
      case 260:
         return "RSA";
      case 513:
      case 514:
         return "EC";
      case 769:
         return "DSA";
      default:
         IllegalArgumentException var10000 = new IllegalArgumentException;
         String var10003 = String.valueOf(Long.toHexString((long)var0));
         var10000.<init>(var10003.length() != 0?"Unknown signature algorithm: 0x".concat(var10003):new String("Unknown signature algorithm: 0x"));
         throw var10000;
      }
   }

   // $FF: renamed from: f (int) android.util.Pair
   private static Pair method_349(int var0) {
      switch(var0) {
      case 257:
         return Pair.create("SHA256withRSA/PSS", new PSSParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, 32, 1));
      case 258:
         return Pair.create("SHA512withRSA/PSS", new PSSParameterSpec("SHA-512", "MGF1", MGF1ParameterSpec.SHA512, 64, 1));
      case 259:
         return Pair.create("SHA256withRSA", (Object)null);
      case 260:
         return Pair.create("SHA512withRSA", (Object)null);
      case 513:
         return Pair.create("SHA256withECDSA", (Object)null);
      case 514:
         return Pair.create("SHA512withECDSA", (Object)null);
      case 769:
         return Pair.create("SHA256withDSA", (Object)null);
      default:
         IllegalArgumentException var10000 = new IllegalArgumentException;
         String var10003 = String.valueOf(Long.toHexString((long)var0));
         var10000.<init>(var10003.length() != 0?"Unknown signature algorithm: 0x".concat(var10003):new String("Unknown signature algorithm: 0x"));
         throw var10000;
      }
   }

   // $FF: renamed from: a (java.nio.ByteBuffer, int, int) java.nio.ByteBuffer
   private static ByteBuffer method_350(ByteBuffer var0, int var1, int var2) {
      if(var2 < 8) {
         throw new IllegalArgumentException((new StringBuilder(38)).append("end < start: ").append(var2).append(" < 8").toString());
      } else {
         int var3 = var0.capacity();
         if(var2 > var0.capacity()) {
            throw new IllegalArgumentException((new StringBuilder(41)).append("end > capacity: ").append(var2).append(" > ").append(var3).toString());
         } else {
            int var4 = var0.limit();
            int var5 = var0.position();

            ByteBuffer var7;
            try {
               var0.position(0);
               var0.limit(var2);
               var0.position(8);
               ByteBuffer var6;
               (var6 = var0.slice()).order(var0.order());
               var7 = var6;
            } finally {
               var0.position(0);
               var0.limit(var4);
               var0.position(var5);
            }

            return var7;
         }
      }
   }

   // $FF: renamed from: b (java.nio.ByteBuffer, int) java.nio.ByteBuffer
   private static ByteBuffer method_351(ByteBuffer var0, int var1) throws BufferUnderflowException {
      if(var1 < 0) {
         throw new IllegalArgumentException((new StringBuilder(17)).append("size: ").append(var1).toString());
      } else {
         int var2 = var0.limit();
         int var3;
         int var4;
         if((var4 = (var3 = var0.position()) + var1) >= var3 && var4 <= var2) {
            var0.limit(var4);

            ByteBuffer var6;
            try {
               ByteBuffer var5;
               (var5 = var0.slice()).order(var0.order());
               var0.position(var4);
               var6 = var5;
            } finally {
               var0.limit(var2);
            }

            return var6;
         } else {
            throw new BufferUnderflowException();
         }
      }
   }

   // $FF: renamed from: b (java.nio.ByteBuffer) java.nio.ByteBuffer
   private static ByteBuffer method_352(ByteBuffer var0) throws IOException {
      IOException var10000;
      int var1;
      if(var0.remaining() < 4) {
         var10000 = new IOException;
         var1 = var0.remaining();
         var10000.<init>((new StringBuilder(93)).append("Remaining buffer too short to contain length of length-prefixed field. Remaining: ").append(var1).toString());
         throw var10000;
      } else if((var1 = var0.getInt()) < 0) {
         throw new IllegalArgumentException("Negative length");
      } else if(var1 > var0.remaining()) {
         var10000 = new IOException;
         int var2 = var0.remaining();
         var10000.<init>((new StringBuilder(101)).append("Length-prefixed field longer than remaining buffer. Field length: ").append(var1).append(", remaining: ").append(var2).toString());
         throw var10000;
      } else {
         return method_351(var0, var1);
      }
   }

   // $FF: renamed from: c (java.nio.ByteBuffer) byte[]
   private static byte[] method_353(ByteBuffer var0) throws IOException {
      int var1;
      if((var1 = var0.getInt()) < 0) {
         throw new IOException("Negative length");
      } else if(var1 > var0.remaining()) {
         IOException var10000 = new IOException;
         int var3 = var0.remaining();
         var10000.<init>((new StringBuilder(90)).append("Underflow while reading length-prefixed value. Length: ").append(var1).append(", available: ").append(var3).toString());
         throw var10000;
      } else {
         byte[] var2 = new byte[var1];
         var0.get(var2);
         return var2;
      }
   }

   // $FF: renamed from: a (int, byte[], int) void
   private static void method_354(int var0, byte[] var1, int var2) {
      var1[1] = (byte)var0;
      var1[2] = (byte)(var0 >>> 8);
      var1[3] = (byte)(var0 >>> 16);
      var1[4] = (byte)(var0 >>> 24);
   }

   // $FF: renamed from: a (java.io.RandomAccessFile, long) android.util.Pair
   private static Pair method_355(RandomAccessFile var0, long var1) throws IOException, class_134 {
      class_134 var10000;
      if(var1 < 32L) {
         var10000 = new class_134;
         var10000.method_451((new StringBuilder(87)).append("APK too small for APK Signing Block. ZIP Central Directory offset: ").append(var1).toString());
         throw var10000;
      } else {
         ByteBuffer var3;
         (var3 = ByteBuffer.allocate(24)).order(ByteOrder.LITTLE_ENDIAN);
         var0.seek(var1 - (long)var3.capacity());
         var0.readFully(var3.array(), var3.arrayOffset(), var3.capacity());
         if(var3.getLong(8) == 2334950737559900225L && var3.getLong(16) == 3617552046287187010L) {
            long var4;
            if((var4 = var3.getLong(0)) >= (long)var3.capacity() && var4 <= 2147483639L) {
               int var6 = (int)(var4 + 8L);
               long var7;
               if((var7 = var1 - (long)var6) < 0L) {
                  var10000 = new class_134;
                  var10000.method_451((new StringBuilder(59)).append("APK Signing Block offset out of range: ").append(var7).toString());
                  throw var10000;
               } else {
                  ByteBuffer var9;
                  (var9 = ByteBuffer.allocate(var6)).order(ByteOrder.LITTLE_ENDIAN);
                  var0.seek(var7);
                  var0.readFully(var9.array(), var9.arrayOffset(), var9.capacity());
                  long var10;
                  if((var10 = var9.getLong(0)) != var4) {
                     var10000 = new class_134;
                     var10000.method_451((new StringBuilder(103)).append("APK Signing Block sizes in header and footer do not match: ").append(var10).append(" vs ").append(var4).toString());
                     throw var10000;
                  } else {
                     return Pair.create(var9, Long.valueOf(var7));
                  }
               }
            } else {
               var10000 = new class_134;
               var10000.method_451((new StringBuilder(57)).append("APK Signing Block size out of range: ").append(var4).toString());
               throw var10000;
            }
         } else {
            var10000 = new class_134;
            var10000.method_451("No APK Signing Block before ZIP Central Directory");
            throw var10000;
         }
      }
   }

   // $FF: renamed from: d (java.nio.ByteBuffer) java.nio.ByteBuffer
   private static ByteBuffer method_356(ByteBuffer var0) throws class_134 {
      method_357(var0);
      ByteBuffer var1 = method_350(var0, 8, var0.capacity() - 24);
      int var2 = 0;

      class_134 var10000;
      while(var1.hasRemaining()) {
         ++var2;
         if(var1.remaining() < 8) {
            var10000 = new class_134;
            var10000.method_451((new StringBuilder(70)).append("Insufficient data to read size of APK Signing Block entry #").append(var2).toString());
            throw var10000;
         }

         long var3;
         if((var3 = var1.getLong()) < 4L || var3 > 2147483647L) {
            var10000 = new class_134;
            var10000.method_451((new StringBuilder(76)).append("APK Signing Block entry #").append(var2).append(" size out of range: ").append(var3).toString());
            throw var10000;
         }

         int var5 = (int)var3;
         int var6 = var1.position() + var5;
         if(var5 > var1.remaining()) {
            var10000 = new class_134;
            int var8 = var1.remaining();
            var10000.method_451((new StringBuilder(91)).append("APK Signing Block entry #").append(var2).append(" size out of range: ").append(var5).append(", available: ").append(var8).toString());
            throw var10000;
         }

         if(var1.getInt() == 1896449818) {
            return method_351(var1, var5 - 4);
         }

         var1.position(var6);
      }

      var10000 = new class_134;
      var10000.method_451("No APK Signature Scheme v2 block in APK Signing Block");
      throw var10000;
   }

   // $FF: renamed from: e (java.nio.ByteBuffer) void
   private static void method_357(ByteBuffer var0) {
      if(var0.order() != ByteOrder.LITTLE_ENDIAN) {
         throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
      }
   }

   // $FF: renamed from: <init> (java.nio.ByteBuffer) void
   public void method_358(ByteBuffer var1) {
      super();
      this.field_194 = var1.slice();
   }

   // $FF: renamed from: a () long
   public long method_19() {
      return (long)this.field_194.capacity();
   }

   // $FF: renamed from: a (java.security.MessageDigest[], long, int) void
   public void method_20(MessageDigest[] var1, long var2, int var4) throws IOException {
      ByteBuffer var6 = this.field_194;
      ByteBuffer var5;
      synchronized(this.field_194) {
         this.field_194.position((int)var2);
         this.field_194.limit((int)var2 + var4);
         var5 = this.field_194.slice();
      }

      MessageDigest[] var11 = var1;
      int var7 = var1.length;

      for(int var8 = 0; var8 < var7; ++var8) {
         MessageDigest var9 = var11[var8];
         var5.position(0);
         var9.update(var5);
      }

   }
}
