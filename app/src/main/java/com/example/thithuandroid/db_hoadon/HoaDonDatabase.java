package com.example.thithuandroid.db_hoadon;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.thithuandroid.model.HoaDon;

@Database(entities = {HoaDon.class}, version = 1, exportSchema = false)
public abstract class HoaDonDatabase extends RoomDatabase {
    private static final String DATABASE_NAME = "hoaDonManagement.db";
    private static HoaDonDatabase instance;

    public static synchronized HoaDonDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), HoaDonDatabase.class, DATABASE_NAME)
                    .allowMainThreadQueries().build();
        }

        return instance;
    }

    public abstract HoaDonDAO hoaDonDAO();
}
