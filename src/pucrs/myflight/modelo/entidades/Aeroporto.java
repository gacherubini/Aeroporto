package pucrs.myflight.modelo.entidades;

public class Aeroporto {
	private String codigo;
	private String nome;
	private Geo local;
	
	public Aeroporto(String codigo, String nome, Geo local) {
		this.codigo = codigo;
		this.nome = nome;
		this.local = local;
	}
	
	public String getCodigo() {
		return this.codigo;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public Geo getLocal() {
		return this.local;
	}
}
