package pucrs.myflight.modelo.gerenciadores;

import java.util.ArrayList;

import pucrs.myflight.modelo.entidades.CiaAerea;

public class GerenciadorCias {
	private ArrayList<CiaAerea> c;
	
	public GerenciadorCias() {
		c = new ArrayList<>();
	}

	public void adicionar(CiaAerea ciaAerea) {
        c.add(ciaAerea);
    }

	public ArrayList<CiaAerea> listarTodos() {
        return c;
    }

	public CiaAerea buscarPorCodigo(String codigo) {
        for (CiaAerea ciaArea : c) {
            if (codigo.equals(ciaArea.getCodigo())) return ciaArea;
        }

        return null;
    }

	public CiaAerea buscarPorNome(String nome) {
        for (CiaAerea ciaArea : c) {
            if (nome.equals(ciaArea.getNome())) return ciaArea;
        }

        return null;
    }
}
