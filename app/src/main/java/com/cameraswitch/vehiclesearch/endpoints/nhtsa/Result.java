
package com.cameraswitch.vehiclesearch.endpoints.nhtsa;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Result implements Parcelable
{

    @SerializedName("Value")
    @Expose
    private Object value;
    @SerializedName("ValueId")
    @Expose
    private String valueId;
    @SerializedName("Variable")
    @Expose
    private String variable;
    @SerializedName("VariableId")
    @Expose
    private Integer variableId;
    public final static Parcelable.Creator<Result> CREATOR = new Creator<Result>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Result createFromParcel(Parcel in) {
            Result instance = new Result();
            instance.value = ((Object) in.readValue((Object.class.getClassLoader())));
            instance.valueId = ((String) in.readValue((String.class.getClassLoader())));
            instance.variable = ((String) in.readValue((String.class.getClassLoader())));
            instance.variableId = ((Integer) in.readValue((Integer.class.getClassLoader())));
            return instance;
        }

        public Result[] newArray(int size) {
            return (new Result[size]);
        }

    }
    ;

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getValueId() {
        return valueId;
    }

    public void setValueId(String valueId) {
        this.valueId = valueId;
    }

    public String getVariable() {
        return variable;
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }

    public Integer getVariableId() {
        return variableId;
    }

    public void setVariableId(Integer variableId) {
        this.variableId = variableId;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(value);
        dest.writeValue(valueId);
        dest.writeValue(variable);
        dest.writeValue(variableId);
    }

    public int describeContents() {
        return  0;
    }

}
