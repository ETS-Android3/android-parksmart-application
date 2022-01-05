# NY PARKSMART # 

NY Parksmart is an Android application built as part of my IOT lab project at Columbia University. The App is the front end of the project, which interfaces with a :fire: [Firebase](https://firebase.google.com/) :fire: database, which holds a record of all available ad-hoc on-road parking spots in the city (please note, this a prototype, but can be scaled to a real world app). A back-end sensing system using a Raspberry Pi interfaced with a Pi-Cam, captures images of parking spots in real time, and a ML model using TF-LITE, detects the presence or absence of a car in the spot, updating the firebase database in real time. The updates are captured by the application, and fed to the user.


## Motivation ##

Ever driven :taxi: to your favorite brunch spot on a Sunday morning, only to find out there is no parking available? Then drove around endlessly to find an ad-hoc parking spot? The NY Park Smart App was built with this in mind. A real time database, updated by a backend sensing application, is feeding ad-hoc parking spots to your phone in real time, enabling you to find the optimal parking spot in seconds, rather than driving around aimlessly.  


## Features ##  
---------------

- **User Registration**: Credentials securely saved with firebase authentication  
- **Authentication**: Login with registered credentials. Authenticated using firebase authentication  
- **List View**: Of available/unavailable parking spots around NY City. 
- **Maps view**: App interfaces with Google Maps. Click on parking spot re-directs you to Google Maps, that can be used to navigate from current location to parking spot.


## Code ## ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)

The app consists of multiple activities as follows:  

- [MainActivity.java](https://github.com/Souryadeep/parksmartapp/blob/master/android/app/src/main/java/com/example/speechrecognition/MainActivity.java): App home page  
- [LoginActivity.java](https://github.com/Souryadeep/parksmartapp/blob/master/android/app/src/main/java/com/example/speechrecognition/LoginActivity.java): Login page  
- [RegisterActivity.java](https://github.com/Souryadeep/parksmartapp/blob/master/android/app/src/main/java/com/example/speechrecognition/RegisterActivity.java): User registration page    
- [CoreActivity.java](https://github.com/Souryadeep/parksmartapp/blob/master/android/app/src/main/java/com/example/speechrecognition/CoreActivity.java): Parking listview page. Takes you to Google Map view based on parking spot selected, or back to home page.  
- [GMapsActivity.java](https://github.com/Souryadeep/parksmartapp/blob/master/android/app/src/main/java/com/example/speechrecognition/GMapsActivity.java): Opens Google Maps with parking spot marker  
- [RecyclerView_Config.java](https://github.com/Souryadeep/parksmartapp/blob/master/android/app/src/main/java/com/example/speechrecognition/RecyclerView_Config.java): Recycler View is used for the list of parking spots  


## Usage ##   

Use [Android Studio](https://developer.android.com/studio) to build the application, and either use Android Studio to push the application onto your Android phone :iphone: using USB, or download the APK and install on your phone. Ensure developer mode is turned on, on your phone  



