/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import java.util.List;
import java.util.Map;
import model.PhieuDoi;

/**
 *
 * @author phtua
 */
public interface PhieuDoiService {
     List<PhieuDoi>getAll();
    boolean them(PhieuDoi phieutra);
    boolean xoaSanPham(int idCTSP ,int SoLuong);
    Map<Integer, Integer> countPhieuDoiByNhanVien(List<PhieuDoi> phieuDoiList);
    Map<Integer, Integer> countPhieuDoiBySanPham(List<PhieuDoi> phieuDoiList);
}
