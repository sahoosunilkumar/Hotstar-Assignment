package com.hotstar.gallery.browse.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Sizes implements Parcelable {

    @SerializedName("canblog")
    @Expose
    private int canblog;
    @SerializedName("canprint")
    @Expose
    private int canprint;
    @SerializedName("candownload")
    @Expose
    private int candownload;
    @SerializedName("size")
    @Expose
    private List<Size> size = null;

    public Sizes() {
    }

    public int getCanblog() {
        return canblog;
    }

    public void setCanblog(int canblog) {
        this.canblog = canblog;
    }

    public int getCanprint() {
        return canprint;
    }

    public void setCanprint(int canprint) {
        this.canprint = canprint;
    }

    public int getCandownload() {
        return candownload;
    }

    public void setCandownload(int candownload) {
        this.candownload = candownload;
    }

    public List<Size> getSize() {
        return size;
    }

    public void setSize(List<Size> size) {
        this.size = size;
    }


    protected Sizes(Parcel in) {
        canblog = in.readInt();
        canprint = in.readInt();
        candownload = in.readInt();
        if (in.readByte() == 0x01) {
            size = new ArrayList<>();
            in.readList(size, Size.class.getClassLoader());
        } else {
            size = null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(canblog);
        dest.writeInt(canprint);
        dest.writeInt(candownload);
        if (size == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(size);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Sizes> CREATOR = new Parcelable.Creator<Sizes>() {
        @Override
        public Sizes createFromParcel(Parcel in) {
            return new Sizes(in);
        }

        @Override
        public Sizes[] newArray(int size) {
            return new Sizes[size];
        }
    };
}