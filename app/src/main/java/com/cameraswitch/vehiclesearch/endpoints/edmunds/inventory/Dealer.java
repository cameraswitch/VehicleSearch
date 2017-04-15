
package com.cameraswitch.vehiclesearch.endpoints.edmunds.inventory;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Dealer implements Parcelable
{

    @SerializedName("dealerId")
    @Expose
    private String dealerId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("franchiseId")
    @Expose
    private String franchiseId;
    @SerializedName("address")
    @Expose
    private Address address;
    @SerializedName("premier")
    @Expose
    private Boolean premier;
    @SerializedName("link")
    @Expose
    private Link____ link;
    public final static Parcelable.Creator<Dealer> CREATOR = new Creator<Dealer>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Dealer createFromParcel(Parcel in) {
            Dealer instance = new Dealer();
            instance.dealerId = ((String) in.readValue((String.class.getClassLoader())));
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            instance.franchiseId = ((String) in.readValue((String.class.getClassLoader())));
            instance.address = ((Address) in.readValue((Address.class.getClassLoader())));
            instance.premier = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            instance.link = ((Link____) in.readValue((Link____.class.getClassLoader())));
            return instance;
        }

        public Dealer[] newArray(int size) {
            return (new Dealer[size]);
        }

    }
    ;

    public String getDealerId() {
        return dealerId;
    }

    public void setDealerId(String dealerId) {
        this.dealerId = dealerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFranchiseId() {
        return franchiseId;
    }

    public void setFranchiseId(String franchiseId) {
        this.franchiseId = franchiseId;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Boolean getPremier() {
        return premier;
    }

    public void setPremier(Boolean premier) {
        this.premier = premier;
    }

    public Link____ getLink() {
        return link;
    }

    public void setLink(Link____ link) {
        this.link = link;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(dealerId);
        dest.writeValue(name);
        dest.writeValue(franchiseId);
        dest.writeValue(address);
        dest.writeValue(premier);
        dest.writeValue(link);
    }

    public int describeContents() {
        return  0;
    }

}
