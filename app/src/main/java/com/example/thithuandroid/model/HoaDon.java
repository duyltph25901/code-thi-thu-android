package com.example.thithuandroid.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "hoaDon")
public class HoaDon {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private double donGiaNhap, donGiaXuat;

    public HoaDon(double donGiaNhap, double donGiaXuat) {
        this.donGiaNhap = donGiaNhap;
        this.donGiaXuat = donGiaXuat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getDonGiaNhap() {
        return donGiaNhap;
    }

    public void setDonGiaNhap(double donGiaNhap) {
        this.donGiaNhap = donGiaNhap;
    }

    public double getDonGiaXuat() {
        return donGiaXuat;
    }

    public void setDonGiaXuat(double donGiaXuat) {
        this.donGiaXuat = donGiaXuat;
    }
}
