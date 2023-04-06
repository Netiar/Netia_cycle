package com.example.netia_cycle.adapters;

import android.text.format.DateUtils;

import androidx.recyclerview.widget.RecyclerView;

import com.example.netia_cycle.databinding.NetiaBinding;
import com.example.netia_cycle.models.Netia;

public class NetiaViewHolder extends RecyclerView.ViewHolder {
    private final long startTime;
    private final NetiaBinding binding;


    public NetiaViewHolder(NetiaBinding binding, long startTime) {
        super(binding.getRoot());
        this.startTime = startTime;
        this.binding = binding;
    }


    public void bindTo(Netia netia) {
        binding.setElapsedSeconds((netia.timestamp - startTime)/1000);
        binding.setNetia(netia);
        binding.executePendingBindings();
    }



}
