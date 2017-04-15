package com.cameraswitch.vehiclesearch;

import android.Manifest;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;

import static android.content.Context.MODE_PRIVATE;

public class Helper {
    public static boolean checkPermission(final Context c) {
        return ActivityCompat.checkSelfPermission(
                c, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
            && ActivityCompat.checkSelfPermission(
                c, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED;
    }
    public static String getVin(Context c) {
        SharedPreferences settings = c.getSharedPreferences(Const.PREFS_NAME, MODE_PRIVATE);

        // Reading from SharedPreferences
        return settings.getString(Const.VIN, Const.DEFAULT_VIN);
    }

    public static void saveVin(Context c, String vin) {
        SharedPreferences settings = c.getSharedPreferences(Const.PREFS_NAME, MODE_PRIVATE);

        // Writing data to SharedPreferences
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(Const.VIN, vin);
        editor.commit();
    }
}
