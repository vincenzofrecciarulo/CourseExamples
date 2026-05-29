package org.generation.italy.examples.oo.banksystem;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    final static double INITIAL_BALANCE = 100;
    final static double DEPOSIT_AMOUNT = 50;
    Account a1;
    @BeforeEach //Arrange
    void setUp() {
        a1 = new Account(INITIAL_BALANCE);
    }

    @AfterEach
    void tearDown() {
    }

    @Test//Act
    void deposit() {
        double endBalance= a1.deposit(DEPOSIT_AMOUNT);
        double expected = balance + DEPOSIT_AMOUNT;
        assertEquals(expected,endBalance);
    }
        boolean success= a1.withdraw(WITHDRAW_AMOUNT);
        assertTrue(success);
    }
        assertFalse(success);
    }
}