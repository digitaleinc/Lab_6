package com.kpilabs;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

/**
 * Клас, що представляє типізований набір іграшок з використанням однозв’язного списку.
 * Реалізує інтерфейс Set.
 *
 * @param <E> тип елементів у наборі
 */
public class ToySet<E extends Toy> implements Set<E> {
    /**
     * Внутрішній клас, що представляє вузол однозв’язного списку.
     */
    private class Node {
        E data;
        Node next;

        Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head; // Початок списку
    private int size;  // Кількість елементів у наборі

    /**
     * Порожній конструктор, створює порожній набір.
     */
    public ToySet() {
        this.head = null;
        this.size = 0;
    }

    /**
     * Конструктор, що створює набір з одного елемента.
     *
     * @param element елемент для додавання у набір
     */
    public ToySet(E element) {
        this();
        add(element);
    }

    /**
     * Конструктор, що створює набір з колекції елементів.
     *
     * @param collection стандартна колекція елементів для додавання у набір
     */
    public ToySet(Collection<? extends E> collection) {
        this();
        addAll(collection);
    }

    /**
     * Повертає кількість елементів у наборі.
     *
     * @return кількість елементів
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Перевіряє, чи набір порожній.
     *
     * @return true, якщо набір порожній, інакше false
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Перевіряє, чи містить набір заданий елемент.
     *
     * @param o елемент для перевірки
     * @return true, якщо набір містить елемент, інакше false
     */
    @Override
    public boolean contains(Object o) {
        if (o == null) return false;
        Node current = head;
        while (current != null) {
            if (current.data.equals(o)) return true;
            current = current.next;
        }
        return false;
    }

    /**
     * Повертає ітератор для набору.
     *
     * @return ітератор
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node current = head;

            /**
             * Перевіряє, чи є наступний елемент.
             *
             * @return true, якщо є наступний елемент, інакше false
             */
            @Override
            public boolean hasNext() {
                return current != null;
            }

            /**
             * Повертає наступний елемент.
             *
             * @return наступний елемент
             * @throws NoSuchElementException якщо елементів більше немає
             */
            @Override
            public E next() {
                if (!hasNext()) throw new NoSuchElementException();
                E data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    /**
     * Повертає масив, що містить всі елементи набору.
     *
     * @return масив елементів
     */
    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        int index = 0;
        Node current = head;
        while (current != null) {
            array[index++] = current.data;
            current = current.next;
        }
        return array;
    }

    /**
     * Повертає масив, що містить всі елементи набору.
     *
     * @param a масив, у який будуть збережені елементи
     * @param <T> тип елементів масиву
     * @return масив елементів
     */
    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < size)
            a = (T[])java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), size);
        int index = 0;
        Node current = head;
        Object[] result = a;
        while (current != null) {
            result[index++] = current.data;
            current = current.next;
        }
        if (a.length > size)
            a[size] = null;
        return a;
    }

    /**
     * Додає елемент до набору, якщо його ще немає.
     *
     * @param e елемент для додавання
     * @return true, якщо елемент був доданий, інакше false
     */
    @Override
    public boolean add(E e) {
        if (e == null) throw new NullPointerException("Набір не допускає null елементи.");
        if (contains(e)) return false;
        Node newNode = new Node(e);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) current = current.next;
            current.next = newNode;
        }
        size++;
        return true;
    }

    /**
     * Видаляє заданий елемент з набору.
     *
     * @param o елемент для видалення
     * @return true, якщо елемент був видалений, інакше false
     */
    @Override
    public boolean remove(Object o) {
        if (o == null) return false;
        if (head == null) return false;
        if (head.data.equals(o)) {
            head = head.next;
            size--;
            return true;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.data.equals(o)) {
                current.next = current.next.next;
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /**
     * Перевіряє, чи набір містить всі елементи заданої колекції.
     *
     * @param c колекція елементів для перевірки
     * @return true, якщо набір містить всі елементи, інакше false
     */
    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object elem : c) {
            if (!contains(elem)) return false;
        }
        return true;
    }

    /**
     * Додає всі елементи заданої колекції до набору.
     *
     * @param c колекція елементів для додавання
     * @return true, якщо набір був змінений, інакше false
     */
    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean modified = false;
        for (E elem : c) {
            if (add(elem)) modified = true;
        }
        return modified;
    }

    /**
     * Зберігає в наборі тільки ті елементи, які містяться також у заданій колекції.
     *
     * @param c колекція елементів для збереження
     * @return true, якщо набір був змінений, інакше false
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;
        Node dummy = new Node(null);
        dummy.next = head;
        Node prev = dummy;
        Node current = head;
        while (current != null) {
            if (!c.contains(current.data)) {
                prev.next = current.next;
                size--;
                modified = true;
            } else {
                prev = current;
            }
            current = current.next;
        }
        head = dummy.next;
        return modified;
    }

    /**
     * Видаляє з набору всі елементи, що містяться у заданій колекції.
     *
     * @param c колекція елементів для видалення
     * @return true, якщо набір був змінений, інакше false
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        Node dummy = new Node(null);
        dummy.next = head;
        Node prev = dummy;
        Node current = head;
        while (current != null) {
            if (c.contains(current.data)) {
                prev.next = current.next;
                size--;
                modified = true;
            } else {
                prev = current;
            }
            current = current.next;
        }
        head = dummy.next;
        return modified;
    }

    /**
     * Видаляє всі елементи з набору.
     */
    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    /**
     * Повертає рядкове представлення набору.
     *
     * @return рядкове представлення набору
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Набір іграшок: [");
        Node current = head;
        while (current != null) {
            sb.append(current.data.toString());
            if (current.next != null) sb.append(", ");
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
