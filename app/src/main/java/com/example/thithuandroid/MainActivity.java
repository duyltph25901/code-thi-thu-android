package com.example.thithuandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.thithuandroid.db_hoadon.HoaDonDatabase;
import com.example.thithuandroid.db_hoadonct.HoaDonCTDAO;
import com.example.thithuandroid.db_hoadonct.HoaDonCTDatabase;
import com.example.thithuandroid.db_sanpham.SanPhamDAO;
import com.example.thithuandroid.db_sanpham.SanPhamDatabase;
import com.example.thithuandroid.db_theloai.TheLoaiDatabase;
import com.example.thithuandroid.model.HoaDon;
import com.example.thithuandroid.model.HoaDonChiTiet;
import com.example.thithuandroid.model.SanPham;
import com.example.thithuandroid.model.TheLoai;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    EditText inputMaLoaiSP, inputMaSanPham, inputSoLuongNhap,
            inputSoLuongXuat, inputDonGiaNhap, inputDonGiaXuat;
    TextView inputNgayNhap, inputNgayXuat;
    Button btn, btn4, btn2, btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        inputNgayNhap.setOnClickListener(v -> showDatePickerDialog(inputNgayNhap));
        inputNgayXuat.setOnClickListener(v -> showDatePickerDialog(inputNgayXuat));

        btn.setOnClickListener(v -> {
            Toast.makeText(this, "Tao bang thanh cong!", Toast.LENGTH_SHORT).show();
        });
        btn2.setOnClickListener(v -> add());
        btn4.setOnClickListener(v -> {
            long sum =  HoaDonCTDatabase.getInstance(MainActivity.this).hoaDonCTDAO().count();
            Toast.makeText(MainActivity.this, "Tong so ban ghi trong database "+sum, Toast.LENGTH_SHORT).show();
        });

        btn3.setOnClickListener(v -> startActivity(new Intent(getBaseContext(), MainActivity2.class)));
    }

    private void init() {
        inputMaLoaiSP = findViewById(R.id.edtMaLoaiSp);
        inputMaSanPham = findViewById(R.id.edtMaSanPan);
        inputSoLuongNhap = findViewById(R.id.edtSoLuongNhap);
        inputSoLuongXuat = findViewById(R.id.edtSoLuongXuat);
        inputDonGiaNhap = findViewById(R.id.edtDonGiaNhap);
        inputDonGiaXuat = findViewById(R.id.edtDonGiaXuat);
        inputNgayNhap = findViewById(R.id.edtNgayNhap);
        inputNgayXuat = findViewById(R.id.edtNgayXuat);
        btn = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);
    }

    private void add() {
        String maLoaiSanPham = inputMaLoaiSP.getText().toString().trim();
        String maSanPham = inputMaSanPham.getText().toString().trim();
        String soLuongNhap = inputSoLuongNhap.getText().toString().trim();
        String soLuongXuat = inputSoLuongXuat.getText().toString().trim();
        String donGiaNhap = inputDonGiaNhap.getText().toString().trim();
        String donGiaXuat = inputDonGiaXuat.getText().toString().trim();
        String ngayNhap = inputNgayNhap.getText().toString().trim();
        String ngayXuat = inputNgayXuat.getText().toString().trim();

        boolean isNullInput = isNullInput(maLoaiSanPham, maSanPham, soLuongNhap, soLuongXuat, donGiaNhap, donGiaXuat, ngayNhap, ngayXuat);
        if (isNullInput) {
            Toast.makeText(this, "Vui long dien day du thong tin!", Toast.LENGTH_SHORT).show();
        }

        TheLoai theLoai = new TheLoai(maLoaiSanPham);
        SanPham sanPham = new SanPham(maSanPham, Integer.valueOf(soLuongNhap), Integer.valueOf(soLuongXuat));
        HoaDon hoaDon = new HoaDon(Double.valueOf(donGiaNhap), Double.valueOf(donGiaXuat));
        HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet(maLoaiSanPham, maSanPham, Integer.valueOf(soLuongNhap), Integer.valueOf(soLuongXuat), Double.valueOf(soLuongNhap), Double.valueOf(soLuongXuat), ngayNhap, ngayXuat);

        insert(theLoai, sanPham, hoaDon, hoaDonChiTiet);
        Toast.makeText(this, "Them moi thanh cong!", Toast.LENGTH_SHORT).show();
    }

    private void insert(TheLoai theLoai, SanPham sanPham, HoaDon hoaDon, HoaDonChiTiet hoaDonChiTiet) {
        TheLoaiDatabase.getInstance(this).theLoaiDAO().insert(theLoai);
        SanPhamDatabase.getInstance(this).sanPhamDAO().insert(sanPham);
        HoaDonDatabase.getInstance(this).hoaDonDAO().insert(hoaDon);
        HoaDonCTDatabase.getInstance(this).hoaDonCTDAO().insert(hoaDonChiTiet);
    }

    private boolean isNullInput(String... input) {
        for (int i=0; i<input.length; i++) {
            if (input[i].isEmpty()) return true;
        }

        return false;
    }

    private void showDatePickerDialog(TextView txtView){
        final Calendar calendar = Calendar.getInstance();
        int ngay = calendar.get(Calendar.DATE);
        int thang = calendar.get(Calendar.MONTH);
        int nam = calendar.get(Calendar.YEAR);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, (view, year, month, dayOfMonth) -> {
            calendar.set(year, month, dayOfMonth);
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            txtView.setText(format.format(calendar.getTime()));
        }, nam, thang ,ngay);
        datePickerDialog.show();
    }
}
