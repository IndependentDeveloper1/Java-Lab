package po74.fomenkov.oop.model;

import java.time.LocalDate;

public interface Account {
    String getNumber();
    void setNumber(String newNumber);
    double getBalance();
    void setBalance(double newBalance);
    LocalDate getCreationDate();
    LocalDate getExpirationDate();
    void setExpirationDate(LocalDate expirationDate);
    int monthesQuantityBeforeExpiration();
}
