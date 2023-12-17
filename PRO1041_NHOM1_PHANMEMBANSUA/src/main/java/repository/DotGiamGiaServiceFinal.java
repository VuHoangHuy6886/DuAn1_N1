/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import java.util.List;
import model.DotGiamGiaFinal;

/**
 *
 * @author HungLOL
 */
public interface DotGiamGiaServiceFinal {
    List<DotGiamGiaFinal> listDGG();

    void insert(DotGiamGiaFinal dgg);

    void delete(String id);

    String change(DotGiamGiaFinal dgg);
    
    
}
