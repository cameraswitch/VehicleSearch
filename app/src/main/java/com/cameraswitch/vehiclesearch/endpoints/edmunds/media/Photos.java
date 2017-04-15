
package com.cameraswitch.vehiclesearch.endpoints.edmunds.media;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Photos implements Parcelable
{

    @SerializedName("photos")
    @Expose
    private List<Photo> photos = null;
    @SerializedName("photosCount")
    @Expose
    private Integer photosCount;
    @SerializedName("links")
    @Expose
    private List<Link_> links = null;
    public final static Parcelable.Creator<Photos> CREATOR = new Creator<Photos>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Photos createFromParcel(Parcel in) {
            Photos instance = new Photos();
            in.readList(instance.photos, (Photo.class.getClassLoader()));
            instance.photosCount = ((Integer) in.readValue((Integer.class.getClassLoader())));
            in.readList(instance.links, (Link_.class.getClassLoader()));
            return instance;
        }

        public Photos[] newArray(int size) {
            return (new Photos[size]);
        }

    }
    ;

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public Integer getPhotosCount() {
        return photosCount;
    }

    public void setPhotosCount(Integer photosCount) {
        this.photosCount = photosCount;
    }

    public List<Link_> getLinks() {
        return links;
    }

    public void setLinks(List<Link_> links) {
        this.links = links;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(photos);
        dest.writeValue(photosCount);
        dest.writeList(links);
    }

    public int describeContents() {
        return  0;
    }

}
