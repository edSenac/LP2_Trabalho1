/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import Model.Aviao;
import java.util.List;

/**
 *
 * @author 631620220
 */
public interface AviaoDAO {
    public boolean salvar(Aviao aviao);
    public void atualizar(Aviao aviao);
    public void deletar(Aviao aviao);
    public List<Aviao> listar();
    public Aviao consultar(int id);
    public List<Aviao> procurarPorNome(String name);
}
