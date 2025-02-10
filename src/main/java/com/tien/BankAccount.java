package com.tien;

class BankAccount {
    private int balance = 1000;

    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            System.out.println("Withdrawing: " + amount);
            balance -= amount;
            System.out.println("Remaining balance: " + balance);
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    public synchronized void deposit(int amount) {
        System.out.println("Depositing: " + amount);
        balance += amount;
        System.out.println("New balance: " + balance);
    }
    
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        Thread t1 = new Thread(() -> account.withdraw(700));
        Thread t2 = new Thread(() -> account.deposit(500));

        t1.start();
        t2.start();
    }
}
