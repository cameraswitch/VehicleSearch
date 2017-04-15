
package com.cameraswitch.vehiclesearch.endpoints.edmunds.inventory;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Link_____ implements Parcelable
{

    @SerializedName("rel")
    @Expose
    private String rel;
    @SerializedName("href")
    @Expose
    private String href;
    public final static Parcelable.Creator<Link_____> CREATOR = new Creator<Link_____>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Link_____ createFromParcel(Parcel in) {
            Link_____ instance = new Link_____();
            instance.rel = ((String) in.readValue((String.class.getClassLoader())));
            instance.href = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Link_____[] newArray(int size) {
            return (new Link_____[size]);
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
