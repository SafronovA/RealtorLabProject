package com.epam.tat.realtor.bo;

public class House {
    private int bedNumber;
    private int bathNumber;
    private int price;
    private int square;
    private int lotSize;
    private int carSpaces;

    public House(int bedNumber, int bathNumber, int price, int square) {
        this.bedNumber = bedNumber;
        this.bathNumber = bathNumber;
        this.price = price;
        this.square = square;
    }

    public House(int bedNumber, int bathNumber, int square, int lotSize, int carSpaces) {
        this.bedNumber = bedNumber;
        this.bathNumber = bathNumber;
        this.square = square;
        this.lotSize = lotSize;
        this.carSpaces = carSpaces;
    }

    /**
     * get bed number in searched house
     *
     * @return bed number
     */
    public int getBedNumber() {
        return bedNumber;
    }

    /**
     * get bath number in searched house
     *
     * @return bath number
     */
    public int getBathNumber() {
        return bathNumber;
    }

    /**
     * get price of searched house
     *
     * @return price value
     */
    public int getPrice() {
        return price;
    }

    /**
     * get square of searched house
     *
     * @return square value
     */
    public int getSquare() {
        return square;
    }

    /**
     * get lot size of searched house
     *
     * @return lotSize value
     */
    public int getLotSize() {
        return lotSize;
    }

    /**
     * get car spaces of searched house
     *
     * @return carSpaces value
     */
    public int getCarSpaces() {
        return carSpaces;
    }

}
