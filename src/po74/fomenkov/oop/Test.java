package po74.fomenkov.oop;

import po74.fomenkov.oop.model.Account;
import po74.fomenkov.oop.model.AccountManager;
import po74.fomenkov.oop.model.Individual;


public class Test {
    public static void main(String[] args) {
        lab1test();
    }

    public static void lab1test() {

        /* Test #1 (class Account)
        // Working

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


        //Test #2 (class Individual)
        // Working

        Account account0 = new Account("12", 534.48);
        Account account1 = new Account("432", 478.5);
        Account account2 = new Account("164", 456.155);
        Account account3 = new Account("864", 584.234);
        Account account4 = new Account("54", 6789.4561);
        Account account5 = new Account();
        Account account6 = new Account();





        Individual individualOne = new Individual();
        Individual individualTwo = new Individual();

        individualOne.add(account0);
        individualOne.add(account1);
        individualOne.add(account2);
        individualTwo.add(account3);
        individualTwo.add(account5);
        individualTwo.add(2,account4);

        //individualOne.showDetailsAccounts();

        individualOne.remove(0);
        individualOne.remove("54");

        //individualOne.showDetailsAccounts();

        //System.out.println(individualOne.hasAccount("53"));

        //individualOne.showDetailsAccounts();


        //System.out.println(individualOne.totalBalance());



        // Test #3 (class AccountManager)
        //Working

        AccountManager accountManager = new AccountManager(2);

        accountManager.add(individualOne);
        accountManager.add(individualTwo);
        accountManager.showDetailsIndividuals();

//
    }
}
