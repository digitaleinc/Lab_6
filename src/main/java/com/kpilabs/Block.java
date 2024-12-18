package com.kpilabs;

/**
 * Клас, що представляє кубики.
 */
public class Block extends Toy {
    private final int numberOfPieces;

    /**
     * Конструктор для класу Block.
     *
     * @param name           назва набору кубиків
     * @param price          ціна набору кубиків
     * @param size           розмір набору кубиків
     * @param numberOfPieces кількість кубиків у наборі
     */
    public Block(String name, double price, String size, int numberOfPieces) {
        super(name, price, size);
        this.numberOfPieces = numberOfPieces;
    }

    /**
     * Повертає рядкове представлення набору кубиків.
     *
     * @return рядкове представлення набору кубиків
     */
    @Override
    public String toString() {
        return super.toString() + String.format(", Кількість: %d", numberOfPieces);
    }
}
