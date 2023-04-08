package pucrs.myflight.modelo.gerenciadores;

import java.util.ArrayList;

import pucrs.myflight.modelo.entidades.Rota;
import pucrs.myflight.modelo.entidades.Aeroporto;

public class GerenciadorRotas {
    private ArrayList<Rota> r;
    
    public GerenciadorRotas() {
        this.r = new ArrayList<Rota>();
    }

    public void adicionar(Rota rota) {
        r.add(rota);
    }

    public ArrayList<Rota> listarTodas() {
        return r;
    }

    public ArrayList<Rota> buscarPorOrigem(Aeroporto origem) {
        ArrayList<Rota> aux = new ArrayList<Rota>();

        for (Rota rota : r) {
            if (origem.equals(rota.getOrigem())) aux.add(rota);
        }

        return aux;
    }

}
