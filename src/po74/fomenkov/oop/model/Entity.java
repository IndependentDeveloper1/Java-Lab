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
        ArrayList<Account> clients = new ArrayList<Account>();
        for (int i = 0; i < accounts.length; i++){
            clients.add(accounts[i]);
        }

    }

    private void add(){

    }

    private void add(int position){

    }

    private Node add(int number){

    }

    private void remove(int number){

    }

    private void set(int number){

    }
}
