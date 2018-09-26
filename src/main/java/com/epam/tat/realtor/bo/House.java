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

    public void setBedNumber(int bedNumber) {
        this.bedNumber = bedNumber;
    }

    public int getBathNumber() {
        return bathNumber;
    }

    public void setBathNumber(int bathNumber) {
        this.bathNumber = bathNumber;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSquare() {
        return square;
    }

    public void setSquare(int square) {
        this.square = square;
    }
}
