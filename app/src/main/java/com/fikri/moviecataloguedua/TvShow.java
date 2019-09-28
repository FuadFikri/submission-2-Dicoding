package com.fikri.moviecataloguedua;

import android.os.Parcel;
import android.os.Parcelable;

public class TvShow implements Parcelable {
    private String title;
    private String language;
    private String year;
    private String overview;
    private String poster;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.language);
        dest.writeString(this.year);
        dest.writeString(this.overview);
        dest.writeString(this.poster);
    }

    public TvShow() {
    }

    protected TvShow(Parcel in) {
        this.title = in.readString();
        this.language = in.readString();
        this.year = in.readString();
        this.overview = in.readString();
        this.poster = in.readString();
    }

    public static final Parcelable.Creator<TvShow> CREATOR = new Parcelable.Creator<TvShow>() {
        @Override
        public TvShow createFromParcel(Parcel source) {
            return new TvShow(source);
        }

        @Override
        public TvShow[] newArray(int size) {
            return new TvShow[size];
        }
    };
}
