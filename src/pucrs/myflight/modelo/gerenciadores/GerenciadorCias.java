package pucrs.myflight.modelo.gerenciadores;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.ArrayList;

import pucrs.myflight.modelo.entidades.CiaAerea;

public class GerenciadorCias {
    private static GerenciadorCias INSTANCE;
	private ArrayList<CiaAerea> c;
	
    public static GerenciadorCias getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new GerenciadorCias();
        }

        return INSTANCE;
    }
    
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

    public void carregarDados() throws Exception {
        System.out.println("[Companhias Aéreas] Carregando dados...");

        Path path = Paths.get("src/pucrs/myflight/data/airlines.dat");

        try (BufferedReader reader = Files.newBufferedReader(path, Charset.forName("utf8"))) {
            String line = null;

            line = reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");
              
                CiaAerea ciaAerea = new CiaAerea(data[0], data[1]);

                this.adicionar(ciaAerea);
            }
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }
}
