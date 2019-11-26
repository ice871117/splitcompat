package com.google.android.play.core.install.model;

import java.util.HashMap;
import java.util.Map;

// $FF: renamed from: com.google.android.play.core.install.model.a
public final class class_143 {

   // $FF: renamed from: a java.util.Map
   private static final Map field_244;
   // $FF: renamed from: b java.util.Map
   private static final Map field_245;


   // $FF: renamed from: a (int) java.lang.String
   public static String method_480(int var0) {
      if(field_244.containsKey(Integer.valueOf(var0)) && field_245.containsKey(Integer.valueOf(var0))) {
         String var1 = (String)field_244.get(Integer.valueOf(var0));
         String var2 = (String)field_245.get(Integer.valueOf(var0));
         return (new StringBuilder(103 + String.valueOf(var1).length() + String.valueOf(var2).length())).append(var1).append(" (https://developer.android.com/reference/com/google/android/play/core/install/model/InstallErrorCode").append("#").append(var2).append(")").toString();
      } else {
         return "";
      }
   }

   // $FF: renamed from: <clinit> () void
   static void method_481() {
      field_244 = new HashMap();
      field_245 = new HashMap();
      field_244.put(Integer.valueOf(1), "No error occurred; only some types of update flow are allowed, while others are forbidden.");
      field_244.put(Integer.valueOf(-2), "An unknown error occurred.");
      field_244.put(Integer.valueOf(-3), "The API is not available on this device.");
      field_244.put(Integer.valueOf(-4), "The request that was sent by the app is malformed.");
      field_244.put(Integer.valueOf(-5), "The install is unavailable to this user or device.");
      field_244.put(Integer.valueOf(-6), "The download/install is not allowed, due to the current device state (e.g. low battery, low disk space, ...).");
      field_244.put(Integer.valueOf(-7), "The install/update has not been (fully) downloaded yet.");
      field_244.put(Integer.valueOf(-8), "The install is already in progress and there is no UI flow to resume.");
      field_244.put(Integer.valueOf(-100), "An internal error happened in the Play Store.");
      field_245.put(Integer.valueOf(1), "NO_ERROR_PARTIALLY_ALLOWED");
      field_245.put(Integer.valueOf(-2), "ERROR_UNKNOWN");
      field_245.put(Integer.valueOf(-3), "ERROR_API_NOT_AVAILABLE");
      field_245.put(Integer.valueOf(-4), "ERROR_INVALID_REQUEST");
      field_245.put(Integer.valueOf(-5), "ERROR_INSTALL_UNAVAILABLE");
      field_245.put(Integer.valueOf(-6), "ERROR_INSTALL_NOT_ALLOWED");
      field_245.put(Integer.valueOf(-7), "ERROR_DOWNLOAD_NOT_PRESENT");
      field_245.put(Integer.valueOf(-8), "ERROR_INSTALL_IN_PROGRESS");
      field_245.put(Integer.valueOf(-100), "ERROR_INTERNAL_ERROR");
   }
}
