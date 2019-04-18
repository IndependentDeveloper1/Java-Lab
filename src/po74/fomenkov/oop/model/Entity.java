package po74.fomenkov.oop.model;

import java.util.ArrayList;

public class Entity implements Client{
    private String name;
    private int size;
    private Node head;
    private Node tail;

    private final static Node EMPTY_HEAD = null;
    private final static Node EMPTY_TAIL = null;

    public Entity(String name){
       this.name = name;
       this.head = EMPTY_HEAD;
       this.tail = EMPTY_TAIL;
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

    private void add(int index){
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
        Node node = getNode(index - 1);
        node.next = node.next.next;
    }

    private void set(Node newNode, int index){
        Node node = getNode(index - 1);
        node = newNode;
    }


}
