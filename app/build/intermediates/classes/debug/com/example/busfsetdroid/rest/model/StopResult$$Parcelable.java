
package com.example.busfsetdroid.rest.model;

import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.parceler.Generated;
import org.parceler.ParcelWrapper;

@Generated(value = "org.parceler.ParcelAnnotationProcessor", date = "2014-11-07T00:12-0500")
public class StopResult$$Parcelable
    implements Parcelable, ParcelWrapper<StopResult>
{

    private StopResult stopResult$$0;
    @SuppressWarnings("UnusedDeclaration")
    public final static StopResult$$Parcelable.Creator$$0 CREATOR = new StopResult$$Parcelable.Creator$$0();

    public StopResult$$Parcelable(android.os.Parcel parcel$$0) {
        stopResult$$0 = new StopResult();
        stopResult$$0 .stop_id = parcel$$0 .readString();
        stopResult$$0 .stop_lon = parcel$$0 .readString();
        stopResult$$0 .agency_id = parcel$$0 .readString();
        stopResult$$0 .stop_code = parcel$$0 .readString();
        stopResult$$0 .zone_id = parcel$$0 .readString();
        stopResult$$0 .stop_lat = parcel$$0 .readString();
        stopResult$$0 .wheelchair_boarding = parcel$$0 .readString();
        stopResult$$0 .stop_desc = parcel$$0 .readString();
        stopResult$$0 .stop_name = parcel$$0 .readString();
        stopResult$$0 .city = parcel$$0 .readString();
    }

    public StopResult$$Parcelable(StopResult stopResult$$1) {
        stopResult$$0 = stopResult$$1;
    }

    @Override
    public void writeToParcel(android.os.Parcel parcel$$1, int flags) {
        parcel$$1 .writeString(stopResult$$0 .stop_id);
        parcel$$1 .writeString(stopResult$$0 .stop_lon);
        parcel$$1 .writeString(stopResult$$0 .agency_id);
        parcel$$1 .writeString(stopResult$$0 .stop_code);
        parcel$$1 .writeString(stopResult$$0 .zone_id);
        parcel$$1 .writeString(stopResult$$0 .stop_lat);
        parcel$$1 .writeString(stopResult$$0 .wheelchair_boarding);
        parcel$$1 .writeString(stopResult$$0 .stop_desc);
        parcel$$1 .writeString(stopResult$$0 .stop_name);
        parcel$$1 .writeString(stopResult$$0 .city);
    }

    @Override
    public int describeContents() {
        return  0;
    }

    @Override
    public StopResult getParcel() {
        return stopResult$$0;
    }

    private final static class Creator$$0
        implements Creator<StopResult$$Parcelable>
    {


        @Override
        public StopResult$$Parcelable createFromParcel(android.os.Parcel parcel$$2) {
            return new StopResult$$Parcelable(parcel$$2);
        }

        @Override
        public StopResult$$Parcelable[] newArray(int size) {
            return new StopResult$$Parcelable[size] ;
        }

    }

}
