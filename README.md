# AutoCare

## Vehicle Service Management Android Application

AutoCare is an Android application developed using Kotlin and Android Studio for managing vehicle service bookings.

The application allows users to enter their vehicle details, select a fuel type and service type, choose whether vehicle pickup is required, select additional services, and confirm a service appointment.

After confirmation, the application displays a complete service summary and generates a booking confirmation notification.

The project demonstrates important Android development concepts including Activities, Fragments, Intents, Bundles, UI components, Input Validation, Notifications, and Activity Lifecycle management.

---

## Aim

To develop an Android-based vehicle service management application that allows users to conveniently book vehicle servicing while demonstrating fundamental Android application development concepts.

---

## Objectives

- To create a user-friendly vehicle service booking application.
- To collect vehicle information from the user.
- To provide different fuel type options.
- To provide different vehicle service options.
- To allow users to request vehicle pickup.
- To provide additional service options.
- To transfer booking information between Android components.
- To display a complete service summary.
- To generate a booking confirmation notification.
- To demonstrate Activity Lifecycle callbacks using Logcat.

---

## Features

- Vehicle registration number input
- Vehicle model input
- Fuel type selection
- Service type selection
- Pickup requirement selection
- Additional service selection
- Input validation
- Fragment-based additional service selection
- Intent-based data transfer
- Service booking summary
- Booking confirmation notification
- Activity lifecycle demonstration
- Logcat lifecycle monitoring
- Professional user interface
- Custom car vector icon for AutoCare branding

---

## Fuel Types

The application provides the following fuel type options:

- Petrol
- Diesel
- Electric

---

## Service Types

The application provides the following service options:

- General Service
- Oil Change
- Full Service

---

## Additional Services

Users can select additional services from the Service Options Fragment:

- Vehicle Inspection
- Wheel Alignment Check
- Interior Cleaning

Users can select one or more additional services.

---

## Technologies Used

| Technology | Purpose |
|---|---|
| Kotlin | Application programming |
| Android Studio | Development environment |
| XML | User interface design |
| Android SDK | Android application development |
| AndroidX | Android support libraries |
| Activities | Application screens |
| Fragments | Modular user interface |
| Intent | Communication and data transfer |
| Bundle | Passing data to Fragment |
| Notification API | Booking confirmation notification |
| Logcat | Activity lifecycle monitoring |

---

## Project Structure

    AutoCare/
    |
    +-- app/
    |   |
    |   +-- src/
    |       |
    |       +-- main/
    |           |
    |           +-- java/com/example/autocare/
    |           |   |
    |           |   +-- MainActivity.kt
    |           |   +-- ServiceOptionsFragment.kt
    |           |   +-- ServiceSummaryActivity.kt
    |           |
    |           +-- res/
    |           |   |
    |           |   +-- drawable/
    |           |   |   +-- ic_car.xml
    |           |   |
    |           |   +-- layout/
    |           |       +-- activity_main.xml
    |           |       +-- fragment_service_options.xml
    |           |       +-- activity_service_summary.xml
    |           |
    |           +-- AndroidManifest.xml
    |
    +-- README.md

---

## Application Workflow

    START
      |
      v
    Main Activity
      |
      +-- Enter Vehicle Number
      |
      +-- Enter Vehicle Model
      |
      +-- Select Fuel Type
      |
      +-- Select Service Type
      |
      +-- Select Pickup Requirement
      |
      v
    Book Service
      |
      v
    Service Options Fragment
      |
      +-- Vehicle Inspection
      |
      +-- Wheel Alignment Check
      |
      +-- Interior Cleaning
      |
      v
    Confirm Service
      |
      v
    Service Summary Activity
      |
      +-- Display Booking Details
      |
      +-- Generate Notification
      |
      v
    Booking Completed

---

## Main Activity

`MainActivity` is the starting screen of the AutoCare application.

The user enters the following information:

- Vehicle registration number
- Vehicle model
- Fuel type
- Service type
- Pickup requirement

The application validates the required fields before allowing the user to continue.

### UI Components

The Main Activity uses:

- TextView
- EditText
- RadioGroup
- RadioButton
- ToggleButton
- Button
- FrameLayout
- ScrollView
- LinearLayout
- ImageView

The Book Service button opens the `ServiceOptionsFragment`.

---

## Service Options Fragment

`ServiceOptionsFragment` is used to display additional service options.

The Fragment contains CheckBoxes for:

- Vehicle Inspection
- Wheel Alignment Check
- Interior Cleaning

The user can select one or more additional services.

The Fragment receives the booking information from `MainActivity` through a Bundle.

After the user clicks the Confirm Service button, the application starts `ServiceSummaryActivity` using an Intent.

---

## Service Summary Activity

`ServiceSummaryActivity` displays the complete booking information.

The following information is displayed:

- Vehicle Number
- Vehicle Model
- Selected Fuel Type
- Service Type
- Pickup Status
- Additional Services

