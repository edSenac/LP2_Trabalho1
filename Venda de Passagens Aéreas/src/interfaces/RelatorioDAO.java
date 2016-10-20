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
    public String porCliente(int id);
    public String porPassageiro(int id);
    public String porOrigem(String origem);
    public String porDestino(String destino);
}
