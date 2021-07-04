package com.example.responsi.view.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.responsi.model.fasilitas.ResponseFasilitas;
import com.example.responsi.model.fasilitas.DataFasilitas;
import com.example.responsi.server.ApiMain;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModelFasilitas extends ViewModel {

    private ApiMain apiMain;

    private MutableLiveData<ArrayList<DataFasilitas>> listFasilitas = new MutableLiveData<>();

    public void setFasilitasDiscover() {
        if(this.apiMain==null){
            apiMain = new ApiMain();
        }

        apiMain.getApiFasilitasKesehatan().getFasilitasKesehatan().enqueue(new Callback<ResponseFasilitas>() {
            @Override
            public void onResponse(Call<ResponseFasilitas> call, Response<ResponseFasilitas> response) {
                ResponseFasilitas fasilitasDiscover = response.body();
                if(fasilitasDiscover != null && fasilitasDiscover.getData() != null){
                    ArrayList<DataFasilitas> dataFasilitas = fasilitasDiscover.getData();
                    listFasilitas.postValue(dataFasilitas);
                }
            }

            @Override
            public void onFailure(Call<ResponseFasilitas> call, Throwable t) {

            }
        });
    }

    public LiveData<ArrayList<DataFasilitas>> getFasilitasDiscover(){
        return listFasilitas;
    }
}
