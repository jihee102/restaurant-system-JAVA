import employees.*;
import exceptions.RestaurantException;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Administration {
    private ArrayList<Employee> employees = new ArrayList<>();

    public Administration(){}

    public Employee findEmployeeByName(String name){
        for (Employee e :employees){
            if(e.getName().equals(name)){
                return e;
            }
        }
        return null;
    }

    public void addWaiter(String eName, int eSalary, boolean hasCertificate) throws RestaurantException {
        if(findEmployeeByName(eName)!= null){
            throw new RestaurantException("Employee already exists.");
        }
        Waiter w = new Waiter(eName,eSalary,hasCertificate);
        employees.add(w);
    }

    public void addCook(String eName, int eSalary) throws RestaurantException{
        if(findEmployeeByName(eName)!= null){
            throw new RestaurantException("Employee already exists.");
        }
        Cook c = new Cook(eName, eSalary);
        employees.add(c);
    }

    public void addDishForCook(String cName, String dName, double dPrice, String dCategory) throws RestaurantException{
        Employee employee = findEmployeeByName(cName);
        if(employee!= null){
            if(employee instanceof Cook){
                ((Cook) employee).addDish(dName,dPrice,dCategory);
            }else {
                throw new RestaurantException("Dish can be added only for Cook");
            }
        }else{
            throw new RestaurantException("Cook not found");
        }
    }

    public String getMostExpensiveDish(){
        String output ="The most expensive dish is: ";
        double price = 0;
        Dish dish = null;
        for(Employee e:employees){
            if(e instanceof Cook){
                if(((Cook) e).expensiveDish().getPrice() > price){
                    price = ((Cook) e).expensiveDish().getPrice();
                    dish = ((Cook) e).expensiveDish();
                }
            }
        }
        return output+dish;
    }

    public void loadFile(String fileName)throws IOException,RestaurantException {
        String jsonSting = new String(Files.readAllBytes(Paths.get(fileName)));
        JSONArray jsonArray = new JSONArray(jsonSting);
        for (int i = 0; i <jsonArray.length() ; i++) {
           JSONObject jsonObject = jsonArray.getJSONObject(i);
           addDishForCook("Faisan", jsonObject.getString("name"), jsonObject.getDouble("price"),jsonObject.getString("category"));
        }
    }

    public String toString(){
        String output ="Cooks: \n";
        for(Employee e : employees){
            if(e instanceof Cook){
                output+= e+"\n";
            }
        }
        output +="Waiters: \n";
        for(Employee e : employees){
            if(e instanceof Waiter){
                output+= e+"\n";
            }
        }
        return output;
    }
}
