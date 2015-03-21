package com.juanpabloprado.campcun.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Juan on 3/20/2015.
 */
public class Place implements Parcelable{
    private String mName;
    private Double mPrice;
    private double mLatitude;
    private double mLongitude;
    private String mImageUrl;

    public Place(String name, Double price, double latitude, double longitude, String imageUrl) {
        mName = name;
        mPrice = price;
        mLatitude = latitude;
        mLongitude = longitude;
        mImageUrl = imageUrl;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public Double getPrice() {
        return mPrice;
    }

    public void setPrice(double price) {
        mPrice = price;
    }

    public double getLatitude() {
        return mLatitude;
    }

    public void setLatitude(double latitude) {
        mLatitude = latitude;
    }

    public double getLongitude() {
        return mLongitude;
    }

    public void setLongitude(double longitude) {
        mLongitude = longitude;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        mImageUrl = imageUrl;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mName);
        dest.writeDouble(mPrice);
        dest.writeDouble(mLatitude);
        dest.writeDouble(mLongitude);
        dest.writeString(mImageUrl);
    }

    private Place(Parcel in) {
        mName = in.readString();
        mPrice = in.readDouble();
        mLatitude = in.readDouble();
        mLongitude = in.readDouble();
        mImageUrl = in.readString();
    }

    public Place() { }

    public static final Creator<Place> CREATOR = new Creator<Place>() {
        @Override
        public Place createFromParcel(Parcel source) {
            return new Place(source);
        }

        @Override
        public Place[] newArray(int size) {
            return new Place[size];
        }
    };

}
