package com.example.mytung.Fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.mytung.DAO.NhanVienDAO;
import com.example.mytung.R;
import com.example.mytung.adapter.NhanvienAdapter;
import com.example.mytung.model.NhanVien;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class NhanvienFragment extends Fragment {
    ListView lv;
    ArrayList<NhanVien> list;
    FloatingActionButton fab;
    Dialog dialog;
    EditText ma_nhan_vien,tai_khoan,mat_khau,ngay_vao_lam,gioi_tinh,ho_ten,dia_chi,so_dien_thoai,level;
    Button btnsave,btncancel;
    NhanVienDAO nvDao;
    NhanvienAdapter adapter;
    NhanVien item;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
    View view = inflater.inflate(R.layout.activity_fragment_ds_nhanvien,container,false);
    lv = view.findViewById(R.id.lv_nhanvien);
    fab = view.findViewById(R.id.tv_fab);
    nvDao = new NhanVienDAO(getContext());
    capnhat();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 opendialogInsert(getContext());
            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                item = list.get(position);
                 opendialogUpdate(item);
            }
        });
            return view;
    }

    protected void opendialogInsert(Context context){
        dialog = new Dialog(context);
        Window window = dialog.getWindow();
        if (window == null){
            return;
        }
        dialog.setContentView(R.layout.dialog_them_nhan_vien);
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        WindowManager.LayoutParams windowAttributes = window.getAttributes();
        window.setAttributes(windowAttributes);
        // ánh xạ
        ma_nhan_vien = dialog.findViewById(R.id.edt_tnv_id);
        ho_ten = dialog.findViewById(R.id.edt_tnv_hoten);
        so_dien_thoai = dialog.findViewById(R.id.edt_tnv_sdt);
        level = dialog.findViewById(R.id.edt_tnv_level);
        gioi_tinh = dialog.findViewById(R.id.edt_tnv_gioi_tinh);
        dia_chi = dialog.findViewById(R.id.edt_tnv_dia_chi);
        tai_khoan = dialog.findViewById(R.id.edt_tnv_tai_khoan);
        mat_khau = dialog.findViewById(R.id.edt_tnv_mat_khau);
        ngay_vao_lam = dialog.findViewById(R.id.edt_tnv_ngay_vao_lam);

        btnsave = dialog.findViewById(R.id.btn_tnv_them);


        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item = new NhanVien();
                item.setMa_nhan_vien(Integer.parseInt(ma_nhan_vien.getText().toString()));
                item.setTai_khoan(tai_khoan.getText().toString());
                item.setMat_khau(mat_khau.getText().toString());
                item.setNgay_vao_lam(ngay_vao_lam.getText().toString());
                item.setGioi_tinh(gioi_tinh.getText().toString());
                item.setHo_ten(ho_ten.getText().toString());
                item.setDia_chi(dia_chi.getText().toString());
                item.setSo_dien_thoai(so_dien_thoai.getText().toString());
                item.setLevel(level.getText().toString());
                if (validate()>0){
                    int kq = nvDao.insert(item);
                    if(kq ==1){
                        Toast.makeText(getContext(),"Thêm thành công!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getContext(),"Thêm không thành công!", Toast.LENGTH_SHORT).show();
                    }
                    capnhat();
                    dialog.cancel();

                }
            }
        });
        dialog.show();
    }

    protected void opendialogUpdate(NhanVien nv){
        dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.dialog_chinh_sua_nv);

        ho_ten = dialog.findViewById(R.id.edt_csnv_hoten);
        level = dialog.findViewById(R.id.edt_csnv_tuoi);
        gioi_tinh = dialog.findViewById(R.id.edt_csnv_gioitinh);
        so_dien_thoai = dialog.findViewById(R.id.edt_csnv_sdt);
        mat_khau = dialog.findViewById(R.id.edt_csnv_matkhau);
        btnsave = dialog.findViewById(R.id.btn_csnv_luu);

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item = new NhanVien();
                item.setMa_nhan_vien(Integer.parseInt(ma_nhan_vien.getText().toString()));
                item.setTai_khoan(tai_khoan.getText().toString());
                item.setMat_khau(mat_khau.getText().toString());
                item.setNgay_vao_lam(ngay_vao_lam.getText().toString());
                item.setGioi_tinh(gioi_tinh.getText().toString());
                item.setHo_ten(ho_ten.getText().toString());
                item.setDia_chi(dia_chi.getText().toString());
                item.setSo_dien_thoai(so_dien_thoai.getText().toString());
                item.setLevel(level.getText().toString());
                if (validate()>0){
                    int kq = nvDao.update(item);
                    if(kq ==1){
                        Toast.makeText(getContext(),"Update thành công!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getContext(),"Update không thành công!", Toast.LENGTH_SHORT).show();
                    }
                    capnhat();
                    dialog.dismiss();

                }
            }
        });
        dialog.show();
    }

    public void xoa(String id){
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Xoá?");
        builder.setCancelable(true);
        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                nvDao.delete(id);
                capnhat();
                dialog.cancel();
            }
        });
        builder.setNegativeButton("NO",((dialog1, which) -> {dialog.cancel();}));
        AlertDialog alertDialog = builder.create();
        builder.show();
    }

   public int validate(){
        int check = 1;
        if(ho_ten.getText().length()==0 || level.getText().length() ==0 || gioi_tinh.getText().length() == 0 || ngay_vao_lam.getText().length() == 0){
            Toast.makeText(getContext(), "Chưa nhập đủ thông tin !",Toast.LENGTH_SHORT).show();
        }
        return check;
    }
    public void capnhat(){
        list = (ArrayList<NhanVien>) nvDao.getAll();
        adapter = new NhanvienAdapter(getContext(),this,list);
        lv.setAdapter(adapter);
    }
}
