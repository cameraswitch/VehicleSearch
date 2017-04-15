
package com.cameraswitch.vehiclesearch.endpoints.edmunds.media;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Photo implements Parcelable
{

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("tags")
    @Expose
    private List<String> tags = null;
    @SerializedName("provider")
    @Expose
    private String provider;
    @SerializedName("sources")
    @Expose
    private List<Source> sources = null;
    @SerializedName("makes")
    @Expose
    private List<String> makes = null;
    @SerializedName("models")
    @Expose
    private List<String> models = null;
    @SerializedName("years")
    @Expose
    private List<String> years = null;
    @SerializedName("color")
    @Expose
    private String color;
    @SerializedName("submodels")
    @Expose
    private List<String> submodels = null;
    @SerializedName("shotTypeAbbreviation")
    @Expose
    private String shotTypeAbbreviation;
    @SerializedName("styleIds")
    @Expose
    private List<String> styleIds = null;
    @SerializedName("exactStyleIds")
    @Expose
    private List<String> exactStyleIds = null;
    public final static Parcelable.Creator<Photo> CREATOR = new Creator<Photo>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Photo createFromParcel(Parcel in) {
            Photo instance = new Photo();
            instance.title = ((String) in.readValue((String.class.getClassLoader())));
            instance.category = ((String) in.readValue((String.class.getClassLoader())));
            in.readList(instance.tags, (java.lang.String.class.getClassLoader()));
            instance.provider = ((String) in.readValue((String.class.getClassLoader())));
            in.readList(instance.sources, (Source.class.getClassLoader()));
            in.readList(instance.makes, (java.lang.String.class.getClassLoader()));
            in.readList(instance.models, (java.lang.String.class.getClassLoader()));
            in.readList(instance.years, (java.lang.String.class.getClassLoader()));
            instance.color = ((String) in.readValue((String.class.getClassLoader())));
            in.readList(instance.submodels, (java.lang.String.class.getClassLoader()));
            instance.shotTypeAbbreviation = ((String) in.readValue((String.class.getClassLoader())));
            in.readList(instance.styleIds, (java.lang.String.class.getClassLoader()));
            in.readList(instance.exactStyleIds, (java.lang.String.class.getClassLoader()));
            return instance;
        }

        public Photo[] newArray(int size) {
            return (new Photo[size]);
        }

    }
    ;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public List<Source> getSources() {
        return sources;
    }

    public void setSources(List<Source> sources) {
        this.sources = sources;
    }

    public List<String> getMakes() {
        return makes;
    }

    public void setMakes(List<String> makes) {
        this.makes = makes;
    }

    public List<String> getModels() {
        return models;
    }

    public void setModels(List<String> models) {
        this.models = models;
    }

    public List<String> getYears() {
        return years;
    }

    public void setYears(List<String> years) {
        this.years = years;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<String> getSubmodels() {
        return submodels;
    }

    public void setSubmodels(List<String> submodels) {
        this.submodels = submodels;
    }

    public String getShotTypeAbbreviation() {
        return shotTypeAbbreviation;
    }

    public void setShotTypeAbbreviation(String shotTypeAbbreviation) {
        this.shotTypeAbbreviation = shotTypeAbbreviation;
    }

    public List<String> getStyleIds() {
        return styleIds;
    }

    public void setStyleIds(List<String> styleIds) {
        this.styleIds = styleIds;
    }

    public List<String> getExactStyleIds() {
        return exactStyleIds;
    }

    public void setExactStyleIds(List<String> exactStyleIds) {
        this.exactStyleIds = exactStyleIds;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(title);
        dest.writeValue(category);
        dest.writeList(tags);
        dest.writeValue(provider);
        dest.writeList(sources);
        dest.writeList(makes);
        dest.writeList(models);
        dest.writeList(years);
        dest.writeValue(color);
        dest.writeList(submodels);
        dest.writeValue(shotTypeAbbreviation);
        dest.writeList(styleIds);
        dest.writeList(exactStyleIds);
    }

    public int describeContents() {
        return  0;
    }

}
