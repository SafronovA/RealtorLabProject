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

    public int getBedNumber() {
        return bedNumber;
    }

    public int getBathNumber() {
        return bathNumber;
    }

    public int getPrice() {
        return price;
    }

    public int getSquare() {
        return square;
    }

}
