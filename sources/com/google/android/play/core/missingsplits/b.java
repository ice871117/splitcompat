package com.google.android.play.core.missingsplits;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.AppTask;
import android.app.ActivityManager.RecentTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import com.google.android.play.core.internal.ag;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

final class b implements MissingSplitsManager {
    private static final ag a = new ag("MissingSplitsManagerImpl");
    private final Context b;
    private final Runtime c;
    private final a d;
    private final AtomicReference<Boolean> e;

    b(Context context, Runtime runtime, a aVar, AtomicReference<Boolean> atomicReference) {
        this.b = context;
        this.c = runtime;
        this.d = aVar;
        this.e = atomicReference;
    }

    private final boolean a() {
        try {
            ApplicationInfo applicationInfo = this.b.getPackageManager().getApplicationInfo(this.b.getPackageName(), 128);
            return applicationInfo.metaData != null && Boolean.TRUE.equals(applicationInfo.metaData.get("com.android.vending.splits.required"));
        } catch (NameNotFoundException e2) {
            a.c("App '%s' is not found in the PackageManager", this.b.getPackageName());
            return false;
        }
    }

    private final boolean a(ComponentName componentName) {
        String className = componentName.getClassName();
        try {
            Class cls = Class.forName(className);
            while (cls != null) {
                if (cls.equals(Activity.class)) {
                    return true;
                }
                Class superclass = cls.getSuperclass();
                if (superclass == cls) {
                    superclass = null;
                }
                cls = superclass;
            }
            return false;
        } catch (ClassNotFoundException e2) {
            a.c("ClassNotFoundException when scanning class hierarchy of '%s'", className);
            try {
                return this.b.getPackageManager().getActivityInfo(componentName, 0) != null;
            } catch (NameNotFoundException e3) {
                return false;
            }
        }
    }

    private final Set<String> b() {
        if (VERSION.SDK_INT < 21) {
            return Collections.emptySet();
        }
        try {
            PackageInfo packageInfo = this.b.getPackageManager().getPackageInfo(this.b.getPackageName(), 0);
            HashSet hashSet = new HashSet();
            if (packageInfo.splitNames == null) {
                return hashSet;
            }
            Collections.addAll(hashSet, packageInfo.splitNames);
            return hashSet;
        } catch (NameNotFoundException e2) {
            a.c("App '%s' is not found in PackageManager", this.b.getPackageName());
            return Collections.emptySet();
        }
    }

    private final List<AppTask> c() {
        List<AppTask> appTasks = ((ActivityManager) this.b.getSystemService("activity")).getAppTasks();
        return appTasks != null ? appTasks : Collections.emptyList();
    }

    public final boolean disableAppIfMissingRequiredSplits() {
        boolean z;
        boolean z2;
        boolean z3;
        if (VERSION.SDK_INT < 21) {
            return false;
        }
        if (isMissingRequiredSplits()) {
            Iterator it = c().iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                AppTask appTask = (AppTask) it.next();
                if (!(appTask.getTaskInfo() == null || appTask.getTaskInfo().baseIntent == null || appTask.getTaskInfo().baseIntent.getComponent() == null)) {
                    if (PlayCoreMissingSplitsActivity.class.getName().equals(appTask.getTaskInfo().baseIntent.getComponent().getClassName())) {
                        z = true;
                        break;
                    }
                }
            }
            if (!z) {
                Iterator it2 = c().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        z2 = false;
                        break;
                    }
                    RecentTaskInfo taskInfo = ((AppTask) it2.next()).getTaskInfo();
                    if (taskInfo == null || taskInfo.baseIntent == null || taskInfo.baseIntent.getComponent() == null || !a(taskInfo.baseIntent.getComponent())) {
                        z3 = false;
                        continue;
                    } else {
                        z3 = true;
                        continue;
                    }
                    if (z3) {
                        z2 = true;
                        break;
                    }
                }
                this.d.b();
                for (AppTask finishAndRemoveTask : c()) {
                    finishAndRemoveTask.finishAndRemoveTask();
                }
                if (z2) {
                    this.b.getPackageManager().setComponentEnabledSetting(new ComponentName(this.b, PlayCoreMissingSplitsActivity.class), 1, 1);
                    this.b.startActivity(new Intent(this.b, PlayCoreMissingSplitsActivity.class).addFlags(884998144));
                }
                this.c.exit(0);
            }
            return true;
        } else if (!this.d.a()) {
            return false;
        } else {
            this.d.c();
            this.c.exit(0);
            return false;
        }
    }

    public final boolean isMissingRequiredSplits() {
        boolean booleanValue;
        boolean z;
        synchronized (this.e) {
            if (((Boolean) this.e.get()) == null) {
                AtomicReference<Boolean> atomicReference = this.e;
                if (VERSION.SDK_INT >= 21 && a()) {
                    Set b2 = b();
                    if (b2.isEmpty() || (b2.size() == 1 && b2.contains(""))) {
                        z = true;
                        atomicReference.set(Boolean.valueOf(z));
                    }
                }
                z = false;
                atomicReference.set(Boolean.valueOf(z));
            }
            booleanValue = ((Boolean) this.e.get()).booleanValue();
        }
        return booleanValue;
    }
}
