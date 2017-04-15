
package com.cameraswitch.vehiclesearch.endpoints.edmunds.inventory;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Prices implements Parcelable
{

    @SerializedName("msrp")
    @Expose
    private Integer msrp;
    @SerializedName("tmv")
    @Expose
    private Integer tmv;
    @SerializedName("invoice")
    @Expose
    private Integer invoice;
    @SerializedName("guaranteedPrice")
    @Expose
    private Integer guaranteedPrice;
    public final static Parcelable.Creator<Prices> CREATOR = new Creator<Prices>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Prices createFromParcel(Parcel in) {
            Prices instance = new Prices();
            instance.msrp = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.tmv = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.invoice = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.guaranteedPrice = ((Integer) in.readValue((Integer.class.getClassLoader())));
            return instance;
        }

        public Prices[] newArray(int size) {
            return (new Prices[size]);
        }

    }
    ;

    public Integer getMsrp() {
        return msrp;
    }

    public void setMsrp(Integer msrp) {
        this.msrp = msrp;
    }

    public Integer getTmv() {
        return tmv;
    }

    public void setTmv(Integer tmv) {
        this.tmv = tmv;
    }

    public Integer getInvoice() {
        return invoice;
    }

    public void setInvoice(Integer invoice) {
        this.invoice = invoice;
    }

    public Integer getGuaranteedPrice() {
        return guaranteedPrice;
    }

    public void setGuaranteedPrice(Integer guaranteedPrice) {
        this.guaranteedPrice = guaranteedPrice;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(msrp);
        dest.writeValue(tmv);
        dest.writeValue(invoice);
        dest.writeValue(guaranteedPrice);
    }

    public int describeContents() {
        return  0;
    }

}
