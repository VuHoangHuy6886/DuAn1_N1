/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelView;

import java.sql.Date;

/**
 *
 * @author vuhoa
 */
public class SanPhamViewModel {

    private int idSanPhamView;
    private String maSanPhamView;
    private String tenSanPhamView;
    private Date ngayTaoView;
    private String tenThuongHieuView;
    private String tenXuatXuView;
    private int trangThai;

    public SanPhamViewModel() {
    }

    public SanPhamViewModel(int idSanPhamView, String maSanPhamView, String tenSanPhamView, Date ngayTaoView, String tenThuongHieuView, String tenXuatXuView, int trangThai) {
        this.idSanPhamView = idSanPhamView;
        this.maSanPhamView = maSanPhamView;
        this.tenSanPhamView = tenSanPhamView;
        this.ngayTaoView = ngayTaoView;
        this.tenThuongHieuView = tenThuongHieuView;
        this.tenXuatXuView = tenXuatXuView;
        this.trangThai = trangThai;
    }

    public int getIdSanPhamView() {
        return idSanPhamView;
    }

    public void setIdSanPhamView(int idSanPhamView) {
        this.idSanPhamView = idSanPhamView;
    }

    public String getMaSanPhamView() {
        return maSanPhamView;
    }

    public void setMaSanPhamView(String maSanPhamView) {
        this.maSanPhamView = maSanPhamView;
    }

    public String getTenSanPhamView() {
        return tenSanPhamView;
    }

    public void setTenSanPhamView(String tenSanPhamView) {
        this.tenSanPhamView = tenSanPhamView;
    }

    public Date getNgayTaoView() {
        return ngayTaoView;
    }

    public void setNgayTaoView(Date ngayTaoView) {
        this.ngayTaoView = ngayTaoView;
    }

    public String getTenThuongHieuView() {
        return tenThuongHieuView;
    }

    public void setTenThuongHieuView(String tenThuongHieuView) {
        this.tenThuongHieuView = tenThuongHieuView;
    }

    public String getTenXuatXuView() {
        return tenXuatXuView;
    }

    public void setTenXuatXuView(String tenXuatXuView) {
        this.tenXuatXuView = tenXuatXuView;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

}
