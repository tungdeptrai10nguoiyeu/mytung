package com.example.mytung.model;

public class NhanVien {
    private int ma_nhan_vien;
    private String tai_khoan;
    private String mat_khau;
    private String ngay_vao_lam;
    private String gioi_tinh;
    private String ho_ten;
    private String so_dien_thoai;
    private String dia_chi;
    private String level;

    public NhanVien(){
    }

    public NhanVien(int ma_nhan_vien, String tai_khoan, String mat_khau, String ngay_vao_lam, String gioi_tinh, String ho_ten, String so_dien_thoai, String dia_chi, String level) {
        this.ma_nhan_vien = ma_nhan_vien;
        this.tai_khoan = tai_khoan;
        this.mat_khau = mat_khau;
        this.ngay_vao_lam = ngay_vao_lam;
        this.gioi_tinh = gioi_tinh;
        this.ho_ten = ho_ten;
        this.so_dien_thoai = so_dien_thoai;
        this.dia_chi = dia_chi;
        this.level = level;
    }

    public int getMa_nhan_vien() {
        return ma_nhan_vien;
    }

    public void setMa_nhan_vien(int ma_nhan_vien) {
        this.ma_nhan_vien = ma_nhan_vien;
    }

    public String getTai_khoan() {
        return tai_khoan;
    }

    public void setTai_khoan(String tai_khoan) {
        this.tai_khoan = tai_khoan;
    }

    public String getMat_khau() {
        return mat_khau;
    }

    public void setMat_khau(String mat_khau) {
        this.mat_khau = mat_khau;
    }

    public String getNgay_vao_lam() {
        return ngay_vao_lam;
    }

    public void setNgay_vao_lam(String ngay_vao_lam) {
        this.ngay_vao_lam = ngay_vao_lam;
    }

    public String getGioi_tinh() {
        return gioi_tinh;
    }

    public void setGioi_tinh(String gioi_tinh) {
        this.gioi_tinh = gioi_tinh;
    }

    public String getHo_ten() {
        return ho_ten;
    }

    public void setHo_ten(String ho_ten) {
        this.ho_ten = ho_ten;
    }

    public String getSo_dien_thoai() {
        return so_dien_thoai;
    }

    public void setSo_dien_thoai(String so_dien_thoai) {
        this.so_dien_thoai = so_dien_thoai;
    }

    public String getDia_chi() {
        return dia_chi;
    }

    public void setDia_chi(String dia_chi) {
        this.dia_chi = dia_chi;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
