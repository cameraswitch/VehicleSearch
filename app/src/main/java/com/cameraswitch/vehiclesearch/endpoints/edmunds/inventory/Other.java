
package com.cameraswitch.vehiclesearch.endpoints.edmunds.inventory;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Other implements Parcelable
{

    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("links")
    @Expose
    private List<Link__> links = null;
    public final static Parcelable.Creator<Other> CREATOR = new Creator<Other>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Other createFromParcel(Parcel in) {
            Other instance = new Other();
            instance.count = ((Integer) in.readValue((Integer.class.getClassLoader())));
            in.readList(instance.links, (com.cameraswitch.vehiclesearch.endpoints.edmunds.inventory.Link__.class.getClassLoader()));
            return instance;
        }

        public Other[] newArray(int size) {
            return (new Other[size]);
        }

    }
    ;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Link__> getLinks() {
        return links;
    }

    public void setLinks(List<Link__> links) {
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
