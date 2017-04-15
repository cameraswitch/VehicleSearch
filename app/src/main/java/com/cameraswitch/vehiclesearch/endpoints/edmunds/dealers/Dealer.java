
package com.cameraswitch.vehiclesearch.endpoints.edmunds.dealers;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Dealer implements Parcelable
{

    @SerializedName("active")
    @Expose
    private Boolean active;
    @SerializedName("dealerId")
    @Expose
    private String dealerId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("niceName")
    @Expose
    private String niceName;
    @SerializedName("distance")
    @Expose
    private Double distance;
    @SerializedName("operations")
    @Expose
    private Operations operations;
    @SerializedName("address")
    @Expose
    private Address address;
    @SerializedName("contactInfo")
    @Expose
    private ContactInfo contactInfo;
    @SerializedName("reviews")
    @Expose
    private Reviews reviews;
    @SerializedName("states")
    @Expose
    private List<String> states = null;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("fiveStarAwardYears")
    @Expose
    private String fiveStarAwardYears;
    public final static Parcelable.Creator<Dealer> CREATOR = new Creator<Dealer>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Dealer createFromParcel(Parcel in) {
            Dealer instance = new Dealer();
            instance.active = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            instance.dealerId = ((String) in.readValue((String.class.getClassLoader())));
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            instance.niceName = ((String) in.readValue((String.class.getClassLoader())));
            instance.distance = ((Double) in.readValue((Double.class.getClassLoader())));
            instance.operations = ((Operations) in.readValue((Operations.class.getClassLoader())));
            instance.address = ((Address) in.readValue((Address.class.getClassLoader())));
            instance.contactInfo = ((ContactInfo) in.readValue((ContactInfo.class.getClassLoader())));
            instance.reviews = ((Reviews) in.readValue((Reviews.class.getClassLoader())));
            in.readList(instance.states, (java.lang.String.class.getClassLoader()));
            instance.type = ((String) in.readValue((String.class.getClassLoader())));
            instance.fiveStarAwardYears = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Dealer[] newArray(int size) {
            return (new Dealer[size]);
        }

    }
    ;

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

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

    public String getNiceName() {
        return niceName;
    }

    public void setNiceName(String niceName) {
        this.niceName = niceName;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Operations getOperations() {
        return operations;
    }

    public void setOperations(Operations operations) {
        this.operations = operations;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

    public Reviews getReviews() {
        return reviews;
    }

    public void setReviews(Reviews reviews) {
        this.reviews = reviews;
    }

    public List<String> getStates() {
        return states;
    }

    public void setStates(List<String> states) {
        this.states = states;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFiveStarAwardYears() {
        return fiveStarAwardYears;
    }

    public void setFiveStarAwardYears(String fiveStarAwardYears) {
        this.fiveStarAwardYears = fiveStarAwardYears;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(active);
        dest.writeValue(dealerId);
        dest.writeValue(name);
        dest.writeValue(niceName);
        dest.writeValue(distance);
        dest.writeValue(operations);
        dest.writeValue(address);
        dest.writeValue(contactInfo);
        dest.writeValue(reviews);
        dest.writeList(states);
        dest.writeValue(type);
        dest.writeValue(fiveStarAwardYears);
    }

    public int describeContents() {
        return  0;
    }

}
