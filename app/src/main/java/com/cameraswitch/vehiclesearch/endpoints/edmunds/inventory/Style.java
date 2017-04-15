
package com.cameraswitch.vehiclesearch.endpoints.edmunds.inventory;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Style implements Parcelable
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("submodel")
    @Expose
    private Submodel submodel;
    @SerializedName("trim")
    @Expose
    private String trim;
    @SerializedName("link")
    @Expose
    private Link link;
    public final static Parcelable.Creator<Style> CREATOR = new Creator<Style>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Style createFromParcel(Parcel in) {
            Style instance = new Style();
            instance.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            instance.submodel = ((Submodel) in.readValue((Submodel.class.getClassLoader())));
            instance.trim = ((String) in.readValue((String.class.getClassLoader())));
            instance.link = ((Link) in.readValue((Link.class.getClassLoader())));
            return instance;
        }

        public Style[] newArray(int size) {
            return (new Style[size]);
        }

    }
    ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Submodel getSubmodel() {
        return submodel;
    }

    public void setSubmodel(Submodel submodel) {
        this.submodel = submodel;
    }

    public String getTrim() {
        return trim;
    }

    public void setTrim(String trim) {
        this.trim = trim;
    }

    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeValue(submodel);
        dest.writeValue(trim);
        dest.writeValue(link);
    }

    public int describeContents() {
        return  0;
    }

}
