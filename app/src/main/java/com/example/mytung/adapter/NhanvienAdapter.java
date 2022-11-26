package com.example.mytung.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.mytung.Fragment.NhanvienFragment;
import com.example.mytung.R;
import com.example.mytung.model.NhanVien;

import java.util.ArrayList;

public class NhanvienAdapter extends ArrayAdapter<NhanVien>{
    Context context;
    NhanvienFragment fragment;
    ArrayList<NhanVien> list;
    TextView ma_nhan_vien;
    TextView ho_ten,level,gioi_tinh,ngay_vao_lam;

    public NhanvienAdapter(@NonNull Context context, NhanvienFragment fragment, ArrayList<NhanVien> list){
        super(context,0,list);
        this.context = context;
        this.fragment = fragment;
        this.list = list;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        View v = convertView;
        if(v == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.items_nhanvien,null);
        }
        final  NhanVien item = list.get(position);
        if(item != null){
            ho_ten = v.findViewById(R.id.item_ho_ten);
            ho_ten.setText("Name: "+item.getHo_ten());

            ma_nhan_vien = v.findViewById(R.id.item_ma_nhan_vien);
            ma_nhan_vien.setText("Mã nhân viên: "+item.getMa_nhan_vien());

            level = v.findViewById(R.id.item_level);
            level.setText("Level: "+item.getLevel());

            gioi_tinh = v.findViewById(R.id.item_gioi_tinh);
            gioi_tinh.setText("Giới tính: "+item.getGioi_tinh());

            ngay_vao_lam = v.findViewById(R.id.item_ngay_vao_lam);
            ngay_vao_lam.setText("Ngày vào làm: "+item.getNgay_vao_lam());
        }
        return v;

    }

}
