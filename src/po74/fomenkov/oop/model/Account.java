package po74.fomenkov.oop.model;

//todo атрибуты - приватные
public class Account {
    public String number;
    public double balance;

    //todo литералы - это зло
    Account(){
        number = "";
        balance = 0;
    }
    //todo конструкторы должны вызывать друг друга
    Account(String number, double balance){
        this.number = number;
        this.balance = balance;
    }

    public static String getNumber(Account account){
        return account.number;
    }

    public static void setNumber(Account account, String newNumber){
        account.number = newNumber;
    }

    public static double getBalance(Account account){
        return account.balance;
    }

    public static void setBalance(Account account, double newBalance){
        account.balance = newBalance;
    }
}
