package po74.fomenkov.oop.model;

public class AccountManager {
    private Client[] clients;
    private int size;

    public AccountManager(int capacity){
        Client[] clients = new Client[capacity];
        this.clients = clients;
    }

    public AccountManager(Client[] clientsOld) {
        Client[] clientsNew = new Client[clientsOld.length];
        System.arraycopy(clientsOld, 0, clientsNew, 0, clientsOld.length);
        this.clients = clientsOld;
        size = clientsNew.length;
    }

    public boolean add(Client client){
        expandArray(isFull());
        clients[size] = client;
        size++;
        return true;
    }

    public boolean add(int index, Client client){
        expandArray(isFull());
        shiftOneClient(index, true);
        clients[index] = client;
        size++;
        return true;
    }

    public Client get(int index) {
        return clients[index];
    }


    public Client set(int index, Client client){
        Client changedClient = clients[index];
         clients[index] = client;
         return changedClient;
    }

    public Client remove(int index){
        Client removedClient = clients[index];
        shiftOneClient(index, false);
        clients[size] = null;
        size--;
        return removedClient;
    }

    public int size(){
        return size;
    }

    public Client[] getClients(){
        Client[] returnedClients = new Client[size];
        System.arraycopy(clients,0,returnedClients,0,size);
        return returnedClients;
    }

    public Client[] sortedByBalanceClients(){
        Client[] sortedClients = getClients();
        System.arraycopy(clients,0,sortedClients,0,size);
        Client swapBuff;
        for (int i = 0; i < size-1; i++){
            for (int j = 0; j < size-1;j++) {

                if(sortedClients[j].totalBalance()>sortedClients[j+1].totalBalance()){
                    swapBuff = sortedClients[j+1];
                    sortedClients[j+1] = sortedClients[j];
                    sortedClients[j] = swapBuff;
                }
            }
        }
        return sortedClients;
    }


    public Account getAccount(String accountNumber){
        for (int i = 0; i < size; i++){
            if (clients[i].hasAccount(accountNumber))
                return (clients[i].get(accountNumber));
        }
        return null;
    }

    public Account removeAccount(String accountNumber){
        if (getAccount(accountNumber) != null)
        {
        for (int i = 0; i < size; i++)
        {
            if (clients[i].hasAccount(accountNumber)) {
                return clients[i].remove(accountNumber);
            }
        }
        }
       return null;
    }

    public Account setAccount(String accountNumber, Account account){
        if (getAccount(accountNumber) != null)
        {
        for (int i = 0; i < size; i++) {
            if (clients[i].hasAccount(accountNumber)) {
                return clients[i].set(clients[i].indexOf(accountNumber) ,account);
            }
        }
        }
        return null;
    }

    private void shiftOneClient(int index, boolean direction ){
        if (direction)
            System.arraycopy(clients, index, clients,index+1,(size-index));
        else
            System.arraycopy(clients, index+1, clients,index,(size-index));
    }

    private boolean isFull(){
        return size == clients.length;
    }

    private void expandArray(boolean expand){
        Client[] clientsNew = new Client[this.clients.length * 2];
        System.arraycopy(this.clients,0,clientsNew,0,size);
        this.clients = clientsNew;
    }

    public void showDetailsClients(){
        for (int i = 0; i < size; i++){
            System.out.println("Client " + (i + 1) + " | Count accounts " + clients[i].size() );
        }
    }

    public Client[] getDebtors(){
        //todo те клиенты, у которых есть кредит (хоть один)
        for (int i = 0; i < size; i++){
            if (clients[i].getCreditAccounts() != null)
                return clients;
        }
        return null;
    }

    public Client[] getWickedDebtors(){
        if (getDebtors() != null){
            for (int i = 0; i < size; i++){
                if (clients[i].getStatus() == ClientStatus.BAD) return clients;
            }
        }
        return null;
    }
}
