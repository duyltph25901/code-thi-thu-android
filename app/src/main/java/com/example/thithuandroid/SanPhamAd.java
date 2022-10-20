package com.example.thithuandroid;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thithuandroid.model.HoaDon;
import com.example.thithuandroid.model.HoaDonChiTiet;

import java.util.List;

public class SanPhamAd extends RecyclerView.Adapter<SanPhamAd.SanPhamViewHolder>{
    private List<HoaDonChiTiet> chiTiets;

    public void setChiTiets(List<HoaDonChiTiet> chiTiets) {
        this.chiTiets = chiTiets;

        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SanPhamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SanPhamViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull SanPhamViewHolder holder, int position) {
        HoaDonChiTiet chiTiet = chiTiets.get(position);

        if (chiTiet == null) return;

        holder.bindHolder(chiTiet);
    }

    @Override
    public int getItemCount() {
        return chiTiets.size();
    }

    public class SanPhamViewHolder extends RecyclerView.ViewHolder {
        TextView txtMaLoai, txtMaSP, txtSoLuongNhap, txtSoLuongXuat, txtDonGiaNhap, txtDonGiaXuat, txtNgayNhap, txtNgayXuat;

        public SanPhamViewHolder(@NonNull View itemView) {
            super(itemView);

            init(itemView);
        }

        private void init(View view) {
            txtMaLoai = view.findViewById(R.id.maLoaiSanPhamItem);
            txtMaSP = view.findViewById(R.id.maSanPhamItem);
            txtSoLuongNhap = view.findViewById(R.id.soLuongNhapItem);
            txtSoLuongXuat = view.findViewById(R.id.soLuongXuatItem);
            txtDonGiaNhap = view.findViewById(R.id.donGiaNhapItem);
            txtDonGiaXuat = view.findViewById(R.id.donGiaXuatItem);
            txtNgayNhap = view.findViewById(R.id.ngayNhapItem);
            txtNgayXuat = view.findViewById(R.id.ngayXuatItem);
        }

        private void bindHolder(final HoaDonChiTiet chiTiet) {
            txtMaLoai.setText(chiTiet.getTheLoai());
            txtMaSP.setText(chiTiet.getMaSanPham());
            txtSoLuongNhap.setText(String.valueOf(chiTiet.getSoLuongNhap()));
            txtSoLuongXuat.setText(String.valueOf(chiTiet.getSoLuongXuat()));
            txtDonGiaNhap.setText(String.valueOf(chiTiet.getDonGiaNhap()));
            txtDonGiaXuat.setText(String.valueOf(chiTiet.getDonGiaXuat()));
            txtNgayXuat.setText(chiTiet.getNgayXuat());
            txtNgayNhap.setText(chiTiet.getNgayNhap());
        }
    }
}
