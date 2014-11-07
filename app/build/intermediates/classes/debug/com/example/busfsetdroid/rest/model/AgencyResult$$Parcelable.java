
package com.example.busfsetdroid.rest.model;

import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.parceler.Generated;
import org.parceler.ParcelWrapper;

@Generated(value = "org.parceler.ParcelAnnotationProcessor", date = "2014-11-07T00:12-0500")
public class AgencyResult$$Parcelable
    implements Parcelable, ParcelWrapper<AgencyResult>
{

    private AgencyResult agencyResult$$0;
    @SuppressWarnings("UnusedDeclaration")
    public final static AgencyResult$$Parcelable.Creator$$1 CREATOR = new AgencyResult$$Parcelable.Creator$$1();

    public AgencyResult$$Parcelable(android.os.Parcel parcel$$3) {
        agencyResult$$0 = new AgencyResult();
        agencyResult$$0 .agency_phone = parcel$$3 .readString();
        agencyResult$$0 .agency_id = parcel$$3 .readString();
        agencyResult$$0 .agency_lang = parcel$$3 .readString();
        agencyResult$$0 .agency_url = parcel$$3 .readString();
        agencyResult$$0 .agency_timezone = parcel$$3 .readString();
        agencyResult$$0 .agency_name = parcel$$3 .readString();
        agencyResult$$0 .city = parcel$$3 .readString();
    }

    public AgencyResult$$Parcelable(AgencyResult agencyResult$$1) {
        agencyResult$$0 = agencyResult$$1;
    }

    @Override
    public void writeToParcel(android.os.Parcel parcel$$4, int flags) {
        parcel$$4 .writeString(agencyResult$$0 .agency_phone);
        parcel$$4 .writeString(agencyResult$$0 .agency_id);
        parcel$$4 .writeString(agencyResult$$0 .agency_lang);
        parcel$$4 .writeString(agencyResult$$0 .agency_url);
        parcel$$4 .writeString(agencyResult$$0 .agency_timezone);
        parcel$$4 .writeString(agencyResult$$0 .agency_name);
        parcel$$4 .writeString(agencyResult$$0 .city);
    }

    @Override
    public int describeContents() {
        return  0;
    }

    @Override
    public AgencyResult getParcel() {
        return agencyResult$$0;
    }

    private final static class Creator$$1
        implements Creator<AgencyResult$$Parcelable>
    {


        @Override
        public AgencyResult$$Parcelable createFromParcel(android.os.Parcel parcel$$5) {
            return new AgencyResult$$Parcelable(parcel$$5);
        }

        @Override
        public AgencyResult$$Parcelable[] newArray(int size) {
            return new AgencyResult$$Parcelable[size] ;
        }

    }

}
