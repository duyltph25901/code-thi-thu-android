package com.example.thithuandroid.db_hoadonct;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.thithuandroid.model.HoaDon;
import com.example.thithuandroid.model.HoaDonChiTiet;

import java.util.List;

@Dao
public interface HoaDonCTDAO {
    @Insert
    void insert(HoaDonChiTiet hoaDonChiTiet);

    @Query("SELECT * FROM hoaDonChiTiet")
    List<HoaDonChiTiet> getList();

    @Query("SELECT  COUNT(`id`) FROM hoaDonChiTiet")
    long count();
}
