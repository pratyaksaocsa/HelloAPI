package edu.ftiuksw.testapi;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Products {
    @SerializedName("products")
    private ArrayList<Product> data;
    @SerializedName("total")
    private int total;
    @SerializedName("skip")
    private int skip;
    @SerializedName("limit")
    private int limit;

    public Products(ArrayList<Product> data, int total, int skip, int limit) {
        this.data = data;
        this.total = total;
        this.skip = skip;
        this.limit = limit;
    }

    public ArrayList<Product> getData() {
        return data;
    }
}
