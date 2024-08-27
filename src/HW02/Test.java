package HW02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Test {
    public static void main(String[] args) {

        var myCollection = new MyArrayList<String>();

        myCollection.add("Строка 0");
        var value = myCollection.get(0);
        printCollection(myCollection, "Добавление элемента в коллекцию:");

        myCollection.set(0, "Новая строка");
        printCollection(myCollection, "Изменение элемента в коллекции:");

        myCollection.remove("Новая строка");
        printCollection(myCollection, "Удаление элемента из коллекции:");

        var stringArray = new String[] { "Строка 1", "Строка 4", "Строка 2", "Строка 3", "Строка 7", "Строка 5", "Строка 6", "Строка 8" };
        myCollection.addAll(Arrays.asList(stringArray));
        printCollection(myCollection, "Добавление коллекции в коллекцию:");

        myCollection.sort();
        printCollection(myCollection, "Сортировка коллекции пузырьковым методом:");
    }

    static <T extends Comparable<T>> void printCollection(MyArrayList<T> items, String testName) {
        System.out.println(testName);
        if (!items.isEmpty())
            for (int i = 0; i < items.size(); i++) {
                System.out.print(items.get(i).toString() + ", ");
            }
        else {
            System.out.print("Коллекция пуста");
        }
        System.out.println();
        System.out.println();
    }
}
