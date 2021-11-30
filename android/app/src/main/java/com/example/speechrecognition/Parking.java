package com.example.speechrecognition;

public class Parking {

    private String parking_spot;
    private String Latitude;
    private String Longitude;
    private String Availability;


    public Parking() {
    }

    public Parking(String parking_spot, String latitude, String longitude, String availability) {
        this.parking_spot = parking_spot;
        Latitude = latitude;
        Longitude = longitude;
        Availability = availability;
    }

    public void setParking_spot(String parking_spot) {
        this.parking_spot = parking_spot;
    }

    public String getParking_spot() {
        return parking_spot;
    }

    public String getLatitude() {
        return Latitude;
    }

    public void setLatitude(String latitude) {
        Latitude = latitude;
    }

    public String getLongitude() {
        return Longitude;
    }

    public void setLongitude(String longitude) {
        Longitude = longitude;
    }

    public String getAvailability() {
        return Availability;
    }

    public void setAvailability(String availability) {
        Availability = availability;
    }
}
