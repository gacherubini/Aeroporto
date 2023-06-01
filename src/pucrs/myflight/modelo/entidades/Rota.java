package pucrs.myflight.modelo.entidades;

public class Rota {
	private CiaAerea ciaAerea;
	private Aeroporto aeroportoOrigem;
	private Aeroporto aeroportoDestino;
	private Aeronave aeronave;
	
	public Rota(CiaAerea ciaAerea, Aeroporto aeroportoOrigem, Aeroporto aeroportoDestino, Aeronave aeronave) {
		this.ciaAerea = ciaAerea;
		this.aeroportoOrigem = aeroportoOrigem;
		this.aeroportoDestino = aeroportoDestino;
		this.aeronave = aeronave;		
	}	
	
	public CiaAerea getCiaAerea() {
		return this.ciaAerea;
	}
	
	public Aeroporto getAeroportoDestino() {
		return this.aeroportoDestino;
	}
	
	public Aeroporto getAeroportoOrigem() {
		return this.aeroportoOrigem;
	}
	
	public Aeronave getAeronave() {
		return this.aeronave;
	}
}
