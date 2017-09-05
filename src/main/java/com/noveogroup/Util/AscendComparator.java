package com.noveogroup.Util;

import com.noveogroup.device.Device;

import java.util.Comparator;

public class AscendComparator implements Comparator<Device> {
    /**
     *null is less than anything else
     */
    @Override
    public int compare(Device o1, Device o2) {
        if (null == o1) {
            if (null == o2) {
                return 0;
            } else {
                return -1;
            }
        }

        if (null == o2) {
            return 1;
        }

        return o1.compareTo(o2);
    }
}
