package edu.ftiuksw.testapi;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIList {

    @GET("mahasiswa")
    Call<ArrayList<Mahasiswa>> getAllMahasiswa();

}
