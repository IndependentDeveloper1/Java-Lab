package po74.fomenkov.oop.model;

public class AccountManager {
    public Individual[] individuals;
    public int size;
    public int countIndividuals;

    AccountManager(int countIndividuals){
        Individual[] individuals = new Individual[size];
        this.individuals = individuals;
    }

    AccountManager(Individual[] individuals){
        Individual[] individualsNew = new Individual[individuals.length];
        for(int i=0; i<individuals.length; i++)
            individualsNew[i] = individuals[i];
        this.individuals = individualsNew;
    }

    public boolean add(Individual individual){

        for (int i = 0; i < individuals.length; i++){
            if (individuals[i].accounts == null) {
                individuals[i] = individual;
                //  countElementsInMassive++;
                return true;
            }
        }
        Individual[] individualsNew = new Individual[individuals.length * 2];
        individualsNew = individuals;
        this.individuals = individualsNew;
        return false;

    }

    public boolean add(int index, Individual individual){
        if (individuals[index].accounts[0] == null)
        {
            individuals[index] = individual;
            return true;
        }
        return false;
    }

    public Individual get(int index) {
        return individuals[index];
    }

    public Individual set(int index, Individual individual){
        return (individuals[index] = individual);
    }

    public Individual remove(int index){
        Individual removedIndividual = individuals[index];
        for (int i = index; i < individuals.length-1; i++)
            individuals[i] = individuals[i+1];
        return removedIndividual;
    }

    public int size(){
        countIndividuals = 0;
        for (int i = 0; i < individuals.length; i++){
            for (int j = 0; j < individuals[i].accounts.length; j++){
                if (individuals[i].accounts[j].number != "") {
                    countIndividuals++;
                    break;
                }
            }
        }
        return countIndividuals;
    }

    public Individual[] getIndividuals(){

        Individual[] returnedIndividual = new Individual[size()];
        int indexOfNewArray = 0;
        for (int i = 0; i < individuals.length; i++){
            returnedIndividual[i] = individuals[i];
        }

        return returnedIndividual;
    }

    public Individual[] sortedIndividualsByBalance(){
        Individual tmp;
        for (int i = 0; i < individuals.length-1; i++){
            for (int j = 0; j < individuals.length-1;j++) {

                if(individuals[j].totalBalance()>individuals[j+1].totalBalance()){
                    tmp = individuals[j+1];
                    individuals[j+1] = individuals[j];
                    individuals[j] = tmp;
                    tmp = null;
                }
            }
        }
        return individuals;
    }

    public double totalBalance(){
        double totalBalance = 0;
        for (int i = 0; i < individuals.length; i++){
            for (int j = 0; j < individuals[i].accounts.length; j++){
                totalBalance += individuals[i].accounts[j].balance;
            }
        }
        return totalBalance;
    }
}
