package po74.fomenkov.oop.model;

import java.time.LocalDate;

public abstract class AbstractAccount implements Account,Cloneable{
    private String number;
    private double balance;
    protected final static String NUMBER_DEFAULT = "";
    protected final static double BALANCE_DEFAULT = 0.0;
    private LocalDate creatonDate;
    private LocalDate expirationDate;

    protected AbstractAccount(){
        this(NUMBER_DEFAULT, BALANCE_DEFAULT);
    }

    protected AbstractAccount(String number, double balance){
        this.number = number;
        this.balance = balance;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public String getNumber() {
        return number;
    }

    @Override
    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString(){
        return String.format("number: %1s balance: %2.2f", number, balance);
    }

    @Override
    public int hashCode() {
        return (System.identityHashCode(number) * System.identityHashCode(balance));
    }

    @Override
    public boolean equals(Object obj){
        if (obj == this) return true;
        if (!(obj instanceof Account)) return false;
        Account account = (Account) obj;
        return (account.getBalance() == this.balance && account.getNumber() == this.number);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public LocalDate getCreationDate(){
        return creatonDate;
    }

    public LocalDate getExpirationDate(){
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate){
        this.expirationDate = expirationDate;
    }

    public int monthesQuantityBeforeExpiration(){
        if ()

        return 0;
    }
}
