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
            if (head == null){
                head = node;
                tail = node;
            }
            else{
                tail.next = node;
                tail = node;
            }
            size++;
        }

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
        /*todo проверяй 3 граничных условия
        1) список пустой
        2) index = 0
        3) index = size
        */
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
        else if(index >= 0 | index <= size - 1){
            Node nodePrev = getNode(index-1);


            tail.next = head.next;
        }
        else if (index == size){
            tail.next = node;
            tail = node;
            tail.next = head.next;
        }
        size++;
    }

    private Node getNode(int index){
        Node node = head;
        for (int i = 0; i < index; i++){
            node = node.next;
        }
        return node;
    }

    private void removeNode(int index){
        /*todo проверяй 2 граничных условия
        1) index = 0
        2) index = size
        */
        if (index == 0){
            head.next = head.next.next;
            tail.next = head.next;
        }
        else if (index == size){ }
        else{

        }
        Node node = getNode(index - 1);
        node.next = node.next.next;
        size--;
    }


    @Override
    public boolean add(Account account) {
        return false;
    }

    @Override
    public boolean add(int index, Account account) {
        return false;
    }

    @Override
    public Account get(int index) {
        return null;
    }

    @Override
    public Account get(String accountNumber) {
        return null;
    }

    @Override
    public boolean hasAccount(String accountNumber) {
        return false;
    }

    @Override
    public Account set(int index, Account account) {
        return null;
    }

    @Override
    public Account remove(int index) {
        return null;
    }

    @Override
    public Account remove(String accountNumber) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Account[] getAccounts() {
        return new Account[0];
    }

    @Override
    public Account[] sortedByBalanceAccounts() {
        return new Account[0];
    }

    @Override
    public double totalBalance() {
        return 0;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public int indexOf(String accountNumber) {
        return 0;
    }
}
