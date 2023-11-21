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
public interface ChiTietVoucherService {
    List<model.ChiTietVoucher> listAll();

    String them(model.ChiTietVoucher ct);

    String Sua(model.ChiTietVoucher ct);

    String xoa(model.ChiTietVoucher ct);

    List<Voucher> serch(model.ChiTietVoucher ct);
}
