
package com.cameraswitch.vehiclesearch.endpoints.nhtsa;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

public class DecodedVin implements Parcelable
{

    @SerializedName("Count")
    @Expose
    private Integer count;
    @SerializedName("Message")
    @Expose
    private String message;
    @SerializedName("SearchCriteria")
    @Expose
    private String searchCriteria;
    @SerializedName("Results")
    @Expose
    private List<Result> results = null;
    public final static Parcelable.Creator<DecodedVin> CREATOR = new Creator<DecodedVin>() {


        @SuppressWarnings({
            "unchecked"
        })
        public DecodedVin createFromParcel(Parcel in) {
            DecodedVin instance = new DecodedVin();
            instance.count = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.message = ((String) in.readValue((String.class.getClassLoader())));
            instance.searchCriteria = ((String) in.readValue((String.class.getClassLoader())));
            in.readList(instance.results, (com.cameraswitch.vehiclesearch.endpoints.nhtsa.Result.class.getClassLoader()));
            return instance;
        }

        public DecodedVin[] newArray(int size) {
            return (new DecodedVin[size]);
        }

    }
    ;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSearchCriteria() {
        return searchCriteria;
    }

    public void setSearchCriteria(String searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(count);
        dest.writeValue(message);
        dest.writeValue(searchCriteria);
        dest.writeList(results);
    }

    public int describeContents() {
        return  0;
    }

}
