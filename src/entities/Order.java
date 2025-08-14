package entities;

import entities.enums.OrderStatus;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private Date moment;
    private OrderStatus status;

    private List<OrderItem> items = new ArrayList<>();
    private Client client;

    public Order(){
    }
    public Order(OrderStatus status, Client client){
        this.status = status;
        this.client = client;
    }

    public void setMoment(){
        this.moment = Date.from(Instant.now());
    }
    public Date getMoment(){
        return this.moment;
    }
    public OrderStatus getStatus(){
        return this.status;
    }
    public Client getClient(){
        return this.client;
    }

    public List<OrderItem> getItems(){
        return this.items;
    }
    public void addItem(OrderItem item){
        this.items.add(item);
    }
    public void removeItem(OrderItem item){
        this.items.remove(item);
    }
    public Double total(){
        Double sum=0.0;
        for (OrderItem item : items){
            sum+=item.subTotal();
        }
        return sum;
    }
}
