# NY PARKSMART # 

NY Parksmart is an Android application built as part of my IOT lab project at Columbia University. The App is the front end of the project, which interfaces with a :fire: [Firebase](https://firebase.google.com/) :fire: database, which holds a record of all available ad-hoc on-road parking spots in the city (please note, this a prototype, but can be scaled to a real world app). A back-end sensing system using a Raspberry Pi interfaced with a Pi-Cam, captures images of parking spots in real time, and a ML model using TF-LITE, detects the presence or absence of a car in the spot, updating the firebase database in real time. The updates are captured by the application, and fed to the user.


## Motivation ##

Ever driven to your favorite brunch spot on a Sunday morning, only to find out there is no parking available? Then drove around endlessly to find an ad-hoc parking spot? The NY Park Smart App was built with this in mind. A real time database, updated by a backend sensing application, is feeding ad-hoc parking spots to your phone in real time, enabling you to find the optimal parking spot in seconds, rather than driving around aimlessly.  


## Features ##  
---------------

- **User Registration**: Credentials securely saved with firebase authentication  
- **Authentication**: Login with registered credentials. Authenticated using firebase authentication  
- **List View**: Of available/unavailable parking spots around NY City. 
- **Maps view**: App interfaces with Google Maps. Click on parking spot re-directs you to Google Maps, that can be used to navigate from current location to parking spot.

## Usage ##   

Use [Android Studio](https://developer.android.com/studio) to build the application, and either use Android Studio to push the application onto your Android phone using USB, or download the APK and install on your phone. Ensure developer mode is turned on, on your phone  



