package com.example.thithuandroid.db_sanpham;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.thithuandroid.model.SanPham;

@Database(entities = {SanPham.class}, version = 1)
public abstract class SanPhamDatabase extends RoomDatabase {
    private static final String DATABASE_NAME = "sanPhamManagement.db";
    private static SanPhamDatabase instance;

    public static synchronized SanPhamDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), SanPhamDatabase.class, DATABASE_NAME)
                    .allowMainThreadQueries().build();
        }

        return instance;
    }

    public abstract SanPhamDAO sanPhamDAO();
}
