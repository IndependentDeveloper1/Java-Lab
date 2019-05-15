package po74.fomenkov.oop;

import po74.fomenkov.oop.model.*;


public class Test {
    public static void main(String[] args) {
        lab2test();
    }


    public static void lab2test() {
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

        Client client = new Client() {
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
        };

        AccountManager accountManager = new AccountManager(1);

        client.add(account);

        accountManager.add(client);

        accountManager.showDetailsClients();
        }
    }

