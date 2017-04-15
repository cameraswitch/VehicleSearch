
package com.cameraswitch.vehiclesearch.endpoints.edmunds.inventory;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Link_ implements Parcelable
{

    @SerializedName("rel")
    @Expose
    private String rel;
    @SerializedName("href")
    @Expose
    private String href;
    @SerializedName("size")
    @Expose
    private String size;
    public final static Parcelable.Creator<Link_> CREATOR = new Creator<Link_>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Link_ createFromParcel(Parcel in) {
            Link_ instance = new Link_();
            instance.rel = ((String) in.readValue((String.class.getClassLoader())));
            instance.href = ((String) in.readValue((String.class.getClassLoader())));
            instance.size = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Link_[] newArray(int size) {
            return (new Link_[size]);
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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(rel);
        dest.writeValue(href);
        dest.writeValue(size);
    }

    public int describeContents() {
        return  0;
    }

}
