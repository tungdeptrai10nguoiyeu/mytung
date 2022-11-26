package com.example.mytung.DAO;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.mytung.database.SQLite;
import com.example.mytung.model.NhanVien;

import java.util.ArrayList;
import java.util.List;

public class NhanVienDAO {
     SQLiteDatabase sqLiteDatabase;
    SQLite sqLite;
    Context context;

    public NhanVienDAO(Context context) {
        this.context = context;
        sqLite = new SQLite(context);
        sqLiteDatabase = sqLite.getWritableDatabase();
    }

    public int insert(NhanVien nv){
        ContentValues values = new ContentValues();
        values.put("ma_nhan_vien",nv.getMa_nhan_vien());
        values.put("tai_khoan",nv.getTai_khoan());
        values.put("mat_khau",nv.getMat_khau());
        values.put("ngay_vao_lam",nv.getNgay_vao_lam());
        values.put("gioi_tinh",nv.getGioi_tinh());
        values.put("ho_ten",nv.getHo_ten());
        values.put("dia_chi",nv.getDia_chi());
        values.put("so_dien_thoai",nv.getSo_dien_thoai());
        values.put("level",nv.getLevel());
        long kq = sqLiteDatabase.insert("NHAN_VIEN",null,values);
        if (kq <= 0){
            return -1;
        }
        return 1;
    }

    public int update(NhanVien nv){
        ContentValues values = new ContentValues();
        values.put("ma_nhan_vien",nv.getMa_nhan_vien());
        values.put("tai_khoan",nv.getTai_khoan());
        values.put("mat_khau",nv.getMat_khau());
        values.put("ngay_vao_lam",nv.getNgay_vao_lam());
        values.put("gioi_tinh",nv.getGioi_tinh());
        values.put("ho_ten",nv.getHo_ten());
        values.put("dia_chi",nv.getDia_chi());
        values.put("so_dien_thoai",nv.getSo_dien_thoai());
        values.put("level",nv.getLevel());
        long kq = sqLiteDatabase.update("NHAN_VIEN",values,"ma_nhan_vien=?",new String[]{String.valueOf(nv.getMa_nhan_vien())});
        if (kq <= 0){
            return -1;
        }
        return 1;
    }

    public int delete(String id){
        return sqLiteDatabase.delete("NHAN_VIEN","ma_nhan_vien",new String[]{id});
    }

    @SuppressLint("Range")
    public List<NhanVien> getData(String sql, String...selectionArgs){
        List<NhanVien> list = new ArrayList<>();
        Cursor c = sqLiteDatabase.rawQuery(sql,selectionArgs);
        while (c.moveToNext()){
            NhanVien nv = new NhanVien();
            nv.setMa_nhan_vien(Integer.parseInt(c.getString(c.getColumnIndex("ma_nhan_vien"))));
            //nv.setTai_khoan(c.getString(c.getColumnIndex("tai_khoan")));
            //nv.setMat_khau(c.getString(c.getColumnIndex("mat_khau")));
            nv.setNgay_vao_lam(c.getString(c.getColumnIndex("ngay_vao_lam")));
            nv.setGioi_tinh(c.getString(c.getColumnIndex("gioi_tinh")));
            nv.setHo_ten(c.getString(c.getColumnIndex("ho_ten")));
            //nv.setDia_chi(c.getString(c.getColumnIndex("dia_chi")));
            //nv.setSo_dien_thoai(c.getString(c.getColumnIndex("so_dien_thoai")));
            nv.setLevel(c.getString(c.getColumnIndex("level")));
            list.add(nv);
        }
        return list;
    }

    public List<NhanVien> getAll(){
        String sql = "SELECT ma_nhan_vien, ho_ten, gioi_tinh, ngay_vao_lam, level  FROM NHAN_VIEN";
        return getData(sql);
    }

    public NhanVien getID(String id){
        String sql = "SELECT ma_nhan_vien, ho_ten, gioi_tinh, ngay_vao_lam, level FROM NHAN_VIEN WHERE ma_nhan_vien=?";
        List<NhanVien> nv = getData(sql,id);
        return nv.get(0);
    }
}
