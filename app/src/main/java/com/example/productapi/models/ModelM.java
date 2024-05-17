package com.example.productapi.models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ModelM implements Parcelable, Serializable {
    @SerializedName("id")
    @Expose
    int modelId;

    @SerializedName("title")
    @Expose
    String modelTitle;

    @SerializedName("description")
    @Expose
    String modelDescription;

    @SerializedName("price")
    @Expose
    Double modelPrice;

    @SerializedName("image")
    @Expose
    String modelImage;

    protected ModelM(Parcel in) {
        modelId = in.readInt();
        modelTitle = in.readString();
        modelDescription = in.readString();
        if (in.readByte() == 0) {
            modelPrice = null;
        } else {
            modelPrice = in.readDouble();
        }
        modelImage = in.readString();
    }

    public static final Creator<ModelM> CREATOR = new Creator<ModelM>() {
        @Override
        public ModelM createFromParcel(Parcel in) {
            return new ModelM(in);
        }

        @Override
        public ModelM[] newArray(int size) {
            return new ModelM[size];
        }
    };

    public ModelM(int modelId, String modelTitle, String modelDescription, Double modelPrice, String modelImage) {
        this.modelId = modelId;
        this.modelTitle = modelTitle;
        this.modelDescription = modelDescription;
        this.modelPrice = modelPrice;
        this.modelImage = modelImage;
    }

    public int getModelId() {
        return modelId;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }

    public String getModelTitle() {
        return modelTitle;
    }

    @Override
    public String toString() {
        return "ModelM{" +
                "modelId=" + modelId +
                ", modelTitle='" + modelTitle + '\'' +
                ", modelDescription='" + modelDescription + '\'' +
                ", modelPrice=" + modelPrice +
                ", modelImage='" + modelImage + '\'' +
                '}';
    }

    public void setModelTitle(String modelTitle) {
        this.modelTitle = modelTitle;
    }

    public String getModelDescription() {
        return modelDescription;
    }

    public void setModelDescription(String modelDescription) {
        this.modelDescription = modelDescription;
    }

    public Double getModelPrice() {
        return modelPrice;
    }

    public void setModelPrice(Double modelPrice) {
        this.modelPrice = modelPrice;
    }

    public String getModelImage() {
        return modelImage;
    }

    public void setModelImage(String modelImage) {
        this.modelImage = modelImage;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeInt(modelId);
        dest.writeString(modelTitle);
        dest.writeString(modelDescription);
        if (modelPrice == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(modelPrice);
        }
        dest.writeString(modelImage);
    }
}
