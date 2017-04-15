
package com.cameraswitch.vehiclesearch.endpoints.edmunds.inventory;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Year implements Parcelable
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("year")
    @Expose
    private Integer year;
    public final static Parcelable.Creator<Year> CREATOR = new Creator<Year>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Year createFromParcel(Parcel in) {
            Year instance = new Year();
            instance.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.year = ((Integer) in.readValue((Integer.class.getClassLoader())));
            return instance;
        }

        public Year[] newArray(int size) {
            return (new Year[size]);
        }

    }
    ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(year);
    }

    public int describeContents() {
        return  0;
    }

}
