package org.generation.italy.examples.oo.banksystem;

import org.generation.italy.examples.oo.banksystem.Account;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    final static double INITIAL_BALANCE = 100;
    final static double DEPOSIT_AMOUNT = 50;
    final static double WITHDRAW_AMOUNT = 20;

    Account a1;

    @BeforeEach
    void setUp() {
        a1 = new Account(INITIAL_BALANCE); // AAA - we arrange here. creating the object we need for testing deposit(). every new Account object here will have an initial balance of INITIAL_BALANCE
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void deposit() {
        double balance = a1.balance;
        double endBalance = a1.deposit(DEPOSIT_AMOUNT);
        double expected = balance + DEPOSIT_AMOUNT;
        assertEquals(expected, endBalance);
        assertEquals(expected, a1.balance);
    }

    @Test
    void withdraw_should_succeed_if_amount_available() {
        double balance = a1.balance;
        boolean success = a1.withdraw(WITHDRAW_AMOUNT);
        assertTrue(success);
        double expectedBalance = balance - WITHDRAW_AMOUNT;
        assertEquals(expectedBalance, a1.balance);
    }

    @Test
    void withdraw_should_fail_if_amount_unavailable() {
        double balance = a1.balance;           // initial balance
        boolean success = a1.withdraw(a1.balance + 1);
        assertFalse(success);
        assertEquals(balance, a1.balance);    // we check that the balance doesn't change!
    }
}