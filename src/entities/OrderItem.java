package entities;

public class OrderItem {
    private Integer quantity;
    private Double price;

    private Product product;

    private OrderItem(){
    }
    public OrderItem(Integer quantity, Product product){
        this.quantity = quantity;
        this.product = product;
    }

    public Integer getQuantity(){
        return this.quantity;
    }
    public Double getPrice(){
        return this.price;
    }

    public Double subTotal(){
        return quantity*price;
    }
    public Product getProduct(){
        return this.product;
    }
    public void setPrice(){
        this.price = this.product.getPrice();
    }
}
