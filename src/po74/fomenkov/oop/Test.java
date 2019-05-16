package po74.fomenkov.oop;

import po74.fomenkov.oop.model.*;


public class Test {
    public static void main(String[] args) {
        lab2test();
    }


    public static void lab2test() {
        DebitAccount account1 = new DebitAccount() ;
        DebitAccount account2 = new DebitAccount() ;
        DebitAccount account3 = new DebitAccount() ;

        Account account = new Account() {
            @Override
            public String getNumber() {
                return null;
            }

            @Override
            public void setNumber(String newNumber) {

            }

            @Override
            public double getBalance() {
                return 0;
            }

            @Override
            public void setBalance(double newBalance) {

            }
        };
        account.setNumber("12");
        System.out.println(account1.getNumber());



        /*account1.setNumber("a");
        account1.setBalance(12.5);
        account2.setNumber("b");
        account2.setBalance(59.4);
        account3.setNumber("c");
        account3.setBalance(8.1);
*/
        System.out.println(account1.getNumber());

        Client client1 = new Client() {
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

            @Override
            public void showDetails() {

            }
        };
        Client client2 = new Client() {
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

            @Override
            public void showDetails() {

            }
        };
        Client client3 = new Client() {
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

            @Override
            public void showDetails() {

            }
        };


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





        }
    }

