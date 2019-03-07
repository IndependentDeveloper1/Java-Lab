package po74.fomenkov.oop.model;

public class AccountManager {
    Individual[] individuals;
    int size;

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
        doublingArrayIndividualsIfFull();
        individuals[size] = individual;
        size++;
        System.out.println(size);
        return true;
    }

    public boolean add(int index, Individual individual){
        doublingArrayIndividualsIfFull();
        shiftOneIndividual(index, "right");
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
        shiftOneIndividual(index, "left");
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
        Individual[] sortedIndividuals = new Individual[individuals.length];
        System.arraycopy(individuals,0,sortedIndividuals,0,size);
        Individual tmp;
        for (int i = 0; i < size-1; i++){
            for (int j = 0; j < size-1;j++) {

                if(sortedIndividuals[j].totalBalance()>sortedIndividuals[j+1].totalBalance()){
                    tmp = sortedIndividuals[j+1];
                    sortedIndividuals[j+1] = sortedIndividuals[j];
                    sortedIndividuals[j] = tmp;
                    tmp = null;
                }
            }
        }
        return sortedIndividuals;
    }

    // Мало информации в методичке не понятно
    /*
    public Account getAccount(String accountNumber){
        for (int i = 0; i < size; i++){
            for (int j = 0; j < individuals[i].size(); j++){
            if (individuals[i].accounts[j].number.equals(accountNumber))
                return individuals[i].accounts[j];
        }
        }
        return null;
    }

    public Account removeAccount(String accountNumber){

        Account removedAccount = getAccount(accountNumber);
        System.arraycopy(accounts, index+1, accounts,index,(size-index));


        return removedAccount;
    }

    public Account setAccount(String accountNumber, Account account){
        Account changedAccount = getAccount(accountNumber);
         = account;
        return changedAccount;
    }
*/
    private void shiftOneIndividual(int index, String side){
        if (side.equals("right")){
            for (int i = (size-1); i >= index; i--){
                individuals[i+1] = individuals[i];
            }
        }
        if (side.equals("left")) System.arraycopy(individuals, index+1, individuals,index,(size-index));
    }


    private void doublingArrayIndividualsIfFull(){
        if (size == individuals.length){
            Individual[] individualsNew = new Individual[this.individuals.length * 2];
            System.arraycopy(this.individuals,0,individualsNew,0,size);
            this.individuals = individualsNew;
        }
    }



    /*public void showDetailsAccounts(){
        for (int i = 0; i < size; i++){
            System.out.println("Index: " + i + " | Number: " + individuals[i].number + " | Balance: " + individuals[i].balance);
        }
    }*/
}
