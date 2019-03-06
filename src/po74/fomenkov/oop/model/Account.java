package po74.fomenkov.oop.model;

//todo атрибуты - приватные
public class Account {
    String number;
    double balance;

    //todo литералы - это зло
    public Account(){
        this("",0);
            }
    //todo конструкторы должны вызывать друг друга
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
