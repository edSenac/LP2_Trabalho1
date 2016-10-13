package interfaces;

import java.util.List;

/**
 *
 * @author lhries
 * @param <T>
 */

//A ideia da interface Dao é que padronizar todos os métodos do CRUD da aplicação.
public interface Dao<T> {
    public void salvar(T tipo);
    public void deletar(T tipo);
    public void atualizar(T tipo);
    public List<T> listar();
    public T procurarPorId(int id);
}
