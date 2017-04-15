
package com.cameraswitch.vehiclesearch.endpoints.edmunds.inventory;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Link___ implements Parcelable
{

    @SerializedName("rel")
    @Expose
    private String rel;
    @SerializedName("href")
    @Expose
    private String href;
    public final static Parcelable.Creator<Link___> CREATOR = new Creator<Link___>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Link___ createFromParcel(Parcel in) {
            Link___ instance = new Link___();
            instance.rel = ((String) in.readValue((String.class.getClassLoader())));
            instance.href = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Link___[] newArray(int size) {
            return (new Link___[size]);
        }

    }
    ;

    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(rel);
        dest.writeValue(href);
    }

    public int describeContents() {
        return  0;
    }

}
