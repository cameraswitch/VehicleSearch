
package com.cameraswitch.vehiclesearch.endpoints.edmunds.inventory;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Photos implements Parcelable
{

    @SerializedName("thumbnails")
    @Expose
    private Thumbnails thumbnails;
    @SerializedName("other")
    @Expose
    private Other other;
    public final static Parcelable.Creator<Photos> CREATOR = new Creator<Photos>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Photos createFromParcel(Parcel in) {
            Photos instance = new Photos();
            instance.thumbnails = ((Thumbnails) in.readValue((Thumbnails.class.getClassLoader())));
            instance.other = ((Other) in.readValue((Other.class.getClassLoader())));
            return instance;
        }

        public Photos[] newArray(int size) {
            return (new Photos[size]);
        }

    }
    ;

    public Thumbnails getThumbnails() {
        return thumbnails;
    }

    public void setThumbnails(Thumbnails thumbnails) {
        this.thumbnails = thumbnails;
    }

    public Other getOther() {
        return other;
    }

    public void setOther(Other other) {
        this.other = other;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(thumbnails);
        dest.writeValue(other);
    }

    public int describeContents() {
        return  0;
    }

}
