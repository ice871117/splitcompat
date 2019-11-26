package com.google.android.play.core.appupdate;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.play.core.install.InstallState;
import com.google.android.play.core.internal.class_145;
import com.google.android.play.core.listener.class_20;
import java.util.Iterator;

// $FF: renamed from: com.google.android.play.core.appupdate.a
public final class class_21 extends class_20 {

   // $FF: renamed from: <init> (android.content.Context) void
   public void method_53(Context var1) {
      class_145 var10001 = new class_145;
      var10001.method_489("AppUpdateListenerRegistry");
      super.method_46(var10001, new IntentFilter("com.google.android.play.core.install.ACTION_INSTALL_STATUS"), var1);
   }

   // $FF: renamed from: a (android.content.Context, android.content.Intent) void
   protected final void method_50(Context var1, Intent var2) {
      String var6 = var1.getPackageName();
      if(!var6.equals(var2.getStringExtra("package.name"))) {
         this.field_5.method_491("ListenerRegistryBroadcastReceiver received broadcast for third party app: %s", new Object[]{var2.getStringExtra("package.name")});
      } else {
         this.field_5.method_491("List of extras in received intent:", new Object[0]);
         Iterator var3 = var2.getExtras().keySet().iterator();

         while(var3.hasNext()) {
            String var4 = (String)var3.next();
            this.field_5.method_491("Key: %s; value: %s", new Object[]{var4, var2.getExtras().get(var4)});
         }

         class_145 var8 = this.field_5;
         var8.method_491("List of extras in received intent needed by fromUpdateIntent:", new Object[0]);
         var8.method_491("Key: %s; value: %s", new Object[]{"install.status", Integer.valueOf(var2.getIntExtra("install.status", 0))});
         var8.method_491("Key: %s; value: %s", new Object[]{"error.code", Integer.valueOf(var2.getIntExtra("error.code", 0))});
         InstallState var7 = InstallState.method_44(var2.getIntExtra("install.status", 0), var2.getIntExtra("error.code", 0), var2.getStringExtra("package.name"));
         this.field_5.method_491("ListenerRegistryBroadcastReceiver.onReceive: %s", new Object[]{var7});
         this.method_51(var7);
      }
   }
}
