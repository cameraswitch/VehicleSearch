package com.cameraswitch.vehiclesearch.endpoints.nhtsa;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface NHTSAApi {

    // https://vpic.nhtsa.dot.gov/api/vehicles/decodevin/5UXWX7C5*BA?format=json&modelyear=2011

    @GET("vehicles/decodevin/{vin}?format=json")
    Call<DecodedVin> decodeVin(@Path("vin") String vin);

}
