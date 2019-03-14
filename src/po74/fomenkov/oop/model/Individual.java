package po74.fomenkov.oop.model;

//todo атрибуты - приватные
//todo ВСЕ ЦИКЛЫ ДО SIZE!!!!!!!!!!!!!!!!!
public class Individual {
    int size;
    Account[] accounts;

    //todo литералы - зло
    //todo этот конструктор должен вызывать следующий
    public Individual(){
        Individual individual = new Individual(16);
        this.accounts = individual.accounts;
    }

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

        doublingArrayAccountsIfFull();
        accounts[size] = account;
        size++;
       // System.out.println(size);
        return true;
    }

    public boolean add(int index, Account account){
        //todo элементы нужно сдвигать
        doublingArrayAccountsIfFull();
        shiftOneElement(index, "right"); //todo пусть 2-й параметр будет boolean
        accounts[index] = account;
        size++;
      //  System.out.println(size);
        return true;
    }

    public Account get(int index) {
        return accounts[index];
    }

    public Account get(String accountNumber){
        //todo findElemByNumber(accountNumber)
    }

    public boolean hasAccount(String accountNumber){
        //todo findElemByNumber(accountNumber)

    }

    public Account set(int index, Account account){
        //todo возвращаешь удаленную ссылку, а не новую
        return (accounts[index] = account);
    }

    public Account remove(int index){
        Account removedAccount = accounts[index];
        shiftOneElement(index, "left");
        accounts[size] = null;
        size--;
        return removedAccount;
    }

    public Account remove(String numberAccount) {
        return remove(findElemByNumber(numberAccount));
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
        Account[] sortedAccounts = new Account[accounts.length];
        System.arraycopy(accounts,0,sortedAccounts,0,size);
        Account swapBuf; //todo имя - гавно
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

    //todo имя - гавно
    private int findElemByNumber(String accountNumber){
        for (int i = 0; i < size; i++){
            if (number.equals(accounts[i].number)) return i;
        }
        return -1;
    }

    private void shiftOneElement(int index, String side /* direction*/){
        if (side.equals("right")){

        } else
         System.arraycopy(accounts, index+1, accounts,index,(size-index));
    }

    //todo имя гавно expand, check,
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
