
package org.parceler;

import java.util.HashMap;
import java.util.Map;
import com.example.busfsetdroid.rest.model.AgencyResponse;
import com.example.busfsetdroid.rest.model.AgencyResponse$$Parcelable;
import com.example.busfsetdroid.rest.model.AgencyResult;
import com.example.busfsetdroid.rest.model.AgencyResult$$Parcelable;
import com.example.busfsetdroid.rest.model.CityResponse;
import com.example.busfsetdroid.rest.model.CityResponse$$Parcelable;
import com.example.busfsetdroid.rest.model.CityResult;
import com.example.busfsetdroid.rest.model.CityResult$$Parcelable;
import com.example.busfsetdroid.rest.model.GenericResponse;
import com.example.busfsetdroid.rest.model.GenericResponse$$Parcelable;
import com.example.busfsetdroid.rest.model.ResultResponse;
import com.example.busfsetdroid.rest.model.ResultResponse$$Parcelable;
import com.example.busfsetdroid.rest.model.RouteResponse;
import com.example.busfsetdroid.rest.model.RouteResponse$$Parcelable;
import com.example.busfsetdroid.rest.model.RouteResult;
import com.example.busfsetdroid.rest.model.RouteResult$$Parcelable;
import com.example.busfsetdroid.rest.model.StopResponse;
import com.example.busfsetdroid.rest.model.StopResponse$$Parcelable;
import com.example.busfsetdroid.rest.model.StopResult;
import com.example.busfsetdroid.rest.model.StopResult$$Parcelable;

@Generated(value = "org.parceler.ParcelAnnotationProcessor", date = "2014-11-07T00:12-0500")
public class Parceler$$Parcels
    implements Repository<org.parceler.Parcels.ParcelableFactory>
{

    private final Map<Class, org.parceler.Parcels.ParcelableFactory> map$$0 = new HashMap<Class, org.parceler.Parcels.ParcelableFactory>();

    public Parceler$$Parcels() {
        map$$0 .put(RouteResult.class, new Parceler$$Parcels.RouteResult$$Parcelable$$0());
        map$$0 .put(AgencyResult.class, new Parceler$$Parcels.AgencyResult$$Parcelable$$0());
        map$$0 .put(CityResponse.class, new Parceler$$Parcels.CityResponse$$Parcelable$$0());
        map$$0 .put(StopResponse.class, new Parceler$$Parcels.StopResponse$$Parcelable$$0());
        map$$0 .put(ResultResponse.class, new Parceler$$Parcels.ResultResponse$$Parcelable$$0());
        map$$0 .put(CityResult.class, new Parceler$$Parcels.CityResult$$Parcelable$$0());
        map$$0 .put(AgencyResponse.class, new Parceler$$Parcels.AgencyResponse$$Parcelable$$0());
        map$$0 .put(GenericResponse.class, new Parceler$$Parcels.GenericResponse$$Parcelable$$0());
        map$$0 .put(RouteResponse.class, new Parceler$$Parcels.RouteResponse$$Parcelable$$0());
        map$$0 .put(StopResult.class, new Parceler$$Parcels.StopResult$$Parcelable$$0());
    }

    public Map<Class, org.parceler.Parcels.ParcelableFactory> get() {
        return map$$0;
    }

    private final static class AgencyResponse$$Parcelable$$0
        implements org.parceler.Parcels.ParcelableFactory<AgencyResponse>
    {


        @Override
        public AgencyResponse$$Parcelable buildParcelable(AgencyResponse input) {
            return new AgencyResponse$$Parcelable(input);
        }

    }

    private final static class AgencyResult$$Parcelable$$0
        implements org.parceler.Parcels.ParcelableFactory<AgencyResult>
    {


        @Override
        public AgencyResult$$Parcelable buildParcelable(AgencyResult input) {
            return new AgencyResult$$Parcelable(input);
        }

    }

    private final static class CityResponse$$Parcelable$$0
        implements org.parceler.Parcels.ParcelableFactory<CityResponse>
    {


        @Override
        public CityResponse$$Parcelable buildParcelable(CityResponse input) {
            return new CityResponse$$Parcelable(input);
        }

    }

    private final static class CityResult$$Parcelable$$0
        implements org.parceler.Parcels.ParcelableFactory<CityResult>
    {


        @Override
        public CityResult$$Parcelable buildParcelable(CityResult input) {
            return new CityResult$$Parcelable(input);
        }

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

    private final static class RouteResponse$$Parcelable$$0
        implements org.parceler.Parcels.ParcelableFactory<RouteResponse>
    {


        @Override
        public RouteResponse$$Parcelable buildParcelable(RouteResponse input) {
            return new RouteResponse$$Parcelable(input);
        }

    }

    private final static class RouteResult$$Parcelable$$0
        implements org.parceler.Parcels.ParcelableFactory<RouteResult>
    {


        @Override
        public RouteResult$$Parcelable buildParcelable(RouteResult input) {
            return new RouteResult$$Parcelable(input);
        }

    }

    private final static class StopResponse$$Parcelable$$0
        implements org.parceler.Parcels.ParcelableFactory<StopResponse>
    {


        @Override
        public StopResponse$$Parcelable buildParcelable(StopResponse input) {
            return new StopResponse$$Parcelable(input);
        }

    }

    private final static class StopResult$$Parcelable$$0
        implements org.parceler.Parcels.ParcelableFactory<StopResult>
    {


        @Override
        public StopResult$$Parcelable buildParcelable(StopResult input) {
            return new StopResult$$Parcelable(input);
        }

    }

}
