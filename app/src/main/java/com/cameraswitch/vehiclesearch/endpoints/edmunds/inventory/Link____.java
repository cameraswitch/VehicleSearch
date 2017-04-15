
package com.cameraswitch.vehiclesearch.endpoints.edmunds.inventory;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Link____ implements Parcelable
{

    @SerializedName("rel")
    @Expose
    private String rel;
    @SerializedName("href")
    @Expose
    private String href;
    public final static Parcelable.Creator<Link____> CREATOR = new Creator<Link____>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Link____ createFromParcel(Parcel in) {
            Link____ instance = new Link____();
            instance.rel = ((String) in.readValue((String.class.getClassLoader())));
            instance.href = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Link____[] newArray(int size) {
            return (new Link____[size]);
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
