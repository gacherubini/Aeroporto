package pucrs.myflight.modelo.entidades;

public class CiaAerea {
	private String codigo;
	private String nome;
	
	public CiaAerea(String codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}
	
	public String getCodigo() {
		return this.codigo;
	}
	
	public String getNome() {
		return this.nome;
	}	
}
