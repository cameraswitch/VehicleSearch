
package com.cameraswitch.vehiclesearch.endpoints.edmunds.inventory;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Make implements Parcelable
{

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("niceName")
    @Expose
    private String niceName;
    public final static Parcelable.Creator<Make> CREATOR = new Creator<Make>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Make createFromParcel(Parcel in) {
            Make instance = new Make();
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            instance.niceName = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Make[] newArray(int size) {
            return (new Make[size]);
        }

    }
    ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNiceName() {
        return niceName;
    }

    public void setNiceName(String niceName) {
        this.niceName = niceName;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(name);
        dest.writeValue(niceName);
    }

    public int describeContents() {
        return  0;
    }

}
