package application;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main (String [] args) throws ParseException {

        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);

        //Client data
        System.out.print("Enter client data: \n");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Birth Date (DD/MM/YYYY): ");
        Date birthDate = dateFormatter.parse(sc.nextLine());

        Client client = new Client(name, email, birthDate);

        //Order data
        System.out.print("Enter order data: \n");
        System.out.print("Status: ");
        String status = sc.nextLine();
        System.out.print("How many items to this order? ");
        int items = sc.nextInt();
        Order order = new Order(OrderStatus.valueOf(status), client);

        for(int i=0;i<items;i++){
            System.out.print("Product name: ");
            String product_name = sc.next();
            System.out.print("Product price: ");
            Double product_price = sc.nextDouble();
            System.out.print("Quantity: ");
            int quantity = sc.nextInt();

            Product item = new Product(product_name, product_price);
            OrderItem orderItem = new OrderItem(quantity, item);
            orderItem.setPrice();
            order.addItem(orderItem);
        }

        order.setMoment();
        System.out.print("ORDER SUMMARY: \n");
        System.out.printf("Order moment: " + order.getMoment() + "\n");
        System.out.printf("Order status: " + order.getStatus() + "\n");
        sc.nextLine();
        System.out.print("Client: " + client.getName() + " (" + client.getBirthDate() + ") - " + client.getEmail() + "\n");
        System.out.print("Order items:\n");
        sc.nextLine();
        Double total=0.0;
        for(OrderItem item : order.getItems()){
            System.out.printf(item.getProduct().getName() + " $" + item.getProduct().getPrice() + item.getQuantity() + " Subtotal: $" + item.subTotal() + "\n");
            total+=item.subTotal();
        }
        System.out.print("Total price: $" + total);

        sc.close();
    }
}

