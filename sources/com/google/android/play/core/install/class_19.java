package com.google.android.play.core.install;

import com.google.android.play.core.install.InstallState;

// $FF: renamed from: com.google.android.play.core.install.a
final class class_19 extends InstallState {

   // $FF: renamed from: a int
   private final int field_2;
   // $FF: renamed from: b int
   private final int field_3;
   // $FF: renamed from: c java.lang.String
   private final String field_4;


   // $FF: renamed from: <init> (int, int, java.lang.String) void
   void method_45(int var1, int var2, String var3) {
      super.method_43();
      this.field_2 = var1;
      this.field_3 = var2;
      if(var3 == null) {
         throw new NullPointerException("Null packageName");
      } else {
         this.field_4 = var3;
      }
   }

   public final int installStatus() {
      return this.field_2;
   }

   public final int installErrorCode() {
      return this.field_3;
   }

   public final String packageName() {
      return this.field_4;
   }

   public final String toString() {
      int var1 = this.field_2;
      int var2 = this.field_3;
      String var3 = this.field_4;
      return (new StringBuilder(83 + String.valueOf(var3).length())).append("InstallState{installStatus=").append(var1).append(", installErrorCode=").append(var2).append(", packageName=").append(var3).append("}").toString();
   }

   public final boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(var1 instanceof InstallState) {
         InstallState var2 = (InstallState)var1;
         return this.field_2 == var2.installStatus() && this.field_3 == var2.installErrorCode() && this.field_4.equals(var2.packageName());
      } else {
         return false;
      }
   }

   public final int hashCode() {
      int var1;
      return ((var1 = 1000003 ^ this.field_2) * 1000003 ^ this.field_3) * 1000003 ^ this.field_4.hashCode();
   }
}
