/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import model.Aviao;
import java.util.List;

/**
 *
 * @author 631620220
 */
public interface AviaoDAO {
    public List<Aviao> procurarPorNome(String name);
    public boolean existeId(int id);
}
