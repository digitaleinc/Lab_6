package com.kpilabs;

/**
 * Клас, що представляє ляльку.
 */
public class Doll extends Toy {
    private final String hairColor;

    /**
     * Конструктор для класу Doll.
     *
     * @param name      назва ляльки
     * @param price     ціна ляльки
     * @param size      розмір ляльки
     * @param hairColor колір волосся ляльки
     */
    public Doll(String name, double price, String size, String hairColor) {
        super(name, price, size);
        this.hairColor = hairColor;
    }

    /**
     * Повертає рядкове представлення ляльки.
     *
     * @return рядкове представлення ляльки
     */
    @Override
    public String toString() {
        return super.toString() + String.format(", Колір волосся: %s", hairColor);
    }
}
