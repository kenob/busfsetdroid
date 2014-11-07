
package com.example.busfsetdroid.rest.model;

import java.util.ArrayList;
import java.util.List;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.parceler.Generated;
import org.parceler.ParcelWrapper;
import org.parceler.Parcels;

@Generated(value = "org.parceler.ParcelAnnotationProcessor", date = "2014-11-07T00:12-0500")
public class AgencyResponse$$Parcelable
    implements Parcelable, ParcelWrapper<AgencyResponse>
{

    private AgencyResponse agencyResponse$$0;
    @SuppressWarnings("UnusedDeclaration")
    public final static AgencyResponse$$Parcelable.Creator$$3 CREATOR = new AgencyResponse$$Parcelable.Creator$$3();

    public AgencyResponse$$Parcelable(android.os.Parcel parcel$$9) {
        agencyResponse$$0 = new AgencyResponse();
        int int$$0 = parcel$$9 .readInt();
        ArrayList<com.example.busfsetdroid.rest.model.AgencyResult> list$$0;
        if (int$$0 < 0) {
            list$$0 = null;
        } else {
            list$$0 = new ArrayList<com.example.busfsetdroid.rest.model.AgencyResult>();
            for (int int$$1 = 0; (int$$1 <int$$0); int$$1 ++) {
                list$$0 .add(((ParcelWrapper<com.example.busfsetdroid.rest.model.AgencyResult> ) parcel$$9 .readParcelable(AgencyResponse$$Parcelable.class.getClassLoader())).getParcel());
            }
        }
        agencyResponse$$0 .results = list$$0;
        agencyResponse$$0 .numResults = parcel$$9 .readString();
        agencyResponse$$0 .code = parcel$$9 .readString();
    }

    public AgencyResponse$$Parcelable(AgencyResponse agencyResponse$$1) {
        agencyResponse$$0 = agencyResponse$$1;
    }

    @Override
    public void writeToParcel(android.os.Parcel parcel$$10, int flags) {
        if (agencyResponse$$0 .results == null) {
            parcel$$10 .writeInt(-1);
        } else {
            parcel$$10 .writeInt(agencyResponse$$0 .results.size());
            for (com.example.busfsetdroid.rest.model.AgencyResult agencyResult$$2 : ((List<com.example.busfsetdroid.rest.model.AgencyResult> ) agencyResponse$$0 .results)) {
                parcel$$10 .writeParcelable(Parcels.wrap(agencyResult$$2), flags);
            }
        }
        parcel$$10 .writeString(agencyResponse$$0 .numResults);
        parcel$$10 .writeString(agencyResponse$$0 .code);
    }

    @Override
    public int describeContents() {
        return  0;
    }

    @Override
    public AgencyResponse getParcel() {
        return agencyResponse$$0;
    }

    private final static class Creator$$3
        implements Creator<AgencyResponse$$Parcelable>
    {


        @Override
        public AgencyResponse$$Parcelable createFromParcel(android.os.Parcel parcel$$11) {
            return new AgencyResponse$$Parcelable(parcel$$11);
        }

        @Override
        public AgencyResponse$$Parcelable[] newArray(int size) {
            return new AgencyResponse$$Parcelable[size] ;
        }

    }

}
