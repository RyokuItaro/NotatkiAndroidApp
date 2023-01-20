package com.example.notatkiappstudiamobilki;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public final class NoteInfo implements Parcelable {
    private String title;
    private String text;

    public NoteInfo(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public NoteInfo(Parcel source) {
        title = source.readString();
        text = source.readString();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    private String getCompareKey() {
        return title + "|" + text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NoteInfo that = (NoteInfo) o;

        return getCompareKey().equals(that.getCompareKey());
    }

    @Override
    public int hashCode() {
        return getCompareKey().hashCode();
    }

    @Override
    public String toString() {
        return getCompareKey();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(text);
    }

    public static final Parcelable.Creator<NoteInfo> CREATOR =
            new Parcelable.Creator<NoteInfo>(){

                @Override
                public NoteInfo createFromParcel(Parcel source) {
                    return new NoteInfo(source);
                }

                @Override
                public NoteInfo[] newArray(int size) {
                    return new NoteInfo[size];
                }
            };
}
