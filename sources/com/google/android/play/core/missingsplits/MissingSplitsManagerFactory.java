package com.google.android.play.core.missingsplits;

import android.content.Context;
import com.google.android.play.core.missingsplits.MissingSplitsManager;
import com.google.android.play.core.missingsplits.class_103;
import com.google.android.play.core.missingsplits.class_99;
import java.util.concurrent.atomic.AtomicReference;

public class MissingSplitsManagerFactory {

   // $FF: renamed from: a java.util.concurrent.atomic.AtomicReference
   private static final AtomicReference field_103;


   // $FF: renamed from: <init> () void
   public void method_165() {
      super();
   }

   public static MissingSplitsManager create(Context var0) {
      class_103 var10000 = new class_103;
      Runtime var10003 = Runtime.getRuntime();
      class_99 var10004 = new class_99;
      var10004.method_294(var0, var0.getPackageManager());
      var10000.method_303(var0, var10003, var10004, field_103);
      return var10000;
   }

   // $FF: renamed from: <clinit> () void
   static void method_166() {
      field_103 = new AtomicReference((Object)null);
   }
}
