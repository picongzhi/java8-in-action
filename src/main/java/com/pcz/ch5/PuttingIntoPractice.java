package com.pcz.ch5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author picongzhi
 */
public class PuttingIntoPractice {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brain = new Trader("Brain", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brain, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950));

        System.out.println(transactions.stream().
                filter(transaction -> transaction.getYear() == 2011).
                sorted(Comparator.comparing(Transaction::getValue)).
                collect(Collectors.toList()));

        System.out.println(transactions.stream().
                map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList()));

        System.out.println(transactions.stream().
                map(Transaction::getTrader).
                filter(trader -> trader.getCity().equals("Cambridge")).
                distinct().
                sorted(Comparator.comparing(Trader::getName)).
                collect(Collectors.toList()));

        System.out.println(transactions.stream().
                map(transaction -> transaction.getTrader().getName()).
                distinct().
                sorted().
                reduce("", (n1, n2) -> n1 + n2));

        System.out.println(transactions.stream().
                anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan")));

        transactions.stream().
                map(Transaction::getTrader).
                filter(trader -> trader.getCity().equals("Milan")).
                forEach(trader -> trader.setCity("Cambridge"));
        System.out.println(transactions);

        System.out.println(transactions.stream().
                map(Transaction::getValue).
                reduce(0, Integer::max));
    }
}
