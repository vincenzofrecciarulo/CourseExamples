package org.generation.italy.examples.oo.lambdaandstreams;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class TransactionService implements TransactionAction{

    @Override
    public List<Transaction> getGuest(Guest guest, List<Transaction> transactionList) {
        List<Transaction> list = transactionList.stream()
                .filter((a) -> a.getG().getName().equals(guest.getName()))
                .filter((b) -> b.getG().getSurname().equals(guest.getSurname()))
                .filter((c) -> c.getG().getDateOfBirth().toString().equals(guest.getDateOfBirth().toString()))
                .map((d) -> {
                    int calcPer = Period.between(d.getG().getDateOfBirth(), LocalDate.now()).getYears();
                    if(calcPer < 18){
                        d.setAmount(d.getAmount() -1);
                    }
                    return d;
                })
                .toList();
        return list;
    }

    @Override
    public int sum(List<Transaction> amountList) {
        return amountList.stream()
                .map(Transaction::getAmount)
                .reduce(0, (acc, n) -> acc + n);
    }
}
