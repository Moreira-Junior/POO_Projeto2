package projeto2_POO;

public class Aplicacao3 {

	public static void main(String[] args) {
		Evento festa = new Evento(3,"festa do circo","10/07/2022",100.0);

		Participante joao = 	new Participante("joao@gmail.com", "joao", 17);
		Participante maria = 	new Participante("maria@gmail.com", "maria", 30);
		Participante pedro = 	new Participante("pedro@gmail.com", "pedro", 70);
		Convidado paulo = 		new Convidado("paulo@gmail.com", "paulo",  17, "empresa1");
		Convidado katia = 		new Convidado("katia@gmail.com", "katia",  17, "empresa2");
		Convidado antonio =		new Convidado("antonio@gmail.com", "antonio",  70, "empresa2");

		//relacionar os objetos
		festa.adicionar(joao);
		festa.adicionar(maria);
		festa.adicionar(paulo);
		festa.adicionar(katia);
		festa.adicionar(antonio);
		joao.adicionar(festa);
		maria.adicionar(festa);
		paulo.adicionar(festa);
		katia.adicionar(festa);
		antonio.adicionar(festa);
		
		System.out.println(festa);
		System.out.println("\nPARTICIPANTES ");
		for(Participante p : festa.getParticipantes())
			System.out.println(p);
		
		System.out.println("\nPARTICIPANTES COM 17 ANOS");
		for(Participante p : festa.getParticipantesPorIdade(17))
			System.out.println(p);
		
		System.out.println("\nquantos convidados para a festa? " +festa.contarConvidados());

		System.out.println("\nCONVIDADOS:");
		for(Convidado c : festa.getConvidados())
			System.out.println(c);
		
		System.out.println("\nCONVIDADOS: empresa2");
		for(Convidado c : festa.getConvidados("empresa2"))
			System.out.println(c);	
	}

}