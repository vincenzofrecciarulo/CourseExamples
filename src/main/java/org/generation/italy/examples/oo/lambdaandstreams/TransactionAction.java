package org.generation.italy.examples.oo.lambdaandstreams;

import java.util.List;

public interface TransactionAction {

    public List<Transaction> getGuest(Guest guest, List<Transaction> transactionList);

    public int sum(List<Transaction> amountList);
}
