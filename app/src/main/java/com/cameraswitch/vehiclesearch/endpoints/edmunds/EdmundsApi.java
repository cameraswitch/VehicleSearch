package com.cameraswitch.vehiclesearch.endpoints.edmunds;

import com.cameraswitch.vehiclesearch.endpoints.edmunds.dealers.Dealers;
import com.cameraswitch.vehiclesearch.endpoints.edmunds.inventory.Inventory;
import com.cameraswitch.vehiclesearch.endpoints.edmunds.media.Photos;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface EdmundsApi {

    //https://api.edmunds.com/api/media/v2/audi/a3/2015/photos?pagenum=1&pagesize=10&view=basic&fmt=json&api_key=key

    @GET("api/media/v2/{make}/{model}/{year}/photos?view=basic&fmt=json")
    Call<Photos> getPhotos(@Path("make") String make,
                           @Path("model") String model,
                           @Path("year") String year,
                           @Query("pagenum") String pagenum,
                           @Query("pagesize") String pagesize,
                           @Query("api_key") String key);

    //https://api.edmunds.com/api/media/v2/photoset?tag=Tesla&category=interior&pagenum=1&pagesize=10&view=basic&fmt=json&api_key=key
    @GET("api/media/v2/photoset?view=basic&fmt=json")
    Call<Photos> getPhotosByTags(@Query("tag") String tag,
                                 @Query("pagenum") String pagenum,
                                 @Query("pagesize") String pagesize,
                                 @Query("api_key") String key);


    //https://api.edmunds.com/api/inventory/v2/inventories?zipcode=90404&radius=50&make=Audi&model=A4&year=2015&type=new&pagenum=1&pagesize=10&sortby=distance%3Aasc&view=basic&fmt=json

    @GET("api/inventory/v2/inventories?fmt=json&type=new&sortby=distance%3Aasc&view=basic")
    Call<Inventory> getInventories(@Query("zipcode") String zipcode,
                                   @Query("make") String make,
                                   @Query("model") String model,
                                   @Query("year") String year,
                                   @Query("pagenum") String pagenum,
                                   @Query("pagesize") String pagesize,
                                   @Query("api_key") String key);

    //http://api.edmunds.com/api/dealer/v2/dealers/?zipcode=90404&radius=100&make=audi&state=new&pageNum=1&pageSize=10&sortby=distance%3AASC&view=basic&api_key=key

    @GET("api/dealer/v2/dealers/?radius=100&state=new&sortby=distance:ASC&view=basic")
    Call<Dealers> getDealers(@Query("zipcode") String zipcode,
                             @Query("make") String make,
                             @Query("pagenum") String pagenum,
                             @Query("pagesize") String pagesize,
                             @Query("api_key") String key);

}
