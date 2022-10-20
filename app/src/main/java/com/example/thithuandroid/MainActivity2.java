package com.example.thithuandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.thithuandroid.db_hoadonct.HoaDonCTDatabase;
import com.example.thithuandroid.model.HoaDonChiTiet;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        RecyclerView recyclerView  = findViewById(R.id.rcv);
        SanPhamAd adapter  = new SanPhamAd();
        List<HoaDonChiTiet> chiTiets = new ArrayList<>();
        adapter.setChiTiets(chiTiets);
        chiTiets = HoaDonCTDatabase.getInstance(this).hoaDonCTDAO().getList();
        adapter.setChiTiets(chiTiets);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
    }
}