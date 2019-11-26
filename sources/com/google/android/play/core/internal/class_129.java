package com.google.android.play.core.internal;

import com.google.android.play.core.internal.class_128;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

// $FF: renamed from: com.google.android.play.core.internal.ba
public class class_129 {

   // $FF: renamed from: a java.lang.Object
   private final Object field_214;
   // $FF: renamed from: b java.lang.reflect.Field
   private final Field field_215;
   // $FF: renamed from: c java.lang.Class
   private final Class field_216;


   // $FF: renamed from: <init> (java.lang.Object, java.lang.reflect.Field, java.lang.Class) void
   void method_424(Object var1, Field var2, Class var3) {
      super();
      this.field_214 = var1;
      this.field_215 = var2;
      this.field_216 = var3;
   }

   // $FF: renamed from: a () java.lang.Object
   public final Object method_425() {
      try {
         return this.field_216.cast(this.field_215.get(this.field_214));
      } catch (Exception var2) {
         class_128 var10000 = new class_128;
         var10000.method_423(String.format("Failed to get value of field %s of type %s on object of type %s", new Object[]{this.field_215.getName(), this.field_214.getClass().getName(), this.field_216.getName()}), var2);
         throw var10000;
      }
   }

   // $FF: renamed from: a (java.lang.Object) void
   public final void method_426(Object var1) {
      try {
         this.field_215.set(this.field_214, var1);
      } catch (Exception var3) {
         class_128 var10000 = new class_128;
         var10000.method_423(String.format("Failed to set value of field %s of type %s on object of type %s", new Object[]{this.field_215.getName(), this.field_214.getClass().getName(), this.field_216.getName()}), var3);
         throw var10000;
      }
   }

   // $FF: renamed from: <init> (java.lang.Object, java.lang.reflect.Field, java.lang.Class, byte) void
   void method_427(Object var1, Field var2, Class var3, byte var4) {
      this.method_424(var1, var2, method_432(var3));
   }

   // $FF: renamed from: a (java.lang.Object[]) void
   public void method_428(Object[] var1) {
      this.method_429(Arrays.asList(var1));
   }

   // $FF: renamed from: a (java.util.Collection) void
   public void method_429(Collection var1) {
      Object[] var2;
      int var3 = (var2 = (Object[])this.method_425()) == null?0:var2.length;
      Object[] var4 = (Object[])Array.newInstance(this.method_433(), var3 + var1.size());
      if(var2 != null) {
         System.arraycopy(var2, 0, var4, 0, var2.length);
      }

      int var5 = var3;

      for(Iterator var6 = var1.iterator(); var6.hasNext(); ++var5) {
         Object var7 = var6.next();
         var4[var5] = var7;
      }

      this.method_426(var4);
   }

   // $FF: renamed from: b (java.lang.Object[]) void
   public void method_430(Object[] var1) {
      this.method_431(Arrays.asList(var1));
   }

   // $FF: renamed from: b (java.util.Collection) void
   public void method_431(Collection var1) {
      Object[] var2;
      int var3 = (var2 = (Object[])this.method_425()) == null?0:var2.length;
      Object[] var4 = (Object[])Array.newInstance(this.method_433(), var3 + var1.size());
      if(var2 != null) {
         System.arraycopy(var2, 0, var4, var1.size(), var2.length);
      }

      int var5 = 0;

      for(Iterator var6 = var1.iterator(); var6.hasNext(); ++var5) {
         Object var7 = var6.next();
         var4[var5] = var7;
      }

      this.method_426(var4);
   }

   // $FF: renamed from: a (java.lang.Class) java.lang.Class
   private static Class method_432(Class var0) {
      return Array.newInstance(var0, 0).getClass();
   }

   // $FF: renamed from: b () java.lang.Class
   private Class method_433() {
      return this.field_215.getType().getComponentType();
   }
}
