package com.google.android.play.core.splitinstall;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class g {
    private final Map<String, Map<String, String>> a = new HashMap();

    public final d a() {
        HashMap hashMap = new HashMap();
        for (Entry entry : this.a.entrySet()) {
            hashMap.put((String) entry.getKey(), Collections.unmodifiableMap(new HashMap((Map) entry.getValue())));
        }
        return new d(Collections.unmodifiableMap(hashMap), 0);
    }

    public final g a(String str, String str2, String str3) {
        if (!this.a.containsKey(str2)) {
            this.a.put(str2, new HashMap());
        }
        ((Map) this.a.get(str2)).put(str, str3);
        return this;
    }
}
