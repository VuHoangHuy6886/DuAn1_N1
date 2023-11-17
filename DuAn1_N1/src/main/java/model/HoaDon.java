package model;

import java.sql.Date;
import java.time.LocalDate;

public class HoaDon {

    private int id;
    private String maHD;
    private LocalDate ngayTao;
    private LocalDate ngaySua;
    private int idKH;
    private float tongTienHang;
    private int idNhanVien;

    public HoaDon() {
    }

    public HoaDon(int id, String maHD, LocalDate ngayTao, LocalDate ngaySua, int idKH, float tongTienHang, int idNhanVien) {
        this.id = id;
        this.maHD = maHD;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.idKH = idKH;
        this.tongTienHang = tongTienHang;
        this.idNhanVien = idNhanVien;
    }

    public HoaDon(int i, String maHD, Date ngayTao, Date ngaySua, int i0, float tongTienHang, int i1) {
        this.id = i;
        this.maHD = maHD;
        this.ngayTao = ngayTao.toLocalDate();
        this.ngaySua = ngaySua.toLocalDate();
        this.idKH = i0;
        this.tongTienHang = tongTienHang;
        this.idNhanVien = i1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public LocalDate getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(LocalDate ngayTao) {
        this.ngayTao = ngayTao;
    }

    public LocalDate getNgaySua() {
        return ngaySua;
    }

    public void setNgaySua(LocalDate ngaySua) {
        this.ngaySua = ngaySua;
    }

    public int getIdKH() {
        return idKH;
    }

    public void setIdKH(int idKH) {
        this.idKH = idKH;
    }

    public float getTongTienHang() {
        return tongTienHang;
    }

    public void setTongTienHang(float tongTienHang) {
        this.tongTienHang = tongTienHang;
    }

    public int getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(int idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

}
