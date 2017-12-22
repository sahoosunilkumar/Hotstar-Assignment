package com.hotstar.gallery.browse.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Size implements Parcelable {

    public final static Creator<Size> CREATOR = new Creator<Size>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Size createFromParcel(Parcel in) {
            return new Size(in);
        }

        public Size[] newArray(int size) {
            return (new Size[size]);
        }

    };
    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("width")
    @Expose
    private String width;
    @SerializedName("height")
    @Expose
    private String height;
    @SerializedName("source")
    @Expose
    private String source;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("media")
    @Expose
    private String media;

    protected Size(Parcel in) {
        this.label = ((String) in.readValue((String.class.getClassLoader())));
        this.width = ((String) in.readValue((String.class.getClassLoader())));
        this.height = ((String) in.readValue((String.class.getClassLoader())));
        this.source = ((String) in.readValue((String.class.getClassLoader())));
        this.url = ((String) in.readValue((String.class.getClassLoader())));
        this.media = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Size() {
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(label);
        dest.writeValue(width);
        dest.writeValue(height);
        dest.writeValue(source);
        dest.writeValue(url);
        dest.writeValue(media);
    }

    public int describeContents() {
        return 0;
    }

}
