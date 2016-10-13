/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Model.Venda;
import interfaces.VendaDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 631620220
 */
public class VendaDAODB extends DaoBd<Venda> implements VendaDAO{ {
    
    @Override
    public void salvar(Venda venda){
       int id = 0;
        try{
            String sql = "INSERT INTO venda (id_cliente, id_voo, ) VALUES (?, ?, ?)";
            
            conectarObtendoId(sql);
            comando.setInt(1, venda.getCliente().getId());
            comando.setInt(2, venda.getVoo().getId());
            Timestamp timestamp;
            timestamp = new Timestamp(venda.getHorario_compra().getTime());
            comando.setTimestamp(3, timestamp);
            comando.executeUpdate();
            ResultSet resultado = comando.getGeneratedKeys();
            if(resultado.next()){
                id = resultado.getInt(1);
                venda.setId(id);
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
    public void atualizar(Venda venda){
        try{
            String sql = "UPDATE venda SET id_cliente=?, id_voo=?, horario=? WHERE id=?";
            conectar(sql);
            comando.setInt(1, venda.getCliente().getId());
            comando.setInt(2, venda.getVoo().getId());
            Timestamp timestamp;
            timestamp = new Timestamp(venda.getHorario_compra().getTime());
            comando.setTimestamp(3, timestamp);
            comando.setInt(4, venda.getId());

            comando.executeUpdate();
            
        }catch(SQLException ex){
            System.err.println("Erro de Sistema - Problema ao atualizar paciente no Banco de Dados!");
            throw new BDException(ex);
        }finally{
            fecharConexao();
        }
    }
    
    @Override
    public void deletar(Venda venda){
        try {
            String sql = "DELETE FROM venda WHERE id = ?";

            conectar(sql);
            comando.setInt(1, venda.getId());
            comando.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("Erro de Sistema - Problema ao deletar paciente no Banco de Dados!");
            throw new BDException(ex);
        } finally {
            fecharConexao();
        }
    }
    
    @Override
    public List<Venda> listar(){
        List<Venda> listaClientes = new ArrayList<>();
        String sql = "SELECT * FROM venda";
        
        try{
            conectar(sql);
            
            ResultSet resultado = comando.executeQuery();
            
            while(resultado.next()){
                int id = resultado.getInt("id");
                String rg = resultado.getString("rg");
                String nome = resultado.getString("nome");
                String telefone = resultado.getString("telefone");
                
                Cliente cliente = new Cliente(id, rg, nome, telefone);
                
                listaClientes.add(cliente);
            }
        }catch(SQLException ex){
            System.err.println("Erro de Sistema - Problema ao buscar os pacientes do Banco de Dados!");
            throw new BDException(ex);
        }finally{
            fecharConexao();
        }
    }
    
    @Override
    public Venda procurarPorId(int id){
        String sql = "SELECT * FROM cliente WHERE id = ?";

        try {
            conectar(sql);
            comando.setInt(1, id);

            ResultSet resultado = comando.executeQuery();

            if (resultado.next()) {
                String rg = resultado.getString("rg");
                String nome = resultado.getString("nome");
                String telefone = resultado.getString("telefone");
                
                /*
                usar DAO para cliente e voo
                horario = timestamp.getTime() -> vira um java.util.date
                */
                Venda venda = new Venda(id, cliente, voo, horario);

                return cliente;
            }
        } catch (SQLException ex) {
            System.err.println("Erro de Sistema - Problema ao buscar o paciente pelo id do Banco de Dados!");
            throw new BDException(ex);
        } finally {
            fecharConexao();
        }
        return null;
    }
}
