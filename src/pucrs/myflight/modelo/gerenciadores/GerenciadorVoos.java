package pucrs.myflight.modelo.gerenciadores;

import java.time.LocalDate;
import java.util.ArrayList;

import pucrs.myflight.modelo.entidades.Voo;

public class GerenciadorVoos {
    private ArrayList<Voo> v;

    public GerenciadorVoos() {
        this.v = new ArrayList<Voo>();
    }

    public void adicionar(Voo voo) {
        v.add(voo);
    }

    public ArrayList<Voo> listarTodos() {
        return v;
    }

    public ArrayList<Voo> buscarData(LocalDate data){
        ArrayList<Voo> aux = new ArrayList<Voo>();

        for (Voo voo : v) {
            // LocalDateTime = data + hora
            // LocalDate     = data

            LocalDate dataDoVoo = voo.getDatahora().toLocalDate();

            if (data.isEqual(dataDoVoo)) aux.add(voo);
        }

        return aux;
    }
}
