/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import Model.Aviao;

/**
 *
 * @author 631620220
 */
public interface AviaoDAO {
    public boolean salvar(Aviao aviao);
    public boolean atualizar(Aviao aviao);
    public boolean deletar(Aviao aviao);
    public void listar();
    public Aviao consultar(int id);
}
