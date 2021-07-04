package com.example.responsi.view.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.responsi.model.kasus.DataKasus;
import com.example.responsi.model.kasus.ResponseKasus;
import com.example.responsi.server.ApiMain;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModelKasus extends ViewModel {

    private ApiMain apiMain;
    private MutableLiveData<ArrayList<DataKasus>> listKasusHarian = new MutableLiveData<>();

    public void setKasusHarianDiscover() {
        if(this.apiMain==null){
            apiMain = new ApiMain();
        }

        apiMain.getApiKasusHarian().getKasusHarian().enqueue(new Callback<ResponseKasus>() {
            @Override
            public void onResponse(Call<ResponseKasus> call, Response<ResponseKasus> response) {
                ResponseKasus kasusHarianRespone = response.body();
                if(kasusHarianRespone != null && kasusHarianRespone.getData() != null){
                    ArrayList<DataKasus> kasusharianItem = kasusHarianRespone.getData().getContent();
                    listKasusHarian.postValue(kasusharianItem);
                }
            }

            @Override
            public void onFailure(Call<ResponseKasus> call, Throwable t) {

            }
        });
    }

    public LiveData<ArrayList<DataKasus>> getKasusHarianDiscover(){
        return listKasusHarian;
    }
}
