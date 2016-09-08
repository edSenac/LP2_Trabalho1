/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author Eduardo
 */
public class Voo {
    
    private static int CODIGO = 1;
    private int codigo;
    private String origem;
    private String destino;
    private Date horario;
    private Aviao aviao;

    public Voo(String origem, String destino, Date horario, Aviao aviao) {
        this.codigo = getCODIGO();
        this.origem = origem;
        this.destino = destino;
        this.horario = horario;
        this.aviao = aviao;
    }
    
    public static int getCODIGO() {
        return CODIGO++;
    }
    
    public int getCodigo(){
        return codigo;
    }
    
    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }

    public Aviao getAviao() {
        return aviao;
    }

    public void setAviao(Aviao aviao) {
        this.aviao = aviao;
    }
    
    
}
