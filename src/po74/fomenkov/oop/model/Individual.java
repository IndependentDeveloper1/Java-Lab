package po74.fomenkov.oop.model;

import java.util.ArrayList;

public class Individual implements Client, Cloneable {
    private int size;
    private Account[] accounts;
    private String name;
    private final static String EMPTY_NAME = "";
    private final static int CAPACITY_DEFAULT = 16;
    private int creditScores;
    private final static int CREDIT_SCORES_DEFAULT = 0;


    public Individual(){
        this(CAPACITY_DEFAULT, EMPTY_NAME, CREDIT_SCORES_DEFAULT);
    }

    public Individual(int capacity, String name, int creditScores) {
        this.accounts = new Account[capacity];
        this.name = name;
        this.creditScores = creditScores;
    }

    public Individual(Account[] accounts, String name, int creditScores){
        this.accounts = new Account[accounts.length];
        System.arraycopy(accounts, 0, this.accounts, 0,accounts.length);
        this.name = name;
        this.creditScores = creditScores;
        size = accounts.length;
    }

    public boolean add(Account account){
        expandArray(isFull());
        accounts[size] = account;
        size++;
        return true;
    }

    public boolean add(int index, Account account){
        expandArray(isFull());
        shiftOneElement(index, true);
        accounts[index] = account;
        size++;
        return true;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Account get(int index) {
        return accounts[index];
    }

    public Account get(String accountNumber){
        return accounts[indexOf(accountNumber)];
    }

    public boolean hasAccount(String accountNumber){
        if (indexOf(accountNumber)!=(-1)) return true;
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
        if (hasAccount(numberAccount))return remove(indexOf(numberAccount));
        return null;
    }

    public int size(){
        return this.size;
    }

    public Account[] getAccounts(){
        Account[] returnedAccounts = new Account[size()];
        System.arraycopy(accounts,0,returnedAccounts,0,size);
        return returnedAccounts;
    }

    public Account[] sortedByBalanceAccounts(){
        Account[] sortedAccounts = getAccounts();
        Account swapBuf;
        for (int i = 0; i < size-1; i++){
            for (int j = 0; j < size-1;j++) {
                if(sortedAccounts[j].getBalance()>sortedAccounts[j+1].getBalance()){
                    swapBuf = sortedAccounts[j+1];
                    sortedAccounts[j+1] = sortedAccounts[j];
                    sortedAccounts[j] = swapBuf;
                }
            }
        }
        return sortedAccounts;
    }

    public double totalBalance(){
        double totalBalance = 0;
        for (int i = 0; i < size; i++){
            totalBalance += accounts[i].getBalance();

        }
        return totalBalance;
    }

    public int indexOf (String accountNumber) {
        for (int i = 0; i < size; i++){
            if (accountNumber.equals(accounts[i].getNumber())) return i;
        }
        return -1;
    }

    private void shiftOneElement(int index, boolean direction /* direction*/){
        if (direction)
            System.arraycopy(accounts, index, accounts,index+1,(size-index));
        else
            System.arraycopy(accounts, index+1, accounts,index,(size-index));

    }

    private boolean isFull(){
        return (size == accounts.length);
    }

    private void expandArray(boolean expand){
        Account[] accountsNew = new Account[accounts.length * 2];
        System.arraycopy(accounts,0,accountsNew,0,size);
        this.accounts = accountsNew;
    }

    public void showDetails(){
        for (int i = 0; i < size; i++){
            System.out.println("Index: " + i + " | Number: " + accounts[i].getNumber() + " | Balance: " + accounts[i].getBalance());
        }
    }

    @Override
    public int getCreditScores() {
        return creditScores;
    }

    @Override
    public void addCreditScores(int creditScores) {
        this.creditScores += creditScores;
    }

    @Override
    public Credit[] getCreditAccounts() {
        ArrayList<Credit> credits = new ArrayList<>();
        for (int i = 0; i < size; i++){
            if (accounts[i] instanceof Credit){
                credits.add((Credit) accounts[i]);
            }
        }
        return (Credit[]) credits.toArray();
    }

    @Override
    public boolean hasCredit() {
        //todo пройдись по массиву до первого кредита (аналогично в Entity)
        for (int i = 0; i < size; i++) {
            if (accounts[i] instanceof Credit)
                return true;
        }
        return false;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Client\nname:%1s\ncreditScore: %2d\n", name, creditScores));
        for (int i = 0; i < size; i++) {
            builder.append(String.format("%1s\n",accounts[i].toString()));
        }
        builder.append(String.format("total: %1.2f", totalBalance()));
        return builder.toString();
    }

    @Override
    public int hashCode(){
        int totalHashCodeClients = 0;
        for (int i = 0; i < size; i++) {
            totalHashCodeClients += accounts[i].hashCode();
        }
        return (totalHashCodeClients ^ name.hashCode() ^ System.identityHashCode(creditScores));
    }

    @Override
    public boolean equals(Object obj){
        return (obj.getClass().equals(super.getClass()) && this.hashCode() == obj.hashCode());
    }

    @Override
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    @Override
    public boolean remove(Account account) {
        return (remove(indexOf(account)) != null);
    }

    @Override
    public int indexOf(Account account) {
        return indexOf(account.getNumber());
    }

    @Override
    public double debtTotal() {
        if (totalBalance() < 0) return Math.abs(totalBalance());
        return 0;
    }

}
