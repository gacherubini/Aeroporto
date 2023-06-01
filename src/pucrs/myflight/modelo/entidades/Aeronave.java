package pucrs.myflight.modelo.entidades;

public class Aeronave {
	private String codigo;
	private String descricao;
	private int capacidade;

	public Aeronave(String codigo, String descricao, int capacidade) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.capacidade = capacidade;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public int getCapacidade() {
		return this.capacidade;
	}
}
