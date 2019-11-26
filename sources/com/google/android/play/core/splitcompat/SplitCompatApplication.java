package com.google.android.play.core.splitcompat;

import android.app.Application;
import android.content.Context;
import com.google.android.play.core.splitcompat.SplitCompat;

public class SplitCompatApplication extends Application {

   // $FF: renamed from: <init> () void
   public void method_284() {
      super();
   }

   protected void attachBaseContext(Context var1) {
      super.attachBaseContext(var1);
      SplitCompat.install(this);
   }
}
