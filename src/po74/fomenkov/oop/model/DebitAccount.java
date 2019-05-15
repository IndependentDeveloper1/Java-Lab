package po74.fomenkov.oop.model;

public class DebitAccount implements Account {
    private String number;
    private double balance;
    private final static String UNKNOWN_NUMBER = "";
    private final static double BALANCE_DEFAULT = 0.0;

    public DebitAccount(){
        this(UNKNOWN_NUMBER,BALANCE_DEFAULT);
            }
    public DebitAccount(String number, double balance){
        this.number = number;
        this.balance = balance;
    }

    public String getNumber(){return number; }

    public void setNumber(String newNumber){
        number = newNumber;
    }

    public double getBalance(){ return balance; }

    public void setBalance(double newBalance){
        balance = newBalance;
    }

}
