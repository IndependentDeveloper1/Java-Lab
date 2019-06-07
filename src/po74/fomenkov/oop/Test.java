package po74.fomenkov.oop;

import po74.fomenkov.oop.model.*;

import java.lang.ref.Cleaner;
import java.time.LocalDate;


public class Test {
    public static void main(String[] args) {
        lab5test();
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

        /* Test #1 (class Account)
        // Working
//
        Account account = new Account("123", 52.5);
        Account account1 = new Account("101", 101.5);
        Account emptyAccount = new Account();
        System.out.println(getBalance(account) + " " + getNumber(account));
        System.out.println(getBalance(account1) + " " + getNumber(account1));
        System.out.println("Number: " + getNumber(account));
        account.setNumber(account, "111");
        System.out.println("New number: " + getNumber(account));
        System.out.println("Balance: " + getBalance(account));
        account.setBalance(account, 105.6);
        System.out.println("New balance: " + getBalance(account));
       */



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
        Account abstractAccount = new DebitAccount("Debit account",321);
        System.out.println(abstractAccount.getBalance());
        System.out.println(abstractAccount.getNumber());
        //3
        Credit credit = new CreditAccount("Credit account", 12.2, 12);
        System.out.println(credit.getAPR());
        System.out.println(((AbstractAccount) credit).getBalance());
        //5
        Account abstractAccount1 = new DebitAccount("Debit account 1",321);
        Account abstractAccount2 = new DebitAccount("Debit account 2",987);
        Account abstractAccount3 = new CreditAccount("Debit account 3",654,20);
        Account[] accounts = new Account[3];
        accounts[0] = abstractAccount1;
        accounts[1] = abstractAccount2;
        accounts[2] = abstractAccount3;
        Client clientEntity1 = new Entity("Client entity 1");
        Client clientEntity2 = new Entity("Client entity 2", accounts);
        Client clientIndividual1 = new Individual();
        Client clientIndividual2 = new Individual(3,"Individual 2", 0);
        Client clientIndividual3 = new Individual(accounts, "Individual 3", -4);

        System.out.println(clientEntity1.getStatus() + " " + clientEntity1.getCreditScores() + " " + clientEntity1.getName());
        System.out.println(clientIndividual1.getStatus() + " " + clientIndividual1.getCreditScores() + " " + clientIndividual1.getName());
        System.out.println(clientIndividual1.getName() + clientIndividual2.getName() + clientIndividual3.getName());

        clientEntity1.add(abstractAccount);
        clientEntity1.addCreditScores(12);
        System.out.println(clientEntity1.getStatus());

        clientEntity1.setName("Client Adolf");
        System.out.println(clientEntity1.getName() + " " + clientEntity1.getStatus());

        clientEntity1.addCreditScores(-90);
        System.out.println(clientEntity1.getName() + " " + clientEntity1.getStatus());

        Account clientWithCredit = new CreditAccount();
        System.out.println(clientWithCredit.getNumber() + " " + ((CreditAccount) clientWithCredit).getAPR());
        clientEntity1.add(clientWithCredit);

        Credit[] credits = clientEntity1.getCreditAccounts();
        if (credits != null) {
            credits[0].setAPR(10);
            for (int i = 0; i < credits.length; i++){
                System.out.println(credits[i].getNumber() + " 123 " + credits[i].getAPR());
            }
        }
        Client[] clients = new Client[5];
        clients[0] = clientEntity1;
        clients[1] = clientEntity2;
        clients[2] = clientIndividual1;
        clients[3] = clientIndividual2;
        clients[4] = clientIndividual3;

        AccountManager accountManager = new AccountManager(clients);
        Credit[] creditAccounts1 = clientEntity2.getCreditAccounts();
        System.out.println(creditAccounts1[0] instanceof Credit);
        System.out.println(credit instanceof Credit);

        Client[] debtors = accountManager.getDebtors();
        System.out.println("Name: " + debtors[0].getName() + " Status: " + debtors[0].getStatus());
        Client[] wickedDebtors = accountManager.getWickedDebtors();
        System.out.println("Name: " + wickedDebtors[0].getName() + " Status: " + wickedDebtors[0].getStatus());

        System.out.println("=--=-=");
        System.out.println(accountManager.toString());

    }

    public static void lab4test(){
        Account abstractAccount = new DebitAccount("Debit account",321);
        Credit credit = new CreditAccount("Credit account", 12.2, 12);
        Account abstractAccount1 = new DebitAccount("Debit account 1",321);
        Account abstractAccount2 = new DebitAccount("Debit account 2",987);
        Account abstractAccount3 = new CreditAccount("Debit account 3",654,20);
        Account[] accounts = new Account[3];
        accounts[0] = abstractAccount1;
        accounts[1] = abstractAccount2;
        accounts[2] = abstractAccount3;
        Client clientEntity1 = new Entity("Client entity 1");
        Client clientEntity2 = new Entity("Client entity 2", accounts);
        Client clientIndividual1 = new Individual();
        Client clientIndividual2 = new Individual(3,"Individual 2", 0);
        Client clientIndividual3 = new Individual(accounts, "Individual 3", -4);
        clientEntity1.add(abstractAccount);
        clientEntity1.addCreditScores(12);
        clientEntity1.setName("Client Adolf");
        clientEntity1.addCreditScores(-90);
        Account clientWithCredit = new CreditAccount();
        clientEntity1.add(clientWithCredit);
        Credit[] credits = clientEntity1.getCreditAccounts();
        Client[] clients = new Client[5];
        clients[0] = clientEntity1;
        clients[1] = clientEntity2;
        clients[2] = clientIndividual1;
        clients[3] = clientIndividual2;
        clients[4] = clientIndividual3;
        AccountManager accountManager = new AccountManager(clients);
        Credit[] creditAccounts1 = clientEntity2.getCreditAccounts();
        Client[] debtors = accountManager.getDebtors();
        Client[] wickedDebtors = accountManager.getWickedDebtors();
        System.out.println(accountManager.toString());
    }

    public static void lab5test(){
        System.out.println(LocalDate.now());
    }
}

