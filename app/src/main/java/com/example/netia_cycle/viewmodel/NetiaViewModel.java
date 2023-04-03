package com.example.netia_cycle.viewmodel;

import android.os.SystemClock;

import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

import com.example.netia_cycle.models.Netia;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NetiaViewModel extends ViewModel {
    private static final String STATE_NETIA = "netia";
    private static final String STATE_START_TIME = "startTime";
   // public List<Netia> netia = new ArrayList<>();
    public final ArrayList<Netia> netia;
    //public final long startTime = SystemClock.elapsedRealtime();
    public final Long startTime;
    private final int id = new Random().nextInt();
    private final SavedStateHandle state;

    public NetiaViewModel(SavedStateHandle state) {
        this.state = state;
        ArrayList<Netia> netia = state.get(STATE_NETIA);
        if (netia== null){
            this.netia = new ArrayList<>();
        }
        else {
            this.netia=netia;
        }

        Long startTime = state.get(STATE_START_TIME);

        if (startTime == null) {
            this.startTime = SystemClock.elapsedRealtime();
            state.set(STATE_START_TIME, this.startTime);
        }
        else {
            this.startTime = startTime;
        }
    }

    public void addEvent(String message, int activityHash) {
        netia.add(new Netia(message, activityHash, id));
        state.set(STATE_NETIA, netia);
    }

    @Override
    protected void onCleared() {
        netia.clear();
    }

}
