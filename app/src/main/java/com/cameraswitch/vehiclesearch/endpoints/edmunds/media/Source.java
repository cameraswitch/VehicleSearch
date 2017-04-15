
package com.cameraswitch.vehiclesearch.endpoints.edmunds.media;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Source implements Parcelable
{

    @SerializedName("link")
    @Expose
    private Link link;
    @SerializedName("extension")
    @Expose
    private String extension;
    @SerializedName("size")
    @Expose
    private Size size;
    public final static Parcelable.Creator<Source> CREATOR = new Creator<Source>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Source createFromParcel(Parcel in) {
            Source instance = new Source();
            instance.link = ((Link) in.readValue((Link.class.getClassLoader())));
            instance.extension = ((String) in.readValue((String.class.getClassLoader())));
            instance.size = ((Size) in.readValue((Size.class.getClassLoader())));
            return instance;
        }

        public Source[] newArray(int size) {
            return (new Source[size]);
        }

    }
    ;

    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(link);
        dest.writeValue(extension);
        dest.writeValue(size);
    }

    public int describeContents() {
        return  0;
    }

}
