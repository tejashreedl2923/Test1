package com.example.autocare

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import androidx.fragment.app.Fragment

class ServiceOptionsFragment : Fragment() {

    private var vehicleNumber = ""
    private var vehicleModel = ""
    private var fuelType = ""
    private var serviceType = ""
    private var pickupStatus = ""

    companion object {

        fun newInstance(
            vehicleNumber: String,
            vehicleModel: String,
            fuelType: String,
            serviceType: String,
            pickupStatus: String
        ): ServiceOptionsFragment {

            val fragment =
                ServiceOptionsFragment()

            val bundle = Bundle()

            bundle.putString(
                "vehicleNumber",
                vehicleNumber
            )

            bundle.putString(
                "vehicleModel",
                vehicleModel
            )

            bundle.putString(
                "fuelType",
                fuelType
            )

            bundle.putString(
                "serviceType",
                serviceType
            )

            bundle.putString(
                "pickupStatus",
                pickupStatus
            )

            fragment.arguments = bundle

            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {

            vehicleNumber =
                it.getString("vehicleNumber", "")

            vehicleModel =
                it.getString("vehicleModel", "")

            fuelType =
                it.getString("fuelType", "")

            serviceType =
                it.getString("serviceType", "")

            pickupStatus =
                it.getString("pickupStatus", "")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(
            R.layout.fragment_service_options,
            container,
            false
        )
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {

        super.onViewCreated(
            view,
            savedInstanceState
        )

        val cbInspection =
            view.findViewById<CheckBox>(
                R.id.cbInspection
            )

        val cbWheel =
            view.findViewById<CheckBox>(
                R.id.cbWheel
            )

        val cbInterior =
            view.findViewById<CheckBox>(
                R.id.cbInterior
            )

        val btnConfirm =
            view.findViewById<Button>(
                R.id.btnConfirmService
            )

        btnConfirm.setOnClickListener {

            var selectedServices = ""

            if (cbInspection.isChecked) {

                selectedServices +=
                    "Vehicle Inspection\n"
            }

            if (cbWheel.isChecked) {

                selectedServices +=
                    "Wheel Alignment Check\n"
            }

            if (cbInterior.isChecked) {

                selectedServices +=
                    "Interior Cleaning\n"
            }

            if (selectedServices.isEmpty()) {

                selectedServices =
                    "No additional services"
            }

            // Create Intent
            val intent =
                Intent(
                    requireContext(),
                    ServiceSummaryActivity::class.java
                )

            // Send data through Intent
            intent.putExtra(
                "vehicleNumber",
                vehicleNumber
            )

            intent.putExtra(
                "vehicleModel",
                vehicleModel
            )

            intent.putExtra(
                "fuelType",
                fuelType
            )

            intent.putExtra(
                "serviceType",
                serviceType
            )

            intent.putExtra(
                "pickupStatus",
                pickupStatus
            )

            intent.putExtra(
                "additionalServices",
                selectedServices
            )

            // Open Summary Activity
            startActivity(intent)
        }
    }
}