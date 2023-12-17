/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import java.util.List;
import model.SanPham;
import modelView.SanPhamViewModel;

/**
 *
 * @author vuhoa
 */
public interface SanPhamService {

    List<SanPhamViewModel> listSanPham(String search);

    String them(SanPham sp);

    String sua(SanPham sp);

    List<SanPhamViewModel> listSanPhamHienThi();
}
