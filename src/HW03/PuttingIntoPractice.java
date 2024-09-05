package HW03;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*
1. Найти все транзакции за 2011 год и отсортировать их по сумме (от меньшей
к большей).

2. Вывести список неповторяющихся городов, в которых работают трейдеры.

3. Найти всех трейдеров из Кембриджа и отсортировать их по именам.

4. Вернуть строку со всеми именами трейдеров, отсортированными в алфавитном
порядке.

5. Выяснить, существует ли хоть один трейдер из Милана.

6. Вывести суммы всех транзакций трейдеров из Кембриджа.

7. Какова максимальная сумма среди всех транзакций?

8. Найти транзакцию с минимальной суммой.
 */
public class PuttingIntoPractice {

    public static void main(String... args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        System.out.println("1. Все транзакции за 2011 год и отсортировать их по сумме (от меньшей к большей)");
        transactions.stream()
                .filter(x -> x.getYear() == 2011)
                .sorted(Comparator.comparingInt(Transaction::getValue))
                .forEach(System.out::println);

        System.out.println("2. Вывести список неповторяющихся городов, в которых работают трейдеры.");
        transactions.stream()
                .map(x-> x.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);

        System.out.println("3. Найти всех трейдеров из Кембриджа и отсортировать их по именам.");
        transactions.stream()
                .map(x-> x.getTrader())
                .distinct()
                .filter(x-> x.getCity().equals("Cambridge"))
                .sorted(Comparator.comparing(Trader::getName))
                .forEach(System.out::println);

        System.out.println("4. Вернуть строку со всеми именами трейдеров, отсортированными в алфавитном порядке.");
        String tradersString = transactions.stream()
                .map(x-> x.getTrader().getName())
                .distinct()
                .sorted()
                .collect(Collectors.joining(" "));
        System.out.println(tradersString);

        System.out.println("5. Выяснить, существует ли хоть один трейдер из Милана.");
        boolean traderFromMilanExist = transactions.stream()
                .map(x-> x.getTrader())
                .anyMatch(x-> x.getCity().equals("Milan"));
        System.out.println(traderFromMilanExist);

        System.out.println("6. Вывести суммы всех транзакций трейдеров из Кембриджа.");
        transactions.stream()
                .filter(x-> x.getTrader().getCity().equals("Cambridge"))
                .map((x-> x.getValue()))
                .forEach(System.out::println);

        System.out.println("7. Какова максимальная сумма среди всех транзакций?");
        int maxValue = transactions.stream()
                .map(x-> x.getValue())
                .max((x,y) -> Integer.compare(x, y))
                .get();
        System.out.println(maxValue);

        System.out.println("8. Найти транзакцию с минимальной суммой");
        Transaction transactionMinValue = transactions.stream()
                .min((x,y) -> Integer.compare(x.getValue(), y.getValue()))
                .get();
        System.out.println(transactionMinValue);
    }
}
