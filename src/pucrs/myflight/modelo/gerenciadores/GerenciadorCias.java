package pucrs.myflight.modelo.gerenciadores;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.HashMap;

import pucrs.myflight.modelo.entidades.CiaAerea;

public class GerenciadorCias {
    private static GerenciadorCias INSTANCE;
    private HashMap<String, CiaAerea> ciasAereas;
	
    public static GerenciadorCias getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new GerenciadorCias();
        }

        return INSTANCE;
    }
    
	public GerenciadorCias() {
		this.ciasAereas =  new HashMap<>();
	}

	public void adicionar(CiaAerea ciaAerea) {
        this.ciasAereas.put(ciaAerea.getNome(), ciaAerea);
    }
	
    public HashMap<String, CiaAerea> listarTodos() {
        return this.ciasAereas;
    }

    // public CiaAerea buscarPorCodigo(String codigo) {
    //     return this.ciasAereas.get(codigo);
    // }

    public CiaAerea buscarPorNome(String nome) {
        return this.ciasAereas.get(nome);
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
