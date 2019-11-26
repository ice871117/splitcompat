package com.google.android.play.core.appupdate;

import android.app.PendingIntent;
import com.google.android.play.core.appupdate.AppUpdateInfo;

// $FF: renamed from: com.google.android.play.core.appupdate.i
final class class_72 extends AppUpdateInfo {

   // $FF: renamed from: a java.lang.String
   private final String field_125;
   // $FF: renamed from: b int
   private final int field_126;
   // $FF: renamed from: c int
   private final int field_127;
   // $FF: renamed from: d int
   private final int field_128;
   // $FF: renamed from: e android.app.PendingIntent
   private final PendingIntent field_129;
   // $FF: renamed from: f android.app.PendingIntent
   private final PendingIntent field_130;


   // $FF: renamed from: <init> (java.lang.String, int, int, int, android.app.PendingIntent, android.app.PendingIntent) void
   void method_193(String var1, int var2, int var3, int var4, PendingIntent var5, PendingIntent var6) {
      super.method_189();
      if(var1 == null) {
         throw new NullPointerException("Null packageName");
      } else {
         this.field_125 = var1;
         this.field_126 = var2;
         this.field_127 = var3;
         this.field_128 = var4;
         this.field_129 = var5;
         this.field_130 = var6;
      }
   }

   public final String packageName() {
      return this.field_125;
   }

   public final int availableVersionCode() {
      return this.field_126;
   }

   public final int updateAvailability() {
      return this.field_127;
   }

   public final int installStatus() {
      return this.field_128;
   }

   // $FF: renamed from: a () android.app.PendingIntent
   final PendingIntent method_191() {
      return this.field_129;
   }

   // $FF: renamed from: b () android.app.PendingIntent
   final PendingIntent method_192() {
      return this.field_130;
   }

   public final String toString() {
      String var1 = this.field_125;
      int var2 = this.field_126;
      int var3 = this.field_127;
      int var4 = this.field_128;
      String var5 = String.valueOf(this.field_129);
      String var6 = String.valueOf(this.field_130);
      return (new StringBuilder(167 + String.valueOf(var1).length() + String.valueOf(var5).length() + String.valueOf(var6).length())).append("AppUpdateInfo{packageName=").append(var1).append(", availableVersionCode=").append(var2).append(", updateAvailability=").append(var3).append(", installStatus=").append(var4).append(", immediateUpdateIntent=").append(var5).append(", flexibleUpdateIntent=").append(var6).append("}").toString();
   }

   public final boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof AppUpdateInfo)) {
         return false;
      } else {
         AppUpdateInfo var2 = (AppUpdateInfo)var1;
         if(this.field_125.equals(var2.packageName()) && this.field_126 == var2.availableVersionCode() && this.field_127 == var2.updateAvailability() && this.field_128 == var2.installStatus()) {
            if(this.field_129 == null) {
               if(var2.method_191() != null) {
                  return false;
               }
            } else if(!this.field_129.equals(var2.method_191())) {
               return false;
            }

            if(this.field_130 == null) {
               if(var2.method_192() != null) {
                  return false;
               }
            } else if(!this.field_130.equals(var2.method_192())) {
               return false;
            }

            return true;
         } else {
            return false;
         }
      }
   }

   public final int hashCode() {
      return (((((1000003 ^ this.field_125.hashCode()) * 1000003 ^ this.field_126) * 1000003 ^ this.field_127) * 1000003 ^ this.field_128) * 1000003 ^ (this.field_129 == null?0:this.field_129.hashCode())) * 1000003 ^ (this.field_130 == null?0:this.field_130.hashCode());
   }
}
