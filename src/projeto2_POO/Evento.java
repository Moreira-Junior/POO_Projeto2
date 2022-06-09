package projeto2_POO;

import java.util.ArrayList;
import java.util.Optional;
import java.util.function.BinaryOperator;

public class Evento {
	
	private int id;
	private String data;
	private String descricao;
	private double preco;
	private ArrayList<Participante> participantes = new ArrayList<>();
	
	public Evento(int id, String descricao, String data, double preco) {
		this.id = id;
		this.descricao = descricao;
		this.data = data;
		this.preco = preco;
	}
	
	public double getTotalValorPago() {
		BinaryOperator<Double> somatorio = (a, b) -> a + b;
		return participantes.stream().map(p -> p.getValorPago(this.preco)).reduce(somatorio).get();
	}
	
	public void adicionar(Participante participante) {
		participantes.add(participante);	
		}
	
	public void remover(Participante participante) {
		participantes.remove(participante);
	}
	
	public double getIdadeMedia() {
		BinaryOperator<Integer> somatorio = (a, b) -> a + b;
		return participantes.stream().map(p -> p.getIdade()).reduce(somatorio).get()/(double)participantes.size();
	}
	
	public ArrayList<Participante> getParticipantesPorIdade(int idade) {
		ArrayList<Participante> participantesPorIdade = new ArrayList<>(); 
		participantes.stream().filter(p -> p.getIdade() == idade).forEach(p -> participantesPorIdade.add(p));
		return participantesPorIdade;
	}
	
	public int contarConvidados() {
		return participantes.stream().filter(p -> p instanceof Convidado).toList().size();
	}
	
	public ArrayList<Convidado> getConvidados(){
		ArrayList<Convidado> convidados = new ArrayList<>();
		participantes.stream().filter(p -> p instanceof Convidado).forEach(c ->convidados.add((Convidado) c));;
		return convidados;
	}
	
	public int contarGratuidades() {
		return participantes.stream().filter(p -> p instanceof Convidado).filter(p -> p.getIdade() < 18).toList().size();
	}
	
	public ArrayList<Convidado> getConvidados(String empresa){
		ArrayList<Convidado> convidados = new ArrayList<>();
		this.getConvidados().stream().filter(c -> c.getEmpresa().equalsIgnoreCase(empresa)).forEach(c -> convidados.add(c));;
		return convidados;
	}
	
	public Participante localizar(String nome) {
		Optional<Participante> participante = participantes.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst();
		if(participante.isPresent()) {
			return participante.get();
		}
		else {
			throw new IllegalArgumentException("O participante " + nome + " não foi encontrado");
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public ArrayList<Participante> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(ArrayList<Participante> participantes) {
		this.participantes = participantes;
	}

	@Override
	public String toString() {
		return "Evento [id=" + id + ", data=" + data + ", nome=" + descricao + ", preco=" + preco + "]";
	}
}
