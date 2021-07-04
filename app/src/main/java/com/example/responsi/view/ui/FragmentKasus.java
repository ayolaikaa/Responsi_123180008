package com.example.responsi.view.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.responsi.R;
import com.example.responsi.model.kasus.DataKasus;

import java.util.ArrayList;

public class FragmentKasus extends Fragment {

    private AdapterKasus adapterKasus;
    private RecyclerView rvKasusHarian;
    private ModelKasus modelKasus;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        adapterKasus = new AdapterKasus(getContext());
        adapterKasus.notifyDataSetChanged();

        rvKasusHarian = view.findViewById(R.id.kasusharian_rv_main);
        rvKasusHarian.setLayoutManager(new LinearLayoutManager(getContext()));

        modelKasus = new ViewModelProvider(this).get(ModelKasus.class);
        modelKasus.setKasusHarianDiscover();
        modelKasus.getKasusHarianDiscover().observe(this ,getKasusHarianDiscover);

        rvKasusHarian.setAdapter(adapterKasus);
    }

    private Observer<ArrayList<DataKasus>> getKasusHarianDiscover = new Observer<ArrayList<DataKasus>>() {
        @Override
        public void onChanged(ArrayList<DataKasus> dataKasuses) {
            if(dataKasuses != null){
                adapterKasus.setData(dataKasuses);
            }
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment2, container, false);
    }

}