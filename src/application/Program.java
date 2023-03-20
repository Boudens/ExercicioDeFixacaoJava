package application;

import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("Enter client data: ");
		System.out.print("Le nom: ");
		String name = sc.nextLine();
		System.out.print("E-mail: ");
		String email = sc.nextLine();
		System.out.print("Date de naissance: ");
		LocalDate birthDate = LocalDate.parse(sc.next(),fmt1);
		
		Client c1 = new Client(name,email,birthDate);
		
		System.out.println("Saisir les données de la commande: ");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		Order order = new Order(Instant.now(),status,c1);
		
		System.out.print("Combien d'articles dans cette commande? ");
		int temp = sc.nextInt();
		
		for (int i = 0; i < temp; i++) {
			System.out.println("Saisir #" + (i+1) + " données de l'article:");
			System.out.print("Nom du produit: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.print("Prix du produit: ");
			double productPrice = sc.nextDouble();
			
			Product product = new Product(productName,productPrice);
			System.out.print("Quantité: ");
			int qtd = sc.nextInt();
			OrderItem orderItem = new OrderItem(qtd,productPrice,product);
			order.addItem(orderItem);
		}
		System.out.println();
		System.out.println("Récapitulatif de la commande:");
		System.out.println(order);
		
		sc.close();
	}

}
