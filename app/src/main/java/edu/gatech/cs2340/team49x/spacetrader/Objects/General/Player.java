package edu.gatech.cs2340.team49x.spacetrader.Objects.General;

import edu.gatech.cs2340.team49x.spacetrader.Objects.Trading.Inventory;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Trading.Tradable;

public class Player {

    private String name;
    private int skillPt;
    private int pilotPt;
    private int fighterPt;
    private int tradePt;
    private int engineerPt;
    private Ship ship;
    private int credits;

    private Player(String name, int skillPt, int pilotPt, int fighterPt, int tradePt, int engineerPt, Ship ship) {
        this.name = name;
        this.skillPt = skillPt;
        this.pilotPt = pilotPt;
        this.fighterPt = fighterPt;
        this.tradePt = tradePt;
        this.engineerPt = engineerPt;
        this.ship = ship;
        this.credits = 1000;
    }

    public Player(String name) {
        this(name, 16, 0,0,0,0,new Ship(Ship.ShipType.GNAT));
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

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public int getCredits() {
        return credits;
    }

    public void changeCredits(int amount) {
        credits += amount;
    }

    public void addToCargo(Inventory items) {
        this.ship.addToCargo(items);
    }

    public void removeFromCargo(Inventory items) {
        this.ship.removeFromCargo(items);
    }

    public int getAmountOf(Tradable good) {
        return this.ship.getAmountOf(good);
    }

    public int cargoSpaceRemaining() {
        return ship.cargoSpaceRemaining();
    }

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