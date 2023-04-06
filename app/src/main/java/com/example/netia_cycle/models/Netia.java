package com.example.netia_cycle.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;

import androidx.annotation.NonNull;

public class Netia implements Parcelable {
    public final long timestamp;
    public final String message;
    public final int activityHash;
    public final int viewHash;

    public Netia(String message, int activityHash, int viewHash) {
        this.message = message;
        this.activityHash = activityHash;
        this.viewHash = viewHash;
        this.timestamp = SystemClock.elapsedRealtime();
    }


    protected Netia(Parcel in) {
        timestamp = in.readLong();
        message = in.readString();
        activityHash = in.readInt();
        viewHash = in.readInt();
    }

    public static final Creator<Netia> CREATOR = new Creator<Netia>() {
        @Override
        public Netia createFromParcel(Parcel in) {
            return new Netia(in);
        }

        @Override
        public Netia[] newArray(int size) {
            return new Netia[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }


    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeLong(timestamp);
        dest.writeString(message);
        dest.writeInt(activityHash);
        dest.writeInt(viewHash);
    }
}
