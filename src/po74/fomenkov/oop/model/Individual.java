package po74.fomenkov.oop.model;

//todo атрибуты - приватные
//todo ВСЕ ЦИКЛЫ ДО SIZE!!!!!!!!!!!!!!!!!
//todo СТРОКИ СРАВНИВАЮТСЯ С ПОМОЩЬЮ equals()!!!!!!!!
public class Individual {
    public int size;
    public Account[] accounts;
    public int countElementsInMassive;
    //todo конструкторы public
    Individual(){
        Account[] accounts = new Account[16];
        this.accounts = accounts;
        this.size = 0; //todo литерады это зло
    }

    //todo не путай size и capacity
    Individual(int size){
        Account[] accounts = new Account[size];
        this.size = size;
        this.accounts = accounts;
    }

    Individual(Account[] accountsOld){
        Account[] accountsNew = new Account[(accountsOld.length)*2];
        //todo System.arraycopy()
        for(int i=0; i<accountsOld.length; i++){
            accountsNew[i] = accountsOld[i];
        }
        this.accounts = accountsNew;

    }

    public boolean add(Account account){
        //todo if (size == accounts.length)
        //todo переделывай
        Account[] accountsNew = new Account[accounts.length * 2];
        accountsNew = accounts;
        this.accounts = accountsNew;
        return false;

    }

    public boolean add(int index, Account account){
        //todo элементы нужно сдвигать
        if (accounts[index].number == "")
        {
            accounts[index] = account;
            // countElementsInMassive++;
            return true;
        }
        return false;
    }

    public Account get(int index) {
        return accounts[index];
    }

    public Account get(String accountNumber){
        int foundedAccIndex;

        for (int i = 0; i < accounts.length; i++){
            if (accounts[i].number == accountNumber)
                return accounts[i];

        }
        return null;
    }

    public boolean hasAccount(String accountNumber){
        for (int i = 0; i < accounts.length; i++){
            if (accounts[i].number == accountNumber)
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

        //todo System.arraycopy()
        for (int i = index; i < accounts.length-1; i++)
            accounts[i] = accounts[i+1];
        return removedAccount;
    }

    //todo дубль цикла с условием. Запили приватный метод, который возвращает индекс найденного эелмента
    //todo shift - вынеси в отдельный приватный метод
    public Account remove(String numberAccount) {
        for (int i = 0; i < accounts.length; i++){
            if (accounts[i].number == numberAccount){
                Account removedAccount = accounts[i];
                for (int j = i; j < accounts.length-1; j++)
                    accounts[j] = accounts[j+1];
                return removedAccount;
            }
        }
        return null;
    }

    public int size(){
        countElementsInMassive = 0;
        for (int i = 0; i < accounts.length; i++){
            if (accounts[i].number != "") countElementsInMassive++;
        }
        return countElementsInMassive;
        //todo return size;
    }

    public Account[] getAccounts(){


        Account[] returnedAccounts = new Account[size()];
        //todo System.arraycopy()
        int indexOfNewArray = 0;
        for (int i = 0; i < accounts.length; i++){

            if(accounts[i].number != "") {
                returnedAccounts[indexOfNewArray] = accounts[i];
                indexOfNewArray++;
            }
        }

        return returnedAccounts;
    }

    public Account[] sortedAccountsByBalance(){
        //todo нужно возвращться отсортированную копию массива
        Account tmp;
        for (int i = 0; i < accounts.length-1; i++){
            for (int j = 0; j < accounts.length-1;j++) {

                if(accounts[j].balance>accounts[j+1].balance){
                    tmp = accounts[j+1];
                    accounts[j+1] = accounts[j];
                    accounts[j] = tmp;
                    tmp = null;
                }
            }


        }
        return accounts;
    }

    public double totalBalance(){
        double totalBalance = 0;
        for (int i = 0; i < accounts.length; i++){
            totalBalance += accounts[i].balance;
        }
        return totalBalance;
    }

}
