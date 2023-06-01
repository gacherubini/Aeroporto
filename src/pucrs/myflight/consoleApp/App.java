package pucrs.myflight.consoleApp;

import pucrs.myflight.modelo.gerenciadores.*;

public class App {
	public static void main(String[] args) throws Exception {
		System.out.println("\n=== My Flight ===\n");

		// Inicialização
		GerenciadorAeronaves gerenciadorAeronaves = GerenciadorAeronaves.getInstance();
		GerenciadorAeroportos gerenciadorAeroportos = GerenciadorAeroportos.getInstance();
		GerenciadorCias gerenciadorCias = GerenciadorCias.getInstance();
		GerenciadorRotas gerenciadorRotas = GerenciadorRotas.getInstance();

		gerenciadorAeronaves.carregarDados();
		gerenciadorAeroportos.carregarDados();
		gerenciadorCias.carregarDados();
		gerenciadorRotas.carregarDados();

		// Testes
		System.out.println(gerenciadorCias.buscarPorNome("Air North").getNome());
		System.out.println(gerenciadorAeronaves.buscarPorCodigo("737").getDescricao());
		System.out.println(gerenciadorAeroportos.buscarPorCodigo("ABK").getNome());
	}
}