package po74.fomenkov.oop;

import po74.fomenkov.oop.model.*;


public class Test {
    public static void main(String[] args) {
        lab2test();
    }


    public static void lab2test() {
        Account account1 = new DebitAccount() ;
        Account account2 = new DebitAccount() ;
        Account account3 = new DebitAccount() ;

        Account account = new DebitAccount();




        account1.setNumber("a");
        account1.setBalance(12.5);
        account2.setNumber("b");
        account2.setBalance(59.4);
        account3.setNumber("c");
        account3.setBalance(8.1);

        System.out.println(account1.getNumber());

        Client client1 = new Entity("1") ;
        Client client2 = new Entity("2") ;
        Client client3 = new Entity("3") ;


        AccountManager accountManager = new AccountManager(1);

        client1.add(account1);
        client1.add(account2);
        client1.add(account3);
       // System.out.println(client1.size());

        client2.add(account2);
        client2.add(account1);
        client2.add(account3);

        client3.add(account3);
        client3.add(account2);
        client3.add(account1);

        accountManager.add(client1);
        accountManager.add(client3);
        accountManager.add(client2);


        Client[] clients = accountManager.getClients();
        //System.out.println(clients[0].totalBalance());


        //accountManager.showDetailsClients();


        accountManager.get(0).showDetails();
        accountManager.





        }
    }

