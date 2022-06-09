package projeto2_POO;

import java.util.Scanner;

public class Aplicacao2 {

	public static void main(String[] args) {
		Participante joao = 	new Participante("joao@gmail.com", "joao", 17);
		Participante maria = 	new Participante("maria@gmail.com", "maria", 30);
		Convidado paulo = 		new Convidado("paulo@gmail.com", "paulo",  17, "empresa1");
		Convidado katia = 		new Convidado("katia@gmail.com", "katia",  17, "empresa2");
		Convidado antonio =		new Convidado("antonio@gmail.com", "antonio",  70, "empresa2");

		Evento festa = new Evento(1,"festa do chapolin","01/07/2022",1000.0);
		Evento show = new Evento(2,"show do piseiro","15/07/2022",2000.0);

		/***********************************
		 * 
		 * Adição de relacionamentos
		 * 
		 ***********************************/

		//	relacionamentos da festa	
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

		//	relacionamentos do show	
		show.adicionar(joao);
		show.adicionar(maria);
		show.adicionar(antonio);
		joao.adicionar(show);
		maria.adicionar(show);
		antonio.adicionar(show);

		System.out.println("\n---------- FESTA ---------");
		System.out.println(festa);
		System.out.println("valor total da festa=" +festa.getTotalValorPago());
		System.out.println("idade media da festa=" +festa.getIdadeMedia());
		System.out.println("gratuidades da festa=" +festa.contarGratuidades());

		System.out.println("\nPARTICIPANTES DA FESTA ");
		for(Participante p : festa.getParticipantes())
			System.out.println(p + "  valor pago=" + p.getValorPago(festa.getPreco()));

		System.out.println("\n---------- SHOW ---------");
		System.out.println(show);
		System.out.println("valor total do show=" +show.getTotalValorPago());
		System.out.println("idade media do show=" +show.getIdadeMedia());
		System.out.println("gratuidades do show=" +show.contarGratuidades());
		System.out.println("\nPARTICIPANTES DO SHOW ");
		for(Participante p : show.getParticipantes())
			System.out.println(p + "  valor pago=" + p.getValorPago(show.getPreco()));

		
		/***********************************
		 * 
		 * Remoção de relacionamentos
		 * 
		 ***********************************/
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("\nDigite o ID do evento que joao será removido:");
		String id = teclado.nextLine();
		Evento evento = joao.localizar( Integer.parseInt(id) );
		if(evento==null) 
			System.out.println("joao nao participa do evento "+id);
		else {
			evento.remover(joao);
			joao.remover(evento);
			System.out.println("joao foi removido do evento "+evento.getId() + " -->"+joao);
		}
		
		
		System.out.println("\nDigite o NOME do participante ou convidado para ser removido do show:");
		String nome = teclado.nextLine();
		Participante participante = show.localizar(nome);
		if(participante==null) 
			System.out.println(nome + " nao participa do show");
		else {
			show.remover(participante);
			participante.remover(show);
			System.out.println("show removeu -->"+participante);
		}

		System.out.println("\nPARTICIPANTES DO SHOW (final)");
		for(Participante p : show.getParticipantes())
			System.out.println(p + "  valor pago=" + p.getValorPago(show.getPreco()));
		System.out.println("valor total do show=" +show.getTotalValorPago());
		System.out.println("idade media do show=" +show.getIdadeMedia());
		System.out.println("gratuidades do show=" +show.contarGratuidades());

		teclado.close();
	}

}
