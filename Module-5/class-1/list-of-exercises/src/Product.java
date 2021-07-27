public class Product {
    private double price;
    private String Name;

    public Product(double price, String name) {
        this.price = price;
        Name = name;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return Name;
    }

    public Product(Product rhs) {
        this.price = rhs.price;
        this.Name = rhs.Name;
    }
}
