
package com.cameraswitch.vehiclesearch.endpoints.edmunds.inventory;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Mpg implements Parcelable
{

    @SerializedName("highway")
    @Expose
    private String highway;
    @SerializedName("city")
    @Expose
    private String city;
    public final static Parcelable.Creator<Mpg> CREATOR = new Creator<Mpg>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Mpg createFromParcel(Parcel in) {
            Mpg instance = new Mpg();
            instance.highway = ((String) in.readValue((String.class.getClassLoader())));
            instance.city = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Mpg[] newArray(int size) {
            return (new Mpg[size]);
        }

    }
    ;

    public String getHighway() {
        return highway;
    }

    public void setHighway(String highway) {
        this.highway = highway;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(highway);
        dest.writeValue(city);
    }

    public int describeContents() {
        return  0;
    }

}
