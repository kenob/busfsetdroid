
package com.example.busfsetdroid.rest.model;

import java.util.ArrayList;
import java.util.List;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.parceler.Generated;
import org.parceler.ParcelWrapper;
import org.parceler.Parcels;

@Generated(value = "org.parceler.ParcelAnnotationProcessor", date = "2014-11-07T00:12-0500")
public class CityResponse$$Parcelable
    implements Parcelable, ParcelWrapper<CityResponse>
{

    private CityResponse cityResponse$$0;
    @SuppressWarnings("UnusedDeclaration")
    public final static CityResponse$$Parcelable.Creator$$9 CREATOR = new CityResponse$$Parcelable.Creator$$9();

    public CityResponse$$Parcelable(android.os.Parcel parcel$$27) {
        cityResponse$$0 = new CityResponse();
        int int$$8 = parcel$$27 .readInt();
        ArrayList<com.example.busfsetdroid.rest.model.CityResult> list$$4;
        if (int$$8 < 0) {
            list$$4 = null;
        } else {
            list$$4 = new ArrayList<com.example.busfsetdroid.rest.model.CityResult>();
            for (int int$$9 = 0; (int$$9 <int$$8); int$$9 ++) {
                list$$4 .add(((ParcelWrapper<com.example.busfsetdroid.rest.model.CityResult> ) parcel$$27 .readParcelable(CityResponse$$Parcelable.class.getClassLoader())).getParcel());
            }
        }
        cityResponse$$0 .results = list$$4;
        cityResponse$$0 .numResults = parcel$$27 .readString();
    }

    public CityResponse$$Parcelable(CityResponse cityResponse$$1) {
        cityResponse$$0 = cityResponse$$1;
    }

    @Override
    public void writeToParcel(android.os.Parcel parcel$$28, int flags) {
        if (cityResponse$$0 .results == null) {
            parcel$$28 .writeInt(-1);
        } else {
            parcel$$28 .writeInt(cityResponse$$0 .results.size());
            for (com.example.busfsetdroid.rest.model.CityResult cityResult$$2 : ((List<com.example.busfsetdroid.rest.model.CityResult> ) cityResponse$$0 .results)) {
                parcel$$28 .writeParcelable(Parcels.wrap(cityResult$$2), flags);
            }
        }
        parcel$$28 .writeString(cityResponse$$0 .numResults);
    }

    @Override
    public int describeContents() {
        return  0;
    }

    @Override
    public CityResponse getParcel() {
        return cityResponse$$0;
    }

    private final static class Creator$$9
        implements Creator<CityResponse$$Parcelable>
    {


        @Override
        public CityResponse$$Parcelable createFromParcel(android.os.Parcel parcel$$29) {
            return new CityResponse$$Parcelable(parcel$$29);
        }

        @Override
        public CityResponse$$Parcelable[] newArray(int size) {
            return new CityResponse$$Parcelable[size] ;
        }

    }

}
