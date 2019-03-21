package po74.fomenkov.oop.model;

public class AccountManager {
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
        return true;
    }

    public boolean add(int index, Individual individual){
        expandArray(isFullArray());
        shiftOneIndividual(index, true);
        individuals[index] = individual;
        size++;
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
        Individual[] sortedIndividuals = getIndividuals();
        System.arraycopy(individuals,0,sortedIndividuals,0,size);
        Individual swapBuff;
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


    //todo следующие три метода - в цикле hasAccount а затем соответсвующий метод //сделал
    public Account getAccount(String accountNumber){
        for (int i = 0; i < size; i++){
            if (individuals[i].hasAccount(accountNumber))
                return (individuals[i].get(accountNumber));
        }
        return null;
    }

    public Account removeAccount(String accountNumber){
        if (getAccount(accountNumber) != null)
        {
        for (int i = 0; i < size; i++)
        {
            if (individuals[i].hasAccount(accountNumber)) {
                return individuals[i].remove(accountNumber);
            }
        }
        }
       return null;
    }

    public Account setAccount(String accountNumber, Account account){
        if (getAccount(accountNumber) != null)
        {
        for (int i = 0; i < size; i++) {
            if (individuals[i].hasAccount(accountNumber)) {
                return individuals[i].set(individuals[i].getIndex(accountNumber) ,account);
            }
        }
        }
        return null;
    }

    private void shiftOneIndividual(int index, boolean direction ){
        if (direction)
            System.arraycopy(individuals, index, individuals,index+1,(size-index));
        else
            System.arraycopy(individuals, index+1, individuals,index,(size-index));
    }

    //todo Имя - гавно
    private boolean isFullArray(){
        //TODO пойми, что не так =)))))
        //исправил
        return (size == individuals.length);
    }

    private void expandArray(boolean expand){
        Individual[] individualsNew = new Individual[individuals.length * 2];
        System.arraycopy(individuals,0,individualsNew,0,size);
        this.individuals = individualsNew;
    }

    //todo индивидуала надо возвращать, а не индекс
    //Ненужный метод
    /*public Individual returnIndividual(String accountNumber){
        for (int i = 0; i < size; i++){
            if (accountNumber.equals(accounts[i].getNumber(accounts[i]))) return i;
        }
        return -1;
    }*/

    public void showDetailsIndividuals(){
        for (int i = 0; i < size; i++){
            System.out.println("Individual " + i + " | Count accounts " + individuals[i].size() );
        }
    }
}
