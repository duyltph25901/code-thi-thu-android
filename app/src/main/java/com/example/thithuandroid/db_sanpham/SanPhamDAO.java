package com.example.thithuandroid.db_sanpham;

import androidx.room.Dao;
import androidx.room.Insert;

import com.example.thithuandroid.model.SanPham;

@Dao
public interface SanPhamDAO {
    @Insert
    void insert(SanPham sanPham);
}
