package com.kpilabs;

/**
 * Клас, що представляє м'яч.
 */
public class Ball extends Toy {
    private final String material;

    /**
     * Конструктор для класу Ball.
     *
     * @param name     назва м'яча
     * @param price    ціна м'яча
     * @param size     розмір м'яча
     * @param material матеріал м'яча
     */
    public Ball(String name, double price, String size, String material) {
        super(name, price, size);
        this.material = material;
    }

    /**
     * Повертає рядкове представлення м'яча.
     *
     * @return рядкове представлення м'яча
     */
    @Override
    public String toString() {
        return super.toString() + String.format(", Матеріал: %s", material);
    }
}
