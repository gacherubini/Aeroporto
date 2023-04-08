package pucrs.myflight.modelo.gerenciadores;

import java.util.ArrayList;

import pucrs.myflight.modelo.entidades.Aeroporto;
public class GerenciadorAeroportos {
    private ArrayList<Aeroporto> a;

    public GerenciadorAeroportos() {
        this.a = new ArrayList<Aeroporto>();
    }

    public void adicionar(Aeroporto aeroporto) {
        a.add(aeroporto);
    }

    public ArrayList<Aeroporto> listarTodos() {
        return a;
    }

    public Aeroporto buscarPorCodigo(String codigo) {
        for (Aeroporto aeroporto : a) {
            if (codigo.equals(aeroporto.getCodigo())) 
            return aeroporto;
        }

        return null;
    }
}

