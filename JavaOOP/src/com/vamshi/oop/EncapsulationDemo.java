package com.vamshi.oop;
class BankAccount{
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    private double balance;
}
public class EncapsulationDemo {
    public static void main(String[] args) {
        BankAccount vamshiAccount = new BankAccount();
        vamshiAccount.setBalance(10000);
        System.out.println("balance is .."+vamshiAccount.getBalance());

    }
}
