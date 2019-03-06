package po74.fomenkov.oop.model;

//todo атрибуты - приватные
//todo ВСЕ ЦИКЛЫ ДО SIZE!!!!!!!!!!!!!!!!!
//todo СТРОКИ СРАВНИВАЮТСЯ С ПОМОЩЬЮ equals()!!!!!!!!
public class Individual {
    int size;
    Account[] accounts;

    //todo конструкторы public
    public Individual(){
        Individual individual = new Individual(16);
        this.accounts = individual.accounts;
    }

    //todo не путай size и capacity
    public Individual(int capacity){
        Account[] accounts = new Account[capacity];
        this.accounts = accounts;
    }

    public Individual(Account[] accountsOld){
        Account[] accountsNew = new Account[accountsOld.length];
        //todo System.arraycopy()
        System.arraycopy(accountsOld, 0, accountsNew, 0,accountsOld.length);
        this.accounts = accountsNew;

    }

    public boolean add(Account account){
        //todo if (size == accounts.length)
        //todo переделывай
        doublingArrayAccountsIfFull();
        accounts[size] = account;
        size++;
        System.out.println(size);
        return true;
    }

    public boolean add(int index, Account account){
        //todo элементы нужно сдвигать
        doublingArrayAccountsIfFull();
        shiftOneElement(index, "right");
        accounts[index] = account;
        size++;
        System.out.println(size);
        return true;
    }

    public Account get(int index) {
        return accounts[index];
    }

    public Account get(String accountNumber){
        int foundedAccIndex;

        for (int i = 0; i < size; i++){
            if (accounts[i].number.equals(accountNumber))
                return accounts[i];
        }
        return null;
    }

    public boolean hasAccount(String accountNumber){
        for (int i = 0; i < size; i++){
            if (accounts[i].number.equals(accountNumber))
                return true;
        }
        return false;
    }

    public Account set(int index, Account account){
        return (accounts[index] = account);
    }

    public Account remove(int index){
        //todo size--
        Account removedAccount = accounts[index];
        shiftOneElement(index, "left");
        //todo System.arraycopy()
        accounts[size] = null;
        size--;
        return removedAccount;
    }

    //todo дубль цикла с условием. Запили приватный метод, который возвращает индекс найденного эелмента
    //todo shift - вынеси в отдельный приватный метод
    public Account remove(String numberAccount) {
        return remove(findElemByNumber(numberAccount));
    }

    public int size(){
        return size;
        //todo return size;
    }

    public Account[] getAccounts(){
        Account[] returnedAccounts = new Account[size()];
        //todo System.arraycopy()
        System.arraycopy(accounts,0,returnedAccounts,0,size);
        return returnedAccounts;
    }

    public Account[] sortedByBalanceAccounts(){
        //todo нужно возвращться отсортированную копию массива
        Account[] sortedAccounts = new Account[accounts.length];
        System.arraycopy(accounts,0,sortedAccounts,0,size);
        Account tmp;
        for (int i = 0; i < size-1; i++){
            for (int j = 0; j < size-1;j++) {

                if(sortedAccounts[j].balance>sortedAccounts[j+1].balance){
                    tmp = sortedAccounts[j+1];
                    sortedAccounts[j+1] = sortedAccounts[j];
                    sortedAccounts[j] = tmp;
                    tmp = null;
                }
            }
        }
        return sortedAccounts;
    }

    public double totalBalance(){
        double totalBalance = 0;
        for (int i = 0; i < size; i++){
            totalBalance += accounts[i].balance;
        }
        return totalBalance;
    }

    private int findElemByNumber(String number){
        for (int i = 0; i < size; i++){
            if (number.equals(accounts[i].number)) return i;
        }
        return -1;
    }

    private void shiftOneElement(int index, String side){
        if (side.equals("right")){
            for (int i = (size-1); i >= index; i--){
                accounts[i+1] = accounts[i];
            }
        }
        if (side.equals("left")) System.arraycopy(accounts, index+1, accounts,index,(size-index));
    }


    private void doublingArrayAccountsIfFull(){
        if (size == accounts.length){
        Account[] accountsNew = new Account[accounts.length * 2];
        System.arraycopy(accounts,0,accountsNew,0,size);
        this.accounts = accountsNew;
        }
    }

    public void showDetailsAccounts(){
        for (int i = 0; i < size; i++){
            System.out.println("Index: " + i + " | Number: " + accounts[i].number + " | Balance: " + accounts[i].balance);
        }
    }


}
