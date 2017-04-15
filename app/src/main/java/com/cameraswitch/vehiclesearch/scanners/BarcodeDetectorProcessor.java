package com.cameraswitch.vehiclesearch.scanners;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.util.SparseArray;

import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.barcode.Barcode;
import com.cameraswitch.vehiclesearch.R;

class BarcodeDetectorProcessor implements Detector.Processor<Barcode> {
    private final OCRActivity.VinDetectorListener mVinDetectorListener;
    private GraphicOverlay<OcrGraphic> mGraphicOverlay;
    private final Context mContext;

    public BarcodeDetectorProcessor(Context c, GraphicOverlay<OcrGraphic> overlay, OCRActivity.VinDetectorListener listener) {
        mContext = c;
        mGraphicOverlay = overlay;
        mVinDetectorListener = listener;
    }

    @Override
    public void release() {
        mGraphicOverlay.clear();
    }

    @Override
    public void receiveDetections(Detector.Detections<Barcode> detections) {
        SparseArray<Barcode> items = detections.getDetectedItems();
        Log.d("Processor", "items " + items);
        for (int i = 0; i < items.size(); ++i) {
            Barcode item = items.valueAt(i);
            if (item != null && item.rawValue != null) {
                String candidate = item.rawValue;
                Log.d("Processor", "candidate " + candidate);
                if (candidate.length() == VIN.VIN_NUMBER_LENGTH + 1) {
                    candidate = candidate.substring(1);
                }
                if (candidate.length() == VIN.VIN_NUMBER_LENGTH) {
                    String vin = candidate.toUpperCase();
                    Log.d("Processor", "vin " + vin);
                    Snackbar.make(mGraphicOverlay, mContext.getString(R.string.detect_vin) +
                                    " " + vin,
                            Snackbar.LENGTH_INDEFINITE)
                            .show();
                    if (VIN.validate(vin)) {
                        OcrGraphic graphic = new OcrGraphic(mGraphicOverlay, null);
                        mGraphicOverlay.add(graphic);
                        if (mVinDetectorListener != null)
                            mVinDetectorListener.onVinDetected(candidate);
                    }
                }
            }
        }
    }
}
