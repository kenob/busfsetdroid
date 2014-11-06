
package com.example.busfsetdroid.rest.model;

import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.parceler.Generated;
import org.parceler.InjectionUtil;
import org.parceler.ParcelWrapper;

@Generated(value = "org.parceler.ParcelAnnotationProcessor", date = "2014-11-06T16:54-0500")
public class ResultResponse$$Parcelable
    implements Parcelable, ParcelWrapper<com.example.busfsetdroid.rest.model.ResultResponse>
{

    private com.example.busfsetdroid.rest.model.ResultResponse resultResponse$$0;
    @SuppressWarnings("UnusedDeclaration")
    public final static ResultResponse$$Parcelable.Creator$$0 CREATOR = new ResultResponse$$Parcelable.Creator$$0();

    public ResultResponse$$Parcelable(android.os.Parcel parcel$$0) {
        resultResponse$$0 = new com.example.busfsetdroid.rest.model.ResultResponse();
        InjectionUtil.setField(com.example.busfsetdroid.rest.model.ResultResponse.class, resultResponse$$0, "message", parcel$$0 .readString());
    }

    public ResultResponse$$Parcelable(com.example.busfsetdroid.rest.model.ResultResponse resultResponse$$1) {
        resultResponse$$0 = resultResponse$$1;
    }

    @Override
    public void writeToParcel(android.os.Parcel parcel$$1, int flags) {
        parcel$$1 .writeString(InjectionUtil.getField(String.class, com.example.busfsetdroid.rest.model.ResultResponse.class, resultResponse$$0, "message"));
    }

    @Override
    public int describeContents() {
        return  0;
    }

    @Override
    public com.example.busfsetdroid.rest.model.ResultResponse getParcel() {
        return resultResponse$$0;
    }

    private final static class Creator$$0
        implements Creator<ResultResponse$$Parcelable>
    {


        @Override
        public ResultResponse$$Parcelable createFromParcel(android.os.Parcel parcel$$2) {
            return new ResultResponse$$Parcelable(parcel$$2);
        }

        @Override
        public ResultResponse$$Parcelable[] newArray(int size) {
            return new ResultResponse$$Parcelable[size] ;
        }

    }

}
