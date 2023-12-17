/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import java.util.List;
import model.KhachHang;

/**
 *
 * @author admin
 */
public interface KhachHangService {
    List<KhachHang> listKhachHang();

    String themKhachHang(KhachHang kh);
    
    String xoaKhachHang (KhachHang kh);

    String sua(KhachHang kh);
    
    

    List<KhachHang> Serch(String kh);
}
    
