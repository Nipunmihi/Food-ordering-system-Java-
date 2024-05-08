package mngFooditems; // Assuming that both User and Food classes are in the same package.

public class Food {
    private int id;
    private String name;
    private double price;
    private String favour;

    public Food(int id, String name, double price, String favour) {
        super();
        this.id = id;
        this.name = name;
        this.price = price;
        this.favour = favour;
    }

    public Food(String name, double price, String favour) {
        super();
        this.name = name;
        this.price = price;
        this.favour = favour;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getFavour() {
        return favour;
    }
}
