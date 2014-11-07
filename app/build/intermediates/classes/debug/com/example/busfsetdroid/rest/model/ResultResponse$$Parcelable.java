
package com.example.busfsetdroid.rest.model;

import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.parceler.Generated;
import org.parceler.ParcelWrapper;

@Generated(value = "org.parceler.ParcelAnnotationProcessor", date = "2014-11-07T00:12-0500")
public class ResultResponse$$Parcelable
    implements Parcelable, ParcelWrapper<ResultResponse>
{

    private ResultResponse resultResponse$$0;
    @SuppressWarnings("UnusedDeclaration")
    public final static ResultResponse$$Parcelable.Creator$$5 CREATOR = new ResultResponse$$Parcelable.Creator$$5();

    public ResultResponse$$Parcelable(android.os.Parcel parcel$$15) {
        resultResponse$$0 = new ResultResponse();
        resultResponse$$0 .message = parcel$$15 .readString();
    }

    public ResultResponse$$Parcelable(ResultResponse resultResponse$$1) {
        resultResponse$$0 = resultResponse$$1;
    }

    @Override
    public void writeToParcel(android.os.Parcel parcel$$16, int flags) {
        parcel$$16 .writeString(resultResponse$$0 .message);
    }

    @Override
    public int describeContents() {
        return  0;
    }

    @Override
    public ResultResponse getParcel() {
        return resultResponse$$0;
    }

    private final static class Creator$$5
        implements Creator<ResultResponse$$Parcelable>
    {


        @Override
        public ResultResponse$$Parcelable createFromParcel(android.os.Parcel parcel$$17) {
            return new ResultResponse$$Parcelable(parcel$$17);
        }

        @Override
        public ResultResponse$$Parcelable[] newArray(int size) {
            return new ResultResponse$$Parcelable[size] ;
        }

    }

}
