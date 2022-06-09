package projeto2_POO;

import java.util.ArrayList;
import java.util.Optional;

public class Participante {
	
	private String email;
	private String nome;
	private int idade;
	private ArrayList<Evento> eventos = new ArrayList<>();
	
	public Participante(String email, String nome, int idade) {
		this.email = email;
		this.nome = nome;
		this.idade = idade;
	}

	public int getPercentual() {
		if(this.idade < 18) {
			return 50;
		}
		else if(this.idade >= 60) {
			return 20;
		}
		else {
			return 0;
		}
	}
	
	public double getValorPago(double valor) {
		double valorPago = valor * (1 - this.getPercentual()/100.0);
		return valorPago;
	}
	
	public void adicionar(Evento evento) {
		eventos.add(evento);
	}
	
	public void remover(Evento evento) {
		eventos.remove(evento);
	}
	
	public Evento localizar(int id) {
		Optional<Evento> evento = eventos.stream().filter(e -> e.getId() == id).findFirst();
		if(evento.isPresent()) {
			return evento.get();
		}
		else {
			throw new IllegalArgumentException("Evento não encontrado!");
		} 
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public ArrayList<Evento> getEventos() {
		return eventos;
	}
	public void setEventos(ArrayList<Evento> eventos) {
		this.eventos = eventos;
	}
	
	@Override
	public String toString() {
		return "email=" + this.getEmail() + ", nome=" + this.getNome() + ", idade=" + this.getIdade() + ", percentual=" + this.getPercentual() + ", eventos=" + this.getEventos().stream().map(e -> e.getId()).toList();
	}
}
