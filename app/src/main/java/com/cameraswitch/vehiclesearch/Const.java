package com.cameraswitch.vehiclesearch;


public class Const {
    public static final String MAKE = "Make";
    public static final String MODEL = "Model";
    public static final String MODEL_YEAR = "Model Year";
    public static final String ZIP_CODE = "ZipCode";
    public static final String DECODED_VIN = "DecodedVin";
    public static final String VIN = "Vin";

    public static final int REQ_CODE_SPEECH_INPUT = 101;
    public static final int REQ_CODE_OCR_INPUT = 102;
    public static final int REQ_CODE_LOCATION_ACCESS = 103;

    public static final int OCR_DETECTOR = 101;
    public static final int BARCODE_DETECTOR = 102;

    public static final String DEFAULT_ZIP_CODE = "94538";

    public static final String DETECTOR_TYPE = "DetectorType";

    public static final String CACHE_FILENAME = "cacheFile";

    public static final int CACHE_FILESIZE = 10 * 1024 * 1024; // 10 MiB;
    public static final int THUMBNAILS_MAX_WIDTH = 700;

    public static final String PREFS_NAME = "PrivatePreference";
    public static final String DEFAULT_VIN = "5YJSA1AG8DFP00001";
}
