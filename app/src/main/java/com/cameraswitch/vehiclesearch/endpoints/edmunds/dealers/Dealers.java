
package com.cameraswitch.vehiclesearch.endpoints.edmunds.dealers;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Dealers implements Parcelable
{

    @SerializedName("dealers")
    @Expose
    private List<Dealer> dealers = null;
    @SerializedName("dealersCount")
    @Expose
    private Integer dealersCount;
    @SerializedName("links")
    @Expose
    private List<Link> links = null;
    public final static Parcelable.Creator<Dealers> CREATOR = new Creator<Dealers>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Dealers createFromParcel(Parcel in) {
            Dealers instance = new Dealers();
            in.readList(instance.dealers, (com.cameraswitch.vehiclesearch.endpoints.edmunds.dealers.Dealer.class.getClassLoader()));
            instance.dealersCount = ((Integer) in.readValue((Integer.class.getClassLoader())));
            in.readList(instance.links, (com.cameraswitch.vehiclesearch.endpoints.edmunds.dealers.Link.class.getClassLoader()));
            return instance;
        }

        public Dealers[] newArray(int size) {
            return (new Dealers[size]);
        }

    }
    ;

    public List<Dealer> getDealers() {
        return dealers;
    }

    public void setDealers(List<Dealer> dealers) {
        this.dealers = dealers;
    }

    public Integer getDealersCount() {
        return dealersCount;
    }

    public void setDealersCount(Integer dealersCount) {
        this.dealersCount = dealersCount;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(dealers);
        dest.writeValue(dealersCount);
        dest.writeList(links);
    }

    public int describeContents() {
        return  0;
    }

}
