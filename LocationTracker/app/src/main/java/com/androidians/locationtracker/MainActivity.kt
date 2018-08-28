package com.androidians.locationtracker

import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v4.app.ActivityCompat
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG

class MainActivity : AppCompatActivity() {

    private var TAG: String = "MainActivity"
    private var locationManager : LocationManager ? = null
    private val toast by lazy { Toast.makeText(this, "", LENGTH_LONG) }
    private val REQUEST_CODE_PERMISSION_GRANTED : Int = 101

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (!isPermissionGranted()) {
            val permissions = arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION)
            ActivityCompat.requestPermissions(this, permissions, REQUEST_CODE_PERMISSION_GRANTED)
        } else {
            init()
        }
    }

    private fun isPermissionGranted() : Boolean {
        if (ActivityCompat
                        .checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) !=
                        PackageManager.PERMISSION_GRANTED) {
            return false;
        }

        return true;
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (REQUEST_CODE_PERMISSION_GRANTED == requestCode) {
            init();
        } else {
            toast.setText("In order for proper functioning, permission required")
        }
    }

    private fun init() {
        locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager?
        try {
            locationManager?.requestLocationUpdates(LocationManager.GPS_PROVIDER, 2000L, 0f, locationListener)
        } catch (e : SecurityException) {
            Log.e(TAG, "error while requesting location updates", e);
        }
    }

    val locationListener : LocationListener = object : LocationListener {

        override fun onLocationChanged(location : Location?) {
            toast.setText("Latitude: "+location?.latitude+ " Longitude: "+location?.latitude)
            Log.e(TAG, "Latitude: "+location?.latitude+ " Longitude: "+location?.latitude)
        }

        override fun onStatusChanged(p0: String?, p1: Int, p2: Bundle?) {
        }

        override fun onProviderEnabled(p0: String?) {
        }

        override fun onProviderDisabled(p0: String?) {
        }

    }

}


