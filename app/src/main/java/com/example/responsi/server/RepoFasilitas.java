package com.example.responsi.server;

import com.example.responsi.model.fasilitas.ResponseFasilitas;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RepoFasilitas {
    @GET("sebaran_v2/jabar/faskes")
    Call<ResponseFasilitas> getFasilitasKesehatan();
}
