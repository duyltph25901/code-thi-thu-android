package com.example.thithuandroid.db_theloai;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.thithuandroid.model.TheLoai;

@Database(entities = {TheLoai.class}, version = 1)
public abstract class TheLoaiDatabase extends RoomDatabase {
    private static final String DATABASE_NAME = "theLoaiManagement.db";
    private static TheLoaiDatabase instance;

    public static synchronized TheLoaiDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), TheLoaiDatabase.class, DATABASE_NAME)
                    .allowMainThreadQueries().build();
        }

        return instance;
    }

    public abstract TheLoaiDAO theLoaiDAO();
}
