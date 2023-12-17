/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import java.util.List;
import model.NhanVien;


public interface NhanVienService {

    List<NhanVien> listNhanVien();

    Boolean them(NhanVien nv);

    String sua(NhanVien nv , int id);
    
   // Boolean xoa(int id);
    
}
