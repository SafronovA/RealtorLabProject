package com.epam.tat.realtor.bo;

public class House {
    private int bedNumber;
    private int bathNumber;
    private int price;
    private int square;

    public House(int bedNumber, int bathNumber, int price, int square) {
        this.bedNumber = bedNumber;
        this.bathNumber = bathNumber;
        this.price = price;
        this.square = square;
    }

    /**
     * get bed number in searched house
     * @return bed number
     */
    public int getBedNumber() {
        return bedNumber;
    }
    /**
     * get bath number in searched house
     * @return bath number
     */
    public int getBathNumber() {
        return bathNumber;
    }
    /**
     * get price of searched house
     * @return price value
     */
    public int getPrice() {
        return price;
    }
    /**
     * get square of searched house
     * @return square value
     */
    public int getSquare() {
        return square;
    }

}
