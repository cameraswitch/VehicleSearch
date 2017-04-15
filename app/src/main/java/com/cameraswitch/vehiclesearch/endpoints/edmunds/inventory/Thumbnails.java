
package com.cameraswitch.vehiclesearch.endpoints.edmunds.inventory;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Thumbnails implements Parcelable
{

    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("links")
    @Expose
    private List<Link_> links = null;
    public final static Parcelable.Creator<Thumbnails> CREATOR = new Creator<Thumbnails>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Thumbnails createFromParcel(Parcel in) {
            Thumbnails instance = new Thumbnails();
            instance.count = ((Integer) in.readValue((Integer.class.getClassLoader())));
            in.readList(instance.links, (com.cameraswitch.vehiclesearch.endpoints.edmunds.inventory.Link_.class.getClassLoader()));
            return instance;
        }

        public Thumbnails[] newArray(int size) {
            return (new Thumbnails[size]);
        }

    }
    ;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Link_> getLinks() {
        return links;
    }

    public void setLinks(List<Link_> links) {
        this.links = links;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(count);
        dest.writeList(links);
    }

    public int describeContents() {
        return  0;
    }

}
