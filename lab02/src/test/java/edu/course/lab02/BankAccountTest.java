package edu.course.lab02;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class BankAccountTest {

    @Test
    void withdrawShouldReduceBalance() {
        BankAccount account = new BankAccount(100);
        account.withdraw(30);
        assertEquals(70, account.getBalance());
    }

    @Test
    void withdrawShouldThrowWhenAmountExceedsBalance() {
        BankAccount account = new BankAccount(50);

        assertThrows(
            IllegalArgumentException.class, 
            () -> account.withdraw(60)
            );
    }

    @Test
    void constructorShouldRejectNegativeBalance() {
        assertThrows(
            IllegalArgumentException.class,
            () -> new BankAccount(-1)
        );
    }

    @Test
    void depositShouldIncreaseBalance() {
        BankAccount account = new BankAccount(50);

        account.deposit(20);

        assertEquals(70, account.getBalance());
    }

    @Test
    void depositShouldRejectZeroAmount() {
        BankAccount account = new BankAccount(50);

        assertThrows(
            IllegalArgumentException.class,
            () -> account.deposit(0)
        );
    }

    @Test
    void depositShouldRejectOverflow() {
        BankAccount account = new BankAccount(Integer.MAX_VALUE);

        assertThrows(
            IllegalArgumentException.class,
            () -> account.deposit(1)
        );
        assertEquals(Integer.MAX_VALUE, account.getBalance());
    }

    @Test
    void withdrawShouldRejectZeroAmount() {
        BankAccount account = new BankAccount(50);

        assertThrows(
            IllegalArgumentException.class,
            () -> account.withdraw(0)
        );
    }
}