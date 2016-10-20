/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

/**
 *
 * @author Eduardo
 */
public interface RelatorioDAO {
    public void porCliente(int id);
    public void porPassageiro(int id);
    public void porOrigem(String origem);
    public void porDestino(String destino);
}
