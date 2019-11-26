package com.google.android.play.core.splitinstall;

import com.google.android.play.core.splitinstall.class_59;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

// $FF: renamed from: com.google.android.play.core.splitinstall.g
public final class class_57 {

   // $FF: renamed from: a java.util.Map
   private final Map field_64;


   // $FF: renamed from: <init> () void
   public void method_113() {
      super();
      this.field_64 = new HashMap();
   }

   // $FF: renamed from: a (java.lang.String, java.lang.String, java.lang.String) com.google.android.play.core.splitinstall.g
   public final class_57 method_114(String var1, String var2, String var3) {
      if(!this.field_64.containsKey(var2)) {
         this.field_64.put(var2, new HashMap());
      }

      ((Map)this.field_64.get(var2)).put(var1, var3);
      return this;
   }

   // $FF: renamed from: a () com.google.android.play.core.splitinstall.d
   public final class_59 method_115() {
      HashMap var1 = new HashMap();
      Iterator var2 = this.field_64.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.put((String)var3.getKey(), Collections.unmodifiableMap(new HashMap((Map)var3.getValue())));
      }

      class_59 var10000 = new class_59;
      var10000.method_121(Collections.unmodifiableMap(var1), (byte)0);
      return var10000;
   }
}
