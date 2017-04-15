
package com.cameraswitch.vehiclesearch.endpoints.edmunds.inventory;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Submodel implements Parcelable
{

    @SerializedName("body")
    @Expose
    private String body;
    @SerializedName("modelName")
    @Expose
    private String modelName;
    @SerializedName("niceName")
    @Expose
    private String niceName;
    public final static Parcelable.Creator<Submodel> CREATOR = new Creator<Submodel>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Submodel createFromParcel(Parcel in) {
            Submodel instance = new Submodel();
            instance.body = ((String) in.readValue((String.class.getClassLoader())));
            instance.modelName = ((String) in.readValue((String.class.getClassLoader())));
            instance.niceName = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Submodel[] newArray(int size) {
            return (new Submodel[size]);
        }

    }
    ;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getNiceName() {
        return niceName;
    }

    public void setNiceName(String niceName) {
        this.niceName = niceName;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(body);
        dest.writeValue(modelName);
        dest.writeValue(niceName);
    }

    public int describeContents() {
        return  0;
    }

}
