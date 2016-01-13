package nl.mprog.spek.model;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;


/**
 * Hardware model class, containing the actual hardware information
 */

public abstract class Hardware {

    public static class Device {
        public static final String BRAND = Build.BRAND;
        public static final String MODEL = Build.MODEL;
        public static final String MANUFACTURER = Build.MANUFACTURER;
        public static final String PRODUCT = Build.PRODUCT;
        public static final String VERSION = getDeviceVersion();
        public static final String RADIO = Build.getRadioVersion();
        public static final String KERNEL = getKernelVersion();


        /**
         * Returns a nicely formatted string of the android version and build number.
         */
        public static String getDeviceVersion() {
            StringBuilder version = new StringBuilder();
            version.append("Android" + " ");
            version.append(Build.VERSION.RELEASE + " ");
            version.append('(' + Build.DISPLAY + ')');
            return version.toString();
        }

        /**
         * Returns the kernel version from /proc/version
         */
        public static String getKernelVersion(){
            String kernel = procGrep("version", ".*");

            if(kernel.isEmpty()){
                return "Could not find kernel version.";
            } else {
                return kernel;
            }
        }

        /**
         * Returns Security Patch version, if it exists.
         */
        @TargetApi(Build.VERSION_CODES.M)
        public static String getSecurityPatch(){
                return Build.VERSION.SECURITY_PATCH;
        }

    }


    public static class CPU {

    }

    /**
     * Returns an InputStream of a file residing in /proc/
     * @param filename  String of the filename, without "/proc".
     * @return InputStream of the file, if it exists null if not.
     */
    public static InputStream procRead(String filename) {
        File readfile    = new File("/proc/", filename);


        if(readfile.exists() && readfile.isFile() && readfile.canRead()) {
            try {
                return new FileInputStream(readfile);
            } catch (FileNotFoundException e) {
                return null;
            }
        }
        else {
            return  null;
        }
    }

    /**
     * returns any line containing a certain pattern.
     * @param filename name of file, residing in /proc/
     * @param pattern  pattern to search file for.
     * @return         All lines containing the pattern devided by newline, in a single string
     */
    public static String procGrep(String filename, String pattern ) {
        final StringBuilder grep = new StringBuilder();

        InputStream readfile = procRead(filename);
        if(readfile == null){
            return grep.toString();
        }

        Scanner scan = new Scanner(readfile);
        while (scan.hasNextLine()){
            String line = scan.nextLine();
            if(line.matches(".*" + pattern+ ".*")){
                grep.append(line);
            }
        }

        scan.close();
        return grep.toString();
    }

}
