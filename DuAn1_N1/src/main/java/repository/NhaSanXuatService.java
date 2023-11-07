/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import java.util.List;
import model.NhaSanXuat;

/**
 *
 * @author vuhoa
 */
public interface NhaSanXuatService {

    List<NhaSanXuat> NSX();

    String them(NhaSanXuat nsx);

    String sua(NhaSanXuat nsx);

    String xoa(NhaSanXuat nsx);

    List<NhaSanXuat> tim(NhaSanXuat nsx);
}
