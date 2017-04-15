
package com.cameraswitch.vehiclesearch.endpoints.edmunds.inventory;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Programs implements Parcelable
{

    @SerializedName("leasePromise")
    @Expose
    private LeasePromise leasePromise;
    @SerializedName("pricePromise")
    @Expose
    private PricePromise pricePromise;
    public final static Parcelable.Creator<Programs> CREATOR = new Creator<Programs>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Programs createFromParcel(Parcel in) {
            Programs instance = new Programs();
            instance.leasePromise = ((LeasePromise) in.readValue((LeasePromise.class.getClassLoader())));
            instance.pricePromise = ((PricePromise) in.readValue((PricePromise.class.getClassLoader())));
            return instance;
        }

        public Programs[] newArray(int size) {
            return (new Programs[size]);
        }

    }
    ;

    public LeasePromise getLeasePromise() {
        return leasePromise;
    }

    public void setLeasePromise(LeasePromise leasePromise) {
        this.leasePromise = leasePromise;
    }

    public PricePromise getPricePromise() {
        return pricePromise;
    }

    public void setPricePromise(PricePromise pricePromise) {
        this.pricePromise = pricePromise;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(leasePromise);
        dest.writeValue(pricePromise);
    }

    public int describeContents() {
        return  0;
    }

}
