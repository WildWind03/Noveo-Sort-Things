package com.noveogroup.algorithm.bubblesort;

import com.noveogroup.Util.ComparatorFactory;
import com.noveogroup.Util.Util;
import com.noveogroup.algorithm.Algorithm;
import com.noveogroup.device.Device;

import java.util.Comparator;

public class BubbleSort implements Algorithm {
    /**
     * Sorts an array of devices. Null array is sorted. Null reference in the array is less than anything else
     * @param devices array of devices.
     * @param ascendingSort true for ascending sort, false for descending sort.
     */

    @Override
    public void sort(Device[] devices, boolean ascendingSort) {
        if (null == devices) {
            return;
        }

        int length = devices.length;

        if (0 == length  || 1 == length) {
            return;
        }

        Comparator<Device> deviceComparator = ComparatorFactory.getInstance(ascendingSort);

        synchronized (devices) {
            for (int i = 0; i < devices.length - 1; ++i) {
                for (int k = 0; k < devices.length - 1 - i; ++k) {
                    if (deviceComparator.compare(devices[k], devices[k + 1]) > 0) {
                        Util.swap(devices, k, k + 1);
                    }
                }
            }
        }
    }
}