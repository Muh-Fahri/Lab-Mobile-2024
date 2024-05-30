package com.example.tugas4praktikum;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class User implements Parcelable {

    private String namaAkun, namaUser, caption;
    private Integer profil, fotoPost;
    private Uri addPost;


    protected User(Parcel in) {
        namaAkun = in.readString();
        namaUser = in.readString();
        caption = in.readString();
        if (in.readByte() == 0) {
            profil = null;
        } else {
            profil = in.readInt();
        }
        if (in.readByte() == 0) {
            fotoPost = null;
        } else {
            fotoPost = in.readInt();
        }
        addPost = in.readParcelable(Uri.class.getClassLoader());
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public User(String namaAkun, String namaUser, String caption, Integer profil, Integer fotoPost) {
        this.namaAkun = namaAkun;
        this.namaUser = namaUser;
        this.caption = caption;
        this.profil = profil;
        this.fotoPost = fotoPost;


    }

    public User(String namaAkun, String namaUser, String caption, Integer profil, Uri addPost) {
        this.namaAkun = namaAkun;
        this.namaUser = namaUser;
        this.caption = caption;
        this.profil = profil;
        this.addPost = addPost;

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(namaAkun);
        dest.writeString(namaUser);
        dest.writeString(caption);
        if (profil == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(profil);
        }
        if (fotoPost == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(fotoPost);
        }
        dest.writeParcelable(addPost, flags);
    }

    public String getNamaAkun() {
        return namaAkun;
    }

    public void setNamaAkun(String namaAkun) {
        this.namaAkun = namaAkun;
    }

    public String getNamaUser() {
        return namaUser;
    }

    public void setNamaUser(String namaUser) {
        this.namaUser = namaUser;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public Integer getProfil() {
        return profil;
    }

    public void setProfil(Integer profil) {
        this.profil = profil;
    }

    public Integer getFotoPost() {
        return fotoPost;
    }

    public void setFotoPost(Integer fotoPost) {
        this.fotoPost = fotoPost;
    }

    public Uri getAddPost() {
        return addPost;
    }

    public void setAddPost(Uri addPost) {
        this.addPost = addPost;
    }


}
