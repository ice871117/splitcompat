package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.os.Build.VERSION;
import com.google.android.play.core.internal.ag;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class SplitInstallHelper {
    private static final ag a = new ag("SplitInstallHelper");

    private SplitInstallHelper() {
    }

    public static void loadLibrary(Context context, String str) throws UnsatisfiedLinkError {
        try {
            System.loadLibrary(str);
        } catch (UnsatisfiedLinkError e) {
            boolean z = false;
            try {
                String str2 = context.getApplicationInfo().nativeLibraryDir;
                String mapLibraryName = System.mapLibraryName(str);
                String sb = new StringBuilder(String.valueOf(str2).length() + 1 + String.valueOf(mapLibraryName).length()).append(str2).append("/").append(mapLibraryName).toString();
                if (new File(sb).exists()) {
                    System.load(sb);
                    z = true;
                }
                if (!z) {
                    throw e;
                }
            } catch (UnsatisfiedLinkError e2) {
                throw e2;
            }
        }
    }

    public static void updateAppInfo(Context context) {
        if (VERSION.SDK_INT > 25 && VERSION.SDK_INT < 28) {
            a.a("Calling dispatchPackageBroadcast", new Object[0]);
            try {
                Class cls = Class.forName("android.app.ActivityThread");
                Method method = cls.getMethod("currentActivityThread", new Class[0]);
                method.setAccessible(true);
                Object invoke = method.invoke(null, new Object[0]);
                Field declaredField = cls.getDeclaredField("mAppThread");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(invoke);
                obj.getClass().getMethod("dispatchPackageBroadcast", new Class[]{Integer.TYPE, String[].class}).invoke(obj, new Object[]{Integer.valueOf(3), new String[]{context.getPackageName()}});
                a.a("Called dispatchPackageBroadcast", new Object[0]);
            } catch (Exception e) {
                a.a((Throwable) e, "Update app info with dispatchPackageBroadcast failed!", new Object[0]);
            }
        }
    }
}
