package com.example.mytung.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLite extends SQLiteOpenHelper {

    public static final String TABLE_CHU_CUA_HANG = "CREATE TABLE CHU_CUA_HANG(ma_chu_cua_hang INTEGER PRIMARY KEY AUTOINCREMENT,ho_ten text,so_dien_thoai integer, tai_khoan text, mat_khau text, level text);";
    public static final String TABLE_NHAN_VIEN = "CREATE TABLE NHAN_VIEN(ma_nhan_vien INTEGER PRIMARY KEY AUTOINCREMENT, " +
            " tai_khoan text, mat_khau text, ngay_vao_lam date," +
            " gioi_tinh text, ho_ten text, dia_chi text, so_dien_thoai text, level text);";
    public  static  final String TABLE_HOA_DON = "CREATE TABLE HOA_DON(ma_hoa_don integer PRIMARY KEY AUTOINCREMENT, ma_nhan_vien integer REFERENCES NHAN_VIEN(ma_nhan_vien), ma_san_pham integer REFERENCES SAN_PHAM(ma_san_pham),so_luong integer, gia_ban integer, ngay_xuat_hd date);";
    public  static final String TABLE_SAN_PHAM = "CREATE TABLE SAN_PHAM(ma_san_pham integer PRIMARY KEY AUTOINCREMENT, ma_loai_hang integer REFERENCES LOAI_HANG(ma_loai_hang), ten_hang text, ngay_nhap date, so_luong integer, gia_ban integer, anh_mo_ta BLOG);";
    public static final String TABLE_LOAI_HANG = "CREATE TABLE LOAI_HANG(ma_loai_hang integer PRIMARY key AUTOINCREMENT, ten_loai_hang text);";

    public SQLite(@Nullable Context context) {
        super(context,"database.db",null,1);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CHU_CUA_HANG);
        db.execSQL(TABLE_NHAN_VIEN);
        db.execSQL(TABLE_HOA_DON);
        db.execSQL(TABLE_SAN_PHAM);
        db.execSQL(TABLE_LOAI_HANG);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE if EXISTS CHU_CUA_HANG");
        db.execSQL("DROP TABLE if EXISTS NHAN_VIEN");
        db.execSQL("DROP TABLE if EXISTS HOA_DON");
        db.execSQL("DROP TABLE if EXISTS SAN_PHAM");
        db.execSQL("DROP TABLE if EXISTS LOAI_HANG");


    }
}
