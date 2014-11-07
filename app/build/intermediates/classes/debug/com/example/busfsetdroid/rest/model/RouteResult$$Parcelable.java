
package com.example.busfsetdroid.rest.model;

import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.parceler.Generated;
import org.parceler.ParcelWrapper;

@Generated(value = "org.parceler.ParcelAnnotationProcessor", date = "2014-11-07T00:12-0500")
public class RouteResult$$Parcelable
    implements Parcelable, ParcelWrapper<RouteResult>
{

    private RouteResult routeResult$$0;
    @SuppressWarnings("UnusedDeclaration")
    public final static RouteResult$$Parcelable.Creator$$4 CREATOR = new RouteResult$$Parcelable.Creator$$4();

    public RouteResult$$Parcelable(android.os.Parcel parcel$$12) {
        routeResult$$0 = new RouteResult();
        routeResult$$0 .route_color = parcel$$12 .readString();
        routeResult$$0 .agency_id = parcel$$12 .readString();
        routeResult$$0 .route_type = parcel$$12 .readString();
        routeResult$$0 .route_id = parcel$$12 .readInt();
        routeResult$$0 .route_short_name = parcel$$12 .readString();
        routeResult$$0 .route_url = parcel$$12 .readString();
        routeResult$$0 .route_long_name = parcel$$12 .readString();
        routeResult$$0 .city = parcel$$12 .readString();
    }

    public RouteResult$$Parcelable(RouteResult routeResult$$1) {
        routeResult$$0 = routeResult$$1;
    }

    @Override
    public void writeToParcel(android.os.Parcel parcel$$13, int flags) {
        parcel$$13 .writeString(routeResult$$0 .route_color);
        parcel$$13 .writeString(routeResult$$0 .agency_id);
        parcel$$13 .writeString(routeResult$$0 .route_type);
        parcel$$13 .writeInt(routeResult$$0 .route_id);
        parcel$$13 .writeString(routeResult$$0 .route_short_name);
        parcel$$13 .writeString(routeResult$$0 .route_url);
        parcel$$13 .writeString(routeResult$$0 .route_long_name);
        parcel$$13 .writeString(routeResult$$0 .city);
    }

    @Override
    public int describeContents() {
        return  0;
    }

    @Override
    public RouteResult getParcel() {
        return routeResult$$0;
    }

    private final static class Creator$$4
        implements Creator<RouteResult$$Parcelable>
    {


        @Override
        public RouteResult$$Parcelable createFromParcel(android.os.Parcel parcel$$14) {
            return new RouteResult$$Parcelable(parcel$$14);
        }

        @Override
        public RouteResult$$Parcelable[] newArray(int size) {
            return new RouteResult$$Parcelable[size] ;
        }

    }

}
