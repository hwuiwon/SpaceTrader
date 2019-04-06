package edu.gatech.cs2340.team49x.spacetrader.Objects.General;

import android.support.annotation.NonNull;

import java.io.Serializable;

public class Player implements Serializable {

    static final long serialVersionUID = 1L;
    private static final int POINT = 16;
    private String name;
    private int skillPt;
    private int pilotPt;
    private int fighterPt;
    private int tradePt;
    private int engineerPt;
    private final Ship ship;
    private int credits;

    private Player(String name, Ship ship) {
        this.name = name;
        this.skillPt = POINT;
        this.pilotPt = 0;
        this.fighterPt = 0;
        this.tradePt = 0;
        this.engineerPt = 0;
        this.ship = ship;
        this.credits = 1000;
    }

    public Player(String name) {
        this(name, new Ship(Ship.ShipType.GNAT));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSkillPt() {
        return skillPt;
    }

    public void setSkillPt(int skillPt) {
        this.skillPt = skillPt;
    }

    public int getPilotPt() {
        return pilotPt;
    }

    public void setPilotPt(int pilotPt) {
        this.pilotPt = pilotPt;
    }

    public int getEngineerPt() {
        return engineerPt;
    }

    public void setEngineerPt(int engineerPt) {
        this.engineerPt = engineerPt;
    }

    public int getTradePt() {
        return tradePt;
    }

    public void setTradePt(int tradePt) {
        this.tradePt = tradePt;
    }

    public int getFighterPt() {
        return fighterPt;
    }

    public void setFighterPt(int fighterPt) {
        this.fighterPt = fighterPt;
    }

    public Ship getShip() {
        return ship;
    }

    public int getCredits() {
        return credits;
    }

    public void changeCredits(int amount) {
        credits += amount;
    }

// --Commented out by Inspection START (4/6/2019 5:57 AM):
// --Commented out by Inspection START (4/6/2019 5:57 AM):
////    public void addToCargo(Inventory items) {
////        this.ship.addToCargo(items);
////    }
//// --Commented out by Inspection START (4/6/2019 5:57 AM):
// --Commented out by Inspection STOP (4/6/2019 5:57 AM)
//// --Commented out by Inspection STOP (4/6/2019 5:57 AM)
//
//    public void removeFromCargo(Inventory items) {
//// --Commented out by Inspection START (4/6/2019 5:57 AM):
// --Commented out by Inspection STOP (4/6/2019 5:57 AM)
//        this.ship.removeFromCargo(items);
//    }
//
//    public int getAmountOf(Tradable good) {
//        return this.ship.getAmountOf(good);
// --Commented out by Inspection STOP (4/6/2019 5:57 AM)

// --Commented out by Inspection START (4/6/2019 6:26 AM):
//    public int cargoSpaceRemaining() {
//        return ship.cargoSpaceRemaining();
//    }
// --Commented out by Inspection STOP (4/6/2019 6:26 AM)

    @NonNull
    @Override
    public String toString() {
        return "\nPlayer{" +
                "\nname = '" + name + '\'' +
                ", \nskillPt = " + skillPt +
                ", pilotPt = " + pilotPt +
                ", fighterPt = " + fighterPt +
                ", tradePt = " + tradePt +
                ", engineerPt = " + engineerPt +
                ", \nship = " + ship.getName() +
                ", credits = " + credits +
                '}';
    }
}