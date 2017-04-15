
package com.cameraswitch.vehiclesearch.endpoints.edmunds.inventory;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Videos implements Parcelable
{

    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("links")
    @Expose
    private List<Link___> links = null;
    public final static Parcelable.Creator<Videos> CREATOR = new Creator<Videos>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Videos createFromParcel(Parcel in) {
            Videos instance = new Videos();
            instance.count = ((Integer) in.readValue((Integer.class.getClassLoader())));
            in.readList(instance.links, (com.cameraswitch.vehiclesearch.endpoints.edmunds.inventory.Link___.class.getClassLoader()));
            return instance;
        }

        public Videos[] newArray(int size) {
            return (new Videos[size]);
        }

    }
    ;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Link___> getLinks() {
        return links;
    }

    public void setLinks(List<Link___> links) {
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
