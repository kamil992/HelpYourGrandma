package pl.grandma;

import java.util.Objects;

public class Product {

    private String name;
    private int quantity;
    private double value;

    public Product(String name, int quantity, double value){
        this.name = name;
        this.quantity = quantity;
        this.value = value;
    }
    public Product(String name, double value){
        this(name,1,value);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return quantity == product.quantity &&
                Double.compare(product.value, value) == 0 &&
                Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, quantity, value);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", value=" + value +
                '}';
    }
}
