package models;

import static java.lang.Math.abs;

public class Location {

    long latitude;
    long longitude;

    public Location(long latitude, long longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double distanceTo(Location other){

        long dx=abs(other.latitude - this.latitude);
        long dy=abs(other.longitude - this.longitude);

        return Math.sqrt(dx*dx + dy*dy);

    }

}
