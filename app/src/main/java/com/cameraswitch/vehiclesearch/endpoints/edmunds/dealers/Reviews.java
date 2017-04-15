
package com.cameraswitch.vehiclesearch.endpoints.edmunds.dealers;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Reviews implements Parcelable
{

    @SerializedName("sales")
    @Expose
    private Sales sales;
    @SerializedName("service")
    @Expose
    private Service service;
    public final static Parcelable.Creator<Reviews> CREATOR = new Creator<Reviews>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Reviews createFromParcel(Parcel in) {
            Reviews instance = new Reviews();
            instance.sales = ((Sales) in.readValue((Sales.class.getClassLoader())));
            instance.service = ((Service) in.readValue((Service.class.getClassLoader())));
            return instance;
        }

        public Reviews[] newArray(int size) {
            return (new Reviews[size]);
        }

    }
    ;

    public Sales getSales() {
        return sales;
    }

    public void setSales(Sales sales) {
        this.sales = sales;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(sales);
        dest.writeValue(service);
    }

    public int describeContents() {
        return  0;
    }

}
