/*
 * Copyright (C) The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.cameraswitch.vehiclesearch.scanners;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.util.SparseArray;

import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.text.TextBlock;
import com.cameraswitch.vehiclesearch.R;

import java.util.ArrayList;

/**
 * A very simple Processor which gets detected TextBlocks and adds them to the overlay
 * as OcrGraphics.
 * TODO: Make this implement Detector.Processor<TextBlock> and add text to the GraphicOverlay
 */
public class OcrDetectorProcessor implements Detector.Processor<TextBlock> {

    private final OCRActivity.VinDetectorListener mVinDetectorListener;
    private GraphicOverlay<OcrGraphic> mGraphicOverlay;
    private Context mContext;

    OcrDetectorProcessor(Context c, GraphicOverlay<OcrGraphic> ocrGraphicOverlay, OCRActivity.VinDetectorListener listener) {
        mContext = c;
        mGraphicOverlay = ocrGraphicOverlay;
        mVinDetectorListener = listener;
    }

    // TODO:  Once this implements Detector.Processor<TextBlock>, implement the abstract methods.


    @Override
    public void receiveDetections(Detector.Detections<TextBlock> detections) {
        mGraphicOverlay.clear();
        SparseArray<TextBlock> items = detections.getDetectedItems();
        for (int i = 0; i < items.size(); ++i) {
            TextBlock item = items.valueAt(i);
            if (item != null && item.getValue() != null) {
                String candidate = item.getValue().replace(" ", "");
                if (candidate.length() == VIN.VIN_NUMBER_LENGTH) {
                    String vin = candidate.toUpperCase();
                    vin = vin.replace("I", "1");
                    vin = vin.replace("O", "0");
                    vin = vin.replace("Q", "0");
                    Log.d("Processor", "vin " + vin);
                    Snackbar.make(mGraphicOverlay, mContext.getString(R.string.detect_vin) +
                            " " + vin,
                            Snackbar.LENGTH_INDEFINITE)
                            .show();
                    /*
                    String v = vin;
                    if (VIN.validate(v)) {
                        OcrGraphic graphic = new OcrGraphic(mGraphicOverlay, item);
                        mGraphicOverlay.add(graphic);
                        if (mVinDetectorListener != null)
                            mVinDetectorListener.onVinDetected(v);
                    }//*/
                    ArrayList<String> possibleVin = VIN.getAllPossibleVIN(vin);
                    for (String v : possibleVin) {
                        Log.d("Processor", "v " + v);
                        if (VIN.validate(v)) {
                            OcrGraphic graphic = new OcrGraphic(mGraphicOverlay, item);
                            mGraphicOverlay.add(graphic);
                            if (mVinDetectorListener != null) {
                                mVinDetectorListener.onVinDetected(v);
                                break;
                            }
                        }
                    }//*/
                }
            }
        }
    }

    @Override
    public void release() {
        mGraphicOverlay.clear();
    }

}