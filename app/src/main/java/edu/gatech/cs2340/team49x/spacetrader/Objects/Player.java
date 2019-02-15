package edu.gatech.cs2340.team49x.spacetrader.Objects;

public class Player {
    private String name;
    private int pilotPt;
    private int engineerPt;
    private int tradePt;
    private int fighterPt;
    private Ship ship;
    private int credits;

    public Player(String name, int pilotPt, int engineerPt, int tradePt, int fighterPt, Ship ship, int credits) {
        this.name = name;
        this.pilotPt = pilotPt;
        this.engineerPt = engineerPt;
        this.tradePt = tradePt;
        this.fighterPt = fighterPt;
        this.ship = ship;
        this.credits = credits;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }
}