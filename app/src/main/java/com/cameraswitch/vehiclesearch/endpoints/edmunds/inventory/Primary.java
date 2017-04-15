
package com.cameraswitch.vehiclesearch.endpoints.edmunds.inventory;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Primary implements Parcelable
{

    @SerializedName("r")
    @Expose
    private Integer r;
    @SerializedName("g")
    @Expose
    private Integer g;
    @SerializedName("b")
    @Expose
    private Integer b;
    @SerializedName("hex")
    @Expose
    private String hex;
    public final static Parcelable.Creator<Primary> CREATOR = new Creator<Primary>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Primary createFromParcel(Parcel in) {
            Primary instance = new Primary();
            instance.r = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.g = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.b = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.hex = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Primary[] newArray(int size) {
            return (new Primary[size]);
        }

    }
    ;

    public Integer getR() {
        return r;
    }

    public void setR(Integer r) {
        this.r = r;
    }

    public Integer getG() {
        return g;
    }

    public void setG(Integer g) {
        this.g = g;
    }

    public Integer getB() {
        return b;
    }

    public void setB(Integer b) {
        this.b = b;
    }

    public String getHex() {
        return hex;
    }

    public void setHex(String hex) {
        this.hex = hex;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(r);
        dest.writeValue(g);
        dest.writeValue(b);
        dest.writeValue(hex);
    }

    public int describeContents() {
        return  0;
    }

}
