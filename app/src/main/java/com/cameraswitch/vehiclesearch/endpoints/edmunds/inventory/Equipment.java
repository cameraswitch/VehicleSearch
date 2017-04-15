
package com.cameraswitch.vehiclesearch.endpoints.edmunds.inventory;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Equipment implements Parcelable
{

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("equipmentType")
    @Expose
    private String equipmentType;
    @SerializedName("cylinder")
    @Expose
    private Integer cylinder;
    @SerializedName("fuelType")
    @Expose
    private String fuelType;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("transmissionType")
    @Expose
    private String transmissionType;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("availability")
    @Expose
    private String availability;
    @SerializedName("price")
    @Expose
    private Price price;
    @SerializedName("manufactureOptionName")
    @Expose
    private String manufactureOptionName;
    @SerializedName("manufactureOptionCode")
    @Expose
    private String manufactureOptionCode;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("attributes")
    @Expose
    private List<Object> attributes = null;
    @SerializedName("equipment")
    @Expose
    private List<Object> equipment = null;
    public final static Parcelable.Creator<Equipment> CREATOR = new Creator<Equipment>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Equipment createFromParcel(Parcel in) {
            Equipment instance = new Equipment();
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            instance.equipmentType = ((String) in.readValue((String.class.getClassLoader())));
            instance.cylinder = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.fuelType = ((String) in.readValue((String.class.getClassLoader())));
            instance.type = ((String) in.readValue((String.class.getClassLoader())));
            instance.transmissionType = ((String) in.readValue((String.class.getClassLoader())));
            instance.id = ((String) in.readValue((String.class.getClassLoader())));
            instance.availability = ((String) in.readValue((String.class.getClassLoader())));
            instance.price = ((Price) in.readValue((Price.class.getClassLoader())));
            instance.manufactureOptionName = ((String) in.readValue((String.class.getClassLoader())));
            instance.manufactureOptionCode = ((String) in.readValue((String.class.getClassLoader())));
            instance.category = ((String) in.readValue((String.class.getClassLoader())));
            in.readList(instance.attributes, (java.lang.Object.class.getClassLoader()));
            in.readList(instance.equipment, (java.lang.Object.class.getClassLoader()));
            return instance;
        }

        public Equipment[] newArray(int size) {
            return (new Equipment[size]);
        }

    }
    ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType;
    }

    public Integer getCylinder() {
        return cylinder;
    }

    public void setCylinder(Integer cylinder) {
        this.cylinder = cylinder;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(String transmissionType) {
        this.transmissionType = transmissionType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
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

    public List<Object> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Object> attributes) {
        this.attributes = attributes;
    }

    public List<Object> getEquipment() {
        return equipment;
    }

    public void setEquipment(List<Object> equipment) {
        this.equipment = equipment;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(name);
        dest.writeValue(equipmentType);
        dest.writeValue(cylinder);
        dest.writeValue(fuelType);
        dest.writeValue(type);
        dest.writeValue(transmissionType);
        dest.writeValue(id);
        dest.writeValue(availability);
        dest.writeValue(price);
        dest.writeValue(manufactureOptionName);
        dest.writeValue(manufactureOptionCode);
        dest.writeValue(category);
        dest.writeList(attributes);
        dest.writeList(equipment);
    }

    public int describeContents() {
        return  0;
    }

}
