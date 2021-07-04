package com.example.responsi.model.fasilitas;

import java.util.ArrayList;

import com.google.gson.annotations.SerializedName;

public class ResponseFasilitas {

	@SerializedName("status_code")
	private int statusCode;

	@SerializedName("data")
	private ArrayList<DataFasilitas> data;

	public void setStatusCode(int statusCode){
		this.statusCode = statusCode;
	}

	public int getStatusCode(){
		return statusCode;
	}

	public void setData(ArrayList<DataFasilitas> data){
		this.data = data;
	}

	public ArrayList<DataFasilitas> getData(){
		return data;
	}
}