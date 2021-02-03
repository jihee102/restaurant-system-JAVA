package employees;

public abstract class Employee {
    private String name;
    private int salary;
    private int employeeNumber;
    private static int count=1;

    public Employee(String eName, int eSalary){
        this.name= eName;
        this.salary = eSalary;
        this.employeeNumber = count;
        count++;
    }

    public String getName() {
        return name;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public int getSalary() {
        return salary;
    }

    public String toString(){
        return "Employee Id: "+employeeNumber+", "+name +" ("+salary+" euro).";
    }
}