The Summary Activity also displays a booking confirmation message.

The user can return to the AutoCare application using the Back to AutoCare button.

---

## Intent Data Passing

The application uses an Intent to transfer booking information from the Service Options Fragment to the Service Summary Activity.

The following data is passed:

    vehicleNumber
    vehicleModel
    fuelType
    serviceType
    pickupStatus
    additionalServices

Example:

    intent.putExtra(
        "vehicleNumber",
        vehicleNumber
    )

The data is retrieved in `ServiceSummaryActivity` using:

    intent.getStringExtra("vehicleNumber")

This demonstrates data communication between Android components using Intent extras.

---

## Fragment Data Passing

The booking information is passed from `MainActivity` to `ServiceOptionsFragment`.

A Bundle is used to store the information.

Example:

    bundle.putString(
        "vehicleNumber",
        vehicleNumber
    )

The Fragment retrieves the information from its arguments.

This demonstrates communication between an Activity and a Fragment.

---

## Notification

After confirming the vehicle service booking, the application generates a notification.

The notification channel is:

    AutoCare Notifications

The notification displays:

    Title:
    AutoCare

    Message:
    Vehicle service appointment has been created.

For Android 13 and later, the application requests notification permission from the user.

The required permission is declared in `AndroidManifest.xml`:

    <uses-permission android:name="android.permission.POST_NOTIFICATIONS" />

The application checks whether notification permission has been granted before displaying the notification.

---

## Activity Lifecycle

The project demonstrates the Android Activity Lifecycle using Logcat.

The lifecycle methods implemented in `MainActivity` are:

- `onCreate()`
- `onStart()`
- `onResume()`
- `onPause()`
- `onStop()`
- `onDestroy()`

The general lifecycle sequence is:

    onCreate()
        |
        v
    onStart()
        |
        v
    onResume()
        |
        v
    Activity Running
        |
        v
    onPause()
        |
        v
    onStop()
        |
        v
    onDestroy()

Lifecycle events are logged using the following Logcat tag:

    AutoCareLifecycle

Example Logcat output:

    D/AutoCareLifecycle: onCreate() called
    D/AutoCareLifecycle: onStart() called
    D/AutoCareLifecycle: onResume() called
    D/AutoCareLifecycle: onPause() called
    D/AutoCareLifecycle: onStop() called
    D/AutoCareLifecycle: onDestroy() called

To observe the lifecycle events:

1. Run the application.
2. Open Logcat in Android Studio.
3. Search for `AutoCareLifecycle`.

The lifecycle callbacks can be observed when the application is started, moved to the background, returned to the foreground, or destroyed.

---

## Input Validation

The application performs input validation before opening the Service Options Fragment.

The following conditions are checked:

1. Vehicle number must not be empty.
2. Vehicle model must not be empty.
3. Fuel type must be selected.
4. Service type must be selected.

If vehicle details are missing, the application displays:

    Please enter vehicle details

If fuel or service type is not selected, the application displays:

    Please select fuel and service type

This prevents incomplete booking information from being submitted.

---

## User Interface

The application uses a consistent blue and white theme.

The main screen contains:

- AutoCare branding
- Car vector icon
- Vehicle details section
- Fuel selection
- Service selection
- Pickup selection
- Book Service button

The Service Options Fragment contains:

- Additional service heading
- Additional service description
- CheckBoxes
- Confirm Service button

The Service Summary Activity contains:

- Booking confirmation header
- Vehicle details card
- Service details card
- Additional service information
- Back to AutoCare button

A vector car icon is used instead of an emoji for the AutoCare branding.

The vector icon is stored as:

    res/drawable/ic_car.xml

---

## Testing

| Test Case | Input or Action | Expected Result |
|---|---|---|
| 1 | Enter a valid vehicle number | Vehicle number is accepted |
| 2 | Enter a valid vehicle model | Vehicle model is accepted |
| 3 | Leave vehicle number empty | Validation message is displayed |
| 4 | Leave vehicle model empty | Validation message is displayed |
| 5 | Select Petrol | Petrol is selected |
| 6 | Select Diesel | Diesel is selected |
| 7 | Select Electric | Electric is selected |
| 8 | Select General Service | General Service is selected |
| 9 | Select Oil Change | Oil Change is selected |
| 10 | Select Full Service | Full Service is selected |
| 11 | Enable Pickup | Pickup status becomes Required |
| 12 | Disable Pickup | Pickup status becomes Not Required |
| 13 | Click Book Service | Service Options Fragment opens |
| 14 | Select Vehicle Inspection | Service is selected |
| 15 | Select Wheel Alignment Check | Service is selected |
| 16 | Select Interior Cleaning | Service is selected |
| 17 | Click Confirm Service | Summary Activity opens |
| 18 | View Summary | Booking details are displayed |
| 19 | Confirm booking | Notification is generated |
| 20 | Open Logcat | Lifecycle events are displayed |
| 21 | Click Back to AutoCare | Summary Activity closes |

