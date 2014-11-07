
package com.example.busfsetdroid.rest.model;

import java.util.ArrayList;
import java.util.List;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.parceler.Generated;
import org.parceler.ParcelWrapper;
import org.parceler.Parcels;

@Generated(value = "org.parceler.ParcelAnnotationProcessor", date = "2014-11-07T00:12-0500")
public class StopResponse$$Parcelable
    implements Parcelable, ParcelWrapper<StopResponse>
{

    private StopResponse stopResponse$$0;
    @SuppressWarnings("UnusedDeclaration")
    public final static StopResponse$$Parcelable.Creator$$8 CREATOR = new StopResponse$$Parcelable.Creator$$8();

    public StopResponse$$Parcelable(android.os.Parcel parcel$$24) {
        stopResponse$$0 = new StopResponse();
        int int$$6 = parcel$$24 .readInt();
        ArrayList<com.example.busfsetdroid.rest.model.StopResult> list$$3;
        if (int$$6 < 0) {
            list$$3 = null;
        } else {
            list$$3 = new ArrayList<com.example.busfsetdroid.rest.model.StopResult>();
            for (int int$$7 = 0; (int$$7 <int$$6); int$$7 ++) {
                list$$3 .add(((ParcelWrapper<com.example.busfsetdroid.rest.model.StopResult> ) parcel$$24 .readParcelable(StopResponse$$Parcelable.class.getClassLoader())).getParcel());
            }
        }
        stopResponse$$0 .results = list$$3;
        stopResponse$$0 .numResults = parcel$$24 .readString();
    }

    public StopResponse$$Parcelable(StopResponse stopResponse$$1) {
        stopResponse$$0 = stopResponse$$1;
    }

    @Override
    public void writeToParcel(android.os.Parcel parcel$$25, int flags) {
        if (stopResponse$$0 .results == null) {
            parcel$$25 .writeInt(-1);
        } else {
            parcel$$25 .writeInt(stopResponse$$0 .results.size());
            for (com.example.busfsetdroid.rest.model.StopResult stopResult$$2 : ((List<com.example.busfsetdroid.rest.model.StopResult> ) stopResponse$$0 .results)) {
                parcel$$25 .writeParcelable(Parcels.wrap(stopResult$$2), flags);
            }
        }
        parcel$$25 .writeString(stopResponse$$0 .numResults);
    }

    @Override
    public int describeContents() {
        return  0;
    }

    @Override
    public StopResponse getParcel() {
        return stopResponse$$0;
    }

    private final static class Creator$$8
        implements Creator<StopResponse$$Parcelable>
    {


        @Override
        public StopResponse$$Parcelable createFromParcel(android.os.Parcel parcel$$26) {
            return new StopResponse$$Parcelable(parcel$$26);
        }

        @Override
        public StopResponse$$Parcelable[] newArray(int size) {
            return new StopResponse$$Parcelable[size] ;
        }

    }

}
