/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Model.Aviao;
import interfaces.AviaoDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 631620220
 */
public class AviaoDAODB extends DaoBd<Aviao> implements AviaoDAO{

    @Override
    public void salvar(Aviao aviao){
        int id = 0;
        try{
            String sql = "INSERT INTO aviao (nome, assentos) VALUES (?, ?)";
            
            conectarObtendoId(sql);
            comando.setString(1, aviao.getNome());
            comando.setInt(2, aviao.getAssentos());
            comando.executeUpdate();
            ResultSet resultado = comando.getGeneratedKeys();
            if(resultado.next()){
                id = resultado.getInt(1);
                aviao.setId(id);
            }else{
                System.err.println("Erro de Sistema - Nao gerou o id conforme esperado!");
                throw new BDException("Nao gerou o id conforme esperado!");
            }
        }catch(SQLException ex){
            System.err.println("Erro de Sistema - Problema ao salvar no Banco de Dados!");
            throw new BDException(ex);
        }finally {
            fecharConexao();
        }
    }
    
    @Override
    public void atualizar(Aviao aviao){
        try{
            String sql = "UPDATE aviao SET nome=?, assentos=? WHERE id_aviao=?";
            conectar(sql);
            comando.setString(1, aviao.getNome());
            comando.setInt(2, aviao.getAssentos());
            comando.setInt(3, aviao.getId());
            comando.executeUpdate();
            
        }catch(SQLException ex){
            System.err.println("Erro de Sistema - Problema ao atualizar Banco de Dados!");
            throw new BDException(ex);
        }finally{
            fecharConexao();
        }
    }
    
    @Override
    public void deletar(Aviao aviao){
        try {
            String sql = "DELETE FROM aviao WHERE id_aviao = ?";

            conectar(sql);
            comando.setInt(1, aviao.getId());
            comando.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("Erro de Sistema - Problema ao deletar do Banco de Dados!");
            throw new BDException(ex);
        } finally {
            fecharConexao();
        }
    }
    
    @Override
    public List<Aviao> listar(){
        List<Aviao> listaAvioes = new ArrayList<>();
        String sql = "SELECT * FROM aviao";
        
        try{
            conectar(sql);
            
            ResultSet resultado = comando.executeQuery();
            
            while(resultado.next()){
                int id = resultado.getInt("id_aviao");
                String nome = resultado.getString("nome");
                int assentos = resultado.getInt("assentos");
                
                Aviao aviao = new Aviao(id, nome, assentos);
                
                listaAvioes.add(aviao);
            }
        }catch(SQLException ex){
            System.err.println("Erro de Sistema - Problema ao buscar os pacientes do Banco de Dados!");
            throw new BDException(ex);
        }finally{
            fecharConexao();
        }
        return listaAvioes;
    }
    
    @Override
    public List<Aviao> procurarPorNome(String name) {
        List<Aviao> listaAvioes = new ArrayList<>();
        String sql = "SELECT * FROM aviao WHERE nome = ?";

        try {
            conectar(sql);
            comando.setString(1, name);
            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {
                int id = resultado.getInt("id_aviao");
                String nome = resultado.getString("nome");
                int assentos = resultado.getInt("assentos");

                Aviao aviao = new Aviao(id, nome, assentos);

                listaAvioes.add(aviao);

            }

        } catch (SQLException ex) {
            System.err.println("Erro de Sistema - Problema ao buscar os pacientes pelo nome do Banco de Dados!");
            throw new BDException(ex);
        } finally {
            fecharConexao();
        }
        return (listaAvioes);
    }

    @Override
    public Aviao procurarPorId(int id) {
        String sql = "SELECT * FROM aviao WHERE id_aviao = ?";

        try {
            conectar(sql);
            comando.setInt(1, id);

            ResultSet resultado = comando.executeQuery();

            if (resultado.next()) {
                String nome = resultado.getString("nome");
                int assentos = resultado.getInt("assentos");
                
                Aviao aviao = new Aviao(id, nome, assentos);

                return aviao;
            }else{
                return null;
            }
        } catch (SQLException ex) {
            System.err.println("Erro de Sistema - Problema ao buscar o paciente pelo id do Banco de Dados!");
            throw new BDException(ex);
        } finally {
            fecharConexao();
        }
    }

    @Override
    public boolean existeId(int id) {
        String sql = "SELECT * FROM aviao WHERE id_aviao = ?";

        try {
            conectar(sql);
            comando.setInt(1, id);

            ResultSet resultado = comando.executeQuery();
            
            if (resultado.next()) {
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            System.err.println("Erro de Sistema - Problema ao buscar o paciente pelo id do Banco de Dados!");
            throw new BDException(ex);
        } finally {
            fecharConexao();
        }
    }
    
}
