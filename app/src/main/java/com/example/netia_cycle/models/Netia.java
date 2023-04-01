package com.example.netia_cycle.models;

import android.os.SystemClock;

public class Netia {
    public final long timestamp = SystemClock.elapsedRealtime();
    public final String message;
    public final int activityHash;
    public final int viewHash;

    public Netia(String message, int activityHash, int viewHash) {
        this.message = message;
        this.activityHash = activityHash;
        this.viewHash = viewHash;
    }

}
