package com.noveogroup.algorithm.insertionsort;

import com.noveogroup.Util.ComparatorFactory;
import com.noveogroup.algorithm.Algorithm;
import com.noveogroup.device.Device;

import java.util.Comparator;

public class InsertSort implements Algorithm {
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

        if (0 == devices.length || 1 == devices.length) {
            return;
        }

        synchronized (devices) {
            Device device;

            Comparator<Device> comparator = ComparatorFactory.getInstance(ascendingSort);

            for (int i = 0; i < devices.length; ++i) {
                device = devices[i];

                int j;
                for (j = i - 1; j >= 0 && (comparator.compare(devices[j], device) > 0); --j) {
                    devices[j + 1] = devices[j];
                }

                devices[j + 1] = device;
            }
        }
    }
}
