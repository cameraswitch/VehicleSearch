
package com.cameraswitch.vehiclesearch.endpoints.edmunds.dealers;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Service implements Parcelable
{

    @SerializedName("overallRating")
    @Expose
    private Double overallRating;
    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("recommendedCount")
    @Expose
    private Integer recommendedCount;
    @SerializedName("notRecommendedCount")
    @Expose
    private Integer notRecommendedCount;
    public final static Parcelable.Creator<Service> CREATOR = new Creator<Service>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Service createFromParcel(Parcel in) {
            Service instance = new Service();
            instance.overallRating = ((Double) in.readValue((Double.class.getClassLoader())));
            instance.count = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.recommendedCount = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.notRecommendedCount = ((Integer) in.readValue((Integer.class.getClassLoader())));
            return instance;
        }

        public Service[] newArray(int size) {
            return (new Service[size]);
        }

    }
    ;

    public Double getOverallRating() {
        return overallRating;
    }

    public void setOverallRating(Double overallRating) {
        this.overallRating = overallRating;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getRecommendedCount() {
        return recommendedCount;
    }

    public void setRecommendedCount(Integer recommendedCount) {
        this.recommendedCount = recommendedCount;
    }

    public Integer getNotRecommendedCount() {
        return notRecommendedCount;
    }

    public void setNotRecommendedCount(Integer notRecommendedCount) {
        this.notRecommendedCount = notRecommendedCount;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(overallRating);
        dest.writeValue(count);
        dest.writeValue(recommendedCount);
        dest.writeValue(notRecommendedCount);
    }

    public int describeContents() {
        return  0;
    }

}
