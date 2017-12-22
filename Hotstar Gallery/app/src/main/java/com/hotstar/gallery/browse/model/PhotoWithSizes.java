package com.hotstar.gallery.browse.model;


import android.os.Parcel;
import android.os.Parcelable;

public class PhotoWithSizes implements Parcelable {
    @SuppressWarnings("unused")
    public static final Parcelable.Creator<PhotoWithSizes> CREATOR = new Parcelable.Creator<PhotoWithSizes>() {
        @Override
        public PhotoWithSizes createFromParcel(Parcel in) {
            return new PhotoWithSizes(in);
        }

        @Override
        public PhotoWithSizes[] newArray(int size) {
            return new PhotoWithSizes[size];
        }
    };
    public Photo photo;
    public Sizes sizes;

    public PhotoWithSizes(Photo photo, Sizes sizes) {
        this.photo = photo;
        this.sizes = sizes;
    }

    protected PhotoWithSizes(Parcel in) {
        photo = (Photo) in.readValue(Photo.class.getClassLoader());
        sizes = (Sizes) in.readValue(Sizes.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(photo);
        dest.writeValue(sizes);
    }
}