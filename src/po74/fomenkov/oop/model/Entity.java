package po74.fomenkov.oop.model;


import java.net.SocketOption;

public class Entity implements Client{
    private String name;
    private int size;
    private Node head;
    private Node tail;
    private int creditScores;
    private final static int CREDIT_SCORES_DEFAULT = 0;

    public Entity(String name){
       this.name = name;
       this.head = new Node();
       creditScores = CREDIT_SCORES_DEFAULT;
    }

    public Entity(String name, Account[] accounts){
        this.name = name;
        for (int i = 0; i < accounts.length; i++){
            Node node = new Node();
            node.value = accounts[i];
            add(node);
            creditScores = CREDIT_SCORES_DEFAULT;
        }

    }

    private Node setNode(int index, Account account){
        Node node = getNode(index);
        Node oldNode = node;
        node.value = account;
        return oldNode;
    }

    private void add(Node node){
        if (head.next == null){
            head.next = node;
            tail = node;
            tail.next = node;
        }
        else {
            tail.next = node;
            tail = node;
            node.next = head.next;
        }
        size++;
    }

    private void add(int index, Node node){

        if (head.next == null){
            head.next = node;
            tail = node;
            node.next = node;
        }
        else if (index == 0){
            node.next = head.next;
            head.next = node;
            tail.next = node;
        }
        else if(index > 0 | index <= size - 1){
            Node nodePrev = getNode(index-1);

            node.next = nodePrev.next;
            nodePrev.next = node;
        }
        else if (index == size){
            tail.next = node;
            tail = node;
            tail.next = head.next;
        }
        size++;
    }

    private Node getNode(int index){
        Node node = head.next;
        for (int i = 0; i < index; i++){
            node = node.next;
        }
        return node;
    }

    private Node getNode(String accountNumber){
        Node node = head.next;
        for (int i = 0; i < size; i++){
            if (node.value.getNumber().equals(accountNumber)) return node;
            node = node.next;
        }
        node = null;
        return node;
    }

    private Node removeNode(int index){

        Node removedNode;
        if (index == 0){
            removedNode = head.next;
            head.next = head.next.next;
            tail.next = head.next;
        }
        else if (index == size - 1){
            removedNode = tail;
            Node nodePrev = getNode(index - 1);
            nodePrev.next = tail.next;
            tail = nodePrev;
        }
        else{
            Node node = getNode(index - 1);
            removedNode = node.next;
            node.next = node.next.next;
        }
        size--;
        return removedNode;
    }

    private Node removeNode(String accountNumber){
        return removeNode(getIndex(accountNumber));
    }

    private int getIndex(String accountNumber){
            Node node = head.next;
            for (int i = 0; i < size; i++){
                if (node.value.getNumber().equals(accountNumber))
                    return i;
                node = node.next;
            }
        return -1;
    }

    private boolean nodeHasAccount(String accountNumber){
        return getIndex(accountNumber) != -1;
    }


    @Override
    public boolean add(Account account) {
        Node node = new Node();
        node.value = account;
        add(node);
        return true;
    }

    @Override
    public boolean add(int index, Account account) {
        Node node = new Node();
        node.value = account;
        add(index, node);
        return true;
    }

    @Override
    public Account get(int index) {
        return getNode(index).value;
    }

    @Override
    public Account get(String accountNumber) {
        return getNode(accountNumber).value;
    }

    @Override
    public boolean hasAccount(String accountNumber) {
        return nodeHasAccount(accountNumber);
    }

    @Override
    public Account set(int index, Account account) {
        return setNode(index, account).value;
    }

    @Override
    public Account remove(int index) {
        return removeNode(index).value;
    }

    @Override
    public Account remove(String accountNumber) {
        return removeNode(accountNumber).value;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public Account[] getAccounts() {
        Account[] accounts = new Account[size];
        for (int i = 0; i < size; i++){
            accounts[i] = getNode(i).value;
        }
        return accounts;
    }

    @Override
    public Account[] sortedByBalanceAccounts() {
        Account[] sortedAccounts = getAccounts();
        Account swapBuf;
        for (int i = 0; i < size - 1; i++){
            for (int j = 0; j < size - 1;j++) {
                if(sortedAccounts[j].getBalance()>sortedAccounts[j+1].getBalance()){
                    swapBuf = sortedAccounts[j+1];
                    sortedAccounts[j+1] = sortedAccounts[j];
                    sortedAccounts[j] = swapBuf;
                }
            }
        }
        return sortedAccounts;
    }

    @Override
    public double totalBalance() {
        double totalBalance = 0;
        for (int i = 0; i < size; i++){
            totalBalance += getNode(i).value.getBalance();
        }
        return totalBalance;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int indexOf(String accountNumber) {
        return getIndex(accountNumber);
    }

    @Override
    public void showDetails(){
        Account[] accounts = getAccounts();
        for (int i = 0; i < size; i++){
            System.out.println("Account: " + i + " Balance is: " + accounts[i].getBalance() + " Account number is: " + accounts[i].getNumber());
        }
    }

    @Override
    public ClientStatus getStatus() {
        switch (creditScores){
            case 0|1|2:
                return ClientStatus.GOOD;
            case 3|4:
                return ClientStatus.GOLD;
        }

        return (ClientStatus.BAD);
    }

    @Override
    public Credit[] getCreditAccounts() {
        //Credit[] credits = new CreditAccount()[getAccounts().length];
        return null;
    }

    @Override
    public int getCreditScores() {
        return creditScores;
    }

    @Override
    public void addCreditScores(int creditScores) {
        this.creditScores += creditScores;
    }
}
