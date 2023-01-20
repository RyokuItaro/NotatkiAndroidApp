package com.example.notatkiappstudiamobilki;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public final class NoteInfo implements Parcelable {
    private String mTitle;
    private String mText;

    public NoteInfo(String title, String text) {
        mTitle = title;
        mText = text;
    }

    public NoteInfo(Parcel source) {
        mTitle = source.readString();
        mText = source.readString();
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }

    private String getCompareKey() {
        return mTitle + "|" + mText;
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
        dest.writeString(mTitle);
        dest.writeString(mText);
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
