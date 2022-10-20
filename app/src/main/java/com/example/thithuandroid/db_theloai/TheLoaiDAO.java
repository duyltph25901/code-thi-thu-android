package com.example.thithuandroid.db_theloai;

import androidx.room.Dao;
import androidx.room.Insert;

import com.example.thithuandroid.model.TheLoai;

@Dao
public interface TheLoaiDAO {
    @Insert
    void insert(TheLoai theLoai);
}
