package com.google.android.play.core.splitinstall;

import android.app.Activity;
import android.content.Context;
import android.content.IntentSender.SendIntentException;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import com.google.android.play.core.listener.StateUpdatedListener;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.Tasks;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

final class o implements SplitInstallManager {
    private final q a;
    /* access modifiers changed from: private */
    public final m b;
    private final k c;
    private final ai d;
    private final Handler e;

    o(q qVar, Context context) {
        this(qVar, context, context.getPackageName());
    }

    private o(q qVar, Context context, String str) {
        this.e = new Handler(Looper.getMainLooper());
        this.c = new k(context, str);
        this.a = qVar;
        this.b = m.a(context);
        this.d = new ai(context);
    }

    /* access modifiers changed from: private */
    public static List<String> b(List<Locale> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (Locale locale : list) {
            if (VERSION.SDK_INT >= 21) {
                arrayList.add(locale.toLanguageTag());
            }
        }
        return arrayList;
    }

    public final Task<Void> cancelInstall(int i) {
        return this.a.b(i);
    }

    public final Task<Void> deferredInstall(List<String> list) {
        return this.a.b(list);
    }

    public final Task<Void> deferredLanguageInstall(List<Locale> list) {
        return VERSION.SDK_INT < 21 ? Tasks.a((Exception) new SplitInstallException(-5)) : this.a.c(b(list));
    }

    public final Task<Void> deferredLanguageUninstall(List<Locale> list) {
        return VERSION.SDK_INT < 21 ? Tasks.a((Exception) new SplitInstallException(-5)) : this.a.d(b(list));
    }

    public final Task<Void> deferredUninstall(List<String> list) {
        this.d.a(list);
        return this.a.a(list);
    }

    public final Set<String> getInstalledLanguages() {
        Set<String> b2 = this.c.b();
        return b2 == null ? Collections.emptySet() : b2;
    }

    public final Set<String> getInstalledModules() {
        return this.c.a();
    }

    public final Task<SplitInstallSessionState> getSessionState(int i) {
        return this.a.a(i);
    }

    public final Task<List<SplitInstallSessionState>> getSessionStates() {
        return this.a.a();
    }

    public final synchronized void registerListener(SplitInstallStateUpdatedListener splitInstallStateUpdatedListener) {
        this.b.a((StateUpdatedListener<StateT>) splitInstallStateUpdatedListener);
    }

    public final boolean startConfirmationDialogForResult(SplitInstallSessionState splitInstallSessionState, Activity activity, int i) throws SendIntentException {
        if (splitInstallSessionState.status() != 8 || splitInstallSessionState.resolutionIntent() == null) {
            return false;
        }
        activity.startIntentSenderForResult(splitInstallSessionState.resolutionIntent().getIntentSender(), i, null, 0, 0, 0);
        return true;
    }

    public final Task<Integer> startInstall(SplitInstallRequest splitInstallRequest) {
        boolean containsAll;
        if (!splitInstallRequest.getLanguages().isEmpty() && VERSION.SDK_INT < 21) {
            return Tasks.a((Exception) new SplitInstallException(-5));
        }
        List<Locale> languages = splitInstallRequest.getLanguages();
        Set b2 = this.c.b();
        if (b2 == null) {
            containsAll = true;
        } else {
            HashSet hashSet = new HashSet();
            for (Locale language : languages) {
                hashSet.add(language.getLanguage());
            }
            containsAll = b2.containsAll(hashSet);
        }
        if (containsAll) {
            if (getInstalledModules().containsAll(splitInstallRequest.getModuleNames()) && (VERSION.SDK_INT < 21 || Collections.disjoint(splitInstallRequest.getModuleNames(), this.d.a()))) {
                this.e.post(new n(this, splitInstallRequest));
                return Tasks.a(Integer.valueOf(0));
            }
        }
        return this.a.a(splitInstallRequest.getModuleNames(), b(splitInstallRequest.getLanguages()));
    }

    public final synchronized void unregisterListener(SplitInstallStateUpdatedListener splitInstallStateUpdatedListener) {
        this.b.b(splitInstallStateUpdatedListener);
    }
}
