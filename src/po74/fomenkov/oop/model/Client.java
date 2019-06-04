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
    int getCreditScores();
    void addCreditScores(int creditScores);
    default ClientStatus getStatus() {
        if (getCreditScores() <= ClientStatus.BAD.getCreditScoreBound())
            return ClientStatus.BAD;
        else if (getCreditScores() >= ClientStatus.RISKY.getCreditScoreBound() & getCreditScores() < ClientStatus.GOOD.getCreditScoreBound()){
            return ClientStatus.RISKY;
        }
        else if (getCreditScores() >= ClientStatus.GOOD.getCreditScoreBound() & getCreditScores() < ClientStatus.GOLD.getCreditScoreBound()){
            return ClientStatus.GOOD;
        }
        else if (getCreditScores() >= ClientStatus.GOLD.getCreditScoreBound() & getCreditScores() < ClientStatus.PLATINUM.getCreditScoreBound()){
            return ClientStatus.GOLD;
        }
        else return ClientStatus.PLATINUM;
        //todo и так далее по диапазонам
    }
    Credit[] getCreditAccounts();
}