package po74.fomenkov.oop.model;


public class Entity implements Client{
    private String name;
    private int size;
    private Node head;
    private Node tail;

    public Entity(String name){
       this.name = name;
       this.head = new Node();
    }

    public Entity(String name, Account[] accounts){
        this.name = name;
        for (int i = 0; i < accounts.length; i++){
            Node node = new Node();
            node.value = accounts[i];
            add(node);
        }

    }

    private Node setNode(int index, String accountNumber){
        Node node = getNode(index);
        Node oldNode = node;
        node.value.setNumber(accountNumber);
        return oldNode;
    }

    private void add(Node node){
        if (head.next == null){
            head = node;
            tail = node;
            node.next = node;
        }
        else{
            tail.next = node;
            tail = node;
            tail.next = head.next;
        }
        size++;
    }

    private void add(int index, Node node){

        if (head.next == null){
            head = node;
            tail = node;
            node.next = node;
        }
        else if (index == 0){
            node.next = head.next.next;
            head.next = node;
            tail.next = head.next;
        }
        else if(index > 0 | index <= size - 1){
            Node nodePrev = getNode(index-1);
            Node newNode = new Node();
            newNode.next = nodePrev.next;
            nodePrev.next = newNode;
            //todo вставка элемента то?

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
        for (int i = 0; i < size - 1; i++){
            node = node.next;
            if (node.value.getNumber().equals(accountNumber)) return node;
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
            //todo удаление tail
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
        if (nodeHasAccount(accountNumber)){
            Node node = head.next;
            for (int i = 0; i < size - 1; i++){
                node = node.next;
                if (node.value.getNumber().equals(accountNumber)) return i;
            }
        }
        return -1;
    }

    private boolean nodeHasAccount(String accountNumber){
        return getNode(accountNumber) != null;
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
        return setNode(index, account.getNumber()).value;
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
        for (int i = 0; i < size - 1; i++){
            accounts[i] = getNode(i).value;
        }
        return accounts;
    }

    @Override
    public Account[] sortedByBalanceAccounts() {
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

    @Override
    public double totalBalance() {
        double totalBalance = 0;
        for (int i = 0; i < size - 1; i++){
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
        return indexOf(accountNumber);
    }

    @Override
    public void showDetails(){
        Account[] accounts = getAccounts();
        for (int i = 0; i < size - 1; i++){
            System.out.println("Balance is: " + accounts[i].getBalance() + " Account number is: " + accounts[i].getNumber());
        }
        System.out.println(size);
    }

}
