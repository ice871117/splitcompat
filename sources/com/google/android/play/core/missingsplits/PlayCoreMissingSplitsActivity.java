package com.google.android.play.core.missingsplits;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.play.core.internal.bi;
import com.google.android.play.core.splitinstall.model.SplitInstallErrorCode;

public class PlayCoreMissingSplitsActivity extends Activity implements OnClickListener {
    private final String a() {
        return getApplicationInfo().loadLabel(getPackageManager()).toString();
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case SplitInstallErrorCode.ACTIVE_SESSIONS_LIMIT_EXCEEDED /*-1*/:
                String packageName = getPackageName();
                startActivity(new Intent("android.intent.action.VIEW").setData(Uri.parse(new StringBuilder(String.valueOf(packageName).length() + 66).append("market://details?id=").append(packageName).append("&referrer=utm_source%3Dplay.core.missingsplits").toString())).setPackage("com.android.vending"));
                break;
        }
        finish();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Builder neutralButton = new Builder(this).setTitle("Installation failed").setCancelable(false).setNeutralButton("Close", this);
        if (bi.a(this)) {
            String a = a();
            neutralButton.setMessage(new StringBuilder(String.valueOf(a).length() + 91).append("The app ").append(a).append(" is missing required components and must be reinstalled from the Google Play Store.").toString()).setPositiveButton("Reinstall", this);
        } else {
            String a2 = a();
            neutralButton.setMessage(new StringBuilder(String.valueOf(a2).length() + 87).append("The app ").append(a2).append(" is missing required components and must be reinstalled from an official store.").toString());
        }
        neutralButton.create().show();
    }
}
