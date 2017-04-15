package com.cameraswitch.vehiclesearch.endpoints.nhtsa;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.cameraswitch.vehiclesearch.Const;

import java.io.File;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.cameraswitch.vehiclesearch.Const.*;

public class NHTSA {
    static final private String HOST = "https://vpic.nhtsa.dot.gov/api/";

    private final NHTSAApi sService;
    private final Retrofit mRetrofit;
    private static NHTSA sNHTSA;

    static public NHTSA getInstance(Context c) {

        if (sNHTSA == null)
            sNHTSA = new NHTSA(c);
        return sNHTSA;
    }
    public NHTSA (Context c) {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        // caching
        Cache cache = new Cache(new File(c.getCacheDir(), CACHE_FILENAME), CACHE_FILESIZE);
        OkHttpClient client = new OkHttpClient.Builder().cache(cache).build();

        mRetrofit = new Retrofit.Builder()
                .baseUrl(HOST)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        sService = mRetrofit.create(NHTSAApi.class);
    }

    public DecodedVin decodeVin(String vin, final OnDecodedListener listener) {
        Call<DecodedVin> response = sService.decodeVin(vin);
        response.enqueue(new Callback<DecodedVin>() {
            @Override
            public void onResponse(Call<DecodedVin> call, Response<DecodedVin> response) {
                if (listener != null)
                    listener.onDecoded(response.body());
            }

            @Override
            public void onFailure(Call<DecodedVin> call, Throwable t) {

            }
        });
        return null;
    }

    public interface OnDecodedListener {
        void onDecoded(DecodedVin response);
    }
}
