package com.google.android.play.core.common;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.os.ResultReceiver;

public class PlayCoreDialogWrapperActivity extends Activity {

   // $FF: renamed from: a android.os.ResultReceiver
   private ResultReceiver field_181;


   // $FF: renamed from: <init> () void
   public void method_289() {
      super();
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      if(var1 == null) {
         this.field_181 = (ResultReceiver)this.getIntent().getParcelableExtra("result_receiver");
         PendingIntent var2 = (PendingIntent)this.getIntent().getExtras().get("confirmation_intent");

         try {
            this.startIntentSenderForResult(var2.getIntentSender(), 0, (Intent)null, 0, 0, 0);
         } catch (SendIntentException var3) {
            if(this.field_181 != null) {
               this.field_181.send(3, new Bundle());
            }

            this.finish();
            return;
         }
      } else {
         this.field_181 = (ResultReceiver)var1.getParcelable("result_receiver");
      }

   }

   protected void onSaveInstanceState(Bundle var1) {
      var1.putParcelable("result_receiver", this.field_181);
   }

   protected void onActivityResult(int var1, int var2, Intent var3) {
      super.onActivityResult(var1, var2, var3);
      if(var1 == 0 && this.field_181 != null) {
         if(var2 == -1) {
            this.field_181.send(1, new Bundle());
         } else if(var2 == 0) {
            this.field_181.send(2, new Bundle());
         }
      }

      this.finish();
   }
}
