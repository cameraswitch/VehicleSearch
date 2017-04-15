
package com.cameraswitch.vehiclesearch.endpoints.edmunds.dealers;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Operations implements Parcelable
{

    @SerializedName("Wednesday")
    @Expose
    private String wednesday;
    @SerializedName("Thursday")
    @Expose
    private String thursday;
    @SerializedName("Tuesday")
    @Expose
    private String tuesday;
    @SerializedName("Saturday")
    @Expose
    private String saturday;
    @SerializedName("Friday")
    @Expose
    private String friday;
    @SerializedName("Monday")
    @Expose
    private String monday;
    @SerializedName("Sunday")
    @Expose
    private String sunday;
    public final static Parcelable.Creator<Operations> CREATOR = new Creator<Operations>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Operations createFromParcel(Parcel in) {
            Operations instance = new Operations();
            instance.wednesday = ((String) in.readValue((String.class.getClassLoader())));
            instance.thursday = ((String) in.readValue((String.class.getClassLoader())));
            instance.tuesday = ((String) in.readValue((String.class.getClassLoader())));
            instance.saturday = ((String) in.readValue((String.class.getClassLoader())));
            instance.friday = ((String) in.readValue((String.class.getClassLoader())));
            instance.monday = ((String) in.readValue((String.class.getClassLoader())));
            instance.sunday = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Operations[] newArray(int size) {
            return (new Operations[size]);
        }

    }
    ;

    public String getWednesday() {
        return wednesday;
    }

    public void setWednesday(String wednesday) {
        this.wednesday = wednesday;
    }

    public String getThursday() {
        return thursday;
    }

    public void setThursday(String thursday) {
        this.thursday = thursday;
    }

    public String getTuesday() {
        return tuesday;
    }

    public void setTuesday(String tuesday) {
        this.tuesday = tuesday;
    }

    public String getSaturday() {
        return saturday;
    }

    public void setSaturday(String saturday) {
        this.saturday = saturday;
    }

    public String getFriday() {
        return friday;
    }

    public void setFriday(String friday) {
        this.friday = friday;
    }

    public String getMonday() {
        return monday;
    }

    public void setMonday(String monday) {
        this.monday = monday;
    }

    public String getSunday() {
        return sunday;
    }

    public void setSunday(String sunday) {
        this.sunday = sunday;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(wednesday);
        dest.writeValue(thursday);
        dest.writeValue(tuesday);
        dest.writeValue(saturday);
        dest.writeValue(friday);
        dest.writeValue(monday);
        dest.writeValue(sunday);
    }

    public int describeContents() {
        return  0;
    }

}
