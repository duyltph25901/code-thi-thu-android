package com.example.thithuandroid.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "theLoai")
public class TheLoai {
    @PrimaryKey(autoGenerate = false)
    @NonNull
    private String maTheLoai;

    public TheLoai(@NonNull String maTheLoai) {
        this.maTheLoai = maTheLoai;
    }

    @NonNull
    public String getMaTheLoai() {
        return maTheLoai;
    }

    public void setMaTheLoai(@NonNull String maTheLoai) {
        this.maTheLoai = maTheLoai;
    }
}
