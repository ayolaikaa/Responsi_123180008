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
import com.example.responsi.model.fasilitas.DataFasilitas;

import java.util.ArrayList;

public class FragmentFasilitas extends Fragment  {

    private AdapterFasilitas adapterFasilitas;
    private RecyclerView rvFasilitasKesehatan;
    private ModelFasilitas modelFasilitas;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        adapterFasilitas = new AdapterFasilitas(getContext());
        adapterFasilitas.notifyDataSetChanged();

        rvFasilitasKesehatan = view.findViewById(R.id.fasilitas_rv_main);
        rvFasilitasKesehatan.setLayoutManager(new LinearLayoutManager(getContext()));

        modelFasilitas = new ViewModelProvider(this).get(ModelFasilitas.class);
        modelFasilitas.setFasilitasDiscover();
        modelFasilitas.getFasilitasDiscover().observe(this ,getFasilitasKesehatanDiscover);

        rvFasilitasKesehatan.setAdapter(adapterFasilitas);
    }

    private Observer<ArrayList<DataFasilitas>> getFasilitasKesehatanDiscover = new Observer<ArrayList<DataFasilitas>>() {
        @Override
        public void onChanged(ArrayList<DataFasilitas> dataFasilitas) {
            if(dataFasilitas != null){
                adapterFasilitas.setData(dataFasilitas);
            }
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment1, container, false);
    }


}