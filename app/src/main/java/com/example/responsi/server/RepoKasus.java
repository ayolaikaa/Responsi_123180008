package com.example.responsi.server;

import com.example.responsi.model.kasus.ResponseKasus;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RepoKasus {
    @GET("rekapitulasi_v2/jabar/kumulatif")
    Call<ResponseKasus> getKasusHarian();

}
