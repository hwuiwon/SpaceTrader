package edu.gatech.cs2340.team49x.spacetrader.Activities.Database;

public class UserInformation {

    public String name;
    public int fuel;
    public int speed;
    public double maxTravelDistance;
    public int credits;
    public int cargoRemaining;
    public double pilotPt;
    public double tradePt;

    public UserInformation(String name, int fuel, int speed, double maxTravelDistance,
                           int credits, int cargoRemaining, double pilotPt, double tradePt) {
        this.name = name;
        this.fuel = fuel;
        this.speed = speed;
        this.maxTravelDistance = maxTravelDistance;
        this.credits = credits;
        this.cargoRemaining = cargoRemaining;
        this.pilotPt = pilotPt;
        this.tradePt = tradePt;
    }
}