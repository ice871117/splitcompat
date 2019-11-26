package com.google.android.play.core.internal;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.util.Log;
import com.google.android.play.core.splitcompat.e;
import com.google.android.play.core.splitinstall.b;
import com.google.android.play.core.splitinstall.c;
import com.google.android.play.core.splitinstall.i;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.List;
import java.util.concurrent.Executor;

public final class ac implements c {
    private final Context a;
    private final e b;
    /* access modifiers changed from: private */
    public final ae c;
    private final Executor d;
    private final i e;

    public ac(Context context, Executor executor, ae aeVar, e eVar, i iVar) {
        this.a = context;
        this.b = eVar;
        this.c = aeVar;
        this.d = executor;
        this.e = iVar;
    }

    private final Integer a(List<Intent> list) {
        FileLock fileLock;
        Integer num;
        Throwable th;
        Throwable th2 = null;
        try {
            FileChannel channel = new RandomAccessFile(this.b.b(), "rw").getChannel();
            try {
                fileLock = channel.tryLock();
            } catch (OverlappingFileLockException e2) {
                fileLock = null;
            }
            if (fileLock != null) {
                try {
                    num = Integer.valueOf(b(list));
                    fileLock.release();
                } catch (Throwable th3) {
                    th = th3;
                    th2 = r0;
                }
            } else {
                num = null;
            }
            if (channel == null) {
                return num;
            }
            a((Throwable) null, channel);
            return num;
            if (channel != null) {
                a(th2, channel);
            }
            throw th;
        } catch (Exception e3) {
            Log.e("SplitCompat", "Error locking files.", e3);
            return Integer.valueOf(-13);
        }
    }

    /* access modifiers changed from: private */
    public final void a(b bVar) {
        try {
            if (!this.e.a(this.a.getApplicationContext())) {
                Log.e("SplitCompat", "Emulating splits failed.");
                bVar.a(-12);
                return;
            }
            Log.i("SplitCompat", "Splits installed.");
            bVar.a();
        } catch (Exception e2) {
            Log.e("SplitCompat", "Error emulating splits.", e2);
            bVar.a(-12);
        }
    }

    private static /* synthetic */ void a(Throwable th, InputStream inputStream) {
        if (th != null) {
            try {
                inputStream.close();
            } catch (Throwable th2) {
                bh.a(th, th2);
            }
        } else {
            inputStream.close();
        }
    }

    private static /* synthetic */ void a(Throwable th, OutputStream outputStream) {
        if (th != null) {
            try {
                outputStream.close();
            } catch (Throwable th2) {
                bh.a(th, th2);
            }
        } else {
            outputStream.close();
        }
    }

    private static /* synthetic */ void a(Throwable th, FileChannel fileChannel) {
        if (th != null) {
            try {
                fileChannel.close();
            } catch (Throwable th2) {
                bh.a(th, th2);
            }
        } else {
            fileChannel.close();
        }
    }

    private final int b(List<Intent> list) {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        FileOutputStream fileOutputStream;
        Throwable th2;
        Throwable th3;
        Throwable th4 = null;
        try {
            Log.i("SplitCompat", "Copying splits.");
            for (Intent intent : list) {
                String stringExtra = intent.getStringExtra("split_id");
                AssetFileDescriptor openAssetFileDescriptor = this.a.getContentResolver().openAssetFileDescriptor(intent.getData(), "r");
                File a2 = this.b.a(stringExtra);
                if (((a2.exists() && a2.length() != openAssetFileDescriptor.getLength()) || !a2.exists()) && !this.b.b(stringExtra).exists()) {
                    bufferedInputStream = new BufferedInputStream(openAssetFileDescriptor.createInputStream());
                    try {
                        fileOutputStream = new FileOutputStream(a2);
                        try {
                            byte[] bArr = new byte[4096];
                            while (true) {
                                int read = bufferedInputStream.read(bArr);
                                if (read <= 0) {
                                    break;
                                }
                                fileOutputStream.write(bArr, 0, read);
                            }
                            fileOutputStream.close();
                            a((Throwable) null, (InputStream) bufferedInputStream);
                        } catch (Throwable th5) {
                            th2 = th5;
                            th3 = r0;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        th4 = r0;
                    }
                }
            }
            Log.i("SplitCompat", "Splits copied.");
            try {
                if (!this.c.a()) {
                    Log.e("SplitCompat", "Split verification failed.");
                    return -11;
                }
                Log.i("SplitCompat", "Splits verified.");
                return 0;
            } catch (Exception e2) {
                Log.e("SplitCompat", "Error verifying splits.", e2);
                return -11;
            }
            a(th4, (InputStream) bufferedInputStream);
            throw th;
            a(th3, (OutputStream) fileOutputStream);
            throw th2;
        } catch (Exception e3) {
            Log.e("SplitCompat", "Error copying splits.", e3);
            return -13;
        }
    }

    /* access modifiers changed from: private */
    public final void b(List<Intent> list, b bVar) {
        Integer a2 = a(list);
        if (a2 != null) {
            if (a2.intValue() == 0) {
                bVar.b();
            } else {
                bVar.a(a2.intValue());
            }
        }
    }

    public final void a(List<Intent> list, b bVar) {
        if (!this.e.a()) {
            throw new IllegalStateException("Ingestion should only be called in SplitCompat mode.");
        }
        this.d.execute(new ab(this, list, bVar));
    }
}
