package com.google.android.play.core.splitinstall;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public abstract class SplitInstallSessionState {
    public static SplitInstallSessionState a(Bundle bundle) {
        return new a(bundle.getInt("session_id"), bundle.getInt("status"), bundle.getInt("error_code"), bundle.getLong("bytes_downloaded"), bundle.getLong("total_bytes_to_download"), bundle.getStringArrayList("module_names"), bundle.getStringArrayList("languages"), (PendingIntent) bundle.getParcelable("user_confirmation_intent"), bundle.getParcelableArrayList("split_file_intents"));
    }

    /* access modifiers changed from: 0000 */
    public abstract List<String> a();

    /* access modifiers changed from: 0000 */
    public abstract List<String> b();

    public abstract long bytesDownloaded();

    /* access modifiers changed from: 0000 */
    public abstract List<Intent> c();

    public abstract int errorCode();

    public List<String> languages() {
        return b() != null ? new ArrayList(b()) : new ArrayList();
    }

    public List<String> moduleNames() {
        return a() != null ? new ArrayList(a()) : new ArrayList();
    }

    public abstract PendingIntent resolutionIntent();

    public abstract int sessionId();

    public abstract int status();

    public abstract long totalBytesToDownload();
}
