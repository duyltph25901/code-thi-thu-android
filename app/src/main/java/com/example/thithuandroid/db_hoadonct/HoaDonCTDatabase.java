package com.example.thithuandroid.db_hoadonct;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.thithuandroid.model.HoaDonChiTiet;

@Database(entities = {HoaDonChiTiet.class}, version = 1, exportSchema = false)
public abstract class HoaDonCTDatabase extends RoomDatabase {
    private static final String DATABASE_NAME = "hoaDonChiTietManagement.db";
    private static HoaDonCTDatabase instance;

    public static synchronized HoaDonCTDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), HoaDonCTDatabase.class, DATABASE_NAME)
                    .allowMainThreadQueries().build();
        }

        return instance;
    }

    public abstract HoaDonCTDAO hoaDonCTDAO();
}
