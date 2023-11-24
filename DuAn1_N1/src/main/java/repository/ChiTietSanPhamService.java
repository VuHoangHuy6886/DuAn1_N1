/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import java.util.List;
import model.ChiTietSanPham;
import modelView.CTSP;

/**
 *
 * @author vuhoa
 */
public interface ChiTietSanPhamService {

    List<CTSP> listChiTietSanPham();

    String themCTSP(ChiTietSanPham sp);

    String sua(ChiTietSanPham sp);

    List<CTSP> Serch(String sp);

    List<CTSP> getSanPhamInHoaDon(int index);
}
