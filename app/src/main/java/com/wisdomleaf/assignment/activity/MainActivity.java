package com.wisdomleaf.assignment.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import com.wisdomleaf.assignment.R;
import com.wisdomleaf.assignment.commonClass.CommanMethods;
import com.wisdomleaf.assignment.commonClass.JsonInterfaceClass;
import com.wisdomleaf.assignment.commonClass.Utils;
import com.wisdomleaf.assignment.modal.ResponseBody;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RowAdapter rowAdapter;
    private RecyclerView recyclerView;
    private JsonInterfaceClass interfaceClass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        getData();
    }

    private void getData() {
        interfaceClass = CommanMethods.getRetrofit(MainActivity.this).create(JsonInterfaceClass.class);
        Utils.displayProgressDialog(this, getString(R.string.processing_request), false);
        Call<ArrayList<ResponseBody>> responseCall = interfaceClass.getData();
        responseCall.enqueue(new Callback<ArrayList<ResponseBody>>() {
            @Override
            public void onResponse(Call<ArrayList<ResponseBody>> call, Response<ArrayList<ResponseBody>> response) {
                Utils.cancelProgressDialog(MainActivity.this);
                if (response.isSuccessful()){
                    if (response.body()!=null && !response.body().toString().isEmpty()){
                        rowAdapter = new RowAdapter(MainActivity.this,response.body());
                        recyclerView.setAdapter(rowAdapter);
                    }else {

                    }
                }else {

                }

            }

            @Override
            public void onFailure(Call<ArrayList<ResponseBody>> call, Throwable t) {
                Utils.cancelProgressDialog(MainActivity.this);
               Toast.makeText(MainActivity.this, getString(R.string.unable_to_process), Toast.LENGTH_SHORT).show();


            }
        });

    }

}
