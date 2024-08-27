package HW02;

import java.util.Arrays;
import java.util.Collection;

public class MyArrayList<T extends Comparable<T>> {
    private Object[] elements;
    private int currentSize = 0;
    private static final int DEFAULT_SIZE = 8;

    public MyArrayList() {
        elements = new Object[DEFAULT_SIZE];
    }

    public MyArrayList(Collection<? extends T> collection) {
        elements = new Object[collection.size()];
        addAll(collection);
    }

    public void add(T item) {
        try {
            checkSize();
            elements[currentSize] = item;
            currentSize++;
        }
        catch(Exception e) {
            throw e;
        }
    }

    public T get(int index) {
        if (checkIndex(index)) {
            return (T)elements[index];
        }
        else {
            throw new IndexOutOfBoundsException();
        }
    }

    public void set(int index, T item) {
        if (checkIndex(index)) {
            elements[index] = item;
        }
        else {
            throw new IndexOutOfBoundsException();
        }
    }

    public boolean remove(T item) {
        for (int i = 0; i < elements.length; i++) {
            if (((T)elements[i]).compareTo(item) == 0) {
                return remove(i);
            }
        }
        return false;
    }

    public boolean remove(int index) {
        if (checkIndex(index)) {
            var newElements = new Object[elements.length - 1];
            for (int i = 0; i < newElements.length; i++) {
                if (i < index) {
                    newElements[i] = elements[i];
                } else if (i > index) {
                    newElements[i] = elements[i + 1];
                }
            }
            currentSize--;
            elements = newElements;
            return true;
        } else return false;
    }

    public void addAll(Collection<? extends T> collection) {
        for (T item : collection) {
            add(item);
        }
    }

    public void sort() {
        boolean swapped;
        int size = currentSize - 1;
        do {
            swapped = false;
            for (int i = 0; i < size; i++) {
                T element1 = this.get(i);
                T element2 = this.get(i + 1);
                if (element1.compareTo(element2) > 0) {
                    T tempItem = element1;
                    elements[i] = element2;
                    elements[i + 1] = tempItem;
                    swapped = true;
                }
            }
        } while (swapped);
    }

    public int size() {
        return currentSize;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    private void checkSize() {
        if (currentSize == elements.length) {
            int newSize = elements.length * 2;
            elements = Arrays.copyOf(elements, newSize);
        }
    }

    private boolean checkIndex(int index) {
        return index >= 0 && index < elements.length;
    }

    public static <K extends Comparable<K>> Object[] sort(Collection<? extends K> collection) {
        Object[] array = collection.toArray();
        boolean swapped;
        int size = array.length - 1;
        do {
            swapped = false;
            for (int i = 0; i < size; i++) {
                if (((K) array[i]).compareTo((K) array[i + 1]) > 0) {
                    Object tempItem = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tempItem;
                    swapped = true;
                }
            }
        } while (swapped);
        return array;
    }
}