---

## Android Concepts Demonstrated

### Activity

An Activity represents a screen in an Android application.

This project contains:

- `MainActivity`
- `ServiceSummaryActivity`

### Fragment

A Fragment represents a reusable portion of the user interface.

This project uses:

- `ServiceOptionsFragment`

The Fragment is displayed inside the `fragmentContainer` of `MainActivity`.

### Intent

Intent is used to start another Activity and transfer information.

The application uses an Intent to move from:

    ServiceOptionsFragment
            |
            | Intent
            v
    ServiceSummaryActivity

### Bundle

A Bundle is used to store and transfer booking information to the Fragment.

The Fragment receives information such as:

- Vehicle Number
- Vehicle Model
- Fuel Type
- Service Type
- Pickup Status

### RadioGroup and RadioButton

RadioButtons are used when the user needs to select one option from a group.

Fuel type:

- Petrol
- Diesel
- Electric

Service type:

- General Service
- Oil Change
- Full Service

### ToggleButton

The ToggleButton is used to determine whether the user requires vehicle pickup.

Possible states:

- Required
- Not Required

### CheckBox

CheckBoxes allow users to select multiple additional services.

The user can select:

- Vehicle Inspection
- Wheel Alignment Check
- Interior Cleaning

### Notification

The Android Notification API is used to notify the user after the service appointment has been created.

### Logcat

Logcat is used to monitor application events and demonstrate Activity Lifecycle callbacks.

---

## Complete Application Flow

    MainActivity
         |
         | Vehicle and service information
         v
    ServiceOptionsFragment
         |
         | Additional services
         v
    ServiceSummaryActivity
         |
         +----> Booking Summary
         |
         +----> Notification

---

## How to Run the Project

### Step 1: Open the Project

Open the AutoCare project in Android Studio.

### Step 2: Sync Gradle

Allow Android Studio to synchronize the Gradle files and download the required dependencies.

### Step 3: Connect a Device

Connect an Android device using USB debugging or start an Android Emulator.

### Step 4: Run the Application

Click the Run button in Android Studio.

### Step 5: Use the Application

Follow this sequence:

    Enter Vehicle Number
            |
            v
    Enter Vehicle Model
            |
            v
    Select Fuel Type
            |
            v
    Select Service Type
            |
            v
    Select Pickup Requirement
            |
            v
    Click Book Service
            |
            v
    Select Additional Services
            |
            v
    Click Confirm Service
            |
            v
    View Service Summary
            |
            v
    Receive Booking Notification

---

## Requirements

The following software and tools are required:

- Android Studio
- Android SDK
- Kotlin
- Gradle
- Android Emulator or physical Android device
- Internet connection for initial dependency setup

---

## Expected Output

After successfully running the application, the user should be able to:

1. Enter vehicle registration information.
2. Enter the vehicle model.
3. Select the fuel type.
4. Select the required service type.
5. Choose whether vehicle pickup is required.
6. Open the additional service Fragment.
7. Select one or more additional services.
8. Confirm the service booking.
9. View the complete booking summary.
10. Receive a booking confirmation notification.
11. Observe Activity Lifecycle events through Logcat.

---

## Advantages

- Simple and user-friendly interface.
- Provides a complete vehicle service booking workflow.
- Uses input validation to prevent incomplete submissions.
- Demonstrates Activity-to-Fragment communication.
- Demonstrates Fragment-to-Activity communication.
- Uses Intent extras for data transfer.
- Provides booking confirmation through Android notifications.
- Demonstrates Activity Lifecycle management.
- Uses a professional and consistent user interface.
- Uses a custom vector car icon for application branding.

---

## Future Enhancements

The application can be extended with the following features:

- User login and registration
- Database integration
- Service center selection
- Appointment date and time selection
- Service price calculation
- Online payment
- Service history
- Vehicle maintenance reminders
- Real-time service status
- Google Maps integration
- Service center location tracking
- Admin dashboard
- Cloud database integration

---

## Conclusion

AutoCare is an Android-based vehicle service management application developed using Kotlin and Android Studio.

The application provides a complete service booking workflow starting from vehicle information entry and service selection to additional service selection, booking confirmation, summary display, and notification generation.

The project demonstrates several fundamental Android development concepts including Activities, Fragments, Intents, Bundles, UI widgets, Input Validation, Notifications, and Activity Lifecycle management.

The project provides practical experience in developing a structured Android application using Kotlin and XML while implementing a real-world vehicle service booking scenario.

---

## Project Information

| Information | Details |
|---|---|
| Project Name | AutoCare |
| Project Type | Android Application |
| Domain | Vehicle Service Management |
| Platform | Android |
| Programming Language | Kotlin |
| UI Technology | XML |
| IDE | Android Studio |

---

## Author

**Name:** Tejashree DL

**USN:** 25MCAR0124

**Program:** Master of Computer Applications
