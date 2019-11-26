package com.google.android.play.core.splitinstall;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SplitInstallRequest {

   // $FF: renamed from: a java.util.List
   private final List field_212;
   // $FF: renamed from: b java.util.List
   private final List field_213;


   public static SplitInstallRequest.Builder newBuilder() {
      SplitInstallRequest.Builder var10000 = new SplitInstallRequest.Builder;
      var10000.method_457((byte)0);
      return var10000;
   }

   // $FF: renamed from: <init> (com.google.android.play.core.splitinstall.SplitInstallRequest$Builder) void
   private void method_416(SplitInstallRequest.Builder var1) {
      super();
      this.field_212 = new ArrayList(var1.field_233);
      this.field_213 = new ArrayList(var1.field_234);
   }

   public List getModuleNames() {
      return this.field_212;
   }

   public List getLanguages() {
      return this.field_213;
   }

   public String toString() {
      return String.format("SplitInstallRequest{modulesNames=%s,languages=%s}", new Object[]{this.field_212, this.field_213});
   }

   // $FF: renamed from: <init> (com.google.android.play.core.splitinstall.SplitInstallRequest$Builder, byte) void
   // $FF: synthetic method
   void method_417(SplitInstallRequest.Builder var1, byte var2) {
      this.method_416(var1);
   }

   public static class Builder {

      // $FF: renamed from: a java.util.List
      private final List field_233;
      // $FF: renamed from: b java.util.List
      private final List field_234;


      // $FF: renamed from: <init> () void
      private void method_456() {
         super();
         this.field_233 = new ArrayList();
         this.field_234 = new ArrayList();
      }

      public SplitInstallRequest.Builder addModule(String var1) {
         this.field_233.add(var1);
         return this;
      }

      public SplitInstallRequest.Builder addLanguage(Locale var1) {
         this.field_234.add(var1);
         return this;
      }

      public SplitInstallRequest build() {
         SplitInstallRequest var10000 = new SplitInstallRequest;
         var10000.method_417(this, (byte)0);
         return var10000;
      }

      // $FF: renamed from: <init> (byte) void
      // $FF: synthetic method
      void method_457(byte var1) {
         this.method_456();
      }
   }
}
