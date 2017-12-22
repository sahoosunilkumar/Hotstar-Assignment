package com.hotstar.gallery.browse.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Photo implements Parcelable {

    public final static Creator<Photo> CREATOR = new Creator<Photo>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Photo createFromParcel(Parcel in) {
            return new Photo(in);
        }

        public Photo[] newArray(int size) {
            return (new Photo[size]);
        }

    };
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("owner")
    @Expose
    private String owner;
    @SerializedName("secret")
    @Expose
    private String secret;
    @SerializedName("server")
    @Expose
    private String server;
    @SerializedName("farm")
    @Expose
    private int farm;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("ispublic")
    @Expose
    private int ispublic;
    @SerializedName("isfriend")
    @Expose
    private int isfriend;
    @SerializedName("isfamily")
    @Expose
    private int isfamily;

    protected Photo(Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.owner = ((String) in.readValue((String.class.getClassLoader())));
        this.secret = ((String) in.readValue((String.class.getClassLoader())));
        this.server = ((String) in.readValue((String.class.getClassLoader())));
        this.farm = ((int) in.readValue((int.class.getClassLoader())));
        this.title = ((String) in.readValue((String.class.getClassLoader())));
        this.ispublic = ((int) in.readValue((int.class.getClassLoader())));
        this.isfriend = ((int) in.readValue((int.class.getClassLoader())));
        this.isfamily = ((int) in.readValue((int.class.getClassLoader())));
    }

    public Photo() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public int getFarm() {
        return farm;
    }

    public void setFarm(int farm) {
        this.farm = farm;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIspublic() {
        return ispublic;
    }

    public void setIspublic(int ispublic) {
        this.ispublic = ispublic;
    }

    public int getIsfriend() {
        return isfriend;
    }

    public void setIsfriend(int isfriend) {
        this.isfriend = isfriend;
    }

    public int getIsfamily() {
        return isfamily;
    }

    public void setIsfamily(int isfamily) {
        this.isfamily = isfamily;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(owner);
        dest.writeValue(secret);
        dest.writeValue(server);
        dest.writeValue(farm);
        dest.writeValue(title);
        dest.writeValue(ispublic);
        dest.writeValue(isfriend);
        dest.writeValue(isfamily);
    }

    public int describeContents() {
        return 0;
    }

}
