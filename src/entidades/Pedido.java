package entidades;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import entidades.enums.StatusPedido;

public class Pedido {

	private LocalDateTime momento;
	private StatusPedido status;
    private Cliente cliente;
	private List<ItemPedido> itens = new ArrayList<>();

	 DateTimeFormatter ftmbr = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
	
	public Pedido() {

	}

	

	public Pedido(LocalDateTime momento, StatusPedido status, Cliente cliente) {
		
		this.momento = momento;
		this.status = status;
		this.cliente = cliente;
	}

	public LocalDateTime getMomento() {
		return momento;
	}

	public void setMomento(LocalDateTime momento) {
		this.momento = momento;
	}

	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}

	public List<ItemPedido> getItens() {
		return itens;
	}

	public Cliente getCliente() {
		return cliente;
	}



	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public void addPedido(ItemPedido item) { // adicionar item a lista
		itens.add(item);
	}

	public void removePedido(ItemPedido item) {
		itens.remove(item);
	}
     
	public double total () {
		double soma =0.0;
		for(ItemPedido item : itens) {
			soma += item.subTotal();
		}
	return soma;
	}
	
	public String toString () {
		StringBuilder sb = new StringBuilder();
		sb.append("Momento do Pedido: ");
		sb.append(LocalDateTime.now().format(ftmbr) + "\n");
		sb.append("Status do Pedido: ");
		sb.append(status + "\n");
        sb.append("Cliente: ");
        sb.append(cliente + "\n");
        sb.append("Itens do pedido: \n");
        for (ItemPedido i: itens ) {
        	sb.append(i + "\n");
        }
	  
      sb.append("Valor Total:  R$");
	  sb.append(String.format("%.2f", total()));
	return sb.toString();
	}
}
