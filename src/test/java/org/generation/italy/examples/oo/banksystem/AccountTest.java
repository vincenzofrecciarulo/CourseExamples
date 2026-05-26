package org.generation.italy.examples.oo.banksystem;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    final static double INITIAL_BALANCE = 100;
    final static double DEPOSIT_AMOUNT = 50;
    Account a1;
    @BeforeEach
    void setUp() {
        a1 = new Account(100);
    }

    @AfterEach
    void tearDown() {
    }

    @Test //Act
    void deposit() {
        double balance = a1.balance;
        double endBalance = a1.deposit(DEPOSIT_AMOUNT);
        double expected = balance + DEPOSIT_AMOUNT;
        assertEquals(expected,endBalance);
        assertEquals(expected, a1.balance);
    }
}