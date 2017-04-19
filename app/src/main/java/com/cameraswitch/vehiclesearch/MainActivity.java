package com.cameraswitch.vehiclesearch;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.os.Parcelable;
import android.speech.RecognizerIntent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.cameraswitch.vehiclesearch.endpoints.nhtsa.DecodedVin;
import com.cameraswitch.vehiclesearch.endpoints.nhtsa.NHTSA;
import com.cameraswitch.vehiclesearch.endpoints.nhtsa.Result;
import com.cameraswitch.vehiclesearch.scanners.OCRActivity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    private static final String TAG = MainActivity.class.getSimpleName();
    private static String mVIN = Const.DEFAULT_VIN;
    private NHTSA mNHTSA;

    private FloatingActionButton mFabOCR;
    private FloatingActionButton mFabBarcode;
    private TextView mTitleView;
    private TextView mDescriptionView;
    private Parcelable mDecodedVin;
    private String mYear = "";
    private String mModel = "";
    private String mMake = "";
    private String mZipCode = Const.DEFAULT_ZIP_CODE;

    private GoogleApiClient mGoogleApiClient;
    private Location mLastLocation;
    private double mLatitude;
    private double mLongitdue;
    private NavigationView mNavigationView;
    private Fragment mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mFabOCR = (FloatingActionButton) findViewById(R.id.fab_camera);
        mFabOCR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), OCRActivity.class);
                i.putExtra(Const.DETECTOR_TYPE, Const.OCR_DETECTOR);
                startActivityForResult(i, Const.REQ_CODE_OCR_INPUT);
            }
        });

        mFabBarcode = (FloatingActionButton) findViewById(R.id.fab_mic);
        mFabBarcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), OCRActivity.class);
                i.putExtra(Const.DETECTOR_TYPE, Const.BARCODE_DETECTOR);
                startActivityForResult(i, Const.REQ_CODE_OCR_INPUT);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        mNavigationView = (NavigationView) findViewById(R.id.nav_view);
        mNavigationView.setNavigationItemSelectedListener(this);

        View layout = mNavigationView.getHeaderView(0);
        mTitleView = (TextView) layout.findViewById(R.id.title_view);
        mDescriptionView = (TextView) layout.findViewById(R.id.description_view);

        mVIN = Helper.getVin(getBaseContext());
        Log.d(TAG, " mVIN = " + mVIN);
        mTitleView.setText(mVIN);
        decodeVin(mVIN);

        if (mGoogleApiClient == null) {
            mGoogleApiClient = new GoogleApiClient.Builder(this)
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .addApi(LocationServices.API)
                    .build();
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    protected void onStart() {
        mGoogleApiClient.connect();
        super.onStart();
    }

    protected void onStop() {
        super.onStop();
        if (mGoogleApiClient.isConnected()) {
            mGoogleApiClient.disconnect();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case Const.REQ_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null != data) {
                    ArrayList<String> result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    String query = result.get(0);
                }
                break;
            }
            case Const.REQ_CODE_OCR_INPUT: {
                if (resultCode == RESULT_OK && null != data) {
                    ArrayList<String> result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    mVIN = result.get(0);
                    Log.d(TAG, "VIN = " + mVIN);
                    Helper.saveVin(getBaseContext(), mVIN);
                    decodeVin(mVIN);
                    mTitleView.setText(mVIN);
                }
                break;
            }
        }
    }

    private void decodeVin(String vin) {
        mNHTSA = NHTSA.getInstance(getBaseContext());
        mNHTSA.decodeVin(vin, mOnDecodedListener);
    }

    private NHTSA.OnDecodedListener mOnDecodedListener = new NHTSA.OnDecodedListener() {
        @Override
        public void onDecoded(DecodedVin response) {
            mDecodedVin = response;
            int count = response.getResults().size();
            for (int i = 0; i < count; i++) {
                Result r = response.getResults().get(i);
                String d = r.getVariable();
                if (d.equalsIgnoreCase(Const.MODEL)) {
                    mModel = (String) r.getValue();
                }
                if (d.equalsIgnoreCase(Const.MAKE)) {
                    mMake = (String) r.getValue();
                }
                if (d.equalsIgnoreCase(Const.MODEL_YEAR)) {
                    mYear = (String) r.getValue();
                }
            }
            String desc = mYear + " " + mMake + " " + mModel;
            mDescriptionView.setText(desc);
            onNavigationItemSelected(mNavigationView.getMenu().findItem(R.id.nav_specs));
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        if (mFragment != null) {
            View v = mFragment.getView();
            ViewPager vp = (ViewPager) v.findViewById(R.id.view_pager);
            if (vp != null && vp.getVisibility() == View.VISIBLE)
                getMenuInflater().inflate(R.menu.grid_action_bar, menu);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_grid) {
            if (mFragment != null) {
                View v = mFragment.getView();
                RecyclerView rv = (RecyclerView) v.findViewById(R.id.recycler_view);
                if (rv != null)
                    rv.setVisibility(View.VISIBLE);
                ViewPager vp = (ViewPager) v.findViewById(R.id.view_pager);
                if (vp != null)
                    vp.setVisibility(View.GONE);
            }
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        mFragment = null;
        Bundle bundle = new Bundle();

        if (id == R.id.nav_specs) {
            mFragment = new DecodeVinFragment();
            bundle.putParcelable(Const.DECODED_VIN, mDecodedVin);
        } else if (id == R.id.nav_gallery) {
            mFragment = new GalleryFragment();
            bundle.putString(Const.MODEL_YEAR, mYear);
            bundle.putString(Const.MAKE, mMake);
            bundle.putString(Const.MODEL, mModel);
        } else if (id == R.id.nav_dealers) {
            mFragment = new DealersFragment();
            bundle.putString(Const.MODEL_YEAR, mYear);
            bundle.putString(Const.MAKE, mMake);
            bundle.putString(Const.MODEL, mModel);
            bundle.putString(Const.ZIP_CODE, mZipCode);
        } else if (id == R.id.nav_map) {
            mFragment = new MapFragment();
            bundle.putString(Const.MAKE, mMake);
            bundle.putString(Const.ZIP_CODE, mZipCode);
        } else if (id == R.id.nav_inventory) {
            mFragment = new InventoryFragment();
            bundle.putString(Const.MODEL_YEAR, mYear);
            bundle.putString(Const.MAKE, mMake);
            bundle.putString(Const.MODEL, mModel);
            bundle.putString(Const.ZIP_CODE, mZipCode);
        }

        if (mFragment != null) {
            mFragment.setArguments(bundle);
            // Insert the fragment by replacing any existing fragment
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.frame_layout, mFragment).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onConnected(Bundle connectionHint) {
        Log.d(TAG, " onConnected()  connectionHint=" + connectionHint);
        if (!Helper.checkPermission(this)) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,
                                 Manifest.permission.ACCESS_FINE_LOCATION},
                    Const.REQ_CODE_LOCATION_ACCESS);
            return;
        }
        mLastLocation = LocationServices.FusedLocationApi.getLastLocation(
                mGoogleApiClient);
        if (mLastLocation != null) {
            mLatitude = mLastLocation.getLatitude();
            mLongitdue = mLastLocation.getLongitude();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    List<Address> addresses = null;
                    while (addresses == null) {
                        try {
                            Geocoder geocoder = new Geocoder(getBaseContext(), Locale.getDefault());
                            addresses = geocoder.getFromLocation(mLatitude, mLongitdue, 1);
                            for(Address address : addresses) {
                                String zip = address.getPostalCode();
                                Log.d(TAG, "address=" + addresses);
                                if (zip != null) {
                                    mZipCode = zip;
                                    Log.d(TAG, "lat=" + mLatitude + " log=" +
                                            mLongitdue + " zipcode=" + mZipCode);
                                    break;
                                }
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        } else {
            Toast.makeText(this, R.string.location_error, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onConnectionSuspended(int i) {
        // The connection to Google Play services was lost for some reason. We call connect() to
        // attempt to re-establish the connection.
        Log.i(TAG, "Connection suspended");
        mGoogleApiClient.connect();
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult result) {
        Log.i(TAG, "Connection failed: ConnectionResult.getErrorCode() = " + result.getErrorCode());
    }

    public double getLatitude() {
        return mLatitude;
    }

    public double getLongitude() {
        return mLongitdue;
    }
}
