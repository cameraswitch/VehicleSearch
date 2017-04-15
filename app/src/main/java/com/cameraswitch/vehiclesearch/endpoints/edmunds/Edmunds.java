package com.cameraswitch.vehiclesearch.endpoints.edmunds;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.cameraswitch.vehiclesearch.Const;
import com.cameraswitch.vehiclesearch.R;
import com.cameraswitch.vehiclesearch.endpoints.edmunds.dealers.Dealers;
import com.cameraswitch.vehiclesearch.endpoints.edmunds.inventory.Inventory;
import com.cameraswitch.vehiclesearch.endpoints.edmunds.media.Photos;

import java.io.File;
import java.io.IOException;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Edmunds {
    public static final String TAG = Edmunds.class.getSimpleName();

    static final public String MEDIA_PREFIX = "https://media.ed.edmunds-media.com";
    static final private String HOST = "https://api.edmunds.com/";

    private final EdmundsApi sService;
    private final Retrofit mRetrofit;
    private static Edmunds sEdmunds;
    private static String sEdmundsApiKey;
    private final Cache mCache;
    private final OkHttpClient mClient;

    static public Edmunds getInstance(Context c) {
        if (sEdmunds == null)
            sEdmunds = new Edmunds(c);
        return sEdmunds;
    }

    public Edmunds (Context c) {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        // caching
        mCache = new Cache(new File(c.getCacheDir(), Const.CACHE_FILENAME), Const.CACHE_FILESIZE);
        mClient = new OkHttpClient.Builder()
                .cache(mCache)
                .addInterceptor(new CacheControlInterceptor(c))
                .build();

        sEdmundsApiKey = c.getString(R.string.edmunds_api_key);
        mRetrofit = new Retrofit.Builder()
                .baseUrl(HOST)
                .client(mClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        sService = mRetrofit.create(EdmundsApi.class);
    }

    private class CacheControlInterceptor implements Interceptor {
        private Context mContext;
        public CacheControlInterceptor(Context c) {
            mContext = c;
        }

        private boolean isNetworkAvailable() {
            ConnectivityManager connectivityManager
                    = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        }

        @Override
        public okhttp3.Response intercept(Chain chain) throws IOException {
            Request request = chain.request();

            // Add Cache Control only for GET methods
            if (request.method().equals("GET")) {
                if (isNetworkAvailable()) {
                    // 1 day
                    request.newBuilder()
                            .header("Cache-Control", "only-if-cached")
                            .build();
                } else {
                    // 4 weeks stale
                    request.newBuilder()
                            .header("Cache-Control", "public, max-stale=2419200")
                            .build();
                }
            }

            okhttp3.Response response = chain.proceed(request);

            // Re-write response CC header to force use of cache
            return response.newBuilder()
                    .header("Cache-Control", "public, max-age=86400") // 1 day
                    .build();
        }
    };

    public void getPhotos(String make, String model, String year,
                          int pagenum, int pagesize,
                          final Edmunds.OnPhotoListener listener) {
        if (model == null || year == null) {
            Call<Photos> response = sService.getPhotosByTags(make,
                    String.valueOf(pagenum), String.valueOf(pagesize), sEdmundsApiKey);
            response.enqueue(new Callback<Photos>() {
                @Override
                public void onResponse(Call<Photos> call, Response<Photos> response) {
                    if (listener != null && response.code() == 200)
                        listener.onPhotosReady(response.body());
                    else
                        Log.i(TAG, "getDealers() onResponse failed " + call);
                }

                @Override
                public void onFailure(Call<Photos> call, Throwable t) {
                    Log.i(TAG, "getPhotos() onFailure " + call);
                }
            });
        } else {
            model = model.replace(" ", "");
            Call<Photos> response = sService.getPhotos(make, model, year,
                    String.valueOf(pagenum), String.valueOf(pagesize), sEdmundsApiKey);
            response.enqueue(new Callback<Photos>() {
                @Override
                public void onResponse(Call<Photos> call, Response<Photos> response) {
                    if (listener != null && response.code() == 200)
                        listener.onPhotosReady(response.body());
                    else
                        Log.i(TAG, "getDealers() onResponse failed " + call);
                }

                @Override
                public void onFailure(Call<Photos> call, Throwable t) {
                    Log.i(TAG, "getPhotos() onFailure " + call);
                }
            });
        }
    }

    public interface OnPhotoListener {
        void onPhotosReady(Photos photos);
    }

    // need an active partner key from Edmunds.com
    public void getInventories(String zipCode, String make, String model, String year,
                       int pagenum, int pagesize,
                       final Edmunds.OnInventoryListener listener) {
        model = model.replace(" " , "");
        Call<Inventory> response = sService.getInventories(zipCode, make, model, year,
                String.valueOf(pagenum), String.valueOf(pagesize), sEdmundsApiKey);

        response.enqueue(new Callback<Inventory>() {
            @Override
            public void onResponse(Call<Inventory> call, Response<Inventory> response) {
                if (listener != null && response.code() == 200)
                    listener.onInventoryReady(response.body());
                else
                    Log.i(TAG, "getDealers() onResponse failed " + call);
            }

            @Override
            public void onFailure(Call<Inventory> call, Throwable t) {
                Log.i(TAG, "getInventories() onFailure " + call);
            }
        });
    }

    public interface OnInventoryListener {
        void onInventoryReady(Inventory inventory);
    }

    public void getDealers(String zipCode, String make,
                           int pagenum, int pagesize,
                           final Edmunds.OnDealersListener listener) {
        Call<Dealers> response = sService.getDealers(zipCode, make,
                String.valueOf(pagenum), String.valueOf(pagesize), sEdmundsApiKey);

        response.enqueue(new Callback<Dealers>() {
            @Override
            public void onResponse(Call<Dealers> call, Response<Dealers> response) {
                if (listener != null && response.code() == 200)
                    listener.onDealersReady(response.body());
                else
                    Log.i(TAG, "getDealers() onResponse failed " + call);
            }

            @Override
            public void onFailure(Call<Dealers> call, Throwable t) {
                Log.i(TAG, "getDealers() onFailure " + call);
            }
        });
    }

    public interface OnDealersListener {
        void onDealersReady(Dealers inventory);
    }
}
