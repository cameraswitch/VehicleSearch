
package com.cameraswitch.vehiclesearch.endpoints.edmunds.inventory;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PricePromise implements Parcelable
{

    @SerializedName("active")
    @Expose
    private Boolean active;
    @SerializedName("disclaimer")
    @Expose
    private String disclaimer;
    public final static Parcelable.Creator<PricePromise> CREATOR = new Creator<PricePromise>() {


        @SuppressWarnings({
            "unchecked"
        })
        public PricePromise createFromParcel(Parcel in) {
            PricePromise instance = new PricePromise();
            instance.active = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            instance.disclaimer = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public PricePromise[] newArray(int size) {
            return (new PricePromise[size]);
        }

    }
    ;

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getDisclaimer() {
        return disclaimer;
    }

    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(active);
        dest.writeValue(disclaimer);
    }

    public int describeContents() {
        return  0;
    }

}
