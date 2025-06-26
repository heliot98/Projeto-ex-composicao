package aplicacao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entidades.Cliente;
import entidades.ItemPedido;
import entidades.Pedido;
import entidades.Produto;
import entidades.enums.StatusPedido;

public class Programa {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);  
		Scanner sc = new Scanner (System.in);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		
		System.out.println("Informe os dados do Cliente");
		System.out.print("NOME :");
		String nome = sc.nextLine();
		System.out.print("EMAIL: ");
		String email = sc.nextLine();
		System.out.print("Data de nascimento (DD/MM/AAAA):");
	    String dataStr = sc.nextLine();
	    
	    Cliente cliente = new Cliente(nome, email, LocalDate.parse(dataStr, fmt));
	    
	    System.out.println("Insira os dados do pedido:");
	    System.out.print("Status: ");
	    StatusPedido status = StatusPedido.valueOf(sc.next());
	   
	    Pedido pedido = new Pedido(LocalDateTime.now(), status, cliente);
	    
	    System.out.println("Quantos itens há neste pedido? ");
	    int N = sc.nextInt();
		sc.nextLine();
	    for (int i = 1;  i <= N; i++) {
	    	System.out.println("Insira os dados do item nº" + i);
	    	System.out.print("Nome do produto: ");
	    	String nomeP = sc.nextLine();
	    	System.out.print("Preço do produto: ");
	    	double precoP = sc.nextDouble();
	    	
	    	Produto produto = new Produto(nomeP, precoP);
	    	
	    	System.out.print("Quantidade: ");
	    	int quantidade = sc.nextInt();
	    	sc.nextLine();
	    	ItemPedido itemPedido = new ItemPedido(quantidade, precoP, produto);
	       
	    	pedido.addPedido(itemPedido); // adicionando os itens a lista
	    }
		System.out.println();
	    System.out.println("SUMARIO DO PEDIDO: ");
	    System.out.println(pedido);
		
		
		sc.close();
	}
}
