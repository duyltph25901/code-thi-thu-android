package com.example.thithuandroid.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "hoaDonChiTiet")
public class HoaDonChiTiet {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String theLoai;
    private String maSanPham;
    private int soLuongNhap, soLuongXuat;
    private double donGiaNhap, donGiaXuat;
    private String ngayNhap, ngayXuat;


    public HoaDonChiTiet(String theLoai, String maSanPham, int soLuongNhap, int soLuongXuat, double donGiaNhap, double donGiaXuat, String ngayNhap, String ngayXuat) {
        this.theLoai = theLoai;
        this.maSanPham = maSanPham;
        this.soLuongNhap = soLuongNhap;
        this.soLuongXuat = soLuongXuat;
        this.donGiaNhap = donGiaNhap;
        this.donGiaXuat = donGiaXuat;
        this.ngayNhap = ngayNhap;
        this.ngayXuat = ngayXuat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
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

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public String getNgayXuat() {
        return ngayXuat;
    }

    public void setNgayXuat(String ngayXuat) {
        this.ngayXuat = ngayXuat;
    }
}
