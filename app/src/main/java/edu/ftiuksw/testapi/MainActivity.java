package edu.ftiuksw.testapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView txtNama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNama = findViewById(R.id.txtNama);
    }

    public void GetDataFromServer(View v) {
        APIList apis = RetrofitClient.getRetrofitClient().create(APIList.class);
        Call<ArrayList<Mahasiswa>> call = apis.getAllMahasiswa();
        call.enqueue(new Callback<ArrayList<Mahasiswa>>() {
            @Override
            public void onResponse(Call<ArrayList<Mahasiswa>> call, Response<ArrayList<Mahasiswa>> response) {
                if(response.isSuccessful()) {
                    ArrayList<Mahasiswa> data = response.body();
                    Log.i("MyLog", data.size()+"");
                    //for (Mahasiswa m : data) {
                        txtNama.setText(data.get(10).getNama());
                    //}
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Mahasiswa>> call, Throwable t) {
                Log.e("MyLog", t.getCause().getMessage());
                Toast.makeText(getApplicationContext(),"Something wrong. Please try again later.",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
