package pucrs.myflight.consoleApp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import pucrs.myflight.modelo.entidades.*;
import pucrs.myflight.modelo.gerenciadores.*;

public class App {
	public static void main(String[] args) {
		System.out.println("\nMyFlight project...");

		testarGerenciadorDeAeroportos();
	}

	public static void testarGerenciadorDeAeroportos() {
		GerenciadorAeroportos g = new GerenciadorAeroportos();

		Geo loc1 = new Geo(85.3848, 22.8313);
		Geo loc2 = new Geo(99.5292, 7.4797);
		Geo loc3 = new Geo(35.669, 62.5328);

		Aeroporto aeroporto1 = new Aeroporto("POA", "Salgado Filho", loc1);
		Aeroporto aeroporto2 = new Aeroporto("GRU", "Guarulhos", loc2);
		Aeroporto aeroporto3 = new Aeroporto("LIS", "Lisboa", loc3);

		g.adicionar(aeroporto1);
		g.adicionar(aeroporto2);
		g.adicionar(aeroporto3);

		ArrayList<Aeroporto> aeroportos = g.listarTodos();

		System.out.println("listarTodos()");

		for (int i = 0; i < aeroportos.size(); i++) {
			System.out.println("Aeroporto no indíce " + i + ": " + aeroportos.get(i));
		}

		Aeroporto resultado1 = g.buscarPorCodigo("POA");
		Aeroporto resultado2 = g.buscarPorCodigo("PICA");

		System.out.println("buscarPorCodigo()");
		System.out.println("Resultado da busca por \"POA\": " + resultado1);
		System.out.println("Resultado da busca por \"PICA\": " + resultado2);
	}

}

// GerenciadorVoos gerenciadorVoos = new GerenciadorVoos(10);

// LocalDateTime d = LocalDateTime.now();
// Voo voo = new Voo(null, d, null);

// gerenciadorVoos.adicionar(voo);

// Testando o método listarTodos()
// ArrayList<Voo> todosOsVoos = gerenciadorVoos.listarTodos();

// System.out.println("Nossa lista têm " + tamanhoDaLista + " entradas.");
// System.out.println(todosOsVoos);

// Testando o método buscarData()
// LocalDate minhaData = LocalDate.of(2020,12,20);
// System.out.println("minhaData: " + minhaData);

// ArrayList<Voo> todosOsVoosNaData = gerenciadorVoos.buscarData(minhaData);

// System.out.println("Nossa lista têm " + tamanhoDaLista + " entradas.");
// System.out.println(todosOsVoosNaData);