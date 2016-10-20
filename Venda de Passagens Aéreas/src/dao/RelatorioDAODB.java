/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import interfaces.RelatorioDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import model.Cliente;

/**
 *
 * @author Eduardo
 */
public class RelatorioDAODB implements RelatorioDAO{
    protected Connection conexao;
    protected PreparedStatement comando;

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
    public void porCliente(int id) {
        String sql = "SELECT * FROM venda "
                + "JOIN cliente USING(id_cliente) "
                + "WHERE id_cliente = ?";

        try{
            conectar(sql);
            
            comando.setInt(1, id);
            
            ResultSet resultado = comando.executeQuery();
            
            while(resultado.next()){
                String nomeCliente = resultado.getString("nome");
                int idVoo = resultado.getInt("id_voo");
                Date horario = resultado.getTimestamp("horario");
                /*
                ClienteDAODB clienteDb = new ClienteDAODB();
                Cliente cliente = clienteDb.procurarPorId(idCliente);
                
                VooDAODB vooDb = new VooDAODB();
                Voo voo = vooDb.procurarPorId(idVoo);
                
                Venda venda = new Venda(id, cliente, voo, horario);
                
                listaVendas.add(venda);*/
            }
        }catch(SQLException ex){
            System.err.println("Erro de Sistema - Problema ao buscar os pacientes do Banco de Dados!");
            throw new BDException(ex);
        }finally{
            fecharConexao();
        }
    }

    @Override
    public void porPassageiro(int id) {
         String sql = "SELECT * FROM venda "
                + "JOIN cliente USING(id_cliente) "
                + "JOIN voo USING(id_voo) "
                + "WHERE id_cliente = ?";

        try{
            conectar(sql);
            
            comando.setInt(1, id);
            
            ResultSet resultado = comando.executeQuery();
            
            while(resultado.next()){
                String nomeCliente = resultado.getString("nome");
                int idVoo = resultado.getInt("id_voo");
                Date horario = resultado.getTimestamp("horario");
                /*
                ClienteDAODB clienteDb = new ClienteDAODB();
                Cliente cliente = clienteDb.procurarPorId(idCliente);
                
                VooDAODB vooDb = new VooDAODB();
                Voo voo = vooDb.procurarPorId(idVoo);
                
                Venda venda = new Venda(id, cliente, voo, horario);
                
                listaVendas.add(venda);*/
            }
        }catch(SQLException ex){
            System.err.println("Erro de Sistema - Problema ao buscar os pacientes do Banco de Dados!");
            throw new BDException(ex);
        }finally{
            fecharConexao();
        }
    }

    @Override
    public void porOrigem(String origem) {
         String sql = "SELECT * FROM voo "
                + "JOIN aviao USING(id_aviao) "
                + "WHERE origem = ?";

        try{
            conectar(sql);
            
            comando.setString(1, origem);
            
            ResultSet resultado = comando.executeQuery();
            
            while(resultado.next()){
                String nomeCliente = resultado.getString("nome");
                int idVoo = resultado.getInt("id_voo");
                Date horario = resultado.getTimestamp("horario");
                /*
                ClienteDAODB clienteDb = new ClienteDAODB();
                Cliente cliente = clienteDb.procurarPorId(idCliente);
                
                VooDAODB vooDb = new VooDAODB();
                Voo voo = vooDb.procurarPorId(idVoo);
                
                Venda venda = new Venda(id, cliente, voo, horario);
                
                listaVendas.add(venda);*/
            }
        }catch(SQLException ex){
            System.err.println("Erro de Sistema - Problema ao buscar os pacientes do Banco de Dados!");
            throw new BDException(ex);
        }finally{
            fecharConexao();
        }
    }

    @Override
    public void porDestino(String destino) {
        String sql = "SELECT * FROM voo "
                + "JOIN aviao USING(id_aviao) "
                + "WHERE destino = ?";

        try{
            conectar(sql);
            
            comando.setString(1, destino);
            
            ResultSet resultado = comando.executeQuery();
            
            while(resultado.next()){
                String nomeCliente = resultado.getString("nome");
                int idVoo = resultado.getInt("id_voo");
                Date horario = resultado.getTimestamp("horario");
                /*
                ClienteDAODB clienteDb = new ClienteDAODB();
                Cliente cliente = clienteDb.procurarPorId(idCliente);
                
                VooDAODB vooDb = new VooDAODB();
                Voo voo = vooDb.procurarPorId(idVoo);
                
                Venda venda = new Venda(id, cliente, voo, horario);
                
                listaVendas.add(venda);*/
            }
        }catch(SQLException ex){
            System.err.println("Erro de Sistema - Problema ao buscar os pacientes do Banco de Dados!");
            throw new BDException(ex);
        }finally{
            fecharConexao();
        }
    }


    
}
