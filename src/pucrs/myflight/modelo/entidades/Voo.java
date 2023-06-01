package pucrs.myflight.modelo.entidades;

import java.time.LocalDateTime;
import java.time.Duration;

public class Voo {
	public enum Status { CONFIRMADO, ATRASADO, CANCELADO };
	
	private Rota rota;
	private LocalDateTime datahora;
	private Duration duracao;
	private Status status;
	
	public Voo(Rota rota, LocalDateTime datahora, Duration duracao) {
		this.rota = rota;
		this.datahora = datahora;
		this.duracao = duracao;
		this.status = Status.CONFIRMADO;
	}
	
	public Rota getRota() {
		return this.rota;
	}
	
	public LocalDateTime getDatahora() {
		return this.datahora;
	}
	
	public Duration getDuracao() {
		return this.duracao;
	}
	
	public Status getStatus() {
		return this.status;
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}

	// TODO: Implementar um toString() bonitinho.
	@Override
	public String toString() {
		return "Voo.toString()";
	}
}
