package po74.fomenkov.oop.model;

//todo атрибуты - приватные
public class Account {
    private String number;
    private double balance;
    private final static String NUMBER_DEFAULT = "";
    private final static double BALANCE_DEFAULT = 0.0;

    //todo литералы - это зло
    public Account(){
        this(NUMBER_DEFAULT,BALANCE_DEFAULT);
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
