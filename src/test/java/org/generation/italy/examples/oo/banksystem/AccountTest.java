package org.generation.italy.examples.oo.banksystem;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    final static double INITIAL_BALANCE = 100;
    Account a1;
    @BeforeEach     //Arrange
    void setUp() {
        a1 = new Account(INITIAL_BALANCE);
    }

    @AfterEach
    void tearDown() {
    }

        double balance = a1.balance;
        double endBalance = a1.deposit(DEPOSIT_AMOUNT);
        double expected = balance + DEPOSIT_AMOUNT;
        assertEquals(expected, endBalance);
        assertEquals(expected, a1.balance);
    }

        double balance = a1.balance;
        assertTrue(success);
        double expectedBalance = balance-WITHDRAW_AMOUNT;
        assertEquals(expectedBalance,a1.balance);
    }
        assertFalse(success);
        assertEquals(balance,a1.balance);
    }

}