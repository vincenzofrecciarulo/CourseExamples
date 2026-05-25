package org.generation.italy.examples.oo.banksystem;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    final static double INITIAL_BALANCE = 100;
    final static double DEPOSIT_AMOUNT = 15;
    final static double WITHDRAW_AMOUNT = 30;
    Account a1;
    @BeforeEach     //Arrange
    void setUp() {
        a1 = new Account(INITIAL_BALANCE);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void try_to_deposit_15_dollars() {
        double balance = a1.balance;
        double endBalance = a1.deposit(DEPOSIT_AMOUNT);
        double expected = balance + DEPOSIT_AMOUNT;
        assertEquals(expected, endBalance);
        assertEquals(expected, a1.balance);

    }

    @Test
    void withdraw_should_success_if_amount_avaiable() {
        double balance = a1.balance;
        boolean success = a1.withdraw(WITHDRAW_AMOUNT);;

        assertTrue(success);
        double expectedBalance = balance-WITHDRAW_AMOUNT;
        assertEquals(expectedBalance,a1.balance);

    }

    @Test
    void withdraw_shouldnt_success_if_amount_avaiable() {
        double balance = a1.balance;
        boolean success = a1.withdraw(a1.balance+1);;

        assertFalse(success);
        assertEquals(balance,a1.balance);

    }

}