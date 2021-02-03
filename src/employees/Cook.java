package employees;

import java.util.ArrayList;

public class Cook extends  Employee{
    private ArrayList<Dish> possibleDishes = new ArrayList<>();

    public Cook(String eName, int eSalary){
        super(eName,eSalary);
    }

    public void addDish(String dName, double dPrice, String dCategory){
        Dish d = new Dish(dName,dPrice,dCategory);
        possibleDishes.add(d);
    }

    public Dish expensiveDish(){
        double price = 0;
        Dish dish = null;
        for(Dish d : possibleDishes){
            if(d.getPrice() > price){
                price = d.getPrice();
                dish = d;
            }
        }
        return dish;
    }

    @Override
    public String toString(){
        String output = super.toString()+ " Can prepare the following: \n";
        for(Dish d :possibleDishes){
            output+= d+"\n";
        }
        return output;
    }
}
