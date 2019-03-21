package po74.fomenkov.oop.model;

public class Account {
    private String number;
    private double balance;
    private final static String UNKNOWN_NUMBER = "";
    private final static double BALANCE_DEFAULT = 0.0;

    public Account(){
        this(UNKNOWN_NUMBER,BALANCE_DEFAULT);
            }
    public Account(String number, double balance){
        this.number = number;
        this.balance = balance;
    }

    public String getNumber(Account account){
        return account.number;
    }

    public void setNumber(Account account, String newNumber){
        account.number = newNumber;
    }

    public double getBalance(Account account){
        return account.balance;
    }

    public void setBalance(Account account, double newBalance){
        account.balance = newBalance;
    }
}
