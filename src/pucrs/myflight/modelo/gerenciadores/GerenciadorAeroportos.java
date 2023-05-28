package pucrs.myflight.modelo.gerenciadores;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import pucrs.myflight.modelo.entidades.Aeroporto;
import pucrs.myflight.modelo.entidades.Geo;

public class GerenciadorAeroportos {
    private static GerenciadorAeroportos INSTANCE;
    private ArrayList<Aeroporto> a;

    public static GerenciadorAeroportos getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new GerenciadorAeroportos();
        }

        return INSTANCE;
    }
    
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

    public void carregarDados() throws Exception {
        System.out.println("[Aeroportos] Carregando dados...");

        Path path = Paths.get("src/pucrs/myflight/data/airports.dat");
        
        try (BufferedReader reader = Files.newBufferedReader(path, Charset.forName("utf8"))) {
            String line = null;

            line = reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");

                double latitude = Double.parseDouble(data[1]);
                double longitude = Double.parseDouble(data[2]);

                Geo geo = new Geo(latitude, longitude);

                Aeroporto aeroporto = new Aeroporto(data[0], data[3], geo);

                this.adicionar(aeroporto);
            }
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }
}
