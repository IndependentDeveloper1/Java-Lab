package po74.fomenkov.oop.model;

import java.util.ArrayList;

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
        if(index >= 0 | index <= size - 1){
            Node node = getNode(index-1);
            Node newNode = new Node();
            newNode.next = node.next;
            node.next = newNode;
            tail.next = head.next;
        }
    }

    private Node getNode(int index){
        Node node = new Node();
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
        Node node = getNode(index - 1);
        node.next = node.next.next;
    }

    private void set(Node newNode, int index){
        Node node = getNode(index - 1);
        node = newNode;
    }


}
