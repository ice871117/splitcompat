package com.google.android.play.core.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.util.Log;
import com.google.android.play.core.splitcompat.e;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class ae {
    private final e a;
    private final az b;
    private final Context c;

    public ae(Context context, e eVar, az azVar) {
        this.a = eVar;
        this.b = azVar;
        this.c = context;
    }

    private static X509Certificate a(Signature signature) {
        try {
            return (X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(signature.toByteArray()));
        } catch (CertificateException e) {
            Log.e("SplitCompat", "Cannot decode certificate.", e);
            return null;
        }
    }

    private final boolean a(String str, List<X509Certificate> list) {
        boolean z;
        try {
            X509Certificate[][] a2 = az.a(str);
            if (a2 == null || a2.length == 0 || a2[0].length == 0) {
                Log.e("SplitCompat", new StringBuilder(String.valueOf(str).length() + 32).append("Downloaded split ").append(str).append(" is not signed.").toString());
                return false;
            } else if (list.isEmpty()) {
                Log.e("SplitCompat", "No certificates found for app.");
                return false;
            } else {
                for (X509Certificate x509Certificate : list) {
                    int length = a2.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            z = false;
                            continue;
                            break;
                        } else if (a2[i][0].equals(x509Certificate)) {
                            z = true;
                            continue;
                            break;
                        } else {
                            i++;
                        }
                    }
                    if (!z) {
                        Log.i("SplitCompat", "There's an app certificate that doesn't sign the split.");
                        return false;
                    }
                }
                return true;
            }
        } catch (Exception e) {
            Log.e("SplitCompat", new StringBuilder(String.valueOf(str).length() + 32).append("Downloaded split ").append(str).append(" is not signed.").toString(), e);
            return false;
        }
    }

    private final Signature[] b() {
        try {
            return this.c.getPackageManager().getPackageInfo(this.c.getPackageName(), 64).signatures;
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    public final boolean a() {
        ArrayList arrayList;
        try {
            File c2 = this.a.c();
            Signature[] b2 = b();
            if (b2 == null) {
                arrayList = null;
            } else {
                ArrayList arrayList2 = new ArrayList();
                for (Signature a2 : b2) {
                    X509Certificate a3 = a(a2);
                    if (a3 != null) {
                        arrayList2.add(a3);
                    }
                }
                arrayList = arrayList2;
            }
            if (arrayList == null || arrayList.isEmpty()) {
                Log.e("SplitCompat", "No app certificates found.");
                return false;
            }
            File[] listFiles = c2.listFiles();
            Arrays.sort(listFiles);
            int length = listFiles.length - 1;
            while (length >= 0) {
                File file = listFiles[length];
                try {
                    if (!a(file.getAbsolutePath(), arrayList)) {
                        Log.e("SplitCompat", "Split verification failure.");
                        return false;
                    }
                    try {
                        file.renameTo(this.a.a(file));
                        length--;
                    } catch (IOException e) {
                        Log.e("SplitCompat", "Cannot write verified split.", e);
                        return false;
                    }
                } catch (Exception e2) {
                    Log.e("SplitCompat", "Split verification error.", e2);
                    return false;
                }
            }
            return true;
        } catch (IOException e3) {
            Log.e("SplitCompat", "Cannot access directory for unverified splits.", e3);
            return false;
        }
    }

    public final boolean a(List<Intent> list) throws IOException {
        for (Intent stringExtra : list) {
            if (!this.a.b(stringExtra.getStringExtra("split_id")).exists()) {
                return false;
            }
        }
        return true;
    }
}
