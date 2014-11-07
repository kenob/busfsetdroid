
package com.example.busfsetdroid.rest.model;

import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.parceler.Generated;
import org.parceler.ParcelWrapper;

@Generated(value = "org.parceler.ParcelAnnotationProcessor", date = "2014-11-07T00:12-0500")
public class CityResult$$Parcelable
    implements Parcelable, ParcelWrapper<CityResult>
{

    private CityResult cityResult$$0;
    @SuppressWarnings("UnusedDeclaration")
    public final static CityResult$$Parcelable.Creator$$2 CREATOR = new CityResult$$Parcelable.Creator$$2();

    public CityResult$$Parcelable(android.os.Parcel parcel$$6) {
        cityResult$$0 = new CityResult();
        cityResult$$0 .name = parcel$$6 .readString();
        cityResult$$0 .slug = parcel$$6 .readString();
    }

    public CityResult$$Parcelable(CityResult cityResult$$1) {
        cityResult$$0 = cityResult$$1;
    }

    @Override
    public void writeToParcel(android.os.Parcel parcel$$7, int flags) {
        parcel$$7 .writeString(cityResult$$0 .name);
        parcel$$7 .writeString(cityResult$$0 .slug);
    }

    @Override
    public int describeContents() {
        return  0;
    }

    @Override
    public CityResult getParcel() {
        return cityResult$$0;
    }

    private final static class Creator$$2
        implements Creator<CityResult$$Parcelable>
    {


        @Override
        public CityResult$$Parcelable createFromParcel(android.os.Parcel parcel$$8) {
            return new CityResult$$Parcelable(parcel$$8);
        }

        @Override
        public CityResult$$Parcelable[] newArray(int size) {
            return new CityResult$$Parcelable[size] ;
        }

    }

}
