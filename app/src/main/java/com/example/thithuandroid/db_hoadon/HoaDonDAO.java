package com.example.thithuandroid.db_hoadon;

import androidx.room.Dao;
import androidx.room.Insert;

import com.example.thithuandroid.model.HoaDon;

@Dao
public interface HoaDonDAO {
    @Insert
    void insert(HoaDon hoaDon);
}
