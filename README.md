# Vehicle Search

    This a an android app to search for vehicle information based on vin number.

# Description

    This is an demo android app to scan for vehicle identification number (VIN) via
    barcode scanner (code 39) or optical character reader (OCR), display specs and 
    vehcile information provided by NHTSA, obtain vehicle photos provided by
    Edmunds.com, obtain the current zip code via Google Location API, list all the
    near by auto dealers provided by Edmunds.com, and show a map of all dealers
    location with markers provided by Google Map API.

# Requirements

    Android studio 2.3
    Android SDK build tools 25.0.2
    Android device with min SDK 25, GPS Sensor, Camera
    Gradle 3.3 

# Dependencies and external libraries

    Android Support Libraries 25.3.1
    Google Play Service Location 10.2.1
    Google Play Service Vision 10.2.1
    Google Play Service Map 10.2.1
    Square Up OKHTTP3 3.6.0
    Square UP Retrofit2 2.2.0
    Square Up Picasso 2.5.2
    Google Code GSON 2.7
    Apache Commons lang2 3.5

# Data set API

    NHTSA API- https://vpic.nhtsa.dot.gov/api/
    Edmunds APIs - http://developer.edmunds.com/
    Google Maps APIs - https://developers.google.com/maps/

# Get and replace your own API Keys

    google_maps_key - https://developers.google.com/maps/documentation/android-api/signup
    edmunds_api_key - http://edmunds.mashery.com/apps/mykeys

# Builds instructions

    ./gradlew build

# Install instructions

    ./gradlew installDebug

# Run instructions

    adb shell am start cameraswitch.vehiclesearch/.MainActivity

# How to use the app

    Press the OCR or BarCode icon to start the camera to scan for VIN number.
    It use the navigation bar on the left side to see the information on
    Specs, Photos, Dealers, Maps.

# Techical feature

    VIN numbers will be validated via algorithms provided by 
        https://en.wikipedia.org/wiki/Vehicle_identification_number

    
# Other references

    JSON interface generator
        http://www.jsonschema2pojo.org/
    Google Mobile Vision Text API for Android
        https://codelabs.developers.google.com/codelabs/mobile-vision-ocr/#0
    Google Maps APIs
        https://developers.google.com/maps/documentation/android-api/map-with-marker
