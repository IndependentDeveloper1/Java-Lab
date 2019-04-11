package po74.fomenkov.oop.model;

public interface Account {
    String getNumber();
    void setNumber(DebitAccount account, String newNumber);
    double getBalance();
    void setBalance(DebitAccount account, double newBalance);
}
