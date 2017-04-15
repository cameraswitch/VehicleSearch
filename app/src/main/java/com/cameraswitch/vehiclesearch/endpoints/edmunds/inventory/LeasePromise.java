
package com.cameraswitch.vehiclesearch.endpoints.edmunds.inventory;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LeasePromise implements Parcelable
{

    @SerializedName("active")
    @Expose
    private Boolean active;
    public final static Parcelable.Creator<LeasePromise> CREATOR = new Creator<LeasePromise>() {


        @SuppressWarnings({
            "unchecked"
        })
        public LeasePromise createFromParcel(Parcel in) {
            LeasePromise instance = new LeasePromise();
            instance.active = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            return instance;
        }

        public LeasePromise[] newArray(int size) {
            return (new LeasePromise[size]);
        }

    }
    ;

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(active);
    }

    public int describeContents() {
        return  0;
    }

}
