package com.google.android.play.core.splitcompat;

import com.google.android.play.core.splitcompat.class_74;
import java.io.File;

// $FF: renamed from: com.google.android.play.core.splitcompat.a
final class class_75 extends class_74 {

   // $FF: renamed from: a java.io.File
   private final File field_132;
   // $FF: renamed from: b java.lang.String
   private final String field_133;


   // $FF: renamed from: <init> (java.io.File, java.lang.String) void
   void method_198(File var1, String var2) {
      super.method_195();
      if(var1 == null) {
         throw new NullPointerException("Null splitFile");
      } else {
         this.field_132 = var1;
         if(var2 == null) {
            throw new NullPointerException("Null splitId");
         } else {
            this.field_133 = var2;
         }
      }
   }

   // $FF: renamed from: a () java.io.File
   final File method_196() {
      return this.field_132;
   }

   // $FF: renamed from: b () java.lang.String
   final String method_197() {
      return this.field_133;
   }

   public final String toString() {
      String var1 = String.valueOf(this.field_132);
      String var2 = this.field_133;
      return (new StringBuilder(35 + String.valueOf(var1).length() + String.valueOf(var2).length())).append("SplitFileInfo{splitFile=").append(var1).append(", splitId=").append(var2).append("}").toString();
   }

   public final boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(var1 instanceof class_74) {
         class_74 var2 = (class_74)var1;
         return this.field_132.equals(var2.method_196()) && this.field_133.equals(var2.method_197());
      } else {
         return false;
      }
   }

   public final int hashCode() {
      return (1000003 ^ this.field_132.hashCode()) * 1000003 ^ this.field_133.hashCode();
   }
}
