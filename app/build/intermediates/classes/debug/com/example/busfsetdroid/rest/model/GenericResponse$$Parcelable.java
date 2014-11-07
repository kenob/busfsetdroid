
package com.example.busfsetdroid.rest.model;

import java.util.ArrayList;
import java.util.List;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.parceler.Generated;
import org.parceler.ParcelWrapper;
import org.parceler.Parcels;

@Generated(value = "org.parceler.ParcelAnnotationProcessor", date = "2014-11-07T00:12-0500")
public class GenericResponse$$Parcelable
    implements Parcelable, ParcelWrapper<GenericResponse>
{

    private GenericResponse genericResponse$$0;
    @SuppressWarnings("UnusedDeclaration")
    public final static GenericResponse$$Parcelable.Creator$$7 CREATOR = new GenericResponse$$Parcelable.Creator$$7();

    public GenericResponse$$Parcelable(android.os.Parcel parcel$$21) {
        genericResponse$$0 = new GenericResponse();
        int int$$4 = parcel$$21 .readInt();
        ArrayList<com.example.busfsetdroid.rest.model.ResultResponse> list$$2;
        if (int$$4 < 0) {
            list$$2 = null;
        } else {
            list$$2 = new ArrayList<com.example.busfsetdroid.rest.model.ResultResponse>();
            for (int int$$5 = 0; (int$$5 <int$$4); int$$5 ++) {
                list$$2 .add(((ParcelWrapper<com.example.busfsetdroid.rest.model.ResultResponse> ) parcel$$21 .readParcelable(GenericResponse$$Parcelable.class.getClassLoader())).getParcel());
            }
        }
        genericResponse$$0 .results = list$$2;
        genericResponse$$0 .numResults = parcel$$21 .readString();
        genericResponse$$0 .code = parcel$$21 .readString();
    }

    public GenericResponse$$Parcelable(GenericResponse genericResponse$$1) {
        genericResponse$$0 = genericResponse$$1;
    }

    @Override
    public void writeToParcel(android.os.Parcel parcel$$22, int flags) {
        if (genericResponse$$0 .results == null) {
            parcel$$22 .writeInt(-1);
        } else {
            parcel$$22 .writeInt(genericResponse$$0 .results.size());
            for (com.example.busfsetdroid.rest.model.ResultResponse resultResponse$$2 : ((List<com.example.busfsetdroid.rest.model.ResultResponse> ) genericResponse$$0 .results)) {
                parcel$$22 .writeParcelable(Parcels.wrap(resultResponse$$2), flags);
            }
        }
        parcel$$22 .writeString(genericResponse$$0 .numResults);
        parcel$$22 .writeString(genericResponse$$0 .code);
    }

    @Override
    public int describeContents() {
        return  0;
    }

    @Override
    public GenericResponse getParcel() {
        return genericResponse$$0;
    }

    private final static class Creator$$7
        implements Creator<GenericResponse$$Parcelable>
    {


        @Override
        public GenericResponse$$Parcelable createFromParcel(android.os.Parcel parcel$$23) {
            return new GenericResponse$$Parcelable(parcel$$23);
        }

        @Override
        public GenericResponse$$Parcelable[] newArray(int size) {
            return new GenericResponse$$Parcelable[size] ;
        }

    }

}
