package com.google.android.play.core.missingsplits;

import android.app.Application;
import com.google.android.play.core.missingsplits.MissingSplitsManagerFactory;

public class MissingSplitsDetectingApplication extends Application {

   private boolean onCreateCalled;


   // $FF: renamed from: <init> () void
   public void method_477() {
      super();
      this.onCreateCalled = false;
   }

   public final void onCreate() {
      if(this.onCreateCalled) {
         throw new IllegalStateException("The onCreate method must be invoked at most once.");
      } else {
         this.onCreateCalled = true;
         if(!MissingSplitsManagerFactory.create(this).disableAppIfMissingRequiredSplits()) {
            super.onCreate();
            this.onCreateCustom();
         }
      }
   }

   public void onCreateCustom() {}
}
