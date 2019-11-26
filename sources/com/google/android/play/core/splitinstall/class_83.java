package com.google.android.play.core.splitinstall;

import android.util.Log;
import com.google.android.play.core.splitinstall.class_57;
import com.google.android.play.core.splitinstall.class_59;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

// $FF: renamed from: com.google.android.play.core.splitinstall.aj
final class class_83 {

   // $FF: renamed from: a org.xmlpull.v1.XmlPullParser
   private final XmlPullParser field_148;
   // $FF: renamed from: b com.google.android.play.core.splitinstall.g
   private final class_57 field_149;


   // $FF: renamed from: <init> (org.xmlpull.v1.XmlPullParser) void
   void method_211(XmlPullParser var1) {
      super();
      class_57 var10001 = new class_57;
      var10001.method_113();
      this.field_149 = var10001;
      this.field_148 = var1;
   }

   // $FF: renamed from: a () com.google.android.play.core.splitinstall.d
   final class_59 method_212() {
      try {
         class_83 var2 = this;

         while(var2.field_148.next() != 1) {
            if(var2.field_148.getEventType() == 2) {
               if(var2.field_148.getName().equals("splits")) {
                  class_83 var3 = var2;

                  while(var3.field_148.next() != 3) {
                     if(var3.field_148.getEventType() == 2) {
                        if(var3.field_148.getName().equals("module")) {
                           class_83 var4 = var3;
                           String var5;
                           if((var5 = var3.method_214("name")) == null) {
                              var3.method_213();
                           } else {
                              while(var4.field_148.next() != 3) {
                                 if(var4.field_148.getEventType() == 2) {
                                    if(var4.field_148.getName().equals("language")) {
                                       String var7 = var5;
                                       class_83 var6 = var4;

                                       while(var6.field_148.next() != 3) {
                                          if(var6.field_148.getEventType() == 2) {
                                             if(var6.field_148.getName().equals("entry")) {
                                                String var10 = var6.method_214("key");
                                                String var11 = var6.method_214("split");
                                                var6.method_213();
                                                if(var10 != null && var11 != null) {
                                                   var6.field_149.method_114(var7, var10, var11);
                                                }
                                             } else {
                                                var6.method_213();
                                             }
                                          }
                                       }
                                    } else {
                                       var4.method_213();
                                    }
                                 }
                              }
                           }
                        } else {
                           var3.method_213();
                        }
                     }
                  }
               } else {
                  var2.method_213();
               }
            }
         }

         return this.field_149.method_115();
      } catch (IllegalStateException var12) {
         Log.e("SplitInstall", "Error while parsing splits.xml", var12);
         return null;
      }
   }

   // $FF: renamed from: b () void
   private final void method_213() throws IOException, XmlPullParserException {
      int var1 = 1;

      while(var1 != 0) {
         switch(this.field_148.next()) {
         case 2:
            ++var1;
            break;
         case 3:
            --var1;
         }
      }

   }

   // $FF: renamed from: a (java.lang.String) java.lang.String
   private final String method_214(String var1) {
      for(int var2 = 0; var2 < this.field_148.getAttributeCount(); ++var2) {
         if(this.field_148.getAttributeName(var2).equals(var1)) {
            return this.field_148.getAttributeValue(var2);
         }
      }

      return null;
   }
}
