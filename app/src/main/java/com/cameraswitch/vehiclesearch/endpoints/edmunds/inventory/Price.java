
package com.cameraswitch.vehiclesearch.endpoints.edmunds.inventory;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Price implements Parcelable
{

    @SerializedName("baseMSRP")
    @Expose
    private Integer baseMSRP;
    @SerializedName("baseInvoice")
    @Expose
    private Integer baseInvoice;
    @SerializedName("estimateTmv")
    @Expose
    private Boolean estimateTmv;
    public final static Parcelable.Creator<Price> CREATOR = new Creator<Price>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Price createFromParcel(Parcel in) {
            Price instance = new Price();
            instance.baseMSRP = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.baseInvoice = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.estimateTmv = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            return instance;
        }

        public Price[] newArray(int size) {
            return (new Price[size]);
        }

    }
    ;

    public Integer getBaseMSRP() {
        return baseMSRP;
    }

    public void setBaseMSRP(Integer baseMSRP) {
        this.baseMSRP = baseMSRP;
    }

    public Integer getBaseInvoice() {
        return baseInvoice;
    }

    public void setBaseInvoice(Integer baseInvoice) {
        this.baseInvoice = baseInvoice;
    }

    public Boolean getEstimateTmv() {
        return estimateTmv;
    }

    public void setEstimateTmv(Boolean estimateTmv) {
        this.estimateTmv = estimateTmv;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(baseMSRP);
        dest.writeValue(baseInvoice);
        dest.writeValue(estimateTmv);
    }

    public int describeContents() {
        return  0;
    }

}
