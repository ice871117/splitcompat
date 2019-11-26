package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.play.core.install.model.InstallStatus;
import com.google.android.play.core.splitinstall.model.SplitInstallSessionStatus;
import java.util.List;

public abstract class bg extends j implements be {
    public bg() {
        super("com.google.android.play.core.splitinstall.protocol.ISplitInstallServiceCallback");
    }

    /* access modifiers changed from: protected */
    public final boolean a(int i, Parcel parcel) throws RemoteException {
        switch (i) {
            case 2:
                c(parcel.readInt(), (Bundle) i.a(parcel, Bundle.CREATOR));
                break;
            case 3:
                Bundle bundle = (Bundle) i.a(parcel, Bundle.CREATOR);
                a(parcel.readInt());
                break;
            case 4:
                a(parcel.readInt(), (Bundle) i.a(parcel, Bundle.CREATOR));
                break;
            case 5:
                b(parcel.readInt(), (Bundle) i.a(parcel, Bundle.CREATOR));
                break;
            case 6:
                e((Bundle) i.a(parcel, Bundle.CREATOR));
                break;
            case SplitInstallSessionStatus.CANCELED /*7*/:
                a((List<Bundle>) parcel.createTypedArrayList(Bundle.CREATOR));
                break;
            case SplitInstallSessionStatus.REQUIRES_USER_CONFIRMATION /*8*/:
                d((Bundle) i.a(parcel, Bundle.CREATOR));
                break;
            case SplitInstallSessionStatus.CANCELING /*9*/:
                a((Bundle) i.a(parcel, Bundle.CREATOR));
                break;
            case InstallStatus.REQUIRES_UI_INTENT /*10*/:
                Bundle bundle2 = (Bundle) i.a(parcel, Bundle.CREATOR);
                b();
                break;
            case InstallStatus.DOWNLOADED /*11*/:
                Bundle bundle3 = (Bundle) i.a(parcel, Bundle.CREATOR);
                a();
                break;
            case 12:
                c((Bundle) i.a(parcel, Bundle.CREATOR));
                break;
            case 13:
                b((Bundle) i.a(parcel, Bundle.CREATOR));
                break;
            default:
                return false;
        }
        return true;
    }
}
