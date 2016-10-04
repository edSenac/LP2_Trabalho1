/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Model.Aviao;
import interfaces.AviaoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 631620220
 */
public class AviaoDAODB implements AviaoDAO{

    private Connection conexao;
    private PreparedStatement comando;

    public Connection conectar(String sql) throws SQLException {
        conexao = BDUtil.getConnection();
        comando = conexao.prepareStatement(sql);
        return conexao;
    }

    public void conectarObtendoId(String sql) throws SQLException {
        conexao = BDUtil.getConnection();
        comando = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
    }

    public void fecharConexao() {
        try {
            if (comando != null) {
                comando.close();
            }
            if (conexao != null) {
                conexao.close();
            }
        } catch (SQLException ex) {
            System.err.println("Erro de Sistema - Erro ao encerrar a conexao");
            throw new BDException(ex);

        }

    }  

    @Override
    public boolean salvar(Aviao aviao){
        int id = 0;
        try{
            String sql = "INSERT INTO aviao (nome, n_assentos) VALUES (?, ?)";
            
            conectarObtendoId(sql);
            comando.setString(1, aviao.getNome());
            comando.setInt(2, aviao.getN_assentos());
            comando.executeUpdate();
            ResultSet resultado = comando.getGeneratedKeys();
            if(resultado.next()){
                id = resultado.getInt(1);
                aviao.setCodigo(id);
                return true;
            }else{
                System.err.println("Erro de Sistema - Nao gerou o id conforme esperado!");
                throw new BDException("Nao gerou o id conforme esperado!");
            }
        }catch(SQLException ex){
            System.err.println("Erro de Sistema - Problema ao salvar paciente no Banco de Dados!");
            throw new BDException(ex);
        }finally {
            fecharConexao();
        }
    }
    
    @Override
    public void atualizar(Aviao aviao){
        try{
            String sql = "UPDATE aviao SET nome=?, n_assentos=? WHERE id=?";
            conectar(sql);
            comando.setString(1, aviao.getNome());
            comando.setInt(2, aviao.getN_assentos());
            comando.setInt(3, aviao.getCodigo());
            comando.executeUpdate();
            
        }catch(SQLException ex){
            System.err.println("Erro de Sistema - Problema ao atualizar paciente no Banco de Dados!");
            throw new BDException(ex);
        }finally{
            fecharConexao();
        }
    }
    
    @Override
    public void deletar(Aviao aviao){
        try {
            String sql = "DELETE FROM aviao WHERE id = ?";

            conectar(sql);
            comando.setInt(1, aviao.getCodigo());
            comando.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("Erro de Sistema - Problema ao deletar paciente no Banco de Dados!");
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
                int id = resultado.getInt("id");
                String nome = resultado.getString("nome");
                int n_assentos = resultado.getInt("n_assentos");
                
                Aviao aviao = new Aviao(id, nome, n_assentos);
                
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
    public Aviao consultar(int id){
        String sql = "SELECT * FROM aviao WHERE id = ?";

        try {
            conectar(sql);
            comando.setInt(1, id);

            ResultSet resultado = comando.executeQuery();

            if (resultado.next()) {
                String nome = resultado.getString("nome");
                int n_assentos = resultado.getInt("n_assentos");
                
                Aviao aviao = new Aviao(id, nome, n_assentos);

                return aviao;
            }
        } catch (SQLException ex) {
            System.err.println("Erro de Sistema - Problema ao buscar o paciente pelo id do Banco de Dados!");
            throw new BDException(ex);
        } finally {
            fecharConexao();
        }
        return null;
    }
    
    @Override
    public List<Aviao> procurarPorNome(String name) {
        List<Aviao> listaAvioes = new ArrayList<>();
        String sql = "SELECT * FROM aviao WHERE nome LIKE ?";

        try {
            conectar(sql);
            comando.setString(1, "%" + name + "%");
            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {
                int id = resultado.getInt("id");
                String nome = resultado.getString("nome");
                int n_assentos = resultado.getInt("n_assentos");

                Aviao aviao = new Aviao(id, nome, n_assentos);

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
}
