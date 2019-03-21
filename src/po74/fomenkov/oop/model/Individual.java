package po74.fomenkov.oop.model;

public class Individual {
    private int size;
    private Account[] accounts;
    private final static int CAPACITY_DEFAULT = 16;

    public Individual(){
        this(CAPACITY_DEFAULT);
    }

    public Individual(int capacity) {
        this.accounts = new Account[capacity];
    }

    public Individual(Account[] accountsOld){
        Account[] accountsNew = new Account[accountsOld.length];
        System.arraycopy(accountsOld, 0, accountsNew, 0,accountsOld.length);
        this.accounts = accountsNew;
    }

    public boolean add(Account account){
        expandArray(isArrayFull());
        accounts[size] = account;
        size++;
        return true;
    }

    public boolean add(int index, Account account){
        expandArray(isArrayFull());
        shiftOneElement(index, true);
        accounts[index] = account;
        size++;
        return true;
    }

    public Account get(int index) {
        return accounts[index];
    }

    public Account get(String accountNumber){
        return accounts[getIndex(accountNumber)];
    }

    public boolean hasAccount(String accountNumber){
        if (getIndex(accountNumber)!=(-1)) return true;
        return false;
    }

    public Account set(int index, Account account){
        Account setAccount = accounts[index];
        accounts[index] = account;
        return setAccount;
    }

    public Account remove(int index){
        Account removedAccount = accounts[index];
        shiftOneElement(index, false);
        accounts[size] = null;
        size--;
        return removedAccount;
    }

    public Account remove(String numberAccount) {
        if (hasAccount(numberAccount))return remove(getIndex(numberAccount));
        return null;
    }

    public int size(){
        return size;
    }

    public Account[] getAccounts(){
        Account[] returnedAccounts = new Account[size()];
        System.arraycopy(accounts,0,returnedAccounts,0,size);
        return returnedAccounts;
    }

    public Account[] sortedByBalanceAccounts(){
        //todo getAccounts()
        //Account[] sortedAccounts = new Account[accounts.length];
       // System.arraycopy(accounts,0,sortedAccounts,0,size);
        Account[] sortedAccounts = getAccounts();
        Account swapBuf;
        for (int i = 0; i < size-1; i++){
            for (int j = 0; j < size-1;j++) {

                if(sortedAccounts[j].getBalance(accounts[j])>sortedAccounts[j+1].getBalance(accounts[j+1])){
                    swapBuf = sortedAccounts[j+1];
                    sortedAccounts[j+1] = sortedAccounts[j];
                    sortedAccounts[j] = swapBuf;
                    //swapBuf = null;
                }
            }
        }
        return sortedAccounts;
    }

    public double totalBalance(){
        double totalBalance = 0;
        for (int i = 0; i < size; i++){
            totalBalance += accounts[i].getBalance(accounts[i]);

        }
        return totalBalance;
    }

    //todo имя - гавно //Вроде исправил
    public int getIndex(String accountNumber){
        for (int i = 0; i < size; i++){
            if (accountNumber.equals(accounts[i].getNumber(accounts[i]))) return i;
        }
        return -1;
    }

    private void shiftOneElement(int index, boolean direction /* direction*/){
        if (direction)
            System.arraycopy(accounts, index, accounts,index+1,(size-index));
        else
            System.arraycopy(accounts, index+1, accounts,index,(size-index));

    }

    //todo Имя - гавно // вроде исправил
    private boolean isArrayFull(){
        //TODO пойми, что не так =)))))
        return (size == accounts.length);
    }

    private void expandArray(boolean expand){
        Account[] accountsNew = new Account[accounts.length * 2];
        System.arraycopy(accounts,0,accountsNew,0,size);
        this.accounts = accountsNew;
    }

    public void showDetailsAccounts(){
        for (int i = 0; i < size; i++){
            System.out.println("Index: " + i + " | Number: " + accounts[i].getNumber(accounts[i]) + " | Balance: " + accounts[i].getBalance(accounts[i]));
        }
    }


}
