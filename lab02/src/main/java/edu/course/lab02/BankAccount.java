package edu.course.lab02;

public class BankAccount {

    private int balance;

    public BankAccount(int balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Баланс не может быть отрицательным");
        }
        this.balance = balance;
    }

    public void deposit(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Сумма пополения должна быть положительной");
        }
        if (amount > Integer.MAX_VALUE - balance) {
            throw new IllegalArgumentException("Баланс слишком велик");
        }
        balance += amount;
    }
    
    public void withdraw(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Сумма списания должна быть положитедьной");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Недостаточно средств на счете");
        }
        balance -= amount;
    }

    public int getBalance() {
        return balance; 
    }    
}