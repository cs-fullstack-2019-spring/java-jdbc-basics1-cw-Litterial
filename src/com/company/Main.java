package com.company;

public class Main {

    public static void main(String[] args) {
        MyJDBC test = new MyJDBC();
        test.connect();
        test.getAllManufacturingData();
        test.getProductData();
        test.maxPriceData();
        test.allProductsUnder100();
    }


}
