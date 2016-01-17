package nl.mprog.spek.model;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Hardware model class, containing the actual hardware information
 */

public abstract class Hardware {

    public static final String KERNEL_PROC = "version";
    public static final String CPU_PROC    = "cpuinfo";



    public static class Device {
        public static final String BRAND = Build.BRAND;
        public static final String MODEL = Build.MODEL;
        public static final String MANUFACTURER = Build.MANUFACTURER;
        public static final String PRODUCT = Build.PRODUCT;
        public static final String VERSION = getDeviceVersion();
        public static final String RADIO = Build.getRadioVersion();
        public static final String KERNEL = System.getProperty("os.version",
                "Could not find kernel version.");

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
         * Returns Security Patch version, if it exists.
         */
        @TargetApi(Build.VERSION_CODES.M)
        public static String getSecurityPatch(){
                return Build.VERSION.SECURITY_PATCH;
        }

    }


    public static class CPU {
        public static String NAME    = getSubFields(CPU_PROC, "Hardware", "[^:]+$",
                "Could not find processor name").get(0);
        public static String ARCH    = System.getProperty("os.arch",
                "Could not find architecture");
        public static int CORE_COUNT = Runtime.getRuntime().availableProcessors();

        //TODO: Get CPU Usage info.

    }


    public static class Memory {

    }

    /**
     *
     * @param filename name of the file searched, residing in /proc/
     * @param pattern  pattern to search in file
     * @param errorMsg error message to display, if no matches were found
     * @return String  string containing all lines matching, seperated by newlines.
     */
    public static String getFullLines(String filename, String pattern, String errorMsg){
        String result = procGrep(filename, pattern);

        if(result.isEmpty()){
            return errorMsg;
        } else {
            return result;
        }
    }

    public static ArrayList<String> getSubFields(String filename, String pattern,
                                                      String subStringRegex, String errorMsg){
        ArrayList<String> result = procGrep(filename, pattern, subStringRegex);
        if(result.isEmpty()){
            result.add(errorMsg);
        }

        return result;
    }

    /**
     * returns any line containing a certain pattern.
     * @param filename name of file, residing in /proc/
     * @param pattern  pattern to search file for.
     * @return         All lines containing the pattern devided by newline, in a single string
     */
    public static String procGrep(String filename, String pattern) {
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

    /**
     * Returns any line containing  certain pattern, and then filters line on a regex.
     * @param filename name of the file, residing in /proc/
     * @param pattern  pattern to search file for.
     * @param regexSubstring pattern to filter results on.
     * @return ArrayList of results.
     */
    public static ArrayList<String> procGrep(String filename, String pattern, String regexSubstring) {
        final StringBuilder grep = new StringBuilder();
        ArrayList<String> result = new ArrayList<>();

        InputStream readfile = procRead(filename);
        if(readfile == null){
            return result;
        }

        Scanner scan = new Scanner(readfile);
        while (scan.hasNextLine()){
            String line = scan.nextLine();
            if(line.matches(".*" + pattern+ ".*")){
                grep.append(line);
            }
        }

        scan.close();

        Pattern regex = Pattern.compile(regexSubstring);
        Matcher m     = regex.matcher(grep.toString());

        int i = 0;
        while(m.find()) {
            result.add(m.group());
            i++;
        }

        return result;
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

}
