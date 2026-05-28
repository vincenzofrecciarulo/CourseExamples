package org.generation.italy.examples.oo.banksystem;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    final static double INITIAL_BALANCE = 100;
    final static double DEPOSIT_AMOUNT = 50;
    final static double WITHDRAW_AMOUNT = 20;
    Account a1;
    @BeforeEach //Arrange
    void setUp() {
        a1 = new Account(INITIAL_BALANCE);
    }

    @AfterEach
    void tearDown() {
    }

    @Test //Act
    void deposit() {
        double balance = a1.getBalance();
        double endBalance= a1.deposit(DEPOSIT_AMOUNT);
        double expected = balance + DEPOSIT_AMOUNT;
        assertEquals(expected,endBalance);
        assertEquals(expected,a1.getBalance());
    }

    @Test//Act
    void withdraw_should_succeed_if_amount_avaiable() {
        double balance = a1.getBalance();
        boolean success= a1.withdraw(WITHDRAW_AMOUNT);
        assertTrue(success);
        double expectedBalance = balance -WITHDRAW_AMOUNT;
        assertEquals(expectedBalance, a1.getBalance());
    }
    @Test//Act
    void withdraw_should_succeed_if_amount_not_avaiable() {
        double balance = a1.getBalance(); //Initial Balance
        boolean success= a1.withdraw(a1.getBalance() +1);
        assertFalse(success);
        assertEquals(balance, a1.getBalance());
    }


}