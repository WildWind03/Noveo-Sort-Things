package com.noveogroup.algorithm.quicksort;

import com.noveogroup.Util.ComparatorFactory;
import com.noveogroup.Util.Util;
import com.noveogroup.algorithm.Algorithm;
import com.noveogroup.device.Device;

import java.util.Comparator;

public class QuickSort implements Algorithm {

    private void sort(Device[] devices, int start, int finish, boolean ascendingSort) {
        if (null == devices) {
            return;
        }

        if (0 == devices.length || 1 == devices.length || finish == start) {
            return;
        }

        if (finish < start) {
            throw new IllegalArgumentException("Finish pointer can't be less than start pointer");
        }

        int toFinish = start;
        int toStart = finish;

        Device bearingDevice = devices[start / 2 + finish / 2];

        Comparator<Device> comparator = ComparatorFactory.getInstance(ascendingSort);

        do {
            while (comparator.compare(bearingDevice, devices[toFinish]) > 0) {
                ++toFinish;
            }
            while (comparator.compare(devices[toStart], bearingDevice) > 0) {
                --toStart;
            }

            if (toFinish <= toStart) {
                if (comparator.compare(devices[toFinish], devices[toStart]) > 0) {
                    Util.swap(devices, toFinish, toStart);
                }

                toStart--;
                toFinish++;
            }
        } while (toFinish <= toStart);

        if (toFinish < finish) {
            sort(devices, toFinish, finish, ascendingSort);
        }

        if (toStart > start) {
            sort(devices, start, toStart, ascendingSort);
        }
    }

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
            sort(devices, 0, devices.length - 1, ascendingSort);
        }
    }
}
