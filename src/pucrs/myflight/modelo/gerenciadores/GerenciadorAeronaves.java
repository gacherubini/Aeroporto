package pucrs.myflight.modelo.gerenciadores;

import java.util.ArrayList;

import pucrs.myflight.modelo.entidades.Aeronave;

public class GerenciadorAeronaves {
    private ArrayList<Aeronave> a;

    public GerenciadorAeronaves() {
        this.a = new ArrayList<Aeronave>();
    }

    public void adicionar(Aeronave aeronave) {
        a.add(aeronave);
    }

    public ArrayList<Aeronave> listarTodos() {
        return a;
    }
    
    public Aeronave buscarPorCodigo(String codigo) {
        for (Aeronave aeronave : a) {
            if (codigo.equals(aeronave.getCodigo())) {
                return aeronave;
            }
        }
        
        return null;
    }
}
