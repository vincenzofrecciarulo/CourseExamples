package org.generation.italy.examples.oo.banksystem;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {
    final static String NAME = "Jacopo";
    final static String SURNAME = "De Maio";
    final static String DATE_OF_BIRTH = "25/07/2000";
    final static char GENDER = 'm';

    Client client;
    @BeforeEach
    void setUp() {
        client = new Client(NAME,SURNAME,DATE_OF_BIRTH,GENDER);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addAccount_if_client_has_not_account() {
        boolean success = client.addAccount();
        assertTrue(success);
        int numAccountTest = client.accounts.length;
        int expected = 1;
        assertEquals(expected,numAccountTest);
    }
}