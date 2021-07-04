package com.example.responsi.model.kasus;

import java.util.ArrayList;

import com.google.gson.annotations.SerializedName;

public class Data{

	@SerializedName("metadata")
	private Metadata metadata;

	@SerializedName("content")
	private ArrayList<DataKasus> content;

	public Metadata getMetadata(){
		return metadata;
	}

	public ArrayList<DataKasus> getContent(){
		return content;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"metadata = '" + metadata + '\'' + 
			",content = '" + content + '\'' + 
			"}";
		}
}