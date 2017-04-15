
package com.cameraswitch.vehiclesearch.endpoints.edmunds.inventory;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Color implements Parcelable
{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("availability")
    @Expose
    private String availability;
    @SerializedName("manufactureOptionName")
    @Expose
    private String manufactureOptionName;
    @SerializedName("manufactureOptionCode")
    @Expose
    private String manufactureOptionCode;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("colorChips")
    @Expose
    private ColorChips colorChips;
    @SerializedName("fabricTypes")
    @Expose
    private List<FabricType> fabricTypes = null;
    public final static Parcelable.Creator<Color> CREATOR = new Creator<Color>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Color createFromParcel(Parcel in) {
            Color instance = new Color();
            instance.id = ((String) in.readValue((String.class.getClassLoader())));
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            instance.availability = ((String) in.readValue((String.class.getClassLoader())));
            instance.manufactureOptionName = ((String) in.readValue((String.class.getClassLoader())));
            instance.manufactureOptionCode = ((String) in.readValue((String.class.getClassLoader())));
            instance.category = ((String) in.readValue((String.class.getClassLoader())));
            instance.colorChips = ((ColorChips) in.readValue((ColorChips.class.getClassLoader())));
            in.readList(instance.fabricTypes, (com.cameraswitch.vehiclesearch.endpoints.edmunds.inventory.FabricType.class.getClassLoader()));
            return instance;
        }

        public Color[] newArray(int size) {
            return (new Color[size]);
        }

    }
    ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getManufactureOptionName() {
        return manufactureOptionName;
    }

    public void setManufactureOptionName(String manufactureOptionName) {
        this.manufactureOptionName = manufactureOptionName;
    }

    public String getManufactureOptionCode() {
        return manufactureOptionCode;
    }

    public void setManufactureOptionCode(String manufactureOptionCode) {
        this.manufactureOptionCode = manufactureOptionCode;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public ColorChips getColorChips() {
        return colorChips;
    }

    public void setColorChips(ColorChips colorChips) {
        this.colorChips = colorChips;
    }

    public List<FabricType> getFabricTypes() {
        return fabricTypes;
    }

    public void setFabricTypes(List<FabricType> fabricTypes) {
        this.fabricTypes = fabricTypes;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeValue(availability);
        dest.writeValue(manufactureOptionName);
        dest.writeValue(manufactureOptionCode);
        dest.writeValue(category);
        dest.writeValue(colorChips);
        dest.writeList(fabricTypes);
    }

    public int describeContents() {
        return  0;
    }

}
