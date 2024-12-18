package com.kpilabs;

/**
 * Клас, що представляє іграшкову машинку.
 */
public class Car extends Toy {
    private final String model;

    /**
     * Конструктор для класу Car.
     *
     * @param name  назва машинки
     * @param price ціна машинки
     * @param size  розмір машинки
     * @param model модель машинки
     */
    public Car(String name, double price, String size, String model) {
        super(name, price, size);
        this.model = model;
    }

    /**
     * Повертає рядкове представлення машинки.
     *
     * @return рядкове представлення машинки
     */
    @Override
    public String toString() {
        return super.toString() + String.format(", Модель: %s", model);
    }
}
