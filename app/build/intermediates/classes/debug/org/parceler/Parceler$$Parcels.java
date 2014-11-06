
package org.parceler;

import java.util.HashMap;
import java.util.Map;
import com.example.busfsetdroid.rest.model.GenericResponse;
import com.example.busfsetdroid.rest.model.GenericResponse$$Parcelable;
import com.example.busfsetdroid.rest.model.ResultResponse;
import com.example.busfsetdroid.rest.model.ResultResponse$$Parcelable;

@Generated(value = "org.parceler.ParcelAnnotationProcessor", date = "2014-11-06T16:54-0500")
public class Parceler$$Parcels
    implements Repository<org.parceler.Parcels.ParcelableFactory>
{

    private final Map<Class, org.parceler.Parcels.ParcelableFactory> map$$0 = new HashMap<Class, org.parceler.Parcels.ParcelableFactory>();

    public Parceler$$Parcels() {
        map$$0 .put(GenericResponse.class, new Parceler$$Parcels.GenericResponse$$Parcelable$$0());
        map$$0 .put(ResultResponse.class, new Parceler$$Parcels.ResultResponse$$Parcelable$$0());
    }

    public Map<Class, org.parceler.Parcels.ParcelableFactory> get() {
        return map$$0;
    }

    private final static class GenericResponse$$Parcelable$$0
        implements org.parceler.Parcels.ParcelableFactory<GenericResponse>
    {


        @Override
        public GenericResponse$$Parcelable buildParcelable(GenericResponse input) {
            return new GenericResponse$$Parcelable(input);
        }

    }

    private final static class ResultResponse$$Parcelable$$0
        implements org.parceler.Parcels.ParcelableFactory<ResultResponse>
    {


        @Override
        public ResultResponse$$Parcelable buildParcelable(ResultResponse input) {
            return new ResultResponse$$Parcelable(input);
        }

    }

}
