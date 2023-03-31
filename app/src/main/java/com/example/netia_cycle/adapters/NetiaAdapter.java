package com.example.netia_cycle.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.example.netia_cycle.databinding.NetiaBinding;
import com.example.netia_cycle.models.Netia;

    public class NetiaAdapter extends ListAdapter<Netia, NetiaViewHolder> {
    private final LayoutInflater inflater;
    private final long startTime;

     public NetiaAdapter(LayoutInflater inflater, long startTime) {
            super(DIFF_CALLBACK);
            this.inflater = inflater;
            this.startTime = startTime;
    }
    @NonNull
    @Override
    public NetiaViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                              int viewType) {
        final NetiaBinding binding = NetiaBinding.inflate(inflater, parent, false);

        return new NetiaViewHolder(binding, startTime);
    }

    @Override
    public void onBindViewHolder(@NonNull NetiaViewHolder holder, int position) {
        holder.bindTo(getItem(position));
    }

    private static final DiffUtil.ItemCallback<Netia> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<Netia>() {
                @Override
                public boolean areItemsTheSame(@NonNull Netia oldEvent, @NonNull Netia newEvent) {
                    return oldEvent == newEvent;
                }

                @Override
                public boolean areContentsTheSame(@NonNull Netia oldEvent, @NonNull Netia newEvent) {
                    return oldEvent.timestamp == newEvent.timestamp &&
                            oldEvent.message.equals(newEvent.message) &&
                            oldEvent.activityHash == newEvent.activityHash &&
                            oldEvent.viewHash == newEvent.viewHash;
                }
            };
}
