package po74.fomenkov.oop;

import po74.fomenkov.oop.model.*;

import java.lang.ref.Cleaner;


public class Test {
    public static void main(String[] args) {
        lab3test();
    }


    public static void lab2test() {
        Account account1 = new DebitAccount() ;
        Account account2 = new DebitAccount() ;
        Account account3 = new DebitAccount() ;


        account1.setNumber("a");
        account1.setBalance(12.5);
        account2.setNumber("b");
        account2.setBalance(59.4);
        account3.setNumber("c");
        account3.setBalance(8.1);

        Client client1 = new Entity("1") ;
        Client client2 = new Entity("2") ;
        Client client3 = new Entity("3") ;

        client1.add(account1);
        client1.add(account2);
        client1.add(account3);

        client2.add(account2);
        client2.add(account1);
        client2.add(account3);

        client3.add(account3);
        client3.add(account2);
        client3.add(account1);

        AccountManager accountManager = new AccountManager(1);

        accountManager.add(client1);
        accountManager.add(client3);
        accountManager.add(client2);


       // client1.remove(0);

        System.out.println();
        client1.showDetails();

        client1.set(2,account1);

        System.out.println();
        client1.showDetails();

        client1.add(account3);

        System.out.println();
        client1.showDetails();

        client1.add(0,account3);

        System.out.println();
        client1.showDetails();

        client1.remove(0);

        System.out.println();
        client1.showDetails();

        client1.remove("a");

        System.out.println();
        client1.showDetails();

        System.out.println(client1.hasAccount("a"));
        System.out.println(client1.hasAccount("d"));

        client1.add(account2);
        client1.add(account3);
        Account[] accounts = client1.sortedByBalanceAccounts();

        for (int i = 0; i < accounts.length; i++){
            System.out.println(accounts[i].getBalance());
        }

        System.out.println(client1.getName());

        System.out.println("Total balance: " + client1.totalBalance());

        System.out.println();

        accountManager.showDetailsClients();
        accountManager.remove(1);
        accountManager.showDetailsClients();
        Account account = accountManager.getAccount("a");
        System.out.println(account.getBalance());
        System.out.println("Count clients: " + accountManager.size());
        Client[] clients = accountManager.sortedByBalanceClients();

        for (int i = 0; i < clients.length; i++){
            System.out.println(clients[i].totalBalance());
        }

        accountManager.set(1,client1);
        accountManager.showDetailsClients();

        Account account123 = accountManager.setAccount("c", account2);
        System.out.println(account123.getBalance());

        Client[] clients2 = accountManager.getClients();
        for (int i = 0; i < clients2.length; i++){
            System.out.println(clients2[i].totalBalance());
        }

    }

    public static void lab3test(){
        //2
        Account abstractAccount = new DebitAccount("123",321);
        System.out.println(abstractAccount.getBalance());
        System.out.println(abstractAccount.getNumber());
        //3
        Credit credit = new CreditAccount("1", 12.2, 12);
        System.out.println(credit.getAPR());
        System.out.println(((AbstractAccount) credit).getBalance());
        //5
        Account abstractAccount1 = new DebitAccount("123",321);
        Account abstractAccount2 = new DebitAccount("789",987);
        Account abstractAccount3 = new DebitAccount("456",654);
        Account[] accounts = new Account[3];
        accounts[0] = abstractAccount1;
        accounts[1] = abstractAccount2;
        accounts[2] = abstractAccount3;
        Client clientEntity1 = new Entity("Ivan");
        Client clientEntity2 = new Entity("Slava", accounts);
        Client clientIndividual1 = new Individual();
        Client clientIndividual2 = new Individual(3,"Vladimir", 0);
        Client clientIndividual3 = new Individual(accounts, "Peter", -4);
        System.out.println(clientEntity1.getStatus() + " " + clientEntity1.getCreditScores() + " " + clientEntity1.getName());
        System.out.println(clientIndividual1.getStatus() + " " + clientIndividual1.getCreditScores() + " " + clientIndividual1.getName());
        System.out.println(clientIndividual1.getName() + clientIndividual2.getName() + clientIndividual3.getName());
        clientEntity1.addCreditScores(12);
        System.out.println(clientEntity1.getStatus());
        clientEntity1.setName("Adolf");
        System.out.println(clientEntity1.getName() + " " + clientEntity1.getStatus());
        clientEntity1.addCreditScores(-9);
        System.out.println(clientEntity1.getName() + " " + clientEntity1.getStatus());
        Credit[] credits = clientEntity1.getCreditAccounts();
        if (credits.length != 0) {
            credits[0].setAPR(10);
            for (int i = 0; i < credits.length; i++){
                System.out.println(credits[i].getNumber() + " " + credits[i].getAPR());
            }
        }

    }

}

