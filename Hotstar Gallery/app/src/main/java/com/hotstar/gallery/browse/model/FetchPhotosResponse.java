package com.hotstar.gallery.browse.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FetchPhotosResponse implements Parcelable {

    public final static Creator<FetchPhotosResponse> CREATOR = new Creator<FetchPhotosResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public FetchPhotosResponse createFromParcel(Parcel in) {
            return new FetchPhotosResponse(in);
        }

        public FetchPhotosResponse[] newArray(int size) {
            return (new FetchPhotosResponse[size]);
        }

    };
    @SerializedName("photos")
    @Expose
    private Photos photos;
    @SerializedName("stat")
    @Expose
    private String stat;

    protected FetchPhotosResponse(Parcel in) {
        this.photos = ((Photos) in.readValue((Photos.class.getClassLoader())));
        this.stat = ((String) in.readValue((String.class.getClassLoader())));
    }

    public FetchPhotosResponse() {
    }

    public Photos getPhotos() {
        return photos;
    }

    public void setPhotos(Photos photos) {
        this.photos = photos;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(photos);
        dest.writeValue(stat);
    }

    public int describeContents() {
        return 0;
    }

}
