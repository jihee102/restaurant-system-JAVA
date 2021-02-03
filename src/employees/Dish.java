package employees;

public class Dish {
    private String name;
    private double price;
    private String category;

    public Dish(String dName, double dPrice, String dCategory){
        this.name =dName;
        this.price= dPrice;
        this.category=dCategory;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public String toString(){
        return name+": "+price;
    }
}
