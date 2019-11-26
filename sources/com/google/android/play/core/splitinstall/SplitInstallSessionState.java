package com.google.android.play.core.splitinstall;

import android.app.PendingIntent;
import android.os.Bundle;
import com.google.android.play.core.splitinstall.class_61;
import java.util.ArrayList;
import java.util.List;

public abstract class SplitInstallSessionState {

   // $FF: renamed from: <init> () void
   public void method_126() {
      super();
   }

   // $FF: renamed from: a (android.os.Bundle) com.google.android.play.core.splitinstall.SplitInstallSessionState
   public static SplitInstallSessionState method_127(Bundle var0) {
      class_61 var10000 = new class_61;
      var10000.method_131(var0.getInt("session_id"), var0.getInt("status"), var0.getInt("error_code"), var0.getLong("bytes_downloaded"), var0.getLong("total_bytes_to_download"), var0.getStringArrayList("module_names"), var0.getStringArrayList("languages"), (PendingIntent)var0.getParcelable("user_confirmation_intent"), var0.getParcelableArrayList("split_file_intents"));
      return var10000;
   }

   public abstract int sessionId();

   public abstract int status();

   public abstract int errorCode();

   public abstract long bytesDownloaded();

   public abstract long totalBytesToDownload();

   // $FF: renamed from: a () java.util.List
   abstract List method_128();

   // $FF: renamed from: b () java.util.List
   abstract List method_129();

   public List moduleNames() {
      return this.method_128() != null?new ArrayList(this.method_128()):new ArrayList();
   }

   public List languages() {
      return this.method_129() != null?new ArrayList(this.method_129()):new ArrayList();
   }

   public abstract PendingIntent resolutionIntent();

   // $FF: renamed from: c () java.util.List
   abstract List method_130();
}
