package com.kpilabs;

/**
 * Абстрактний базовий клас, що представляє загальну іграшку.
 */
public abstract class Toy {
    private final String name;
    private final double price;
    private final String size; // Small, Medium, Large

    /**
     * Конструктор для класу Toy.
     *
     * @param name  назва іграшки
     * @param price ціна іграшки
     * @param size  розмір іграшки (Small, Medium, Large)
     */
    public Toy(String name, double price, String size) {
        this.name = name;
        this.price = price;
        this.size = size;
    }

    /**
     * Повертає рядкове представлення іграшки.
     *
     * @return рядкове представлення іграшки
     */
    @Override
    public String toString() {
        return String.format("%s | Назва: %s, Ціна: %.2f, Розмір: %s",
                this.getClass().getSimpleName(), name, price, size);
    }

    /**
     * Перевизначення методу equals для забезпечення унікальності елементів у наборі.
     *
     * @param obj об'єкт для порівняння
     * @return true, якщо об'єкти однакові, інакше false
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Toy other)) return false;
        return this.name.equals(other.name) &&
                Double.compare(this.price, other.price) == 0 &&
                this.size.equals(other.size);
    }

    /**
     * Перевизначення методу hashCode для забезпечення унікальності елементів у наборі.
     *
     * @return хеш-код об'єкта
     */
    @Override
    public int hashCode() {
        int result = name.hashCode();
        long temp = Double.doubleToLongBits(price);
        result = 31 * result + (int)(temp ^ (temp >>> 32));
        result = 31 * result + size.hashCode();
        return result;
    }
}
