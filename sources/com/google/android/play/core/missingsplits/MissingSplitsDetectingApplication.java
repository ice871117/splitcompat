package com.google.android.play.core.missingsplits;

import android.app.Application;

public class MissingSplitsDetectingApplication extends Application {
    private boolean onCreateCalled = false;

    public final void onCreate() {
        if (this.onCreateCalled) {
            throw new IllegalStateException("The onCreate method must be invoked at most once.");
        }
        this.onCreateCalled = true;
        if (!MissingSplitsManagerFactory.create(this).disableAppIfMissingRequiredSplits()) {
            super.onCreate();
            onCreateCustom();
        }
    }

    public void onCreateCustom() {
    }
}
