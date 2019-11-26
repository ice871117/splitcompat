package com.google.android.play.core.splitinstall;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

// $FF: renamed from: com.google.android.play.core.splitinstall.d
public final class class_59 {

   // $FF: renamed from: a java.util.Map
   private final Map field_67;


   // $FF: renamed from: <init> (java.util.Map) void
   private void method_119(Map var1) {
      super();
      this.field_67 = var1;
   }

   // $FF: renamed from: a (java.util.Collection) java.util.Map
   final Map method_120(Collection var1) {
      HashMap var2 = new HashMap();

      Set var10002;
      String var4;
      for(Iterator var3 = this.field_67.keySet().iterator(); var3.hasNext(); var2.put(var4, var10002)) {
         var4 = (String)var3.next();
         Collection var7 = var1;
         if(!this.field_67.containsKey(var4)) {
            var10002 = Collections.emptySet();
         } else {
            HashSet var8 = new HashSet();
            Iterator var9 = ((Map)this.field_67.get(var4)).entrySet().iterator();

            while(var9.hasNext()) {
               Entry var10 = (Entry)var9.next();
               if(var7.contains(var10.getKey())) {
                  var8.add((String)var10.getValue());
               }
            }

            var10002 = Collections.unmodifiableSet(var8);
         }
      }

      return var2;
   }

   // $FF: renamed from: <init> (java.util.Map, byte) void
   // $FF: synthetic method
   void method_121(Map var1, byte var2) {
      this.method_119(var1);
   }
}
