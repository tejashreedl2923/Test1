package com.example.autocare

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class ServiceSummaryActivity : AppCompatActivity() {

    private val channelId = "autocare_channel"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_service_summary)

        val tvVehicleNumber =
            findViewById<TextView>(R.id.tvVehicleNumber)

        val tvVehicleModel =
            findViewById<TextView>(R.id.tvVehicleModel)

        val tvFuelType =
            findViewById<TextView>(R.id.tvFuelType)

        val tvServiceType =
            findViewById<TextView>(R.id.tvServiceType)

        val tvPickupStatus =
            findViewById<TextView>(R.id.tvPickupStatus)

        val tvAdditionalServices =
            findViewById<TextView>(R.id.tvAdditionalServices)

        val btnBack =
            findViewById<Button>(R.id.btnBack)

        // Receive data from Intent

        val vehicleNumber =
            intent.getStringExtra("vehicleNumber")

        val vehicleModel =
            intent.getStringExtra("vehicleModel")

        val fuelType =
            intent.getStringExtra("fuelType")

        val serviceType =
            intent.getStringExtra("serviceType")

        val pickupStatus =
            intent.getStringExtra("pickupStatus")

        val additionalServices =
            intent.getStringExtra("additionalServices")

        // Display data

        tvVehicleNumber.text =
            "Vehicle Number: $vehicleNumber"

        tvVehicleModel.text =
            "Vehicle Model: $vehicleModel"

        tvFuelType.text =
            "Selected Fuel Type: $fuelType"

        tvServiceType.text =
            "Service Type: $serviceType"

        tvPickupStatus.text =
            "Pickup Status: $pickupStatus"

        tvAdditionalServices.text =
            "Additional Services:\n$additionalServices"

        // Create notification channel
        createNotificationChannel()

// Request notification permission for Android 13+
        if (Build.VERSION.SDK_INT >= 33) {

            if (
                ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.POST_NOTIFICATIONS
                ) != PackageManager.PERMISSION_GRANTED
            ) {

                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.POST_NOTIFICATIONS),
                    100
                )

            } else {

                showBookingNotification()
            }

        } else {

            showBookingNotification()
        }

        btnBack.setOnClickListener {
            finish()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(
            requestCode,
            permissions,
            grantResults
        )

        if (requestCode == 100) {

            if (
                grantResults.isNotEmpty() &&
                grantResults[0] == PackageManager.PERMISSION_GRANTED
            ) {

                showBookingNotification()

            }
        }
    }

    private fun createNotificationChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            val channel = NotificationChannel(
                channelId,
                "AutoCare Notifications",
                NotificationManager.IMPORTANCE_DEFAULT
            )

            channel.description =
                "Notifications for vehicle service bookings"

            val notificationManager =
                getSystemService(
                    NotificationManager::class.java
                )

            notificationManager.createNotificationChannel(
                channel
            )
        }
    }

    private fun showBookingNotification() {

        val builder =
            NotificationCompat.Builder(
                this,
                channelId
            )
                .setSmallIcon(
                    android.R.drawable.ic_dialog_info
                )
                .setContentTitle(
                    "AutoCare"
                )
                .setContentText(
                    "Vehicle service appointment has been created."
                )
                .setPriority(
                    NotificationCompat.PRIORITY_DEFAULT
                )
                .setAutoCancel(true)

        if (
            Build.VERSION.SDK_INT < 33 ||
            ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.POST_NOTIFICATIONS
            ) == PackageManager.PERMISSION_GRANTED
        ) {

            NotificationManagerCompat
                .from(this)
                .notify(
                    1001,
                    builder.build()
                )
        }
    }
}