package projeto2_POO;

public class Convidado extends Participante {

	private String empresa;

	public Convidado(String email, String nome, int idade, String empresa) {
		super(email, nome, idade);
		this.empresa = empresa;
	}

	
	@Override
	public int getPercentual() {
		return super.getPercentual() + 50;
	}
	
	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	
	@Override
	public String toString() {
		return "email=" + this.getEmail() + ", nome=" + this.getNome() + ", idade=" + this.getIdade() + ", percentual=" + this.getPercentual() + ", empresa=" + this.getEmpresa() + ", eventos=" + this.getEventos().stream().map(e -> e.getId()).toList();
	}
}
