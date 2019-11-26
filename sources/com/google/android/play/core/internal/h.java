package com.google.android.play.core.internal;

import android.util.Pair;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.security.DigestException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
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
import java.security.spec.InvalidKeySpecException;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class h implements b {
    private final ByteBuffer a;

    public h(ByteBuffer byteBuffer) {
        this.a = byteBuffer.slice();
    }

    private static int a(int i, int i2) {
        return b(b(i), b(i2));
    }

    private static long a(long j) {
        return ((j + 1048576) - 1) / 1048576;
    }

    private static long a(ByteBuffer byteBuffer, int i) {
        return ((long) byteBuffer.getInt(i)) & 4294967295L;
    }

    private static long a(ByteBuffer byteBuffer, long j) throws c {
        a(byteBuffer);
        long a2 = a(byteBuffer, byteBuffer.position() + 16);
        if (a2 >= j) {
            throw new c("ZIP Central Directory offset out of range: " + a2 + ". ZIP End of Central Directory offset: " + j);
        }
        a(byteBuffer);
        if (a(byteBuffer, byteBuffer.position() + 12) + a2 == j) {
            return a2;
        }
        throw new c("ZIP Central Directory is not immediately followed by End of Central Directory");
    }

    private static Pair<ByteBuffer, Long> a(RandomAccessFile randomAccessFile, int i) throws IOException {
        int i2;
        if (i < 0 || i > 65535) {
            throw new IllegalArgumentException("maxCommentSize: " + i);
        }
        long length = randomAccessFile.length();
        if (length < 22) {
            return null;
        }
        ByteBuffer allocate = ByteBuffer.allocate(((int) Math.min((long) i, length - 22)) + 22);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        long capacity = length - ((long) allocate.capacity());
        randomAccessFile.seek(capacity);
        randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
        a(allocate);
        int capacity2 = allocate.capacity();
        if (capacity2 >= 22) {
            int min = Math.min(capacity2 - 22, 65535);
            int i3 = capacity2 - 22;
            int i4 = 0;
            while (true) {
                if (i4 >= min) {
                    break;
                }
                i2 = i3 - i4;
                if (allocate.getInt(i2) == 101010256 && (allocate.getShort(i2 + 20) & 65535) == i4) {
                    break;
                }
                i4++;
            }
        }
        i2 = -1;
        if (i2 == -1) {
            return null;
        }
        allocate.position(i2);
        ByteBuffer slice = allocate.slice();
        slice.order(ByteOrder.LITTLE_ENDIAN);
        return Pair.create(slice, Long.valueOf(((long) i2) + capacity));
    }

    private static Pair<ByteBuffer, Long> a(RandomAccessFile randomAccessFile, long j) throws IOException, c {
        if (j < 32) {
            throw new c("APK too small for APK Signing Block. ZIP Central Directory offset: " + j);
        }
        ByteBuffer allocate = ByteBuffer.allocate(24);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        randomAccessFile.seek(j - ((long) allocate.capacity()));
        randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
        if (allocate.getLong(8) == 2334950737559900225L && allocate.getLong(16) == 3617552046287187010L) {
            long j2 = allocate.getLong(0);
            if (j2 < ((long) allocate.capacity()) || j2 > 2147483639) {
                throw new c("APK Signing Block size out of range: " + j2);
            }
            int i = (int) (8 + j2);
            long j3 = j - ((long) i);
            if (j3 < 0) {
                throw new c("APK Signing Block offset out of range: " + j3);
            }
            ByteBuffer allocate2 = ByteBuffer.allocate(i);
            allocate2.order(ByteOrder.LITTLE_ENDIAN);
            randomAccessFile.seek(j3);
            randomAccessFile.readFully(allocate2.array(), allocate2.arrayOffset(), allocate2.capacity());
            long j4 = allocate2.getLong(0);
            if (j4 == j2) {
                return Pair.create(allocate2, Long.valueOf(j3));
            }
            throw new c("APK Signing Block sizes in header and footer do not match: " + j4 + " vs " + j2);
        }
        throw new c("No APK Signing Block before ZIP Central Directory");
    }

    private static ByteBuffer a(ByteBuffer byteBuffer, int i, int i2) {
        if (i2 < 8) {
            throw new IllegalArgumentException("end < start: " + i2 + " < 8");
        }
        int capacity = byteBuffer.capacity();
        if (i2 > byteBuffer.capacity()) {
            throw new IllegalArgumentException("end > capacity: " + i2 + " > " + capacity);
        }
        int limit = byteBuffer.limit();
        int position = byteBuffer.position();
        try {
            byteBuffer.position(0);
            byteBuffer.limit(i2);
            byteBuffer.position(8);
            ByteBuffer slice = byteBuffer.slice();
            slice.order(byteBuffer.order());
            return slice;
        } finally {
            byteBuffer.position(0);
            byteBuffer.limit(limit);
            byteBuffer.position(position);
        }
    }

    private static void a(int i, byte[] bArr, int i2) {
        bArr[1] = (byte) i;
        bArr[2] = (byte) (i >>> 8);
        bArr[3] = (byte) (i >>> 16);
        bArr[4] = (byte) (i >>> 24);
    }

    private static void a(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    private static void a(Map<Integer, byte[]> map, FileChannel fileChannel, long j, long j2, long j3, ByteBuffer byteBuffer) throws SecurityException {
        if (map.isEmpty()) {
            throw new SecurityException("No digests provided");
        }
        a aVar = new a(fileChannel, 0, j);
        a aVar2 = new a(fileChannel, j2, j3 - j2);
        ByteBuffer duplicate = byteBuffer.duplicate();
        duplicate.order(ByteOrder.LITTLE_ENDIAN);
        a(duplicate);
        int position = duplicate.position() + 16;
        if (j < 0 || j > 4294967295L) {
            throw new IllegalArgumentException("uint32 value of out range: " + j);
        }
        duplicate.putInt(position + duplicate.position(), (int) j);
        h hVar = new h(duplicate);
        int[] iArr = new int[map.size()];
        int i = 0;
        Iterator it = map.keySet().iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                break;
            }
            iArr[i2] = ((Integer) it.next()).intValue();
            i = i2 + 1;
        }
        try {
            byte[][] a2 = a(iArr, new b[]{aVar, aVar2, hVar});
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < iArr.length) {
                    int i5 = iArr[i4];
                    if (!MessageDigest.isEqual((byte[]) map.get(Integer.valueOf(i5)), a2[i4])) {
                        throw new SecurityException(String.valueOf(c(i5)).concat(" digest of contents did not verify"));
                    }
                    i3 = i4 + 1;
                } else {
                    return;
                }
            }
        } catch (DigestException e) {
            throw new SecurityException("Failed to compute digest(s) of contents", e);
        }
    }

    private static boolean a(int i) {
        switch (i) {
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

    private static X509Certificate[] a(ByteBuffer byteBuffer, Map<Integer, byte[]> map, CertificateFactory certificateFactory) throws SecurityException, IOException {
        byte[] bArr;
        ByteBuffer b = b(byteBuffer);
        ByteBuffer b2 = b(byteBuffer);
        byte[] c = c(byteBuffer);
        int i = -1;
        byte[] bArr2 = null;
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (b2.hasRemaining()) {
            i2++;
            try {
                ByteBuffer b3 = b(b2);
                if (b3.remaining() < 8) {
                    throw new SecurityException("Signature record too short");
                }
                int i3 = b3.getInt();
                arrayList.add(Integer.valueOf(i3));
                if (a(i3)) {
                    if (i == -1 || a(i3, i) > 0) {
                        bArr = c(b3);
                    } else {
                        bArr = bArr2;
                        i3 = i;
                    }
                    bArr2 = bArr;
                    i = i3;
                }
            } catch (IOException | BufferUnderflowException e) {
                throw new SecurityException("Failed to parse signature record #" + i2, e);
            }
        }
        if (i != -1) {
            String e2 = e(i);
            Pair f = f(i);
            String str = (String) f.first;
            AlgorithmParameterSpec algorithmParameterSpec = (AlgorithmParameterSpec) f.second;
            try {
                PublicKey generatePublic = KeyFactory.getInstance(e2).generatePublic(new X509EncodedKeySpec(c));
                Signature instance = Signature.getInstance(str);
                instance.initVerify(generatePublic);
                if (algorithmParameterSpec != null) {
                    instance.setParameter(algorithmParameterSpec);
                }
                instance.update(b);
                if (!instance.verify(bArr2)) {
                    throw new SecurityException(String.valueOf(str).concat(" signature did not verify"));
                }
                byte[] bArr3 = null;
                b.clear();
                ByteBuffer b4 = b(b);
                ArrayList arrayList2 = new ArrayList();
                int i4 = 0;
                while (b4.hasRemaining()) {
                    i4++;
                    try {
                        ByteBuffer b5 = b(b4);
                        if (b5.remaining() < 8) {
                            throw new IOException("Record too short");
                        }
                        int i5 = b5.getInt();
                        arrayList2.add(Integer.valueOf(i5));
                        bArr3 = i5 == i ? c(b5) : bArr3;
                    } catch (IOException | BufferUnderflowException e3) {
                        throw new IOException("Failed to parse digest record #" + i4, e3);
                    }
                }
                if (!arrayList.equals(arrayList2)) {
                    throw new SecurityException("Signature algorithms don't match between digests and signatures records");
                }
                int b6 = b(i);
                byte[] bArr4 = (byte[]) map.put(Integer.valueOf(b6), bArr3);
                if (bArr4 == null || MessageDigest.isEqual(bArr4, bArr3)) {
                    ByteBuffer b7 = b(b);
                    ArrayList arrayList3 = new ArrayList();
                    int i6 = 0;
                    while (b7.hasRemaining()) {
                        int i7 = i6 + 1;
                        byte[] c2 = c(b7);
                        try {
                            arrayList3.add(new f((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(c2)), c2));
                            i6 = i7;
                        } catch (CertificateException e4) {
                            throw new SecurityException("Failed to decode certificate #" + i7, e4);
                        }
                    }
                    if (arrayList3.isEmpty()) {
                        throw new SecurityException("No certificates listed");
                    } else if (Arrays.equals(c, ((X509Certificate) arrayList3.get(0)).getPublicKey().getEncoded())) {
                        return (X509Certificate[]) arrayList3.toArray(new X509Certificate[arrayList3.size()]);
                    } else {
                        throw new SecurityException("Public key mismatch between certificate and signature record");
                    }
                } else {
                    throw new SecurityException(String.valueOf(c(b6)).concat(" contents digest does not match the digest specified by a preceding signer"));
                }
            } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | SignatureException | InvalidKeySpecException e5) {
                throw new SecurityException(new StringBuilder(String.valueOf(str).length() + 27).append("Failed to verify ").append(str).append(" signature").toString(), e5);
            }
        } else if (i2 == 0) {
            throw new SecurityException("No signatures found");
        } else {
            throw new SecurityException("No supported signatures found");
        }
    }

    private static byte[][] a(int[] iArr, b[] bVarArr) throws DigestException {
        long j = 0;
        for (b a2 : bVarArr) {
            j += a(a2.a());
        }
        if (j >= 2097151) {
            throw new DigestException("Too many chunks: " + j);
        }
        int i = (int) j;
        byte[][] bArr = new byte[iArr.length][];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            byte[] bArr2 = new byte[((d(iArr[i2]) * i) + 5)];
            bArr2[0] = 90;
            a(i, bArr2, 1);
            bArr[i2] = bArr2;
        }
        byte[] bArr3 = new byte[5];
        bArr3[0] = -91;
        int i3 = 0;
        MessageDigest[] messageDigestArr = new MessageDigest[iArr.length];
        int i4 = 0;
        while (i4 < iArr.length) {
            String c = c(iArr[i4]);
            try {
                messageDigestArr[i4] = MessageDigest.getInstance(c);
                i4++;
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(String.valueOf(c).concat(" digest not supported"), e);
            }
        }
        int i5 = 0;
        int length = bVarArr.length;
        int i6 = 0;
        while (true) {
            int i7 = i6;
            int i8 = i5;
            if (i7 < length) {
                b bVar = bVarArr[i7];
                long j2 = 0;
                long a3 = bVar.a();
                while (true) {
                    long j3 = a3;
                    if (j3 <= 0) {
                        break;
                    }
                    int min = (int) Math.min(j3, 1048576);
                    a(min, bArr3, 1);
                    for (int i9 = 0; i9 < messageDigestArr.length; i9++) {
                        messageDigestArr[i9].update(bArr3);
                    }
                    try {
                        bVar.a(messageDigestArr, j2, min);
                        for (int i10 = 0; i10 < iArr.length; i10++) {
                            int i11 = iArr[i10];
                            byte[] bArr4 = bArr[i10];
                            int d = d(i11);
                            MessageDigest messageDigest = messageDigestArr[i10];
                            int digest = messageDigest.digest(bArr4, (i3 * d) + 5, d);
                            if (digest != d) {
                                String algorithm = messageDigest.getAlgorithm();
                                throw new RuntimeException(new StringBuilder(String.valueOf(algorithm).length() + 46).append("Unexpected output size of ").append(algorithm).append(" digest: ").append(digest).toString());
                            }
                        }
                        j2 += (long) min;
                        a3 = j3 - ((long) min);
                        i3++;
                    } catch (IOException e2) {
                        throw new DigestException("Failed to digest chunk #" + i3 + " of section #" + i8, e2);
                    }
                }
            } else {
                byte[][] bArr5 = new byte[iArr.length][];
                int i12 = 0;
                while (i12 < iArr.length) {
                    int i13 = iArr[i12];
                    byte[] bArr6 = bArr[i12];
                    String c2 = c(i13);
                    try {
                        bArr5[i12] = MessageDigest.getInstance(c2).digest(bArr6);
                        i12++;
                    } catch (NoSuchAlgorithmException e3) {
                        throw new RuntimeException(String.valueOf(c2).concat(" digest not supported"), e3);
                    }
                }
                return bArr5;
            }
            i5 = i8 + 1;
            i6 = i7 + 1;
        }
    }

    private static X509Certificate[][] a(RandomAccessFile randomAccessFile) throws c, SecurityException, IOException {
        return a(randomAccessFile.getChannel(), b(randomAccessFile));
    }

    public static X509Certificate[][] a(String str) throws c, SecurityException, IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, "r");
        try {
            X509Certificate[][] a2 = a(randomAccessFile);
            randomAccessFile.close();
            return a2;
        } finally {
            try {
                randomAccessFile.close();
            } catch (IOException e) {
            }
        }
    }

    private static X509Certificate[][] a(FileChannel fileChannel, d dVar) throws SecurityException {
        int i = 0;
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        try {
            CertificateFactory instance = CertificateFactory.getInstance("X.509");
            try {
                ByteBuffer b = b(dVar.a);
                while (b.hasRemaining()) {
                    i++;
                    try {
                        arrayList.add(a(b(b), (Map<Integer, byte[]>) hashMap, instance));
                    } catch (IOException | SecurityException | BufferUnderflowException e) {
                        throw new SecurityException("Failed to parse/verify signer #" + i + " block", e);
                    }
                }
                if (i <= 0) {
                    throw new SecurityException("No signers found");
                } else if (hashMap.isEmpty()) {
                    throw new SecurityException("No content digests found");
                } else {
                    a(hashMap, fileChannel, dVar.b, dVar.c, dVar.d, dVar.e);
                    return (X509Certificate[][]) arrayList.toArray(new X509Certificate[arrayList.size()][]);
                }
            } catch (IOException e2) {
                throw new SecurityException("Failed to read list of signers", e2);
            }
        } catch (CertificateException e3) {
            throw new RuntimeException("Failed to obtain X.509 CertificateFactory", e3);
        }
    }

    private static int b(int i) {
        switch (i) {
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
                String str = "Unknown signature algorithm: 0x";
                String valueOf = String.valueOf(Long.toHexString((long) i));
                throw new IllegalArgumentException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
    }

    private static int b(int i, int i2) {
        switch (i) {
            case 1:
                switch (i2) {
                    case 1:
                        return 0;
                    case 2:
                        return -1;
                    default:
                        throw new IllegalArgumentException("Unknown digestAlgorithm2: " + i2);
                }
            case 2:
                switch (i2) {
                    case 1:
                        return 1;
                    case 2:
                        return 0;
                    default:
                        throw new IllegalArgumentException("Unknown digestAlgorithm2: " + i2);
                }
            default:
                throw new IllegalArgumentException("Unknown digestAlgorithm1: " + i);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x002a  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0034  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.play.core.internal.d b(java.io.RandomAccessFile r10) throws java.io.IOException, com.google.android.play.core.internal.c {
        /*
            r9 = 0
            android.util.Pair r0 = c(r10)
            java.lang.Object r8 = r0.first
            java.nio.ByteBuffer r8 = (java.nio.ByteBuffer) r8
            java.lang.Object r0 = r0.second
            java.lang.Long r0 = (java.lang.Long) r0
            long r6 = r0.longValue()
            r0 = 20
            long r0 = r6 - r0
            r2 = 0
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 < 0) goto L_0x0032
            r10.seek(r0)
            int r0 = r10.readInt()
            r1 = 1347094023(0x504b0607, float:1.36246794E10)
            if (r0 != r1) goto L_0x0032
            r0 = 1
        L_0x0028:
            if (r0 == 0) goto L_0x0034
            com.google.android.play.core.internal.c r0 = new com.google.android.play.core.internal.c
            java.lang.String r1 = "ZIP64 APK not supported"
            r0.<init>(r1)
            throw r0
        L_0x0032:
            r0 = r9
            goto L_0x0028
        L_0x0034:
            long r4 = a(r8, r6)
            android.util.Pair r1 = a(r10, r4)
            java.lang.Object r0 = r1.first
            java.nio.ByteBuffer r0 = (java.nio.ByteBuffer) r0
            java.lang.Object r1 = r1.second
            java.lang.Long r1 = (java.lang.Long) r1
            long r2 = r1.longValue()
            java.nio.ByteBuffer r1 = d(r0)
            com.google.android.play.core.internal.d r0 = new com.google.android.play.core.internal.d
            r0.<init>(r1, r2, r4, r6, r8, r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.internal.h.b(java.io.RandomAccessFile):com.google.android.play.core.internal.d");
    }

    private static ByteBuffer b(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer.remaining() < 4) {
            throw new IOException("Remaining buffer too short to contain length of length-prefixed field. Remaining: " + byteBuffer.remaining());
        }
        int i = byteBuffer.getInt();
        if (i < 0) {
            throw new IllegalArgumentException("Negative length");
        } else if (i <= byteBuffer.remaining()) {
            return b(byteBuffer, i);
        } else {
            throw new IOException("Length-prefixed field longer than remaining buffer. Field length: " + i + ", remaining: " + byteBuffer.remaining());
        }
    }

    private static ByteBuffer b(ByteBuffer byteBuffer, int i) throws BufferUnderflowException {
        if (i < 0) {
            throw new IllegalArgumentException("size: " + i);
        }
        int limit = byteBuffer.limit();
        int position = byteBuffer.position();
        int i2 = position + i;
        if (i2 < position || i2 > limit) {
            throw new BufferUnderflowException();
        }
        byteBuffer.limit(i2);
        try {
            ByteBuffer slice = byteBuffer.slice();
            slice.order(byteBuffer.order());
            byteBuffer.position(i2);
            return slice;
        } finally {
            byteBuffer.limit(limit);
        }
    }

    private static Pair<ByteBuffer, Long> c(RandomAccessFile randomAccessFile) throws IOException, c {
        Pair<ByteBuffer, Long> a2;
        if (randomAccessFile.length() < 22) {
            a2 = null;
        } else {
            a2 = a(randomAccessFile, 0);
            if (a2 == null) {
                a2 = a(randomAccessFile, 65535);
            }
        }
        if (a2 != null) {
            return a2;
        }
        throw new c("Not an APK file: ZIP End of Central Directory record not found in file with " + randomAccessFile.length() + " bytes");
    }

    private static String c(int i) {
        switch (i) {
            case 1:
                return "SHA-256";
            case 2:
                return "SHA-512";
            default:
                throw new IllegalArgumentException("Unknown content digest algorthm: " + i);
        }
    }

    private static byte[] c(ByteBuffer byteBuffer) throws IOException {
        int i = byteBuffer.getInt();
        if (i < 0) {
            throw new IOException("Negative length");
        } else if (i > byteBuffer.remaining()) {
            throw new IOException("Underflow while reading length-prefixed value. Length: " + i + ", available: " + byteBuffer.remaining());
        } else {
            byte[] bArr = new byte[i];
            byteBuffer.get(bArr);
            return bArr;
        }
    }

    private static int d(int i) {
        switch (i) {
            case 1:
                return 32;
            case 2:
                return 64;
            default:
                throw new IllegalArgumentException("Unknown content digest algorthm: " + i);
        }
    }

    private static ByteBuffer d(ByteBuffer byteBuffer) throws c {
        e(byteBuffer);
        ByteBuffer a2 = a(byteBuffer, 8, byteBuffer.capacity() - 24);
        int i = 0;
        while (a2.hasRemaining()) {
            i++;
            if (a2.remaining() < 8) {
                throw new c("Insufficient data to read size of APK Signing Block entry #" + i);
            }
            long j = a2.getLong();
            if (j < 4 || j > 2147483647L) {
                throw new c("APK Signing Block entry #" + i + " size out of range: " + j);
            }
            int i2 = (int) j;
            int position = a2.position() + i2;
            if (i2 > a2.remaining()) {
                throw new c("APK Signing Block entry #" + i + " size out of range: " + i2 + ", available: " + a2.remaining());
            } else if (a2.getInt() == 1896449818) {
                return b(a2, i2 - 4);
            } else {
                a2.position(position);
            }
        }
        throw new c("No APK Signature Scheme v2 block in APK Signing Block");
    }

    private static String e(int i) {
        switch (i) {
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
                String str = "Unknown signature algorithm: 0x";
                String valueOf = String.valueOf(Long.toHexString((long) i));
                throw new IllegalArgumentException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
    }

    private static void e(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    private static Pair<String, ? extends AlgorithmParameterSpec> f(int i) {
        switch (i) {
            case 257:
                return Pair.create("SHA256withRSA/PSS", new PSSParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, 32, 1));
            case 258:
                return Pair.create("SHA512withRSA/PSS", new PSSParameterSpec("SHA-512", "MGF1", MGF1ParameterSpec.SHA512, 64, 1));
            case 259:
                return Pair.create("SHA256withRSA", null);
            case 260:
                return Pair.create("SHA512withRSA", null);
            case 513:
                return Pair.create("SHA256withECDSA", null);
            case 514:
                return Pair.create("SHA512withECDSA", null);
            case 769:
                return Pair.create("SHA256withDSA", null);
            default:
                String str = "Unknown signature algorithm: 0x";
                String valueOf = String.valueOf(Long.toHexString((long) i));
                throw new IllegalArgumentException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
    }

    public long a() {
        return (long) this.a.capacity();
    }

    public void a(MessageDigest[] messageDigestArr, long j, int i) throws IOException {
        ByteBuffer slice;
        synchronized (this.a) {
            this.a.position((int) j);
            this.a.limit(((int) j) + i);
            slice = this.a.slice();
        }
        for (MessageDigest messageDigest : messageDigestArr) {
            slice.position(0);
            messageDigest.update(slice);
        }
    }
}
