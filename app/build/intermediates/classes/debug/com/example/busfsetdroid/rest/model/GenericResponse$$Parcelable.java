
package com.example.busfsetdroid.rest.model;

import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.parceler.Generated;
import org.parceler.InjectionUtil;
import org.parceler.ParcelWrapper;
import org.parceler.Parcels;

@Generated(value = "org.parceler.ParcelAnnotationProcessor", date = "2014-11-06T16:54-0500")
public class GenericResponse$$Parcelable
    implements Parcelable, ParcelWrapper<com.example.busfsetdroid.rest.model.GenericResponse>
{

    private com.example.busfsetdroid.rest.model.GenericResponse genericResponse$$0;
    @SuppressWarnings("UnusedDeclaration")
    public final static GenericResponse$$Parcelable.Creator$$1 CREATOR = new GenericResponse$$Parcelable.Creator$$1();

    public GenericResponse$$Parcelable(android.os.Parcel parcel$$3) {
        genericResponse$$0 = new com.example.busfsetdroid.rest.model.GenericResponse();
        InjectionUtil.setField(com.example.busfsetdroid.rest.model.GenericResponse.class, genericResponse$$0, "statusCode", parcel$$3 .readString());
        int int$$0 = parcel$$3 .readInt();
        java.util.ArrayList<com.example.busfsetdroid.rest.model.ResultResponse> list$$0;
        if (int$$0 < 0) {
            list$$0 = null;
        } else {
            list$$0 = new java.util.ArrayList<com.example.busfsetdroid.rest.model.ResultResponse>();
            for (int int$$1 = 0; (int$$1 <int$$0); int$$1 ++) {
                list$$0 .add(((ParcelWrapper<com.example.busfsetdroid.rest.model.ResultResponse> ) parcel$$3 .readParcelable(GenericResponse$$Parcelable.class.getClassLoader())).getParcel());
            }
        }
        InjectionUtil.setField(com.example.busfsetdroid.rest.model.GenericResponse.class, genericResponse$$0, "results", list$$0);
        InjectionUtil.setField(com.example.busfsetdroid.rest.model.GenericResponse.class, genericResponse$$0, "numResults", parcel$$3 .readInt());
    }

    public GenericResponse$$Parcelable(com.example.busfsetdroid.rest.model.GenericResponse genericResponse$$1) {
        genericResponse$$0 = genericResponse$$1;
    }

    @Override
    public void writeToParcel(android.os.Parcel parcel$$4, int flags) {
        parcel$$4 .writeString(InjectionUtil.getField(String.class, com.example.busfsetdroid.rest.model.GenericResponse.class, genericResponse$$0, "statusCode"));
        if (InjectionUtil.getField(java.util.ArrayList.class, com.example.busfsetdroid.rest.model.GenericResponse.class, genericResponse$$0, "results") == null) {
            parcel$$4 .writeInt(-1);
        } else {
            parcel$$4 .writeInt(InjectionUtil.getField(java.util.ArrayList.class, com.example.busfsetdroid.rest.model.GenericResponse.class, genericResponse$$0, "results").size());
            for (com.example.busfsetdroid.rest.model.ResultResponse resultResponse$$2 : ((java.util.ArrayList<com.example.busfsetdroid.rest.model.ResultResponse> ) InjectionUtil.getField(java.util.ArrayList.class, com.example.busfsetdroid.rest.model.GenericResponse.class, genericResponse$$0, "results"))) {
                parcel$$4 .writeParcelable(Parcels.wrap(resultResponse$$2), flags);
            }
        }
        parcel$$4 .writeInt(InjectionUtil.getField(Integer.class, com.example.busfsetdroid.rest.model.GenericResponse.class, genericResponse$$0, "numResults"));
    }

    @Override
    public int describeContents() {
        return  0;
    }

    @Override
    public com.example.busfsetdroid.rest.model.GenericResponse getParcel() {
        return genericResponse$$0;
    }

    private final static class Creator$$1
        implements Creator<GenericResponse$$Parcelable>
    {


        @Override
        public GenericResponse$$Parcelable createFromParcel(android.os.Parcel parcel$$5) {
            return new GenericResponse$$Parcelable(parcel$$5);
        }

        @Override
        public GenericResponse$$Parcelable[] newArray(int size) {
            return new GenericResponse$$Parcelable[size] ;
        }

    }

}
