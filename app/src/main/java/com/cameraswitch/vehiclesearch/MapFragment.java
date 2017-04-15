package com.cameraswitch.vehiclesearch;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.cameraswitch.vehiclesearch.endpoints.edmunds.Edmunds;
import com.cameraswitch.vehiclesearch.endpoints.edmunds.dealers.Address;
import com.cameraswitch.vehiclesearch.endpoints.edmunds.dealers.Dealer;
import com.cameraswitch.vehiclesearch.endpoints.edmunds.dealers.Dealers;

import static com.cameraswitch.vehiclesearch.Const.MAKE;
import static com.cameraswitch.vehiclesearch.Const.ZIP_CODE;

public class MapFragment extends Fragment implements
        OnMapReadyCallback, GoogleMap.OnMarkerClickListener {
    private String mZipCode;
    private MapView mMapView;
    private GoogleMap mGoogleMap;
    private Edmunds mEdmunds;
    private String mMake;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.map_fragment, container, false);
        mZipCode = getArguments().getString(ZIP_CODE);
        mMake = getArguments().getString(MAKE);

        mMapView = (MapView) rootView.findViewById(R.id.mapView);
        mMapView.onCreate(savedInstanceState);
        mMapView.onResume(); // needed to get the map to display immediately

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        mMapView.getMapAsync(this);
        mEdmunds = Edmunds.getInstance(getContext());
        return rootView;
    }

    public Edmunds.OnDealersListener mOnDealerListener = new Edmunds.OnDealersListener() {
        @Override
        public void onDealersReady(Dealers dealers) {
            for (Dealer d : dealers.getDealers()) {
                Address address = d.getAddress();
                String fullAddress =
                        address.getStreet() + ", " +
                                address.getCity() + ", " +
                                address.getStateCode() + " " +
                                address.getZipcode();
                LatLng dealer = new LatLng(address.getLatitude(), address.getLongitude());
                mGoogleMap.addMarker(new MarkerOptions()
                        .position(dealer)
                        .title(d.getName())
                        .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_dealer_marker))
                        .snippet(fullAddress));
                mGoogleMap.setOnMarkerClickListener(MapFragment.this);
            }
        }
    };

    @Override
    public boolean onMarkerClick(Marker marker) {
        String address = marker.getSnippet();
        Intent i = new Intent(android.content.Intent.ACTION_VIEW,
                Uri.parse("google.navigation:q=" + address));
        getContext().startActivity(i);
        return false;
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        if (!Helper.checkPermission(getContext())) {
            ActivityCompat.requestPermissions(getActivity(),
                    new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,
                            Manifest.permission.ACCESS_FINE_LOCATION},
                    Const.REQ_CODE_LOCATION_ACCESS);
        }
        mGoogleMap = googleMap;

        if (mMake != null && mZipCode != null) {
            // TODO: paging the next 20 items
            mEdmunds.getDealers(mZipCode, mMake, 1, 20, mOnDealerListener);
        }
        // For showing a move to my location button
        mGoogleMap.setMyLocationEnabled(true);

        MainActivity activity = (MainActivity) getActivity();
        LatLng latLng = new LatLng(activity.getLatitude(), activity.getLongitude());
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(latLng, 9);
        mGoogleMap.animateCamera(cameraUpdate);
    }
}
