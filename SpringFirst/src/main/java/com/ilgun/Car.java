package com.ilgun;

public class Car {

    private double fiyat ;

    public Car(){

        System.out.println("Inside Car constructor");
        fiyat = 40.1;
    }

    public void setFiyat(double fiyat3) {
        this.fiyat = fiyat3;
    }

    public double getFiyat() {
        return fiyat;
    }

    public void vergi(){

        System.out.println("Total fee with tax :  " +  (fiyat + 50.2));

    }
}
