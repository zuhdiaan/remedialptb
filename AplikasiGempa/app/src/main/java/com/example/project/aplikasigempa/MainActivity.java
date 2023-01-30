package com.example.project.aplikasigempa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.project.aplikasigempa.adapter.ListGempaAdapter;
import com.example.project.aplikasigempa.config.RetrofitConfig;
import com.example.project.aplikasigempa.model.FeatureModel;
import com.example.project.aplikasigempa.response.Feature;
import com.example.project.aplikasigempa.response.ListGempa;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvListGempa;
    private RetrofitConfig retrofitConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        retrofitConfig = new RetrofitConfig();
        rvListGempa = findViewById(R.id.rv_list_gempa);
        rvListGempa.setLayoutManager(new LinearLayoutManager(this));
        loadData();
    }

    public void loadData(){
        Call<ListGempa> call = retrofitConfig.configRetrofit().getListGempa();
        call.enqueue(new Callback<ListGempa>() {
            @Override
            public void onResponse(Call<ListGempa> call, Response<ListGempa> response) {
                if(response.isSuccessful()){
                    ListGempa listGempa = response.body();
                    List<Feature> featureList = listGempa.getFeatures();
                    ArrayList<FeatureModel> featureArrayList = new ArrayList<>();
                    ListGempaAdapter listGempaAdapter = new ListGempaAdapter(featureArrayList);

                    for(Feature feature : featureList){
                        FeatureModel featureModel = new FeatureModel(
                                feature.getType(),
                                feature.getProperties(),
                                feature.getGeometry(),
                                feature.getId()
                        );

                        featureArrayList.add(featureModel);
                        rvListGempa.setAdapter(listGempaAdapter);
                        listGempaAdapter.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void onFailure(Call<ListGempa> call, Throwable t) {
                System.out.println("error : " + t);
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}