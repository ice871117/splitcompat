package com.google.android.play.core.splitinstall;

import android.app.PendingIntent;
import com.google.android.play.core.splitinstall.SplitInstallSessionState;
import java.util.List;

// $FF: renamed from: com.google.android.play.core.splitinstall.a
final class class_61 extends SplitInstallSessionState {

   // $FF: renamed from: a int
   private final int field_72;
   // $FF: renamed from: b int
   private final int field_73;
   // $FF: renamed from: c int
   private final int field_74;
   // $FF: renamed from: d long
   private final long field_75;
   // $FF: renamed from: e long
   private final long field_76;
   // $FF: renamed from: f java.util.List
   private final List field_77;
   // $FF: renamed from: g java.util.List
   private final List field_78;
   // $FF: renamed from: h android.app.PendingIntent
   private final PendingIntent field_79;
   // $FF: renamed from: i java.util.List
   private final List field_80;


   // $FF: renamed from: <init> (int, int, int, long, long, java.util.List, java.util.List, android.app.PendingIntent, java.util.List) void
   void method_131(int var1, int var2, int var3, long var4, long var6, List var8, List var9, PendingIntent var10, List var11) {
      super.method_126();
      this.field_72 = var1;
      this.field_73 = var2;
      this.field_74 = var3;
      this.field_75 = var4;
      this.field_76 = var6;
      this.field_77 = var8;
      this.field_78 = var9;
      this.field_79 = var10;
      this.field_80 = var11;
   }

   public final int sessionId() {
      return this.field_72;
   }

   public final int status() {
      return this.field_73;
   }

   public final int errorCode() {
      return this.field_74;
   }

   public final long bytesDownloaded() {
      return this.field_75;
   }

   public final long totalBytesToDownload() {
      return this.field_76;
   }

   // $FF: renamed from: a () java.util.List
   final List method_128() {
      return this.field_77;
   }

   // $FF: renamed from: b () java.util.List
   final List method_129() {
      return this.field_78;
   }

   public final PendingIntent resolutionIntent() {
      return this.field_79;
   }

   // $FF: renamed from: c () java.util.List
   final List method_130() {
      return this.field_80;
   }

   public final String toString() {
      int var1 = this.field_72;
      int var2 = this.field_73;
      int var3 = this.field_74;
      long var4 = this.field_75;
      long var6 = this.field_76;
      String var8 = String.valueOf(this.field_77);
      String var9 = String.valueOf(this.field_78);
      String var10 = String.valueOf(this.field_79);
      String var11 = String.valueOf(this.field_80);
      return (new StringBuilder(251 + String.valueOf(var8).length() + String.valueOf(var9).length() + String.valueOf(var10).length() + String.valueOf(var11).length())).append("SplitInstallSessionState{sessionId=").append(var1).append(", status=").append(var2).append(", errorCode=").append(var3).append(", bytesDownloaded=").append(var4).append(", totalBytesToDownload=").append(var6).append(", moduleNamesNullable=").append(var8).append(", languagesNullable=").append(var9).append(", resolutionIntent=").append(var10).append(", splitFileIntents=").append(var11).append("}").toString();
   }

   public final boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof SplitInstallSessionState)) {
         return false;
      } else {
         SplitInstallSessionState var2 = (SplitInstallSessionState)var1;
         if(this.field_72 == var2.sessionId() && this.field_73 == var2.status() && this.field_74 == var2.errorCode() && this.field_75 == var2.bytesDownloaded() && this.field_76 == var2.totalBytesToDownload()) {
            if(this.field_77 == null) {
               if(var2.method_128() != null) {
                  return false;
               }
            } else if(!this.field_77.equals(var2.method_128())) {
               return false;
            }

            if(this.field_78 == null) {
               if(var2.method_129() != null) {
                  return false;
               }
            } else if(!this.field_78.equals(var2.method_129())) {
               return false;
            }

            if(this.field_79 == null) {
               if(var2.resolutionIntent() != null) {
                  return false;
               }
            } else if(!this.field_79.equals(var2.resolutionIntent())) {
               return false;
            }

            if(this.field_80 == null) {
               if(var2.method_130() != null) {
                  return false;
               }
            } else if(!this.field_80.equals(var2.method_130())) {
               return false;
            }

            return true;
         } else {
            return false;
         }
      }
   }

   public final int hashCode() {
      int var1;
      return ((((((((var1 = 1000003 ^ this.field_72) * 1000003 ^ this.field_73) * 1000003 ^ this.field_74) * 1000003 ^ (int)(this.field_75 >>> 32 ^ this.field_75)) * 1000003 ^ (int)(this.field_76 >>> 32 ^ this.field_76)) * 1000003 ^ (this.field_77 == null?0:this.field_77.hashCode())) * 1000003 ^ (this.field_78 == null?0:this.field_78.hashCode())) * 1000003 ^ (this.field_79 == null?0:this.field_79.hashCode())) * 1000003 ^ (this.field_80 == null?0:this.field_80.hashCode());
   }
}
