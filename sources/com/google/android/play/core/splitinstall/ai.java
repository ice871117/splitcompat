package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

final class ai {
    private final Context a;

    ai(Context context) {
        this.a = context;
    }

    private final SharedPreferences b() {
        return this.a.getSharedPreferences("playcore_split_install_internal", 0);
    }

    /* access modifiers changed from: 0000 */
    public final synchronized Set<String> a() {
        Set<String> hashSet;
        try {
            hashSet = b().getStringSet("deferred_uninstall_module_list", new HashSet());
            if (hashSet == null) {
                hashSet = new HashSet<>();
            }
        } catch (Exception e) {
            hashSet = new HashSet<>();
        }
        return hashSet;
    }

    /* access modifiers changed from: 0000 */
    public final synchronized void a(Collection<String> collection) {
        Set a2 = a();
        boolean z = false;
        for (String add : collection) {
            z = a2.add(add) ? true : z;
        }
        if (z) {
            try {
                b().edit().putStringSet("deferred_uninstall_module_list", a2).apply();
            } catch (Exception e) {
            }
        }
    }
}
