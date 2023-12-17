/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import java.util.List;

/**
 *
 * @author vuhoa
 */
public interface CrudfullTable<T> {

    List<T> listAll();

    String them(T t);

    String Sua(T t);

    String xoa(T t);

    List<T> serch(T t);
}
