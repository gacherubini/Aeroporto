package pucrs.myflight.modelo.gerenciadores;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

import pucrs.myflight.modelo.entidades.Aeronave;

public class GerenciadorAeronaves {
    private static GerenciadorAeronaves INSTANCE;
    private HashMap<String, Aeronave> aeronaves;

    public static GerenciadorAeronaves getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new GerenciadorAeronaves();
        }

        return INSTANCE;
    }

    public GerenciadorAeronaves() {
        this.aeronaves = new HashMap<>();
    }

    public void adicionar(Aeronave aeronave) {
        this.aeronaves.put(aeronave.getCodigo(), aeronave);
    }

    public HashMap<String, Aeronave> listarTodos() {
        return this.aeronaves;
    }
    
    public Aeronave buscarPorCodigo(String codigo) {
        return this.aeronaves.get(codigo);
    }

    public void carregarDados() throws Exception {
        System.out.println("[Aeronaves] Carregando dados...");

        Path path = Paths.get("src/pucrs/myflight/data/equipment.dat");

        try (BufferedReader reader = Files.newBufferedReader(path, Charset.forName("utf8"))) {
            String line = null;

            line = reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");
              
                Aeronave aeronave = new Aeronave(data[0], data[1], Integer.parseInt(data[2]));

                this.adicionar(aeronave);
            }
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }
}
