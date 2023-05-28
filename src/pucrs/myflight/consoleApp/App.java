package pucrs.myflight.consoleApp;


import pucrs.myflight.modelo.gerenciadores.*;

public class App {
	public static void main(String[] args) throws Exception {
		System.out.println("\nMyFlight project...");

		GerenciadorAeronaves gerenciadorAeronaves = GerenciadorAeronaves.getInstance();
		GerenciadorAeroportos gerenciadorAeroportos = GerenciadorAeroportos.getInstance();
		GerenciadorCias gerenciadorCias = GerenciadorCias.getInstance();
		GerenciadorRotas gerenciadorRotas = GerenciadorRotas.getInstance();

		gerenciadorAeronaves.carregarDados();
		gerenciadorAeroportos.carregarDados();
		gerenciadorCias.carregarDados();
		gerenciadorRotas.carregarDados();

		System.out.println(gerenciadorCias.buscarPorCodigo("4N").getNome());
		System.out.println(gerenciadorAeronaves.buscarPorCodigo("737").getDescricao());
		System.out.println(gerenciadorAeroportos.buscarPorCodigo("ABK").getNome());
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