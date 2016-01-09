package nl.mprog.spek.model;

import android.os.Build;

import nl.mprog.spek.BuildConfig;

/**
 * Hardware model class, containing the actual hardware information
 */

public class Hardware {

    public static class Device {
        static public final String NAME = Build.DEVICE;
        static public final String BRAND = Build.BRAND;
        static public final String MODEL = Build.MODEL;
        static public final String MANUFACTURER = Build.MANUFACTURER;
        static public final String PRODUCT = Build.PRODUCT;
        static public final String BOOTLOADER = Build.BOOTLOADER;
        static public final String RADIO = Build.getRadioVersion();
        static public final String KERNEL = BuildConfig.VERSION_NAME;
        static public final String VERSION = getDeviceVersion();

        //TODO get ACTUAL Android Version.
        static public String getDeviceVersion() {
            StringBuilder version = new StringBuilder();
            version.append(Build.VERSION.BASE_OS + " ");
            version.append(Build.VERSION.INCREMENTAL + " ");
            version.append('(' + Build.VERSION.CODENAME + ')');
            return version.toString();
        }

    }



}
