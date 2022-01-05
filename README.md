# NY PARKSMART

NY Parksmart is an Android application built as part of my IOT lab project at Columbia University. The App is the front end of the project, which interfaces with a [Firebase](https://firebase.google.com/) database, which holds a record of all available ad-hoc on-road parking spots in the city (please note, this a prototype, but can be scaled to a real world app). A back-end sensing system using a Raspberry Pi interfaced with a Pi-Cam, captures images of parking spots in real time, and a ML model using TF-LITE, detects the presence or absence of a car in the spot, updating the firebase database in real time. The updates are captured by the application, and fed to the user.

## Feature  





