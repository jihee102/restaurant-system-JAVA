package employees;

public class Waiter extends Employee{
    private boolean hasCertificate;

    public Waiter(String eName, int eSalary, boolean hasCertificate){
        super(eName,eSalary);
        this.hasCertificate = hasCertificate;
    }

    @Override
    public String toString(){
        String output = super.toString();
        if(hasCertificate){
            output+=", certified";
        }else {
            output+=", uncertified";
        }
        return output;
    }
}
