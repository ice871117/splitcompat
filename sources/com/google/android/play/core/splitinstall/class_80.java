package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// $FF: renamed from: com.google.android.play.core.splitinstall.ai
final class class_80 {

   // $FF: renamed from: a android.content.Context
   private final Context field_141;


   // $FF: renamed from: <init> (android.content.Context) void
   void method_205(Context var1) {
      super();
      this.field_141 = var1;
   }

   // $FF: renamed from: a () java.util.Set
   final synchronized Set method_206() {
      try {
         Set var1;
         return (Set)((var1 = this.method_208().getStringSet("deferred_uninstall_module_list", new HashSet())) == null?new HashSet():var1);
      } catch (Exception var2) {
         return new HashSet();
      }
   }

   // $FF: renamed from: a (java.util.Collection) void
   final synchronized void method_207(Collection var1) {
      Set var2 = this.method_206();
      boolean var3 = false;
      Iterator var4 = var1.iterator();

      while(var4.hasNext()) {
         String var5 = (String)var4.next();
         if(var2.add(var5)) {
            var3 = true;
         }
      }

      if(var3) {
         try {
            this.method_208().edit().putStringSet("deferred_uninstall_module_list", var2).apply();
            return;
         } catch (Exception var6) {
            ;
         }
      }

   }

   // $FF: renamed from: b () android.content.SharedPreferences
   private final SharedPreferences method_208() {
      return this.field_141.getSharedPreferences("playcore_split_install_internal", 0);
   }
}
