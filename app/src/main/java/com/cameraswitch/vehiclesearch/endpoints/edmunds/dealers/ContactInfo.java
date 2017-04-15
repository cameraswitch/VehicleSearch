
package com.cameraswitch.vehiclesearch.endpoints.edmunds.dealers;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ContactInfo implements Parcelable
{

    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("website")
    @Expose
    private String website;
    @SerializedName("gpContactFirstName")
    @Expose
    private String gpContactFirstName;
    @SerializedName("gpContactLastName")
    @Expose
    private String gpContactLastName;
    @SerializedName("gpContactFirstName2")
    @Expose
    private String gpContactFirstName2;
    @SerializedName("gpContactLastName2")
    @Expose
    private String gpContactLastName2;
    @SerializedName("gpContactEmail")
    @Expose
    private String gpContactEmail;
    @SerializedName("gpCommitment")
    @Expose
    private String gpCommitment;
    @SerializedName("gpPhone")
    @Expose
    private String gpPhone;
    public final static Parcelable.Creator<ContactInfo> CREATOR = new Creator<ContactInfo>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ContactInfo createFromParcel(Parcel in) {
            ContactInfo instance = new ContactInfo();
            instance.phone = ((String) in.readValue((String.class.getClassLoader())));
            instance.website = ((String) in.readValue((String.class.getClassLoader())));
            instance.gpContactFirstName = ((String) in.readValue((String.class.getClassLoader())));
            instance.gpContactLastName = ((String) in.readValue((String.class.getClassLoader())));
            instance.gpContactFirstName2 = ((String) in.readValue((String.class.getClassLoader())));
            instance.gpContactLastName2 = ((String) in.readValue((String.class.getClassLoader())));
            instance.gpContactEmail = ((String) in.readValue((String.class.getClassLoader())));
            instance.gpCommitment = ((String) in.readValue((String.class.getClassLoader())));
            instance.gpPhone = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public ContactInfo[] newArray(int size) {
            return (new ContactInfo[size]);
        }

    }
    ;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getGpContactFirstName() {
        return gpContactFirstName;
    }

    public void setGpContactFirstName(String gpContactFirstName) {
        this.gpContactFirstName = gpContactFirstName;
    }

    public String getGpContactLastName() {
        return gpContactLastName;
    }

    public void setGpContactLastName(String gpContactLastName) {
        this.gpContactLastName = gpContactLastName;
    }

    public String getGpContactFirstName2() {
        return gpContactFirstName2;
    }

    public void setGpContactFirstName2(String gpContactFirstName2) {
        this.gpContactFirstName2 = gpContactFirstName2;
    }

    public String getGpContactLastName2() {
        return gpContactLastName2;
    }

    public void setGpContactLastName2(String gpContactLastName2) {
        this.gpContactLastName2 = gpContactLastName2;
    }

    public String getGpContactEmail() {
        return gpContactEmail;
    }

    public void setGpContactEmail(String gpContactEmail) {
        this.gpContactEmail = gpContactEmail;
    }

    public String getGpCommitment() {
        return gpCommitment;
    }

    public void setGpCommitment(String gpCommitment) {
        this.gpCommitment = gpCommitment;
    }

    public String getGpPhone() {
        return gpPhone;
    }

    public void setGpPhone(String gpPhone) {
        this.gpPhone = gpPhone;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(phone);
        dest.writeValue(website);
        dest.writeValue(gpContactFirstName);
        dest.writeValue(gpContactLastName);
        dest.writeValue(gpContactFirstName2);
        dest.writeValue(gpContactLastName2);
        dest.writeValue(gpContactEmail);
        dest.writeValue(gpCommitment);
        dest.writeValue(gpPhone);
    }

    public int describeContents() {
        return  0;
    }

}
