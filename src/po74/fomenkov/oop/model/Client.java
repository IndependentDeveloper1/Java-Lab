package po74.fomenkov.oop.model;

public interface Client {
    boolean add(Account account);
    boolean add(int index, Account account);
    Account get(int index);
    Account get(String accountNumber);
    boolean hasAccount(String accountNumber);
    Account set(int index, Account account);
    Account remove(int index);
    Account remove(String accountNumber);
    int size();
    Account[] getAccounts();
    Account[] sortedByBalanceAccounts();
    double totalBalance();
    String getName();
    void setName(String name);
    int indexOf(String accountNumber);
    void showDetails();
}