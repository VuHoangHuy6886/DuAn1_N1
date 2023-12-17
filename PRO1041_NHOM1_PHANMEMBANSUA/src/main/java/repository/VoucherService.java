/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import java.util.List;
import model.Voucher;

/**
 *
 * @author Thang
 */
public interface VoucherService {

    List<Voucher> listAll();

    String them(Voucher vc);

    String Sua(Voucher t);

    String xoa(Voucher t);

    List<Voucher> serch(Voucher t);
}
