
package com.cameraswitch.vehiclesearch.endpoints.edmunds.inventory;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Inventory_ implements Parcelable
{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("vin")
    @Expose
    private String vin;
    @SerializedName("stockNumber")
    @Expose
    private String stockNumber;
    @SerializedName("mileage")
    @Expose
    private Integer mileage;
    @SerializedName("make")
    @Expose
    private Make make;
    @SerializedName("model")
    @Expose
    private Model model;
    @SerializedName("year")
    @Expose
    private Year year;
    @SerializedName("style")
    @Expose
    private Style style;
    @SerializedName("media")
    @Expose
    private Media media;
    @SerializedName("colors")
    @Expose
    private List<Color> colors = null;
    @SerializedName("mpg")
    @Expose
    private Mpg mpg;
    @SerializedName("prices")
    @Expose
    private Prices prices;
    @SerializedName("programs")
    @Expose
    private Programs programs;
    @SerializedName("equipment")
    @Expose
    private List<Equipment> equipment = null;
    @SerializedName("features")
    @Expose
    private List<String> features = null;
    @SerializedName("dealer")
    @Expose
    private Dealer dealer;
    public final static Parcelable.Creator<Inventory_> CREATOR = new Creator<Inventory_>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Inventory_ createFromParcel(Parcel in) {
            Inventory_ instance = new Inventory_();
            instance.id = ((String) in.readValue((String.class.getClassLoader())));
            instance.type = ((String) in.readValue((String.class.getClassLoader())));
            instance.vin = ((String) in.readValue((String.class.getClassLoader())));
            instance.stockNumber = ((String) in.readValue((String.class.getClassLoader())));
            instance.mileage = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.make = ((Make) in.readValue((Make.class.getClassLoader())));
            instance.model = ((Model) in.readValue((Model.class.getClassLoader())));
            instance.year = ((Year) in.readValue((Year.class.getClassLoader())));
            instance.style = ((Style) in.readValue((Style.class.getClassLoader())));
            instance.media = ((Media) in.readValue((Media.class.getClassLoader())));
            in.readList(instance.colors, (com.cameraswitch.vehiclesearch.endpoints.edmunds.inventory.Color.class.getClassLoader()));
            instance.mpg = ((Mpg) in.readValue((Mpg.class.getClassLoader())));
            instance.prices = ((Prices) in.readValue((Prices.class.getClassLoader())));
            instance.programs = ((Programs) in.readValue((Programs.class.getClassLoader())));
            in.readList(instance.equipment, (com.cameraswitch.vehiclesearch.endpoints.edmunds.inventory.Equipment.class.getClassLoader()));
            in.readList(instance.features, (java.lang.String.class.getClassLoader()));
            instance.dealer = ((Dealer) in.readValue((Dealer.class.getClassLoader())));
            return instance;
        }

        public Inventory_[] newArray(int size) {
            return (new Inventory_[size]);
        }

    }
    ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getStockNumber() {
        return stockNumber;
    }

    public void setStockNumber(String stockNumber) {
        this.stockNumber = stockNumber;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public Make getMake() {
        return make;
    }

    public void setMake(Make make) {
        this.make = make;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public List<Color> getColors() {
        return colors;
    }

    public void setColors(List<Color> colors) {
        this.colors = colors;
    }

    public Mpg getMpg() {
        return mpg;
    }

    public void setMpg(Mpg mpg) {
        this.mpg = mpg;
    }

    public Prices getPrices() {
        return prices;
    }

    public void setPrices(Prices prices) {
        this.prices = prices;
    }

    public Programs getPrograms() {
        return programs;
    }

    public void setPrograms(Programs programs) {
        this.programs = programs;
    }

    public List<Equipment> getEquipment() {
        return equipment;
    }

    public void setEquipment(List<Equipment> equipment) {
        this.equipment = equipment;
    }

    public List<String> getFeatures() {
        return features;
    }

    public void setFeatures(List<String> features) {
        this.features = features;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(type);
        dest.writeValue(vin);
        dest.writeValue(stockNumber);
        dest.writeValue(mileage);
        dest.writeValue(make);
        dest.writeValue(model);
        dest.writeValue(year);
        dest.writeValue(style);
        dest.writeValue(media);
        dest.writeList(colors);
        dest.writeValue(mpg);
        dest.writeValue(prices);
        dest.writeValue(programs);
        dest.writeList(equipment);
        dest.writeList(features);
        dest.writeValue(dealer);
    }

    public int describeContents() {
        return  0;
    }

}
