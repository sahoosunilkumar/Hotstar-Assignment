package com.hotstar.gallery.browse.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FetchPhotoDetailResponse implements Parcelable {

    public final static Creator<FetchPhotoDetailResponse> CREATOR = new Creator<FetchPhotoDetailResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public FetchPhotoDetailResponse createFromParcel(Parcel in) {
            return new FetchPhotoDetailResponse(in);
        }

        public FetchPhotoDetailResponse[] newArray(int size) {
            return (new FetchPhotoDetailResponse[size]);
        }

    };
    @SerializedName("sizes")
    @Expose
    private Sizes sizes;
    @SerializedName("stat")
    @Expose
    private String stat;

    protected FetchPhotoDetailResponse(Parcel in) {
        this.sizes = ((Sizes) in.readValue((Sizes.class.getClassLoader())));
        this.stat = ((String) in.readValue((String.class.getClassLoader())));
    }

    public FetchPhotoDetailResponse() {
    }

    public Sizes getSizes() {
        return sizes;
    }

    public void setSizes(Sizes sizes) {
        this.sizes = sizes;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(sizes);
        dest.writeValue(stat);
    }

    public int describeContents() {
        return 0;
    }

}
