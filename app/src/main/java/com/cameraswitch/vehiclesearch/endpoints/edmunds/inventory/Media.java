
package com.cameraswitch.vehiclesearch.endpoints.edmunds.inventory;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Media implements Parcelable
{

    @SerializedName("photos")
    @Expose
    private Photos photos;
    @SerializedName("videos")
    @Expose
    private Videos videos;
    public final static Parcelable.Creator<Media> CREATOR = new Creator<Media>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Media createFromParcel(Parcel in) {
            Media instance = new Media();
            instance.photos = ((Photos) in.readValue((Photos.class.getClassLoader())));
            instance.videos = ((Videos) in.readValue((Videos.class.getClassLoader())));
            return instance;
        }

        public Media[] newArray(int size) {
            return (new Media[size]);
        }

    }
    ;

    public Photos getPhotos() {
        return photos;
    }

    public void setPhotos(Photos photos) {
        this.photos = photos;
    }

    public Videos getVideos() {
        return videos;
    }

    public void setVideos(Videos videos) {
        this.videos = videos;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(photos);
        dest.writeValue(videos);
    }

    public int describeContents() {
        return  0;
    }

}
