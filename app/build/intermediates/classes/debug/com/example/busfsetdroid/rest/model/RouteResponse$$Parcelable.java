
package com.example.busfsetdroid.rest.model;

import java.util.ArrayList;
import java.util.List;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.parceler.Generated;
import org.parceler.ParcelWrapper;
import org.parceler.Parcels;

@Generated(value = "org.parceler.ParcelAnnotationProcessor", date = "2014-11-07T00:12-0500")
public class RouteResponse$$Parcelable
    implements Parcelable, ParcelWrapper<RouteResponse>
{

    private RouteResponse routeResponse$$0;
    @SuppressWarnings("UnusedDeclaration")
    public final static RouteResponse$$Parcelable.Creator$$6 CREATOR = new RouteResponse$$Parcelable.Creator$$6();

    public RouteResponse$$Parcelable(android.os.Parcel parcel$$18) {
        routeResponse$$0 = new RouteResponse();
        int int$$2 = parcel$$18 .readInt();
        ArrayList<com.example.busfsetdroid.rest.model.RouteResult> list$$1;
        if (int$$2 < 0) {
            list$$1 = null;
        } else {
            list$$1 = new ArrayList<com.example.busfsetdroid.rest.model.RouteResult>();
            for (int int$$3 = 0; (int$$3 <int$$2); int$$3 ++) {
                list$$1 .add(((ParcelWrapper<com.example.busfsetdroid.rest.model.RouteResult> ) parcel$$18 .readParcelable(RouteResponse$$Parcelable.class.getClassLoader())).getParcel());
            }
        }
        routeResponse$$0 .results = list$$1;
        routeResponse$$0 .numResults = parcel$$18 .readString();
    }

    public RouteResponse$$Parcelable(RouteResponse routeResponse$$1) {
        routeResponse$$0 = routeResponse$$1;
    }

    @Override
    public void writeToParcel(android.os.Parcel parcel$$19, int flags) {
        if (routeResponse$$0 .results == null) {
            parcel$$19 .writeInt(-1);
        } else {
            parcel$$19 .writeInt(routeResponse$$0 .results.size());
            for (com.example.busfsetdroid.rest.model.RouteResult routeResult$$2 : ((List<com.example.busfsetdroid.rest.model.RouteResult> ) routeResponse$$0 .results)) {
                parcel$$19 .writeParcelable(Parcels.wrap(routeResult$$2), flags);
            }
        }
        parcel$$19 .writeString(routeResponse$$0 .numResults);
    }

    @Override
    public int describeContents() {
        return  0;
    }

    @Override
    public RouteResponse getParcel() {
        return routeResponse$$0;
    }

    private final static class Creator$$6
        implements Creator<RouteResponse$$Parcelable>
    {


        @Override
        public RouteResponse$$Parcelable createFromParcel(android.os.Parcel parcel$$20) {
            return new RouteResponse$$Parcelable(parcel$$20);
        }

        @Override
        public RouteResponse$$Parcelable[] newArray(int size) {
            return new RouteResponse$$Parcelable[size] ;
        }

    }

}
