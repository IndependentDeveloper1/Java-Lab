package po74.fomenkov.oop.model;

public abstract class AbstractAccount implements Account{
    private String number;
    private double balance;
    protected final static String NUMBER_DEFAULT = "";
    protected final static double BALANCE_DEFAULT = 0.0;

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
}
