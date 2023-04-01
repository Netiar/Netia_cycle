package com.example.netia_cycle.viewmodel;

import android.os.SystemClock;

import androidx.lifecycle.ViewModel;

import com.example.netia_cycle.models.Netia;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NetiaViewModel extends ViewModel {
    public final List<Netia> netia = new ArrayList<>();
    public final long startTime = SystemClock.elapsedRealtime();
    private final int id = new Random().nextInt();

    public void addEvent(String message, int activityHash) {
        netia.add(new Netia(message, activityHash, id));
    }

    @Override
    protected void onCleared() {
        netia.clear();
    }

}
