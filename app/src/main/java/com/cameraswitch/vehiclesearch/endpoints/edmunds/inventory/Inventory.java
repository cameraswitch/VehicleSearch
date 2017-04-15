
package com.cameraswitch.vehiclesearch.endpoints.edmunds.inventory;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Inventory implements Parcelable
{

    @SerializedName("inventories")
    @Expose
    private List<Inventory_> inventories = null;
    @SerializedName("inventoriesCount")
    @Expose
    private Integer inventoriesCount;
    @SerializedName("links")
    @Expose
    private List<Link_____> links = null;
    public final static Parcelable.Creator<Inventory> CREATOR = new Creator<Inventory>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Inventory createFromParcel(Parcel in) {
            Inventory instance = new Inventory();
            in.readList(instance.inventories, (com.cameraswitch.vehiclesearch.endpoints.edmunds.inventory.Inventory_.class.getClassLoader()));
            instance.inventoriesCount = ((Integer) in.readValue((Integer.class.getClassLoader())));
            in.readList(instance.links, (com.cameraswitch.vehiclesearch.endpoints.edmunds.inventory.Link_____.class.getClassLoader()));
            return instance;
        }

        public Inventory[] newArray(int size) {
            return (new Inventory[size]);
        }

    }
    ;

    public List<Inventory_> getInventories() {
        return inventories;
    }

    public void setInventories(List<Inventory_> inventories) {
        this.inventories = inventories;
    }

    public Integer getInventoriesCount() {
        return inventoriesCount;
    }

    public void setInventoriesCount(Integer inventoriesCount) {
        this.inventoriesCount = inventoriesCount;
    }

    public List<Link_____> getLinks() {
        return links;
    }

    public void setLinks(List<Link_____> links) {
        this.links = links;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(inventories);
        dest.writeValue(inventoriesCount);
        dest.writeList(links);
    }

    public int describeContents() {
        return  0;
    }

}
