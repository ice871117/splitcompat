package com.google.android.play.core.splitinstall.model;

import java.util.HashMap;
import java.util.Map;

// $FF: renamed from: com.google.android.play.core.splitinstall.model.a
public final class class_130 {

   // $FF: renamed from: a java.util.Map
   private static final Map field_217;
   // $FF: renamed from: b java.util.Map
   private static final Map field_218;


   // $FF: renamed from: a (int) java.lang.String
   public static String method_434(int var0) {
      if(field_217.containsKey(Integer.valueOf(var0)) && field_218.containsKey(Integer.valueOf(var0))) {
         String var1 = (String)field_217.get(Integer.valueOf(var0));
         String var2 = (String)field_218.get(Integer.valueOf(var0));
         return (new StringBuilder(118 + String.valueOf(var1).length() + String.valueOf(var2).length())).append(var1).append(" (https://developer.android.com/reference/com/google/android/play/core/splitinstall/model/SplitInstallErrorCode.html").append("#").append(var2).append(")").toString();
      } else {
         return "";
      }
   }

   // $FF: renamed from: <clinit> () void
   static void method_435() {
      field_217 = new HashMap();
      field_218 = new HashMap();
      field_217.put(Integer.valueOf(-1), "Too many sessions are running for current app, existing sessions must be resolved first.");
      field_217.put(Integer.valueOf(-2), "A requested module is not available (to this user/device, for the installed apk).");
      field_217.put(Integer.valueOf(-3), "Request is otherwise invalid.");
      field_217.put(Integer.valueOf(-4), "Requested session is not found.");
      field_217.put(Integer.valueOf(-5), "Split Install API is not available.");
      field_217.put(Integer.valueOf(-6), "Network error: unable to obtain split details.");
      field_217.put(Integer.valueOf(-7), "Download not permitted under current device circumstances (e.g. in background).");
      field_217.put(Integer.valueOf(-8), "Requested session contains modules from an existing active session and also new");
      field_217.put(Integer.valueOf(-9), "Service handling split install has died.");
      field_217.put(Integer.valueOf(-10), "Install failed due to insufficient storage.");
      field_217.put(Integer.valueOf(-11), "Signature verification error when invoking SplitCompat.");
      field_217.put(Integer.valueOf(-12), "Error in SplitCompat emulation.");
      field_217.put(Integer.valueOf(-13), "Error in copying files for SplitCompat.");
      field_217.put(Integer.valueOf(-100), "Unknown error processing split install.");
      field_218.put(Integer.valueOf(-1), "ACTIVE_SESSIONS_LIMIT_EXCEEDED");
      field_218.put(Integer.valueOf(-2), "MODULE_UNAVAILABLE");
      field_218.put(Integer.valueOf(-3), "INVALID_REQUEST");
      field_218.put(Integer.valueOf(-4), "SESSION_NOT_FOUND");
      field_218.put(Integer.valueOf(-5), "API_NOT_AVAILABLE");
      field_218.put(Integer.valueOf(-6), "NETWORK_ERROR");
      field_218.put(Integer.valueOf(-7), "ACCESS_DENIED");
      field_218.put(Integer.valueOf(-8), "INCOMPATIBLE_WITH_EXISTING_SESSION");
      field_218.put(Integer.valueOf(-9), "SERVICE_DIED");
      field_218.put(Integer.valueOf(-10), "INSUFFICIENT_STORAGE");
      field_218.put(Integer.valueOf(-11), "SPLITCOMPAT_VERIFICATION_ERROR");
      field_218.put(Integer.valueOf(-12), "SPLITCOMPAT_EMULATION_ERROR");
      field_218.put(Integer.valueOf(-13), "SPLITCOMPAT_COPY_ERROR");
   }
}
