
package com.cameraswitch.vehiclesearch.endpoints.edmunds.inventory;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ColorChips implements Parcelable
{

    @SerializedName("primary")
    @Expose
    private Primary primary;
    public final static Parcelable.Creator<ColorChips> CREATOR = new Creator<ColorChips>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ColorChips createFromParcel(Parcel in) {
            ColorChips instance = new ColorChips();
            instance.primary = ((Primary) in.readValue((Primary.class.getClassLoader())));
            return instance;
        }

        public ColorChips[] newArray(int size) {
            return (new ColorChips[size]);
        }

    }
    ;

    public Primary getPrimary() {
        return primary;
    }

    public void setPrimary(Primary primary) {
        this.primary = primary;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(primary);
    }

    public int describeContents() {
        return  0;
    }

}
