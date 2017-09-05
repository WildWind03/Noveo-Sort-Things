package com.noveogroup.Util;

import com.noveogroup.device.Device;

public class Util {
    public static void swap(Device[] devices, int pos1, int pos2) {
        if (null == devices) {
            throw new NullPointerException("Null reference instead of array of devices");
        }

        if (pos1 < 0 || pos2 < 0) {
            throw new IllegalArgumentException("Pos1 and pos2 mustn't be negative");
        }

        if (pos1 > devices.length || pos2 > devices.length) {
            throw new IllegalArgumentException("Value of pos arg can't be bigger than length of the device array!");
        }

        Device device = devices[pos1];
        devices[pos1] = devices[pos2];
        devices[pos2] = device;
    }
}
