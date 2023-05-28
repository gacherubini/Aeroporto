package pucrs.myflight.modelo.gerenciadores;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import pucrs.myflight.modelo.entidades.Aeronave;

public class GerenciadorAeronaves {
    private static GerenciadorAeronaves INSTANCE;
    private ArrayList<Aeronave> a;

    public static GerenciadorAeronaves getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new GerenciadorAeronaves();
        }

        return INSTANCE;
    }

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
