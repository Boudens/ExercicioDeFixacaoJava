package entities;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	private Instant date;
	private OrderStatus status;
	private Client client;

	private List<OrderItem> orders = new ArrayList<>();
	DateTimeFormatter fmt3 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.systemDefault());
	public Order() {

	}

	public Order(Instant date, OrderStatus status, Client client) {
		this.date = date;
		this.status = status;
		this.client = client;
	}

	public Instant getDate() {
		return date;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public void addItem(OrderItem item) {
		orders.add(item);
	}

	public void removeItem(OrderItem item) {
		orders.remove(item);
	}

	public double total() {
		double sum = 0.0;
		for (OrderItem item : orders) {
			sum += item.subTotal();
		}
		return sum;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Moment de la commande: ");
		sb.append(fmt3.format(date) + "\n");
		sb.append("Statut de la commande: ");
		sb.append(status + "\n");
		sb.append("Client(e): ");
		sb.append(client + "\n");
		sb.append("Items commandés:\n");
		for (OrderItem item : orders) {
			sb.append(item + "\n");
		}
		sb.append("Prix total: $");
		sb.append(String.format("%.2f", total()));
		return sb.toString();
	}
}
