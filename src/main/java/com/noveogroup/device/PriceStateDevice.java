package com.noveogroup.device;

abstract public class PriceStateDevice implements Device {
    private int price;

    public PriceStateDevice(int price) throws InvalidPriceException {
        if (price < 0) {
            throw new InvalidPriceException("Invalid price. It can not be less than zero");
        }

        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public int compareTo(Device o) {
        if (null == o) {
            throw new NullPointerException("Trying to compare with null");
        }

        if (price < o.getPrice()) {
            return -1;
        }

        if (price > o.getPrice()) {
            return 1;
        }

        return 0;
    }
}