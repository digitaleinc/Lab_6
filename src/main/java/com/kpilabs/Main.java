package com.kpilabs;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// variant 25

// 1. Інтерфейс - Set
// 2. Внутрішня структура колекції - Однозв’язний список

// 3. Створити клас, що описує типізовану колекцію
// (типом колекції є узагальнений клас з лабораторної роботи №5),
// що реалізує заданий варіантом інтерфейс (п.2) та має задану
// внутрішню структуру (п.3). Реалізувати всі методи інтерфейсу,
// а також створити не менше ніж 3 конструктори (1 – порожній, 2 – в який передається
// 1 об’єкт узагальненого класу, 3 – в який передається стандартна колекція об’єктів).
// Всі початкові дані задаються у виконавчому методі. Код повинен бути детально задокументований.
// Код повинен відповідати стандартам Java Code Conventions (або Google Java Style Guide)
// та бути завантаженим на GitHub.

/**
 * Головний клас для запуску програми роботи з колекцією ToySet.
 */
public class Main {
    /**
     * Головний метод для виконання програми.
     *
     * @param args командні аргументи
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ініціалізація іграшок
        Toy car1 = new Car("Хот вілс", 10.13, "маленька", "швидкісна");
        Toy doll1 = new Doll("барбі", 15.22, "середня", "коричневий");
        Toy ball1 = new Ball("баскетбольний м'яч", 8.01, "велика", "ґума");
        Toy block1 = new Block("набір лего", 29.23, "середня", 150);
        Toy car2 = new Car("стара машинка", 12.87, "маленька", "вінтаж");
        // Дубль для перевірки Set
        Toy doll2 = new Doll("барбі", 15.22, "середня", "коричневий");

        // Використання порожнього конструктора
        ToySet<Toy> toySet1 = new ToySet<>();
        toySet1.add(car1);
        toySet1.add(doll1);
        toySet1.add(ball1);
        toySet1.add(block1);
        toySet1.add(car2);
        toySet1.add(doll2); // Не має бути додано, дубль

        System.out.println("Набір іграшок (toySet1):");
        System.out.println(toySet1);
        System.out.println("Розмір набору: " + toySet1.size());

        // Використання конструктора з одним елементом
        ToySet<Toy> toySet2 = new ToySet<>(ball1);
        System.out.println("\nНабір іграшок (toySet2) після додавання одного елемента:");
        System.out.println(toySet2);
        System.out.println("Розмір набору: " + toySet2.size());

        // Використання конструктора з колекцією
        List<Toy> initialToys = Arrays.asList(car1, doll1, ball1, block1, car2, doll2);
        ToySet<Toy> toySet3 = new ToySet<>(initialToys);
        System.out.println("\nНабір іграшок (toySet3) після ініціалізації з колекції:");
        System.out.println(toySet3);
        System.out.println("Розмір набору: " + toySet3.size());

        // Демонстрація основних методів
        System.out.println("\nДодати нову іграшку:");
        Toy ball2 = new Ball("Basketball", 9.99, "Medium", "Rubber");
        boolean added = toySet1.add(ball2);
        System.out.println("Іграшка додана: " + added);
        System.out.println(toySet1);

        System.out.println("\nСпроба додати дубль іграшки:");
        added = toySet1.add(doll1);
        System.out.println("Іграшка додана: " + added);
        System.out.println(toySet1);

        System.out.println("\nВидалити іграшку (стара машинка):");
        boolean removed = toySet1.remove(car2);
        System.out.println("Іграшка видалена: " + removed);
        System.out.println(toySet1);

        System.out.println("\nПеревірити наявність іграшки (барбі):");
        boolean contains = toySet1.contains(doll1);
        System.out.println("Набір містить Barbie: " + contains);

        System.out.println("\nВідображення всіх іграшок у наборі (toySet1):");
        for (Toy toy : toySet1) {
            System.out.println(toy);
        }
        scanner.close();
    }
}
