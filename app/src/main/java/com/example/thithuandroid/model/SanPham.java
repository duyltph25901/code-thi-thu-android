package com.example.thithuandroid.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "sanPham")
public class SanPham {
    @PrimaryKey(autoGenerate = false)
    @NonNull
    private String maSanPham;
    private int soLuongNhap, soLuongXuat;

    public SanPham(@NonNull String maSanPham, int soLuongNhap, int soLuongXuat) {
        this.maSanPham = maSanPham;
        this.soLuongNhap = soLuongNhap;
        this.soLuongXuat = soLuongXuat;
    }

    @NonNull
    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(@NonNull String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public int getSoLuongNhap() {
        return soLuongNhap;
    }

    public void setSoLuongNhap(int soLuongNhap) {
        this.soLuongNhap = soLuongNhap;
    }

    public int getSoLuongXuat() {
        return soLuongXuat;
    }

    public void setSoLuongXuat(int soLuongXuat) {
        this.soLuongXuat = soLuongXuat;
    }
}
