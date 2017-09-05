package com.noveogroup.Util;

import com.noveogroup.device.Device;

import java.util.Comparator;

public class ComparatorFactory {
    public static Comparator<Device> getInstance(boolean ascendMode) {
        if (ascendMode) {
            return new AscendComparator();
        } else {
            return new DescendComparator();
        }
    }
}
