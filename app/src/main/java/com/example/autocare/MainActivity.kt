package com.example.autocare

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val TAG = "AutoCareLifecycle"

    private lateinit var etVehicleNumber: EditText
    private lateinit var etVehicleModel: EditText
    private lateinit var rgFuel: RadioGroup
    private lateinit var rgService: RadioGroup
    private lateinit var togglePickup: ToggleButton
    private lateinit var btnBookService: Button


    // ---------------------------------------------------------
    // Activity Lifecycle
    // ---------------------------------------------------------

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d(TAG, "onCreate() called")

        setContentView(R.layout.activity_main)

        // Find views
        etVehicleNumber =
            findViewById(R.id.etVehicleNumber)

        etVehicleModel =
            findViewById(R.id.etVehicleModel)

        rgFuel =
            findViewById(R.id.rgFuel)

        rgService =
            findViewById(R.id.rgService)

        togglePickup =
            findViewById(R.id.togglePickup)

        btnBookService =
            findViewById(R.id.btnBookService)


        // Book Service button
        btnBookService.setOnClickListener {

            val vehicleNumber =
                etVehicleNumber.text.toString().trim()

            val vehicleModel =
                etVehicleModel.text.toString().trim()


            // Validate vehicle details
            if (vehicleNumber.isEmpty() ||
                vehicleModel.isEmpty()
            ) {

                Toast.makeText(
                    this,
                    "Please enter vehicle details",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }


            // Validate fuel and service selection
            if (rgFuel.checkedRadioButtonId == -1 ||
                rgService.checkedRadioButtonId == -1
            ) {

                Toast.makeText(
                    this,
                    "Please select fuel and service type",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }


            // Get selected fuel type
            val fuelType =
                when (rgFuel.checkedRadioButtonId) {

                    R.id.rbPetrol ->
                        "Petrol"

                    R.id.rbDiesel ->
                        "Diesel"

                    R.id.rbElectric ->
                        "Electric"

                    else ->
                        ""
                }


            // Get selected service type
            val serviceType =
                when (rgService.checkedRadioButtonId) {

                    R.id.rbGeneral ->
                        "General Service"

                    R.id.rbOil ->
                        "Oil Change"

                    R.id.rbFull ->
                        "Full Service"

                    else ->
                        ""
                }


            // Get pickup status
            val pickupStatus =
                if (togglePickup.isChecked) {

                    "Required"

                } else {

                    "Not Required"
                }


            // Open Service Options Fragment
            openServiceOptions(
                vehicleNumber,
                vehicleModel,
                fuelType,
                serviceType,
                pickupStatus
            )
        }
    }


    // ---------------------------------------------------------
    // Open Service Options Fragment
    // ---------------------------------------------------------

    private fun openServiceOptions(
        vehicleNumber: String,
        vehicleModel: String,
        fuelType: String,
        serviceType: String,
        pickupStatus: String
    ) {

        val fragment =
            ServiceOptionsFragment.newInstance(
                vehicleNumber,
                vehicleModel,
                fuelType,
                serviceType,
                pickupStatus
            )

        supportFragmentManager
            .beginTransaction()
            .replace(
                R.id.fragmentContainer,
                fragment
            )
            .addToBackStack(null)
            .commit()
    }


    // ---------------------------------------------------------
    // Lifecycle: Activity becomes visible
    // ---------------------------------------------------------

    override fun onStart() {
        super.onStart()

        Log.d(
            TAG,
            "onStart() called"
        )
    }


    // ---------------------------------------------------------
    // Lifecycle: Activity becomes interactive
    // ---------------------------------------------------------

    override fun onResume() {
        super.onResume()

        Log.d(
            TAG,
            "onResume() called"
        )
    }


    // ---------------------------------------------------------
    // Lifecycle: Activity is partially leaving foreground
    // ---------------------------------------------------------

    override fun onPause() {
        super.onPause()

        Log.d(
            TAG,
            "onPause() called"
        )
    }


    // ---------------------------------------------------------
    // Lifecycle: Activity is no longer visible
    // ---------------------------------------------------------

    override fun onStop() {
        super.onStop()

        Log.d(
            TAG,
            "onStop() called"
        )
    }


    // ---------------------------------------------------------
    // Lifecycle: Activity is being destroyed
    // ---------------------------------------------------------

    override fun onDestroy() {
        super.onDestroy()

        Log.d(
            TAG,
            "onDestroy() called"
        )
    }
}