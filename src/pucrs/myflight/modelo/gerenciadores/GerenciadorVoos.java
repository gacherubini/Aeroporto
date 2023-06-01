package pucrs.myflight.modelo.gerenciadores;

import java.time.LocalDate;
import java.util.ArrayList;

import pucrs.myflight.modelo.entidades.Voo;

public class GerenciadorVoos {
    private ArrayList<Voo> voos;

    public GerenciadorVoos() {
        this.voos = new ArrayList<>();
    }

    public void adicionar(Voo voo) {
        this.voos.add(voo);
    }

    public ArrayList<Voo> listarTodos() {
        return this.voos;
    }

    public ArrayList<Voo> buscarPorDatahora(LocalDate datahora){
        ArrayList<Voo> aux = new ArrayList<>();

        for (Voo voo : this.voos) {
            // LocalDate     = data
            // LocalDateTime = data + hora

            LocalDate data = voo.getDatahora().toLocalDate();

            if (datahora.isEqual(data)) aux.add(voo);
        }

        return aux;
    }
}
