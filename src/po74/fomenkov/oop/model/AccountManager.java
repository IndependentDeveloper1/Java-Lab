package po74.fomenkov.oop.model;

public class AccountManager {
    //todo private
    private Individual[] individuals;
    private int size;

    public AccountManager(int capacity){
        Individual[] individuals = new Individual[capacity];
        this.individuals = individuals;
    }

    public AccountManager(Individual[] individualsOld) {
        Individual[] individualsNew = new Individual[individualsOld.length];
        System.arraycopy(individualsOld, 0, individualsNew, 0, individualsOld.length);
        this.individuals = individualsOld;
    }

    public boolean add(Individual individual){
        expandArray(isFullArray());
        individuals[size] = individual;
        size++;
        System.out.println(size);
        return true;
    }

    public boolean add(int index, Individual individual){
        expandArray(isFullArray());
        shiftOneIndividual(index, true);
        individuals[index] = individual;
        size++;
        System.out.println(size);
        return true;
    }

    public Individual get(int index) {
        return individuals[index];
    }


    public Individual set(int index, Individual individual){
        Individual changedIdividual = individuals[index];
         individuals[index] = individual;
         return changedIdividual;
    }

    public Individual remove(int index){
        Individual removedIndividual = individuals[index];
        shiftOneIndividual(index, false);
        individuals[size] = null;
        size--;
        return removedIndividual;
    }

    public int size(){
        return size;
    }

    public Individual[] getIndividuals(){
        Individual[] returnedIndividuals = new Individual[size];
        System.arraycopy(individuals,0,returnedIndividuals,0,size);
        return returnedIndividuals;
    }

    public Individual[] sortedByBalanceIndividuals(){
        //todo getIndividuals()
        Individual[] sortedIndividuals = getIndividuals();
        System.arraycopy(individuals,0,sortedIndividuals,0,size);
        Individual swapBuff; //todo имя гавно
        for (int i = 0; i < size-1; i++){
            for (int j = 0; j < size-1;j++) {

                if(sortedIndividuals[j].totalBalance()>sortedIndividuals[j+1].totalBalance()){
                    swapBuff = sortedIndividuals[j+1];
                    sortedIndividuals[j+1] = sortedIndividuals[j];
                    sortedIndividuals[j] = swapBuff;
                    //swapBuff = null;
                }
            }
        }
        return sortedIndividuals;
    }


    public Account getAccount(String accountNumber){
        for (int i = 0; i < size; i++){
            if (individuals[i].returnElemByNumber(accountNumber) !=(-1))
                return (individuals[i].get(individuals[i].returnElemByNumber(accountNumber)));
        }
        return null;
    }

    public Account removeAccount(String accountNumber){
        Account removedAccount = getAccount(accountNumber);
        Individual individual = new Individual();
        for (int i = 0; i < size; i++) {
            if (individuals[i].returnElemByNumber(accountNumber) != (-1)) {
                individual = individuals[i];
                individual.remove(accountNumber);
                individuals[i] = individual;
                return removedAccount;
            }
        }
       return null;
    }

    public Account setAccount(String accountNumber, Account account){
        Account changedAccount = getAccount(accountNumber);
        Individual individual = new Individual();
        for (int i = 0; i < size; i++) {
            if (individuals[i].returnElemByNumber(accountNumber) != (-1)) {
                individual = individuals[i];
                individual.set();
                individuals[i] = individual;
                return changedAccount;
            }
        }
        return null;
    }

    private void shiftOneIndividual(int index, boolean direction /* todo boolean */){
        if (direction)
            System.arraycopy(individuals, index, individuals,index+1,(size-index));
        else
            System.arraycopy(individuals, index+1, individuals,index,(size-index));
    }

    //todo имя гавно
   /* private void doublingArrayIndividualsIfFull(){
        if (size == individuals.length){
            Individual[] individualsNew = new Individual[this.individuals.length * 2];
            System.arraycopy(this.individuals,0,individualsNew,0,size);
            this.individuals = individualsNew;
        }
    }*/

    private boolean isFullArray(){
        if (size == individuals.length) return true;
        return false;
    }

    private void expandArray(boolean expand){
        Individual[] individualsNew = new Individual[individuals.length * 2];
        System.arraycopy(individuals,0,individualsNew,0,size);
        this.individuals = individualsNew;
    }

    public int returnIndividual(String accountNumber){
        for (int i = 0; i < size; i++){
            if (accountNumber.equals(accounts[i].getNumber(accounts[i]))) return i;
        }
        return -1;
    }


    private

    /*public void showDetailsAccounts(){
        for (int i = 0; i < size; i++){
            System.out.println("Index: " + i + " | Number: " + individuals[i].number + " | Balance: " + individuals[i].balance);
        }
    }*/
}
