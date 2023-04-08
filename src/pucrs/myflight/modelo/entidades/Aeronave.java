package pucrs.myflight.modelo.entidades;

public class Aeronave {
	private String codigo;
	private String descricao;
	
	public Aeronave(String codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}
}