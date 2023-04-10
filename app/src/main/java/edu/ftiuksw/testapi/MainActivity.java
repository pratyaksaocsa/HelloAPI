package edu.ftiuksw.testapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView txtNama;
    private Button btnGetData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNama = findViewById(R.id.txtNama);
        btnGetData = findViewById(R.id.btnGetData);
        btnGetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                APIList apis = RetrofitClient.getRetrofitClient().create(APIList.class);
                Call<Products> call = apis.getAllProduct();
                call.enqueue(new Callback<Products>() {
                    @Override
                    public void onResponse(Call<Products> call, Response<Products> response) {
                        if(response.isSuccessful()) {
                            Products products = response.body();
                            ArrayList<Product> allProduct = products.getData();
                            Product product = allProduct.get(0);
                            txtNama.setText(product.getTitle());
                            Log.i("MyLog", allProduct.size()+"");
                        }
                    }

                    @Override
                    public void onFailure(Call<Products> call, Throwable t) {
                        t.printStackTrace();
                        Toast.makeText(getApplicationContext(),"Something wrong. Please try again later.",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
