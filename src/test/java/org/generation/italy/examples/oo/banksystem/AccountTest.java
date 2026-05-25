package org.generation.italy.examples.oo.banksystem;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    final static double INITIAL_BALANCE = 100;
    final static double DEPOSIT_AMOUNT=50;
    final static double WITHDRAW_AMOUNT=50;
    final static double WITHDRAW_AMOUNT2=150;

    Account a1;

    @BeforeEach//Arrange
    void setUp() {
        a1 = new Account(INITIAL_BALANCE);
    }

    @AfterEach
    void tearDown() {
    }

    @Test//Act
    void deposit() {
        double balance = a1.balance;
        double endBalance = a1.deposit(DEPOSIT_AMOUNT);
        double expected = balance + DEPOSIT_AMOUNT;
        assertEquals (expected, endBalance);
        assertEquals (expected , a1.balance);
    }
    @Test
    void withdraw_should_succeed_if_amount_available() {
        double balance = a1.balance;
        boolean success = a1.withdraw(WITHDRAW_AMOUNT);
        assertTrue(success);
        double expBalance = balance - WITHDRAW_AMOUNT;
        assertEquals (expBalance , a1.balance);
    }
    @Test
    void withdraw_should_not_succeed_if_amount_not_available() {
        double balance = a1.balance;
        boolean success = a1.withdraw(WITHDRAW_AMOUNT2);
        assertFalse(success);
        assertEquals(balance, a1.balance);
    }
}