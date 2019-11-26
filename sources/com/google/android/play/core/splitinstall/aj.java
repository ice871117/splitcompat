package com.google.android.play.core.splitinstall;

import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

final class aj {
    private final XmlPullParser a;
    private final g b = new g();

    aj(XmlPullParser xmlPullParser) {
        this.a = xmlPullParser;
    }

    private final String a(String str) {
        for (int i = 0; i < this.a.getAttributeCount(); i++) {
            if (this.a.getAttributeName(i).equals(str)) {
                return this.a.getAttributeValue(i);
            }
        }
        return null;
    }

    private final void b() throws IOException, XmlPullParserException {
        int i = 1;
        while (i != 0) {
            switch (this.a.next()) {
                case 2:
                    i++;
                    break;
                case 3:
                    i--;
                    break;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: CFG modification limit reached, blocks count: 153 */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0092, code lost:
        if (r6.a.getName().equals("entry") == false) goto L_0x00af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0094, code lost:
        r1 = a("key");
        r2 = a("split");
        b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00a3, code lost:
        if (r1 == null) goto L_0x0076;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00a5, code lost:
        if (r2 == null) goto L_0x0076;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00a7, code lost:
        r6.b.a(r0, r1, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00af, code lost:
        b();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.play.core.splitinstall.d a() {
        /*
            r6 = this;
            r5 = 3
            r4 = 2
        L_0x0002:
            org.xmlpull.v1.XmlPullParser r0 = r6.a     // Catch:{ XmlPullParserException -> 0x004b, IOException -> 0x00ad, IllegalStateException -> 0x00b3 }
            int r0 = r0.next()     // Catch:{ XmlPullParserException -> 0x004b, IOException -> 0x00ad, IllegalStateException -> 0x00b3 }
            r1 = 1
            if (r0 == r1) goto L_0x00bf
            org.xmlpull.v1.XmlPullParser r0 = r6.a     // Catch:{ XmlPullParserException -> 0x004b, IOException -> 0x00ad, IllegalStateException -> 0x00b3 }
            int r0 = r0.getEventType()     // Catch:{ XmlPullParserException -> 0x004b, IOException -> 0x00ad, IllegalStateException -> 0x00b3 }
            if (r0 != r4) goto L_0x0002
            org.xmlpull.v1.XmlPullParser r0 = r6.a     // Catch:{ XmlPullParserException -> 0x004b, IOException -> 0x00ad, IllegalStateException -> 0x00b3 }
            java.lang.String r0 = r0.getName()     // Catch:{ XmlPullParserException -> 0x004b, IOException -> 0x00ad, IllegalStateException -> 0x00b3 }
            java.lang.String r1 = "splits"
            boolean r0 = r0.equals(r1)     // Catch:{ XmlPullParserException -> 0x004b, IOException -> 0x00ad, IllegalStateException -> 0x00b3 }
            if (r0 == 0) goto L_0x00ba
        L_0x0021:
            org.xmlpull.v1.XmlPullParser r0 = r6.a     // Catch:{ XmlPullParserException -> 0x004b, IOException -> 0x00ad, IllegalStateException -> 0x00b3 }
            int r0 = r0.next()     // Catch:{ XmlPullParserException -> 0x004b, IOException -> 0x00ad, IllegalStateException -> 0x00b3 }
            if (r0 == r5) goto L_0x0002
            org.xmlpull.v1.XmlPullParser r0 = r6.a     // Catch:{ XmlPullParserException -> 0x004b, IOException -> 0x00ad, IllegalStateException -> 0x00b3 }
            int r0 = r0.getEventType()     // Catch:{ XmlPullParserException -> 0x004b, IOException -> 0x00ad, IllegalStateException -> 0x00b3 }
            if (r0 != r4) goto L_0x0021
            org.xmlpull.v1.XmlPullParser r0 = r6.a     // Catch:{ XmlPullParserException -> 0x004b, IOException -> 0x00ad, IllegalStateException -> 0x00b3 }
            java.lang.String r0 = r0.getName()     // Catch:{ XmlPullParserException -> 0x004b, IOException -> 0x00ad, IllegalStateException -> 0x00b3 }
            java.lang.String r1 = "module"
            boolean r0 = r0.equals(r1)     // Catch:{ XmlPullParserException -> 0x004b, IOException -> 0x00ad, IllegalStateException -> 0x00b3 }
            if (r0 == 0) goto L_0x00b5
            java.lang.String r0 = "name"
            java.lang.String r0 = r6.a(r0)     // Catch:{ XmlPullParserException -> 0x004b, IOException -> 0x00ad, IllegalStateException -> 0x00b3 }
            if (r0 != 0) goto L_0x0058
            r6.b()     // Catch:{ XmlPullParserException -> 0x004b, IOException -> 0x00ad, IllegalStateException -> 0x00b3 }
            goto L_0x0021
        L_0x004b:
            r0 = move-exception
        L_0x004c:
            java.lang.String r1 = "SplitInstall"
            java.lang.String r2 = "Error while parsing splits.xml"
            android.util.Log.e(r1, r2, r0)
            r0 = 0
        L_0x0054:
            return r0
        L_0x0055:
            r6.b()     // Catch:{ XmlPullParserException -> 0x004b, IOException -> 0x00ad, IllegalStateException -> 0x00b3 }
        L_0x0058:
            org.xmlpull.v1.XmlPullParser r1 = r6.a     // Catch:{ XmlPullParserException -> 0x004b, IOException -> 0x00ad, IllegalStateException -> 0x00b3 }
            int r1 = r1.next()     // Catch:{ XmlPullParserException -> 0x004b, IOException -> 0x00ad, IllegalStateException -> 0x00b3 }
            if (r1 == r5) goto L_0x0021
            org.xmlpull.v1.XmlPullParser r1 = r6.a     // Catch:{ XmlPullParserException -> 0x004b, IOException -> 0x00ad, IllegalStateException -> 0x00b3 }
            int r1 = r1.getEventType()     // Catch:{ XmlPullParserException -> 0x004b, IOException -> 0x00ad, IllegalStateException -> 0x00b3 }
            if (r1 != r4) goto L_0x0058
            org.xmlpull.v1.XmlPullParser r1 = r6.a     // Catch:{ XmlPullParserException -> 0x004b, IOException -> 0x00ad, IllegalStateException -> 0x00b3 }
            java.lang.String r1 = r1.getName()     // Catch:{ XmlPullParserException -> 0x004b, IOException -> 0x00ad, IllegalStateException -> 0x00b3 }
            java.lang.String r2 = "language"
            boolean r1 = r1.equals(r2)     // Catch:{ XmlPullParserException -> 0x004b, IOException -> 0x00ad, IllegalStateException -> 0x00b3 }
            if (r1 == 0) goto L_0x0055
        L_0x0076:
            org.xmlpull.v1.XmlPullParser r1 = r6.a     // Catch:{ XmlPullParserException -> 0x004b, IOException -> 0x00ad, IllegalStateException -> 0x00b3 }
            int r1 = r1.next()     // Catch:{ XmlPullParserException -> 0x004b, IOException -> 0x00ad, IllegalStateException -> 0x00b3 }
            if (r1 == r5) goto L_0x0058
            org.xmlpull.v1.XmlPullParser r1 = r6.a     // Catch:{ XmlPullParserException -> 0x004b, IOException -> 0x00ad, IllegalStateException -> 0x00b3 }
            int r1 = r1.getEventType()     // Catch:{ XmlPullParserException -> 0x004b, IOException -> 0x00ad, IllegalStateException -> 0x00b3 }
            if (r1 != r4) goto L_0x0076
            org.xmlpull.v1.XmlPullParser r1 = r6.a     // Catch:{ XmlPullParserException -> 0x004b, IOException -> 0x00ad, IllegalStateException -> 0x00b3 }
            java.lang.String r1 = r1.getName()     // Catch:{ XmlPullParserException -> 0x004b, IOException -> 0x00ad, IllegalStateException -> 0x00b3 }
            java.lang.String r2 = "entry"
            boolean r1 = r1.equals(r2)     // Catch:{ XmlPullParserException -> 0x004b, IOException -> 0x00ad, IllegalStateException -> 0x00b3 }
            if (r1 == 0) goto L_0x00af
            java.lang.String r1 = "key"
            java.lang.String r1 = r6.a(r1)     // Catch:{ XmlPullParserException -> 0x004b, IOException -> 0x00ad, IllegalStateException -> 0x00b3 }
            java.lang.String r2 = "split"
            java.lang.String r2 = r6.a(r2)     // Catch:{ XmlPullParserException -> 0x004b, IOException -> 0x00ad, IllegalStateException -> 0x00b3 }
            r6.b()     // Catch:{ XmlPullParserException -> 0x004b, IOException -> 0x00ad, IllegalStateException -> 0x00b3 }
            if (r1 == 0) goto L_0x0076
            if (r2 == 0) goto L_0x0076
            com.google.android.play.core.splitinstall.g r3 = r6.b     // Catch:{ XmlPullParserException -> 0x004b, IOException -> 0x00ad, IllegalStateException -> 0x00b3 }
            r3.a(r0, r1, r2)     // Catch:{ XmlPullParserException -> 0x004b, IOException -> 0x00ad, IllegalStateException -> 0x00b3 }
            goto L_0x0076
        L_0x00ad:
            r0 = move-exception
            goto L_0x004c
        L_0x00af:
            r6.b()     // Catch:{ XmlPullParserException -> 0x004b, IOException -> 0x00ad, IllegalStateException -> 0x00b3 }
            goto L_0x0076
        L_0x00b3:
            r0 = move-exception
            goto L_0x004c
        L_0x00b5:
            r6.b()     // Catch:{ XmlPullParserException -> 0x004b, IOException -> 0x00ad, IllegalStateException -> 0x00b3 }
            goto L_0x0021
        L_0x00ba:
            r6.b()     // Catch:{ XmlPullParserException -> 0x004b, IOException -> 0x00ad, IllegalStateException -> 0x00b3 }
            goto L_0x0002
        L_0x00bf:
            com.google.android.play.core.splitinstall.g r0 = r6.b     // Catch:{ XmlPullParserException -> 0x004b, IOException -> 0x00ad, IllegalStateException -> 0x00b3 }
            com.google.android.play.core.splitinstall.d r0 = r0.a()     // Catch:{ XmlPullParserException -> 0x004b, IOException -> 0x00ad, IllegalStateException -> 0x00b3 }
            goto L_0x0054
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.splitinstall.aj.a():com.google.android.play.core.splitinstall.d");
    }
}
