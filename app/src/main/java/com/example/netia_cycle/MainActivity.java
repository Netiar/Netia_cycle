package com.example.netia_cycle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.netia_cycle.adapters.NetiaAdapter;
import com.example.netia_cycle.databinding.ActivityMainBinding;
import com.example.netia_cycle.viewmodel.NetiaViewModel;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private NetiaAdapter adapter;
    private NetiaViewModel vm;
    private final int id = new Random().nextInt();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityMainBinding binding =
                ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        vm = new ViewModelProvider(this).get(NetiaViewModel.class);
        adapter = new NetiaAdapter(getLayoutInflater(), vm.startTime);
        addEvent("onCreate()");

        binding.rec.setLayoutManager(new LinearLayoutManager(this));
        binding.rec.addItemDecoration(
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        binding.rec.setAdapter(adapter);

    }
    @Override
    protected void onStart() {
        super.onStart();
        addEvent("onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        addEvent("onResume()");
    }

    @Override
    protected void onPause() {
        addEvent("onPause()");
        super.onPause();
    }

    @Override
    protected void onStop() {
        addEvent("onStop()");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        addEvent("onDestroy()");
        super.onDestroy();
    }

    private void addEvent(String message) {
        vm.addEvent(message, id);
        adapter.submitList(new ArrayList<>(vm.netia));
    }
}