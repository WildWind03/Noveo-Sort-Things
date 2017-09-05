package com.noveogroup.algorithmtest;

import com.noveogroup.algorithm.Algorithm;
import com.noveogroup.algorithm.bubblesort.BubbleSort;
import com.noveogroup.algorithm.insertionsort.InsertSort;
import com.noveogroup.algorithm.quicksort.QuickSort;
import com.noveogroup.device.*;
import org.junit.Assert;
import org.junit.Test;

public class SortTest {

    @Test
    public void checkSort() throws InvalidPriceException {
        Algorithm[] algorithms = new Algorithm[] {new BubbleSort(), new InsertSort(), new QuickSort()};

        for (Algorithm algorithm : algorithms) {
            Device[] devices = new Device[] {new Laptop(300), new MobilePhone(400), new Tablet(100), new Laptop(250), new Laptop(500)};

            algorithm.sort(devices, true);
            Assert.assertEquals(100, devices[0].getPrice());
            Assert.assertEquals(250, devices[1].getPrice());
            Assert.assertEquals(300, devices[2].getPrice());
            Assert.assertEquals(400, devices[3].getPrice());
            Assert.assertEquals(500, devices[4].getPrice());

            algorithm.sort(devices, false);
            Assert.assertEquals(500, devices[0].getPrice());
            Assert.assertEquals(400, devices[1].getPrice());
            Assert.assertEquals(300, devices[2].getPrice());
            Assert.assertEquals(250, devices[3].getPrice());
            Assert.assertEquals(100, devices[4].getPrice());
        }
    }

    @Test
    public void checkForNull() {
        Algorithm[] algorithms = new Algorithm[] {new BubbleSort(), new InsertSort(), new QuickSort()};

        for (Algorithm algorithm : algorithms) {
            algorithm.sort(null, true);
        }
    }

    @Test
    public void checkSortingArraysWithNull() throws InvalidPriceException {
        Algorithm[] algorithms = new Algorithm[] {new BubbleSort(), new InsertSort(), new QuickSort()};

        for (Algorithm algorithm : algorithms) {
            Device[] devices = new Device[] {new Laptop(300), new MobilePhone(400), new Tablet(100), new Laptop(250), null};

            algorithm.sort(devices, true);
            Assert.assertEquals(null, devices[0]);
            Assert.assertEquals(100, devices[1].getPrice());
            Assert.assertEquals(250, devices[2].getPrice());
            Assert.assertEquals(300, devices[3].getPrice());
            Assert.assertEquals(400, devices[4].getPrice());

            algorithm.sort(devices, false);
            Assert.assertEquals(400, devices[0].getPrice());
            Assert.assertEquals(300, devices[1].getPrice());
            Assert.assertEquals(250, devices[2].getPrice());
            Assert.assertEquals(100, devices[3].getPrice());
            Assert.assertEquals(null, devices[4]);
        }
    }
}