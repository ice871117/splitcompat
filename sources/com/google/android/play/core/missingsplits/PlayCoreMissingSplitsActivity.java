package com.google.android.play.core.missingsplits;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.play.core.internal.class_133;

public class PlayCoreMissingSplitsActivity extends Activity implements OnClickListener {

   // $FF: renamed from: <init> () void
   public void method_316() {
      super();
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      Builder var3 = (new Builder(this)).setTitle("Installation failed").setCancelable(false).setNeutralButton("Close", this);
      String var4;
      if(class_133.method_449(this)) {
         var4 = this.method_317();
         var3.setMessage((new StringBuilder(91 + String.valueOf(var4).length())).append("The app ").append(var4).append(" is missing required components and must be reinstalled from the Google Play Store.").toString()).setPositiveButton("Reinstall", this);
      } else {
         var4 = this.method_317();
         var3.setMessage((new StringBuilder(87 + String.valueOf(var4).length())).append("The app ").append(var4).append(" is missing required components and must be reinstalled from an official store.").toString());
      }

      var3.create().show();
   }

   public void onClick(DialogInterface var1, int var2) {
      switch(var2) {
      case -1:
         String var4 = this.getPackageName();
         String var5 = (new StringBuilder(66 + String.valueOf(var4).length())).append("market://details?id=").append(var4).append("&referrer=utm_source%3Dplay.core.missingsplits").toString();
         Intent var6 = (new Intent("android.intent.action.VIEW")).setData(Uri.parse(var5)).setPackage("com.android.vending");
         this.startActivity(var6);
      default:
         this.finish();
      }
   }

   // $FF: renamed from: a () java.lang.String
   private final String method_317() {
      return this.getApplicationInfo().loadLabel(this.getPackageManager()).toString();
   }
}
