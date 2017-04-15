package com.cameraswitch.vehiclesearch.scanners;

import android.support.annotation.Nullable;
import android.util.Log;

import java.util.ArrayList;

public class VIN {
    public static final int VIN_NUMBER_LENGTH = 17; // 17 for VIN number in USA
    private static final String TAG = VIN.class.getSimpleName();

    private static int transliterate(char c) {
        return "0123456789.ABCDEFGH..JKLMN.P.R..STUVWXYZ".indexOf(c) % 10;
    }

    private static char getCheckDigit(String vin) {
        String map = "0123456789X";
        String weights = "8765432X098765432";
        int sum = 0;
        for (int i = 0; i < VIN_NUMBER_LENGTH; ++i) {
            sum += transliterate(vin.charAt(i)) * map.indexOf(weights.charAt(i));
        }
        return map.charAt(sum % 11);
    }

    public static boolean validate(String vin) {
        if(vin.length()!=VIN_NUMBER_LENGTH) return false;
        return getCheckDigit(vin) == vin.charAt(8);
    }

    public static ArrayList<String> getAllPossibleVIN(String vin) {
        String [] group = new String [] {"5S", "EGD", "B8", "A4"};
        ArrayList<String> result = new ArrayList<String>();
        StringBuffer sb = new StringBuffer(vin);
        int len = vin.length();
        walk(0, vin, sb, len, result, group);
        return result;
    }

    private static void walk(int start, String vin, StringBuffer sb, int len,
                             ArrayList<String> result, String [] group) {
        if (start == len) {
            result.add(sb.toString());
            Log.d(TAG, " sb = " + sb.toString());
            return;
        }

        char ch = vin.charAt(start);
        String g = getGroup(ch, group);
        if (g != null) {
            int size = g.length();
            for(int j=0; j<size; j++) {
                sb.setCharAt(start, g.charAt(j));
                Log.d(TAG, " sb = " + sb.toString());
                walk(start + 1, vin, sb, len, result, group);
            }
        } else {
            walk(start + 1, vin, sb, len, result, group);
        }
    }

    @Nullable
    private static String getGroup(char ch, String[] group) {
        int size = group.length;
        for (int i = 0; i<size; i++) {
            String g = group[i];
            if (g.contains(String.valueOf(ch)))
                return g;
        }
        return null;
    }
}

