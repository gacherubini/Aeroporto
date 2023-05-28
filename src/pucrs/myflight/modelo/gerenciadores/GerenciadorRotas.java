package pucrs.myflight.modelo.gerenciadores;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import pucrs.myflight.modelo.entidades.Rota;
import pucrs.myflight.modelo.entidades.Aeronave;
import pucrs.myflight.modelo.entidades.Aeroporto;
import pucrs.myflight.modelo.entidades.CiaAerea;

public class GerenciadorRotas {
    private static GerenciadorRotas INSTANCE;
    private ArrayList<Rota> r;
    
    public static GerenciadorRotas getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new GerenciadorRotas();
        }

        return INSTANCE;
    }
    
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

    public void carregarDados() throws Exception {
        System.out.println("[Rotas] Carregando dados...");

        GerenciadorAeronaves gerenciadorAeronaves = GerenciadorAeronaves.getInstance();
        GerenciadorAeroportos gerenciadorAeroportos = GerenciadorAeroportos.getInstance();
        GerenciadorCias gerenciadorCias = GerenciadorCias.getInstance();

        Path path = Paths.get("src/pucrs/myflight/data/routes.dat");
        
        try (BufferedReader reader = Files.newBufferedReader(path, Charset.forName("utf8"))) {
            String line = null;

            line = reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");

                String codigoAeronave = data[5].substring(0, 3);

                CiaAerea ciaAerea = gerenciadorCias.buscarPorNome(data[0]);
                Aeroporto aeroportoOrigem = gerenciadorAeroportos.buscarPorCodigo(data[1]);
                Aeroporto aeroportoDestino = gerenciadorAeroportos.buscarPorCodigo(data[2]);
                Aeronave aeronave = gerenciadorAeronaves.buscarPorCodigo(codigoAeronave);

                Rota rota = new Rota(ciaAerea, aeroportoOrigem, aeroportoDestino, aeronave);

                this.adicionar(rota);
            }
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }
}
